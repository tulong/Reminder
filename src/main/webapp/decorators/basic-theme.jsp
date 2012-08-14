<?xml version="1.0" encoding="UTF-8" ?>

<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Reminder</title>
    <style type="text/css">
    img#logo 
{
float:left;
}
    
ul#list-nav {
float:left;
  list-style:none;
  margin:20px;
  padding:0;
  width:525px
}

ul#list-nav li {
  display:inline
}

ul#list-nav li a {
  text-decoration:none;
  padding:5px 0;
  width:100px;
  background:#485e49;
  color:#eee;
  float:left;
  text-align:center;
  border-left:1px solid #fff;
}

ul#list-nav li a:hover {
  background:#a2b3a1;
  color:#000
}
</style>

</head>
<body>
    <img id="logo" src="http://www.logomaker.com/logo-images/ca5a58ef6ec3826d.gif" width="100" hight="75" />

<ul id="list-nav">
  <li><a href="#">Home</a></li>
  <li><a href="remind">Remind</a></li>
  <li><a href="informer">Informer</a></li>
  <li><a href="login">Login</a></li>
  <li><a href="#">Contact</a></li>
</ul>
<br />
<br />
<br />
<br />
<br />
<br />
    
    <c:if test="${!empty currentUser}" >

<P>  Welcome! ${currentUser.name} </P>
</c:if>	


    <hr />
    <decorator:body />
    <hr />
    <h1>Footer</h1>
</body>
</html>