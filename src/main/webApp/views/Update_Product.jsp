<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="p" uri="http://www.springframework.org/tags/form" %>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <style>
        body{
            display: flex;
            margin: auto;
            width: 900px;
            justify-content: center;
            background: url(https://img5.thuthuatphanmem.vn/uploads/2021/12/06/bau-troi-mau-hong-dep_082138552.jpg) 50% 50% no-repeat;
        }
        a {
            color: #fff;
            text-decoration: none;
        }
        a:hover {
            color: #fff;
            text-decoration: none;
        }
        .a1{
            color: red;
        }
    </style>
</head>
<body>
<div id="main">
    <h1>Update Sub Category with ID = ${getProduct.getId()}</h1>
    <br>

    <%--@elvariable id="getProduct" type="java"--%>
    <form:form method="POST"
               action="/products/updateProduct/${getProduct.getId()}"
               modelAttribute="getProduct"
    >
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1">ID</span>
            </div>
            <form:input  type="text" class="form-control"
                         placeholder="sub_cate_code" aria-label="sub_cate_code"
                         aria-describedby="basic-addon1"
                         value="${getProduct.getId()}"
                         path="id" readonly="true"/>
        </div>

        <form:errors class="1" path="subcate_id" />
        <div style="display:flex ;">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1">Subcate_id</span>
            </div>
            <form:select name="" id="" style="width:100px" path="subcate_id">
                <c:forEach var="sub_categories" items="${sub_categories}">
                    <form:option value="${sub_categories.getId()}">${sub_categories.getId()}</form:option>
                </c:forEach>
            </form:select>
        </div>
        <br>
        <form:errors class="a1" path="product_name"/>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1">Product_name</span>
            </div>
            <form:input type="text" class="form-control"
                        placeholder="product_name" aria-label="product_name"
                        aria-describedby="basic-addon1"
                        value="${getProduct.getProduct_name()}"
                        path="product_name"
            />
        </div>
        <form:errors class="a1" path="color"/>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1">Color</span>
            </div>
            <form:input type="text"
                        class="form-control" placeholder="color"
                        aria-label="color" aria-describedby="basic-addon1"
                        value="${getProduct.getColor()}"
                        path="color"
            />
        </div>

        <form:errors class="a1" path="quantity"/>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1">Quantity</span>
            </div>
            <form:input type="number"
                        class="form-control" placeholder="quantity"
                        aria-label="quantity" aria-describedby="basic-addon1"
                        value="${getProduct.getQuantity()}"
                        path="quantity"
            />
        </div>

        <form:errors class="a1" path="sell_price"/>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1">Sell_price</span>
            </div>
            <form:input type="number"
                        class="form-control" placeholder="sell_price"
                        aria-label="sell_price" aria-describedby="basic-addon1"
                        value="${getProduct.getSell_price()}"
                        path="sell_price"
            />
        </div>
        <form:errors class="a1" path="origin_price"/>
        <p class="a1">${loi}</p>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1">Origin_price</span>
            </div>
            <form:input type="number"
                        class="form-control" placeholder="origin_price"
                        aria-label="origin_price" aria-describedby="basic-addon1"
                        value="${getProduct.getOrigin_price()}"
                        path="origin_price"
            />
        </div>

        <form:errors class="a1" path="description"/>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1">Description</span>
            </div>
            <form:input type="text"
                        class="form-control" placeholder="description"
                        aria-label="description" aria-describedby="basic-addon1"
                        value="${getProduct.getDescription()}"
                        path="description"
            />
        </div>

        <br>
        <div style="display:flex ;">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1">Status_id</span>
            </div>
            <form:select name="" id="" style="width:100px" path="status_id">
                <c:forEach var="statuses" items="${statuses}">
                    <form:option value="${statuses.getId()}">${statuses.getId()}</form:option>
                </c:forEach>
            </form:select>
        </div>


        <br>
        <input type="submit" class="btn btn-dark" value="Update"/>
        <button type="button" class="btn btn-dark">
            <a href="../../products?p=0">
                Back to Table Product
            </a>
        </button>

    </form:form>
    <form:form
            method="post"
            action="../../products/deleteProduct/${getProduct.getId()}"
            onsubmit="return confirm('Do you want to delete?')?true:false"
    >
        <input style="background-color: red; width:120px; height:40px; margin-top: 10px" type="submit" value="Delete"/>
    </form:form>
</div>



</body>
</html>