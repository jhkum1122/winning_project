<!-- 이곳은 글 상세보기 내용이 나오는 부분이다!!!
<제목>
<작성자>
<조회수>
<내용>
<이메일>
<button>글수정
<button>글삭제
<button>답글쓰기
<button>목록으로!!
-->

<%@page import="roadshop.web.board.vo.BoardInfo"%>
<%@page import="roadshop.web.board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="style.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="script.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<title>Insert title here</title>
<%
/*이 부분을 오늘 수정해야 함!!*/
	BoardInfo article=(BoardInfo)request.getAttribute("article");	
	//다운캐스팅(BoardInfo), 그리고 해당 기사(record)를 받음!!
	String pageNum=(String)request.getParameter("pageNum");			//pageNum에 대해서 받아옴!! 
	
%>
</head>
<body >
<center>
	<table border="1">
		<tr>
			<td colspan="2" bgcolor="#f567b6">제목</td>
		  	<td colspan="4" bgcolor="#FFFFFF" ><%=article.getB_subject() %>
       	  <input name="button" type="button" onClick="window.location='boardList.bo'" value="글신고" align="right">		  </td>
		</tr>
		<tr>
			<td width="60" height="45" bgcolor="#f567b6">작성자</td>
		 	<td width="80" bgcolor="#FFFFFF"><%=article.getB_writer() %></td>
			<td width="60" bgcolor="#f567b6">조회수</td>
			<td width="180" bgcolor="#FFFFFF"><%=article.getReadcount() %></td>		
		</tr>	
		
		<tr>
		  <td height="20" colspan="2" bgcolor="#f567b6">멤버id</td>
		  <td colspan="4" bgcolor="#FFFFFF"><%=article.getM_id() %></td>
	  	</tr>
		<tr>
		  <td height="20" colspan="2" bgcolor="#f567b6">아이템id</td>
		  <td colspan="4" bgcolor="#FFFFFF"><%=article.getI_id() %></td>
	  	</tr>
		<tr>
		  <td height="20" colspan="2" bgcolor="#f567b6">게시판이미지</td>
		  <td colspan="4" bgcolor="#FFFFFF">
		  <img src="<%=request.getContextPath() %>/board/images/<%=article.getB_image() %>" height="200" border="0">
		  </td>
	  </tr>
		<tr>
			<td height="150" colspan="2" bgcolor="#f567b6">내용</td>
			<td colspan="4" bgcolor="#FFFFFF"><%=article.getB_content()%></td>
		</tr>	
		
		<tr>	    
	    	<td height="25" bgcolor="#f567b6"  colspan="6">
	    		<center>	            
	    		<input type="button" OnClick="document.location.href='boardFileUpdateForm.bo?num=<%=article.getB_num() %>&pageNum=<%=pageNum %>'" value="modification(using a file)"/>
	        	<input type="button" OnClick="document.location.href='boardUpdateForm.bo?num=<%=article.getB_num() %>&pageNum=<%=pageNum %>'" value="modification"/>
				<input type="button" OnClick="document.location.href='boardDeleteForm.bo?num=<%=article.getB_num() %>&pageNum=<%=pageNum %>'" value="deletion"/>
				<input type="button" value="reply(using a file)" Onclick="document.location.href='boardFileWriteForm.bo?num=<%=article.getB_num() %>&ref=<%=article.getRef() %>&re_step=<%=article.getRe_step()%>&re_level=<%=article.getRe_level() %>'"/>
				<input type="button" value="reply" Onclick="document.location.href='boardWriteForm.bo?num=<%=article.getB_num() %>&ref=<%=article.getRef() %>&re_step=<%=article.getRe_step()%>&re_level=<%=article.getRe_level() %>'"/>
				<input type="button" value="List" Onclick="document.location.href='boardList.bo?pageNum=<%=pageNum %>'"/>
  		  		</center>
  		  	</td>
		</tr>
  </table>
</center>
</body>
</html>
