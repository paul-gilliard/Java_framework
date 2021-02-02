<%-- 
    Document   : newjsp
    Created on : 13 janv. 2021, 11:33:43
    Author     : paul
--%>
<%-- <%@page import="java.util.Date" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean class="java.util.Date " id="d" scope="page"></jsp:useBean>--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <div>
            ${d}
         </div>
         <div>
            ${5+3}
         </div>
    </body>
</html>
