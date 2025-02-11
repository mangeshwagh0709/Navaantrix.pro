<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
  <style>
        body { font-family: Arial, sans-serif; margin: 0; padding: 0; }
        #menuBar { background-color: #333; padding: 10px; text-align: center; }
        #menuBar a { color: white; text-decoration: none; padding: 10px 20px; }
        #menuBar a:hover { background-color: #ddd; color: black; }
        form { max-width: 400px; margin: 20px auto; }
        input, label { display: block; width: 100%; margin-bottom: 10px; }
        input[type="submit"] { background: #4CAF50; color: white; cursor: pointer; }
    </style>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!--  SepExamMvc
 -->

    <div id="menuBar">
    
        <a href="viewprodata">View</a>
        <a href="SubProPage">Add Sub Product</a>
        <a href="SubProPage">Delete Product</a>
        
        
            
    </div>
    <h3 style="text-align: center;">Navaantrix Pvt Management System</h3>
  

    <table border="1" style="width: 80%; margin: 20px auto; text-align: center; border-collapse: collapse;">
        <thead>
            <tr>
                <th>Product Name</th>
                <th>Product Type</th>
                <th>Unit</th>
                <th>Sub Product</th>
               
            </tr>
        </thead>
        <tbody>
            <c:forEach var="p" items="${pdata}">
                <tr>
                    <td>${p.getName()}</td>
                    <td>${p.getType()}</td>
                    <td>${p.getUnit()}</td>
                    <td>${p.getSubproname()}</td>
                    <td>
                    
                       <a href='deleteemp?Bdid=${p.getProductId()}'>Delete</a>
                                                                 
                      
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>





</body>
</html>