<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Where is my Information?!</title>
		<link rel="stylesheet"	href="<%=request.getContextPath()%>/web/style.css" type="text/css" />
		<script language='JavaScript' src='<%=request.getContextPath()%>/script.js'></script>
		<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
	</head>

<%
	String load = (String) request.getAttribute("load");

	System.out.println("Here is main.jsp in <html> load =" + load);
	if (load == null) {
		load = "index.jsp";
	}
	String mem_id = (String)session.getAttribute("id");
	System.out.println("Here is main.jsp in <html> mem_id =" + mem_id);
	
%>

	<body background = "/images/bg-body-top.jpg">
		<div class="body">
			<div class="center2">
				<%
				System.out.println("Here is main.jsp in <body> load =" + load);
				%>
				<jsp:include page="<%=load%>"></jsp:include>
			</div>
			<div class="center3"></div>
		</div>
	</body>
</html>