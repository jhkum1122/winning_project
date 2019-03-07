<!-- 

	이 곳은 글 상세정보보기page에서
	글삭제<Button>을 눌렀을 때 나오는 page를 나타냄!!!


	이 곳에서는 글삭제를 위해 글번호,//삭제 후 보던 페이지를 보여주기위해 페이지번호
	를 갖고옴!!
	
	글삭제<button>을 눌렀을 때 
	boardDelete.bo서블렛을 이용한다!!post방식으로 이동!!
	
	글목록보기를 링크로 연결해서 서블렛을 이용하게 한다!!

 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<title>Insert title here</title>
</head>
<body>
<center>


<%
	//이 곳은 글 삭제를 확인하는 부분으로!!! 해당 글의 글번호(num), 해당글page번호(pageNum)을 갖고온다!
	int num=(Integer)request.getAttribute("num");//글삭제를 위해 글번호
	String pageNum=(String)request.getParameter("pageNum");//삭제 후 보던 페이지를 보여주기위해 페이지번호
%>
<form action="boardDelete.bo" method="post">
	<input type="hidden" name="num" value="<%=num %>" align="center"/>
	<input type="hidden" name="pageNum" value="<%=pageNum %>" align="center"/>
	<input type="submit" value="글삭제"  align="center"/><br/>
	<input type="button" value="글삭제취소" OnClick="window.location='boardList.bo'" align="center"/>

</form>

</center>
</body>
</html>