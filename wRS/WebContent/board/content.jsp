<!-- �̰��� �� �󼼺��� ������ ������ �κ��̴�!!!
<����>
<�ۼ���>
<��ȸ��>
<����>
<�̸���>
<button>�ۼ���
<button>�ۻ���
<button>��۾���
<button>�������!!
-->

<%@page import="roadshop.web.board.vo.BoardInfo"%>
<%@page import="roadshop.web.board.dao.BoardDAO"%>
<%@ include file="/view/color.jsp"%>
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
/*�� �κ��� ���� �����ؾ� ��!!*/
	BoardInfo article=(BoardInfo)request.getAttribute("article");	
	//�ٿ�ĳ����(BoardInfo), �׸��� �ش� ���(record)�� ����!!
	String pageNum=(String)request.getParameter("pageNum");			//pageNum�� ���ؼ� �޾ƿ�!! 
	
%>
</head>
<body >
<center>
	<table border="1">
		<tr>
			<td colspan="2" bgcolor="#f567b6">����</td>
		  	<td colspan="4" bgcolor="#FFFFFF" ><%=article.getB_subject() %>
       	  <input name="button" type="button" onClick="window.location='boardList.bo'" value="�۽Ű�" align="right">		  </td>
		</tr>
		<tr>
			<td width="60" height="45" bgcolor="#f567b6">�ۼ���</td>
		 	<td width="80" bgcolor="#FFFFFF"><%=article.getB_writer() %></td>
			<td width="60" bgcolor="#f567b6">��ȸ��</td>
			<td width="180" bgcolor="#FFFFFF"><%=article.getReadcount() %></td>		
		</tr>	
		
		<tr>
		  <td height="20" colspan="2" bgcolor="#f567b6">���id</td>
		  <td colspan="4" bgcolor="#FFFFFF"><%=article.getM_id() %></td>
	  	</tr>
		<tr>
		  <td height="20" colspan="2" bgcolor="#f567b6">������id</td>
		  <td colspan="4" bgcolor="#FFFFFF"><%=article.getI_id() %></td>
	  	</tr>
		<tr>
		  <td height="20" colspan="2" bgcolor="#f567b6">�Խ����̹���</td>
		  <td colspan="4" bgcolor="#FFFFFF">
		  <img src="<%=request.getContextPath() %>/board/images/<%=article.getB_image() %>" height="200" border="0">
		  </td>
	  </tr>
		<tr>
			<td height="150" colspan="2" bgcolor="#f567b6">����</td>
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