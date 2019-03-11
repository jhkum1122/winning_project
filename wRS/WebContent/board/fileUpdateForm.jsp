<%@page import="roadshop.web.board.vo.*"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language="JavaScript" src="<%=request.getContextPath() %>/board/script.js"></script>
<title>게시판업데이트화면</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<% 
	//request는 BoardUpdateWriteFormAction.execute(request,response)에서 온 것임!!
	BoardInfo article=(BoardInfo)request.getAttribute("article");
	String pageNum=(String)request.getAttribute("pageNum");
	
	int b_num=article.getB_num();
	//ReplyVO의미
	int ref = article.getRef();
	int re_step = article.getRe_step();
	int re_level = article.getRe_level();
	
	String i_id = article.getI_id();
	String m_id = article.getM_id();

	request.setAttribute("ref",ref);
	request.setAttribute("re_level",re_level);
	request.setAttribute("re_step",re_step);
	System.out.println("이 곳은 fileUpdateForm.jsp입니다.!!");
	System.out.println("이 곳은 에서 값을 제대로 받아왔는지 확인하기 위해서\n"+
	"ref = "+article.getRef() +",re_step = "+article.getRe_step()+",re_level = "+article.getRe_level()+
	",readcount = "+article.getReadcount()+",page_Num = "+pageNum);
	
%>
   
<body>
<center>
<b>글쓰기업데이트화면</b>
<br/>
	<form method="post"  enctype="multipart/form-data" name="fileWriteForm" action="boardFileUpdatePro.bo" onsubmit="return writeSave()">
				<input type="hidden" name="b_num" value="<%=article.getB_num()%>"/>
				<input type="hidden" name="pageNum" value="<%=pageNum%>"/>
				<input type="hidden" name="readcount" value="<%=article.getReadcount()%>"/>
				<input type="hidden" name="ref" value="<%=ref%>"/>
				<input type="hidden" name="re_step" value="<%=re_step%>"/>
				<input type="hidden" name="re_level" value="<%=re_level%>"/>
				
		<table width="400" border="1">
		   	<tr>
				<td align="right" colspan="2" bgcolor="f567b6">
	  		  	<input type="button" value="목록보기" OnClick="window.location='boardList.bo'" >		   	  </td>
		   	</tr>
		   	
		   	<tr>
		    	<td  width="70"  bgcolor="f567b6" align="center">작성자</td>
	    	  	<td  width="330" bgcolor="#FFFFFF"><input type="text" size="10" maxlength="10" name="b_writer" 
		    	value="<%=article.getB_writer()%>"/></td>
		  	</tr>
		  	<tr>
		    	<td  width="70"  bgcolor="f567b6" align="center" >제 목</td>
	    	 	<td  width="330" bgcolor="#FFFFFF"><input type="text" size="40" maxlength="50" name="b_subject"
		    	value="<%=article.getB_subject()%>"/>	       	  </td>
		  	</tr>
		  	
		  	<tr>
		    	<td  bgcolor="f567b6" align="center">MemberId</td>
	    	  <td bgcolor="#FFFFFF"><input type="text" size="40" maxlength="50" name="m_id"
		    	value="<%=article.getM_id()%>"/></td>
	      	</tr>
	      	
		  	<tr>
		    	<td  bgcolor="f567b6" align="center">itemId</td>
	    	  <td bgcolor="#FFFFFF"> <input type="text" size="40" maxlength="50" name="i_id"
		        value="<%=article.getI_id()%>"/></td>
	      	</tr>
		  	<tr>
		    	<td  width="70"  bgcolor="f567b6" align="center">게시판이미지</td>
	    	  	<td bgcolor="#FFFFFF"><input name="b_image" type="file"	value="<%=article.getB_image()%>"/></td>
		  	</tr>
		  	
		  	<tr>
		    	<td  width="70"  bgcolor="f567b6" align="center" >내 용</td>
	   	 	  <td  width="330" bgcolor="#FFFFFF" ><textarea name="b_content" rows="13" cols="40"><%=article.getB_content()%></textarea> </td>
		  	</tr>
		  	
			<tr bgcolor="#0099CC">      
		 		<td colspan=2 align="center" bgcolor="f567b6"> 
				  	<input type="submit" value="글수정">  
				  	<input type="reset" value="다시작성">
		  	  <input type="button" value="목록보기" 
				  	OnClick="window.location='boardList.bo?pageNum=<%=pageNum%>'">			  </td>
			</tr>
	  </table>
	</form>
</center>
</body>

</html>      
