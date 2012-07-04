<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script language="javascript" type="text/javascript" src="script/datepicker/WdatePicker.js"></script>
<body>

<c:if test="${!empty currentUser}" >

<P>  Welcome! ${currentUser.name} </P>
</c:if>

<form action="addRemind" method="post">
<label>Reminder Date:</label>
<input id="d1" type="text" name="reminderDate" onClick="WdatePicker()"/><br>
<label>Task:</label>
<input type="text" name="task"/><br>
<button type="submit">submit</button>

</form>
</body>
</html>