<%@page import="MODEL.CartaModel"%>
<%@page import="java.util.List"%>
<%@page import="DAO.CartaDao"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="DAO.*, MODEL.*" %>
<%@ page import="java.sql.Connection" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Index</title>
    <%@include file="all-css.jsp" %>


</head>
<body class="bg-light">

<%@include file="navbar.jsp" %>

<div class="container p-3">
<div class="card">
<div class="card-body"></div>

 <p class="text-center mt-3 fs-1">Todas as suas Cartas</p>
<% 
CartaDao cartadao = new CartaDao();
CartaModel cartam = new CartaModel();
List<CartaModel> list = cartadao.searchCards();
request.setAttribute("list", list);

%>

       <table class="table">
         <thead>
           <tr>
             <th scope="col">ID</th>
             <th scope="col">Name</th>
             <th scope="col">Code</th>
             <th scope="col">Categoria</th>
             <th scope="col">Valor</th>
             <th scope="col">Quantidade</th>
           </tr>
         </thead>
        
         <tbody>
          <c:forEach items="${list}" var="carta">
          <form action="delete" method="post">
           <tr>
             <th scope="row">${carta.ID}</th>
             <td>${carta.NAME}</td>
             <td>${carta.CODE}</td>
             <td>${carta.CATEGORY}</td>
             <td>${carta.VALOR}</td>
             <td>${carta.QNT}</td>
             <td>
             <a href="edit-produto.jsp?id=${carta.getID()}" class="btn-sm btn-primary">Editar</a>
             <input type="hidden" name="id" value="${carta.getID()}">
             <button type="submit" class="btn-sm btn-danger ms-1">Delete</button></td>
             </td>
           </tr>
            </form>
           </c:forEach>
         </tbody>
       </table>
      
</div>

</div>
</body>
</html>





    











































