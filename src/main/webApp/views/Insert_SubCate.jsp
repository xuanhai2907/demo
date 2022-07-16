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
    </style>
</head>
<body>
<div id="main">
    <h1>Insert Sub Category</h1>
    <br>
<%--    <br> with ID = ${getSubcate.getId()}--%>
    <br>
    <%--@elvariable id="getSubcate" type="java"--%>
    <form:form method="POST"
               action="../categories/insertSubCate"
               modelAttribute="getSubcate"
    >

        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1">sub_cate_code</span>
            </div>
            <form:input type="text" class="form-control"
                        placeholder="sub_cate_code" aria-label="sub_cate_code"
                        aria-describedby="basic-addon1"
                        value="${getSubCate.getSub_cate_code()}"
                        path="sub_cate_code"
            />
        </div>
        <form:errors path="sub_cate_code"/>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1">sub_cate_name</span>
            </div>
            <form:input type="text"
                        class="form-control" placeholder="sub_cate_name"
                        aria-label="sub_cate_name" aria-describedby="basic-addon1"
                        value="${getSubCate.getSub_cate_name()}"
                        path="sub_cate_name"
            />
        </div>
        <form:errors path="sub_cate_name"/>
        <div style="display:flex;">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1">Cate ID</span>
            </div>
            <form:select name="" id="" style="width:100px" path="cate_id">
                <form:option value="1">1</form:option>
                <form:option value="2">2</form:option>
                <form:option value="3">3</form:option>
                <form:option value="4">4</form:option>
                <form:option value="5">5</form:option>
            </form:select>
        </div>
        <br>
        <input type="submit" class="btn btn-dark" value="Insert"/>
        <button type="button" class="btn btn-dark">
            <a href="../../categories?p=0">
                Back to Table Sub Cate
            </a>
        </button>
    </form:form>
</div>
</body>
</html>