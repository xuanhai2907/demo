package com.example.springmvc.demo.controller;

import com.example.springmvc.demo.model.Product;
import com.example.springmvc.demo.model.Product_Brand;
import com.example.springmvc.demo.model.Status;
import com.example.springmvc.demo.model.Sub_category;
import com.example.springmvc.demo.repositories.ProductRepository;
import com.example.springmvc.demo.repositories.Product_BrandRepository;
import com.example.springmvc.demo.repositories.StatusRepository;
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
@RequestMapping(path = "products")
public class ProductController implements WebMvcConfigurer {
    @Autowired
    private ProductRepository productRepository;
//    @RequestMapping(value = "", method = RequestMethod.GET)
//    public String getAllProduct(ModelMap modelMap){
//        Iterable<Product> products = productRepository.findAll();
//        modelMap.addAttribute("products", products);
//        return "Product";
//    }
// Phân trang
@RequestMapping(value = "", method = RequestMethod.GET)
public String page(ModelMap modelMap,
                   @RequestParam("p") Optional<Integer> p
) {
    if(p.get() == -1) {
        p = Optional.of(0);
    }
    int i = (int) ((productRepository.count()/5));
    if(p.get() > (productRepository.count()/5)) {
        p = Optional.of(i);
    }
    Pageable pageable = PageRequest.of(p.orElse(0),5);
    Page<Product> page = productRepository.findAll(pageable);
    modelMap.addAttribute("products",page);
    return "Product";
}
    @Autowired
    private Sub_CategoryRepository subCategoryRepository;

// UPDATE
    @RequestMapping(value = "/getUpdateProduct/{id}", method = RequestMethod.GET)
    public  String getUpdateProduct(ModelMap modelMap,
                                    @PathVariable Integer id){
        Iterable<Product> products = productRepository.findByid(id);
        Iterable<Sub_category> sub_categories = subCategoryRepository.findAll();
        Iterable<Status> statuses = statusRepository.findAll();
        modelMap.addAttribute("products", products);
        modelMap.addAttribute("getProduct", productRepository.findById(id).get());
        modelMap.addAttribute("sub_categories", sub_categories);
        modelMap.addAttribute("statuses", statuses);
        return "Update_Product";
    }

//UPDATE
    @RequestMapping(value = "/updateProduct/{id}", method = RequestMethod.POST)
    public String updateProduct(
            ModelMap modelMap,
            @Valid @ModelAttribute("getProduct") Product product,
            BindingResult bindingResult,
            @PathVariable Integer id
    ){
        modelMap.addAttribute("sub_categories", subCategoryRepository.findAll());
        modelMap.addAttribute("statuses", statusRepository.findAll());
        if ((bindingResult.hasErrors())){
            return "Update_Product";
        }
    try{
        if (productRepository.findById(product.getId()).isPresent()){
            Product foundProduct = productRepository.findById(product.getId()).get();
            if (product.getProduct_name() != null ||
            product.getColor() != null ||
            product.getQuantity() != null ||
            product.getDescription() != null ||
            product.getSell_price() > 0 ||
            product.getOrigin_price() > 0 ||
            product.getStatus_id() != null ||
            product.getSubcate_id() != null
            ){
                foundProduct.setProduct_name(product.getProduct_name());
                foundProduct.setColor(product.getColor());
                foundProduct.setDescription(product.getDescription());
                foundProduct.setQuantity(product.getQuantity());
                foundProduct.setSell_price(product.getSell_price());
                foundProduct.setOrigin_price(product.getOrigin_price());
                foundProduct.setSubcate_id(product.getSubcate_id());
                foundProduct.setStatus_id(product.getStatus_id());
            }
            if(product.getOrigin_price() > product.getSell_price()){
                modelMap.addAttribute("loi", "Origin_price no bigger than Sell_price");
                return "Update_Product";
            }
            productRepository.save(foundProduct);
        }
    }catch (Exception e){
        e.printStackTrace();
    }
        return "redirect:/products"; 
    }
    @Autowired
    private StatusRepository statusRepository;
// INSERT
    @RequestMapping(value = "/getInsertProduct", method = RequestMethod.GET)
    public String getInsertProduct(ModelMap modelMap){
        Product p1 = new Product();
        modelMap.addAttribute("getProduct", p1);
        modelMap.addAttribute("categories", subCategoryRepository.findAll());
        modelMap.addAttribute("statuses", statusRepository.findAll());

        return "Insert_Product";
    }
// INSERT
    @RequestMapping(value = "/insertProduct", method = RequestMethod.POST)
    public String insertProduct(ModelMap modelMap,
                                @Valid @ModelAttribute("getProduct") Product product,
                                BindingResult bindingResult) {

        modelMap.addAttribute("categories", subCategoryRepository.findAll());
        modelMap.addAttribute("statuses", statusRepository.findAll());
        System.out.println(product.getStatus_id());
        if ((bindingResult.hasErrors())){
            return "Insert_Product";
        }
        try {
            if(product.getOrigin_price() > product.getSell_price()){
                modelMap.addAttribute("loi", "Origin_price no bigger than Sell_price");
                return "Insert_Product";
            }
            productRepository.save(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/products";
    }

//DELETE
    @Autowired
    private Product_BrandRepository product_brandRepository;
    @RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.POST)
    public  String deleteProduct(ModelMap modelMap, @PathVariable Integer id){
        Iterable<Product_Brand> product_brands = product_brandRepository.findAll();
        for (Product_Brand x :
                product_brands) {
            if(x.getProduct_id() == id){
                product_brandRepository.deleteById(x.getProduct_id());
            }
        }
        productRepository.deleteById(id);
        return "redirect:/products";
    }
}
