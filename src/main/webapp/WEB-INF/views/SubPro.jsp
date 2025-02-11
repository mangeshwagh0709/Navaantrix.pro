<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Management</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 0; padding: 0; }
        #menuBar { background-color: #333; padding: 10px; text-align: center; }
        #menuBar a { color: white; text-decoration: none; padding: 10px 20px; }
        #menuBar a:hover { background-color: #ddd; color: black; }
        form { max-width: 400px; margin: 20px auto; }
        input, label { display: block; width: 100%; margin-bottom: 10px; }
        input[type="submit"] { background: #4CAF50; color: white; cursor: pointer; }
    </style>
    
</head>
<body>

    <div id="menuBar">
    
        <a href="viewbookdata">View</a>
        <a href="update.jsp">Update</a>
        
    </div>
    <h3 style="text-align: center;">Navaantrix Pvt Management System</h3>
    
    <form action="addsubpro" method="get">
    
        <label>Product Name:</label>        
        <input type="text" name="name">

        <label>Unit:</label>
        <input type="text" name="unit">
        
        
           <div class="mb-3">
    <label for="subproductList" class="form-label fw-bold">
        <i class="fas fa-box"></i> Select a Subproduct
    </label>
    <select class="form-select form-control shadow-sm border-primary" id="subproductList" name="subproduct_id" required>
        <option value="" disabled selected>🔽 Choose a Subproduct</option>
        
        <c:forEach var="p" items="${pdata}">
        
            <option value="${p.getProductId()}">📦 ${p.getName()}</option>
            
        </c:forEach>
        
    </select>
</div>
           
        

       <br><br> <input type="submit" value="Submit">
    </form>
    
</body>
</html>
