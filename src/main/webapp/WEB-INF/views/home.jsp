<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    
        <a href="viewprodata">View</a>
        <a href="SubProPage">Add Sub Product</a>
        
            
    </div>
    <h3 style="text-align: center;">Navaantrix Pvt Management System</h3>
    
    <form action="bookdata" method="get">
    
        <label>Sub Product Name:</label>
        <input type="text" name="subproname"> 

         <label>Unit:</label>
        <input type="text" name="unit">

        <input type="submit" value="Submit">
    </form>
</body>
</html>
