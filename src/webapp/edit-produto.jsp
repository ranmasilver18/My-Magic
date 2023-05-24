<%--
  Created by IntelliJ IDEA.
  User: camil
  Date: 12/05/2023
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@page import="org.eclipse.jdt.internal.compiler.ast.MagicLiteral"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@page import="MODEL.*"%>
<%@page import="DAO.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link rel="icon" type="image/png"
	href="https://cdn-icons-png.flaticon.com/512/1160/1160515.png" />
<title>Editar sua Carta</title>
<%@include file="all-css.jsp"%>
</head>

<body class="bg-light">
	<%@include file="navbar.jsp"%>
	<%@page import="MODEL.*,DAO.*"%>

	<div class="container p-4">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<p class="fs-3 text-center">Editar Cartas</p>

						<%
						CartaModel cartam = new CartaModel();
						CartaDao cartad = new CartaDao();
						
						String id = request.getParameter("id");						
						CartaModel cartaId = cartad.cardFindById(id);
						
						%>

						<form action="update" method="post">
								<div class="mb-3">
									<label class="form-label">ID</label>
									<input type="text" name="ID" class="form-control" value="<%=cartaId.getID()%>">
								</div>
								
								<div class="mb-3">
									<label class="form-label">Nome</label>
									<input type="text" name="name" class="form-control" value="<%=cartaId.getNAME()%>">
								</div>

								<div class="mb-3">
									<label class="form-label">Code</label>
									<input type="text" name="CODE" class="form-control" value="<%=cartaId.getCODE()%>">
								</div>
								
								<div class="mb-3">
									<label class="form-label">Categoria</label>
									<input type="text" name="CATEGORY" class="form-control" value="<%=cartaId.getCATEGORY()%>">
								</div>
								
								<div class="mb-3">
									<label class="form-label">Valor</label>
									<input type="text" name="VALOR" class="form-control" value="<%=cartaId.getVALOR()%>">
								</div>
								
								<div class="mb-3">
									<label class="form-label">Quantidade</label>
									<input type="text" name="QNT" class="form-control" value="<%=cartaId.getQNT()%>">
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

