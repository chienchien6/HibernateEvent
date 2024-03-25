<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>活動資訊</title>
</head>
<body style="bakground-color:#fdf5e6">
<div align="center">
<h2>活動資訊</h2>
<form method="post" action="${pageContext.request.contextPath}/WSupdate">
<jsp:useBean id="eventBeans" scope="request" class="model.Event"/>
	<table>
	<tr><td>活動編號
		<td><input style="background-color: #7B7B7B; "type="text"   value="<%= eventBeans.getEventId() %>" readonly name="EVENTID">
	<tr><td>活動名稱<td><input type="text" value="<%= eventBeans.getEventName() %>" name="EVENT_NAME">
	<tr><td>報名開始日期<td><input type="text"  value="<%=eventBeans.getSignupStartime() %>" name="SIGNUP_STARTIME">
	<tr><td>報名結束日期<td><input type="text"  value="<%=eventBeans.getSignupEndtime()%>" name="SIGNUP_ENDTIME">
	<tr><td>活動開始時間<td><input type="text" value="<%=eventBeans.getStartTime()%>" name="EVENT_STARTIME">
	<tr><td>活動結束時間<td><input type="text" value="<%=eventBeans.getEndTime()%>" name="EVENT_ENDTIME">
	<tr><td>活動詳細資料<td><input type="text" value="<%=eventBeans.getEventDetail()%>" name="EVENT_DETAIL">
	<tr><td>活動種類<td><input type="text" value="<%= eventBeans.getEventCategory()%>" name="EVENT_CATEGORY">
	<tr><td>報名金額<td><input type="text" value="<%= eventBeans.getEventPrice()%>" name="EVENT_PRICE">
	<tr><td>活動地址<td><input type="text" value="<%=eventBeans.getEventLocation()%>" name="EVENT_ADDRES">
	<tr><td>組織者<td><input type="text" value="<%= eventBeans.getOrganizer()%>" name="ORGANIZER">
	<tr><td>圖片<td><input type="text" value="<%= eventBeans.getPicture()%>" name="PICTURE">
	</table>
	<button name="type" value="upData">確定</button>
</form>
</div>

</body>
</html>