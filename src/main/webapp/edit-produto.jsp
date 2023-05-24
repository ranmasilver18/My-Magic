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
                    <p class="fs-3 text-center">Edit Produtos</p>

                    <form action="" method="post">
                        <div class="mb-3">
                            <label class="form-label">Codigo</label>
                            <input type="text" name= "code" class="form-control">
                        </div>
                        <button type="submit" class="btn btn-primary col-md-12">Atualizar</button>
                    </form>



                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

