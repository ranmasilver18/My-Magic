<%--
  Created by IntelliJ IDEA.
  User: camil
  Date: 12/05/2023
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="all-css.jsp"%>
</head>
<body class="bg-light">
<%@include file="navbar.jsp"%>
        <div class="container p-4">
        <div class="row">
        <div class="col-md-6 offset-md-3">
        <div class="card">
        <div class="card-body">
        <p class="fs-3 text-center">Register</p>

                <form action="register" method="post">
                        <div class="mb-3">
                                <label class="form-label">Code</label>
                                <input type="text" name= "code" class="form-control">
                        </div>

                        <div class="mb-3">
                                <label class="form-label">Name</label>
                                <input type="text" name="name" class="form-control">
                        </div>

                        <div class="mb-3">
                                <label class="form-label">Categoriay</label>
                                <input type="text" name="category" class="form-control">
                        </div>

                        <div class="mb-3">
                                <label class="form-label">Valor</label>
                                <input type="number" name="valor" class="form-control">
                        </div>
                        
                        <div class="mb-3">
                                <label class="form-label">Quantidade</label>
                                <input type="number" name="qnt" class="form-control">
                        </div>

                        <button type="submit" class="btn btn-primary">Submit</button>
                </form>



        </div>
        </div>
        </div>
        </div>
        </div>
</body>
</html>
