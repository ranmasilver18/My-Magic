<%--
  Created by IntelliJ IDEA.
  User: camil
  Date: 12/05/2023
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="MODEL.CartaModel" %>

<html>
<head>
<link rel="icon" type="image/png" href="https://cdn-icons-png.flaticon.com/512/1160/1160515.png"/>
    <title>Editar sua Carta</title>
    <%@include file="all-css.jsp"%>
</head>

<body class="bg-light">
<%@include file="navbar.jsp"%>

<div class="container p-4">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <div class="card">
                <div class="card-body">
                    <p class="fs-3 text-center">Editar Cartas</p>

                    <form action="" method="post">
                    <c:set var="CODE" value="$CODE"></c:set>
                        <div class="mb-3">
                            <label class="form-label">Codigo</label>
                            <input type="text" name= "code" class="form-control">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Nome</label>
                            <input type="text" name="name" class="form-control">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Categoria</label>
                            <input type="text" name="categoria" class="form-control">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Valor</label>
                            <input type="number" name="valor" class="form-control">
                        </div>


                        <div class="mb-3">
                            <label class="form-label">Quantidade</label>
                            <input type="number" name="qnt" class="form-control">
                        </div>


                        <button type="submit" class="btn btn-primary col-md-12">Atualizar</button>
                    </form>

						<p style="color: red">${erro</p>

                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

