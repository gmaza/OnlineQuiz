<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="Database.DatabaseHelper" %>
<%! DatabaseHelper db= new DatabaseHelper(); 
HashMap<String, String> mymap = new HashMap<String, String>();
HashMap<String, String> mymap2 = new HashMap<String, String>();
%>
<%
mymap2.put("UserName", "'5'");
mymap2.put("FirstName", "'5'");
db.Delete("users", mymap2);
%>

<%
mymap.put("UserName", "'7'");
mymap.put("FirstName", "'7'");
mymap.put("LastName", "'7'");
mymap.put("Mail", "'7'");
mymap.put("Password", "'7'");
db.Insert("users", mymap); %>
Hii
sdfsdf
<h1>id na xui</h1>
</body>
</html>