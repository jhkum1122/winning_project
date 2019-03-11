﻿<%@ page import="roadshop.web.board.vo.BoardInfo"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language="JavaScript" src="<%=request.getContextPath() %>/board/script.js"></script>
<title>게시판</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>

<% 
	//actionForward에서 넘어온 jsp페이지 임!!
	//request는 BoardWriteFormAction.execute(request,response)에서 온 것임!!
	BoardInfo boardInfo = (BoardInfo)request.getAttribute("boardInfo");
	//각 각 BoardWriteFormAction.execute(request,response)에서 request.setAttribute로 정의한 것을 얻은 부분임!
	
	int num=boardInfo.getB_num();
	//ReplyVO를 의미함!!
	int ref=boardInfo.getRef();
	int re_step=boardInfo.getRe_step();
	int re_level=boardInfo.getRe_level();
	
	//이쪽은 시험버전임!!m_id!!
	String i_id = boardInfo.getI_id();
	String m_id = boardInfo.getM_id();
	
	request.setAttribute("ref",ref);
	request.setAttribute("re_level",re_level);
	request.setAttribute("re_step",re_step);

%>
   
<body>
<center><b>글쓰기</b>
<br>
<form method="post" name="writeform" action="boardWritePro.bo" onsubmit="return writeSave()">
	<input type="hidden" name="b_num" value="<%=num%>">
	<input type="hidden" name="ref" value="<%=ref%>">
	<input type="hidden" name="re_step" value="<%=re_step%>">
	<input type="hidden" name="re_level" value="<%=re_level%>">
	

	<table width="400" border="1" cellspacing="0" cellpadding="0">
	  <tr bgcolor="#0099CC">
		   <td colspan="2" align="right" bgcolor="f567b6">
  				<input type="button" value="목록보기" OnClick="window.location='boardList.bo'">
  			</td>
	  </tr>
	  <tr>
		    <td  width="70"  bgcolor="f567b6" ><center>이 름</center></td>
	    <td  width="330" bgcolor="#FFFFFF"><input type="text" size="10" maxlength="10" name="b_writer"></td>
	  </tr>
	  <tr>
		    <td  width="70"  bgcolor="f567b6" align="center" >제 목</td>
		    <td  width="330" bgcolor="#FFFFFF">
			    <%if(num==0){
			    	System.out.println(num+"if(b_num==0)");
			    %>
			       <input type="text" size="40" maxlength="50" name="b_subject"/>
				<%}else{
					System.out.println(num+"else(b_num !=0)");
				%>
				   <input type="text" size="40" maxlength="50" name="b_subject" 
				   value="[Re]"/>
		<%}%>		</td>
	  </tr>
	  <tr>
	    <td  width="70"  bgcolor="f567b6" align="center">멤버id</td>
	    <td  width="330" bgcolor="#FFFFFF">
        <input type="text" size="40" maxlength="30" name="m_id" value="" ></td>
	  </tr>
	  <tr>
	    <td  width="70"  bgcolor="f567b6" align="center">아이템id</td>
	    <td  width="330" bgcolor="#FFFFFF">
        <input type="text" size="40" maxlength="30" name="i_id" ></td>
	  </tr>
	  
	  <tr>
	    <td  bgcolor="f567b6" align="center" >게시판이미지</td>
	    <td bgcolor="#FFFFFF" ><input type="text" size="40" maxlength="30" name="b_image" ></td>
      </tr>
	  <tr>
		    <td  width="70"  bgcolor="f567b6" align="center" >내 용</td>
		    <td  width="330" bgcolor="#FFFFFF" >
        <textarea name="b_content" rows="13" cols="40"></textarea> </td>
	  </tr>
		<tr bgcolor="#0099CC">
			 <td colspan=2 align="center" bgcolor="f567b6"> 
			   	<input type="submit" value="글쓰기">  
			  	<input type="reset" value="다시작성">
  		  		<input type="button" value="목록보기" OnClick="window.location='boardList.bo'">	  	  
  		  	</td>
	  	</tr>
	</table>    
</form>  
</center>    
</body>
</html>      
