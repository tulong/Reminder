<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<c:if test="${!empty informers}">
		<fieldset>
			<legend>Already Have:</legend>
			<c:forEach items="${informers}" var="informer">
${informer.type}:<input type="text" value="${informer.number}" />
				<br />
			</c:forEach>
		</fieldset>
	</c:if>

	<fieldset>
		<legend>Add One:</legend>
		<form action="informer" method="post">
			Informer:<input type="text" name="number" /><br /> Type:<select
				name="type">
				<c:if test="${!empty option}">
${option}
</c:if>
			</select> <br />
			<button type="submit">submit</button>
		</form>
	</fieldset>
</body>
</html>