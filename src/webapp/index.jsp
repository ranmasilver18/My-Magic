<%@ page import="java.sql.Connection" %><%--
  Created by IntelliJ IDEA.
  User: camil
  Date: 12/05/2023
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
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

 <p class="text-center mt-3 fs-1">All Cards</p>

       <table class="table">
         <thead>
           <tr>
             <th scope="col">Code</th>
             <th scope="col">Name</th>
             <th scope="col">Category</th>
             <th scope="col">Price</th>
             <th scope="col">Action</th>
           </tr>
         </thead>
         <tbody>
           <tr>
             <th scope="row">1</th>
             <td>Mark</td>
             <td>Otto</td>
             <td>@mdo</td>
             <td>
             <a href="edit-produto.jsp" class="btn-sm btn-primary">Edit</a>
               <a href="" class="btn-sm btn-danger ms-1">Delete</a>
             </td>
           </tr>
           <tr>
             <th scope="row">2</th>
             <td>Jacob</td>
             <td>Thornton</td>
             <td>@fat</td>
           </tr>
           <tr>
             <th scope="row">3</th>
             <td colspan="2">Larry the Bird</td>
             <td>@twitter</td>
           </tr>
         </tbody>
       </table>
</div>

</div>
</body>
</html>





    











































