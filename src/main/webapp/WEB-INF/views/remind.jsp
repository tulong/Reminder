<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remind</title>

</head>
<body>

    <script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
    
	<link href="${request.getContextPath() }script/mobiscroll/css/mobiscroll-2.0.1.custom.min.css" rel="stylesheet" type="text/css" />
	<script src="${request.getContextPath() }script/mobiscroll/js/mobiscroll-2.0.1.custom.min.js" type="text/javascript"></script>


    <script type="text/javascript">
$(function(){
    var now = new Date();

    $('#i').scroller({
        preset: 'datetime',
        minDate: new Date(now.getFullYear(), now.getMonth(), now.getDate()),
        theme: 'default',
        display: 'modal',
        mode: 'clickpick'
    });    

    $('#show').click(function(){
        $('#i').scroller('show'); 
        return false;
    });
    $('#clear').click(function () {
        $('#i').val('');
        return false;
    });
});
    </script>

	<c:if test="${!empty remindList}">
		<c:forEach items="${remindList}" var="remind">
			<fieldset>
				<legend>Reminder:</legend>
				Date:<input type="text" name="reminderDate"
					value="${remind.reminderDate}" /><br /> Task:<input type="text"
					name="task" value="${remind.task}" /><br />
			</fieldset>
		</c:forEach>
	</c:if>

	<fieldset>
		<legend>Add:</legend>
		<form action="remind" method="post">
			<label>Reminder Date:</label> <input id="i" type="text"
				name="reminderDate" onClick="WdatePicker()" /><br /> <label>Task:</label>
			<input type="text" name="task" /><br />
			<button type="submit">submit</button>
		</form>
	</fieldset>
</body>
</html>