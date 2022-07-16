<!doctype html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <style>
        table, th, td{
            border:2px solid aqua;
        }
        button{
            color: white;
            background-color: aqua;
        }
        body {
            display: flex;
            margin: auto;
            width: 1200px;
            flex-direction: column;
            background: url(https://img5.thuthuatphanmem.vn/uploads/2021/12/06/bau-troi-mau-hong-dep_082138552.jpg) 50% 50% no-repeat;
        }
        li{
            margin-top: 20px;
            margin-left: 20px;
        }
    </style>
</head>
<body style="text-align: center">
<h1 style="color: red">TABLE PRODUCT</h1>
<%--    // Lấy danh sachs đói tượng categories ra ngoài table;--%>
<table>
    <tr>
        <th>ID</th>
        <th>Sub_cate_id</th>
        <th>Product_name</th>
        <th>Color</th>
        <th>Quantity</th>
        <th>Sell_price</th>
        <th>Origin_price</th>
        <th>Description</th>
        <th>Status_id</th>
        <th>Action</th>
        <th><a href="/products/getInsertProduct"><button>Insert</button></a></th>
    </tr>
    <c:forEach var="product" items="${products.content}">
        <tr>
            <td>${product.getId()}</td>
            <td>${product.getSubcate_id()}</td>
            <td>${product.getProduct_name()}</td>
            <td>${product.getColor()}</td>
            <td>${product.getQuantity()}</td>
            <td>${product.getSell_price()}</td>
            <td>${product.getOrigin_price()}</td>
            <td>${product.getDescription()}</td>
            <td>${product.getStatus_id()}</td>
            <th><a href="../products/getUpdateProduct/${product.getId()}"><button>Click me<3</button></a></th>
        </tr>
    </c:forEach>
</table>
<nav aria-label="Page navigation example">
    <ul class="pagination justify-content-center">
        <li class="page-item">
            <a class="page-link" href="/products?p=0">First</a>
        </li>
        <li class="page-item">
            <a class="page-link" href="/products?p=${products.number - 1}">Previous</a>
        </li>
        <li class="page-item"><a class="page-link" href="/products?p=${products.number + 1}">Next</a></li>
        <li class="page-item">
            <a class="page-link" href="/products?p=${products.totalPages - 1}">Last</a>
        </li>
    </ul>
</nav>
    <button type="button" class="btn btn-dark">
        <a href="../../home">
            Back to Home
        </a>
    </button>
</body>
</html>