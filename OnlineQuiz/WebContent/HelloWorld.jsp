<%@page import="Repository.UserRepository"%>
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
<%@ page import="Models.User" %>
<%@ page import="Helper.HashHelper" %>
<%! DatabaseHelper db= new DatabaseHelper(); 
HashMap<String, String> mymap = new HashMap<String, String>();
HashMap<String, String> mymap2 = new HashMap<String, String>();
HashMap<String, String> mymap3 = new HashMap<String, String>();
UserRepository repo = new UserRepository();
User useri = new User();
HashHelper hhp = new HashHelper();
%>
<%
mymap2.put("UserName", "'5'");
mymap2.put("FirstName", "'5'");
//db.Delete("users", mymap2);
%>

<%
mymap.put("UserName", "'7'");
mymap.put("PasswordHash", "'7'");
mymap.put("FirstName", "'7'");
mymap.put("LastName", "'7'");
mymap.put("Age", "7");
mymap.put("Mail", "'7'");
//db.Insert("users", mymap); %>
<%
mymap3.put("UserName", "'gukamaz'");
mymap3.put("FirstName", "'gukani'");
//db.Update("users", mymap3, 1);
useri.SetUsername("gukacho");
useri.SetPasswordHash(hhp.Hash("gukani57"));
useri.SetFirstname("Guka");
useri.SetLastname("Mazanashvili");
useri.SetAge(22);
useri.SetMail("bla@bla.com");
repo.Save(useri);
repo.Login("gukacho", "gukani57");
%>

Hii
sdfsdf
<h1>id na xui</h1>
</body>
</html>