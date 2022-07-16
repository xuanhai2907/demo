package com.example.springmvc.demo.controller;

import com.example.springmvc.demo.model.Category;
import com.example.springmvc.demo.model.Product;
import com.example.springmvc.demo.model.Product_Brand;
import com.example.springmvc.demo.model.Sub_category;
import com.example.springmvc.demo.repositories.ProductRepository;
import com.example.springmvc.demo.repositories.Product_BrandRepository;
import com.example.springmvc.demo.repositories.Sub_CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import javax.validation.Valid;

import java.util.Optional;

@Controller
@RequestMapping(path = "categories")
public class Sub_CategoryController implements WebMvcConfigurer {
    @Autowired // Inject "categoryRepository"
    private Sub_CategoryRepository subCategoryRepository;
//    @RequestMapping(value = "", method = RequestMethod.GET)
//    public String getAllSubCategries(ModelMap modelMap){
//        Iterable<Sub_category> categories = subCategoryRepository.findAll();
//        modelMap.addAttribute("categories", categories);
//        return "Sub_category";
//    }
    // Phân trang
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String page(ModelMap modelMap,
                       @RequestParam("p") Optional<Integer> p
    ) {
        if(p.get() == -1) {
            p = Optional.of(0);
        }
        int i = (int) ((subCategoryRepository.count()/5));
        if(p.get() > (subCategoryRepository.count()/5)) {
            p = Optional.of(i);
        }
        Pageable pageable = PageRequest.of(p.orElse(0),5);
        Page<Sub_category> page = subCategoryRepository.findAll(pageable);
        modelMap.addAttribute("categories",page);
        return "Sub_category";
    }
//UPDATE
    @RequestMapping(value = "/getUpdateSubCate/{id}", method = RequestMethod.GET)
    public String getUpdateSubCate(ModelMap modelMap, @PathVariable Integer id){
        Iterable<Sub_category> categories = subCategoryRepository.findByid(id);
        modelMap.addAttribute("categories", categories);
        modelMap.addAttribute("getSubcate",subCategoryRepository.findById(id).get());
        return "Update_SubCate";
    }

//UPDATE
    @RequestMapping(value = "/updateSubCate/{id}", method = RequestMethod.POST)
    public String updateSubCate(ModelMap modelMap,
                                @Valid
                                @ModelAttribute("getSubcate") Sub_category subCateModel,
                                BindingResult bindingResult,
                                @PathVariable Integer id) {
            if ((bindingResult.hasErrors())){
                return "Update_SubCate";
            }
        try {
            if(subCategoryRepository.findById(subCateModel.getId()).isPresent()) {
                Sub_category foundSubCate = subCategoryRepository.findById(subCateModel.getId()).get();
                if(subCateModel.getSub_cate_name() != null ||
                        subCateModel.getSub_cate_code() != null
                ) {
                    foundSubCate.setCate_id(subCateModel.getCate_id());
                    foundSubCate.setSub_cate_code(subCateModel.getSub_cate_code());
                    foundSubCate.setSub_cate_name(subCateModel.getSub_cate_name());
                }
                subCategoryRepository.save(foundSubCate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/categories";
    }
//INSERT
    @RequestMapping(value = "/getInsertSubCate", method = RequestMethod.GET)
    public String getInsertSubCate(ModelMap modelMap){
        modelMap.addAttribute("getSubcate", new Sub_category());
        modelMap.addAttribute("categories",subCategoryRepository.findAll());
        return "Insert_SubCate";
    }
//INSERT
    @RequestMapping(value = "/insertSubCate", method = RequestMethod.POST)
    public String insertSubCate(ModelMap modelMap,
                                @Valid @ModelAttribute("getSubcate") Sub_category subCateModel,
                                BindingResult bindingResult) {
        if ((bindingResult.hasErrors())){
            return "Insert_SubCate";
        }
        try {
//            subCateModel.setId();
            subCategoryRepository.save(subCateModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/categories";
    }
    //DELETE
//    @RequestMapping(value = "/deleteSubCate/{id}", method = RequestMethod.POST)
//    public String deleteSubCate(ModelMap modelMap, @PathVariable Integer id){
//        subCategoryRepository.deleteById(id);
//        return "redirect:/categories";
//    }
    @Autowired // Inject "categoryRepository"
    private Product_BrandRepository product_brandRepository;
    @Autowired // Inject "categoryRepository"
    private ProductRepository productRepository;
    @RequestMapping(value = "/deleteSubCate/{id}", method = RequestMethod.POST)
    public String deleteSubCate(ModelMap modelMap, @PathVariable Integer id) {
        Iterable<Product> products = productRepository.findAll();
        Iterable<Product_Brand> product_brands = product_brandRepository.findAll();
        System.out.println(id);
        for (Product x: products
        ) {
            if(x.getSubcate_id() == id) {
                for (Product_Brand y: product_brands
                ) {
                    if(y.getProduct_id() == x.getId()) {
                        product_brandRepository.deleteById(y.getProduct_id());
                    }
                }
                productRepository.deleteById(x.getId());
            }
        }
        subCategoryRepository.deleteById(id);
        return "redirect:/categories";
    }
}
