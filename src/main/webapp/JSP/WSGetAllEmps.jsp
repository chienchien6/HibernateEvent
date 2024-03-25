<%@page import="java.time.format.DateTimeFormatter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  import="java.util.*,model.Event"%>
  <%! @SuppressWarnings("unchecked") %>
  
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>活動資訊</title>
<style>
	.position{
		float:right;
/* 		transform: translateX(-50%); */
/*  		padding-top: 33px; */
/*         width: 500px; */
/*         padding-botton: 100px; */
			margin-right: 200px; 
	}
	td {
 		 padding: 5px 10px; /* 上下各 10px，左右各 20px 的内边距 */
  		white-space: nowrap;
	}
	
	footer{
		height: 60px;
	}
	

	
</style>
</head>

<body style='background-color:#fdf5e6'>
<div class="position">
<h2>活動資訊</h2> 
	
		<form method="post" action="${pageContext.request.contextPath}/WSSearchByDate" onsubmit="return validateForm()">
			日期 : <input type="text" id="EVENT_STARTIME" name="EVENT_STARTIME" /><button name="type"  value="select">查詢</button>
								
		</form>
		<br>

	<table border="1" >
	<tr style="background-color:#a8fefa">
	<th>活動編號<th>活動名稱<th>報名開始日期<th>報名結束日期<th>活動開始時間<th>活動結束時間<th>活動詳細資料<th>活動種類<th>報名金額<th>活動地址<th>組織者<th>圖片</th></tr>
	
	<%List<Event> eventBeans=(ArrayList<Event>)request.getAttribute("eventBeans");
	for(Event evBean:eventBeans){%>

	<tr>
		<td><%=evBean.getEventId()%></td>
		<td><%=evBean.getEventName()%></td>
		<td><%=evBean.getSignupStartime()%></td>
		<td><%=evBean.getSignupEndtime()%></td>
		<td><%=evBean.getStartTime()%></td>
		<td><%=evBean.getEndTime()%></td>
		<td><%=evBean.getEventDetail() %></td>
		<td><%=evBean.getEventCategory()%></td>
		<td><%=evBean.getEventPrice()%></td>
		<td><%=evBean.getEventLocation()%></td>
		<td><%=evBean.getOrganizer()%></td>
		<td><%=evBean.getPicture()%></td>
		
		<td><form action="WSGetUpdateData" method="post">
		
		<input type="hidden" name="EVENTID" value="<%=evBean.getEventId()%>">
		<button type="submit" class="update">更新</button>
		
		</form></td>
		<td><form action="WSdelete" method="post">
		
		<input type="hidden" name="EVENTID" value="<%=evBean.getEventId()%>">
		<button type="submit" class="delete">刪除</button>
		
		</form></td>
	
		
	</tr>
	
	<% }%>
	</table>
	
	
	<a href="/EventHibernate/html/WSinsert.html"><input type="submit" value="新增資料"></a>
	<a href="${pageContext.request.contextPath}/WSall"><input type="submit" value="查詢所有資料"></a>
	<footer></footer>
</div>	
	<!--<form method="post"action="html/index.html">
		<button>回首頁</button>
	</form>-->
	 <script>
	 
     
        const update = document.querySelector('.update')
        add.addEventListener('click', function () {
            location.href = 'WSGetUpdateData.html'
        })

        

        const delete = document.querySelector('.delete')
        getAll.addEventListener('click', function () {
            location.href = '../WSdelete'
        })
        

    </script>
	

</body>
</html>