<%@page import="roadshop.web.board.vo.BoardInfo"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ include file="/view/color.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type = "text/javascript"  src="<%=request.getContextPath() %>/board/script.js"></script>

<title>board(using files)</title>

<script type = "text/javascript">

function writeSave(){
	if(document.fileWriteForm.b_writer.value==""){
		  alert("Enter your name");
		  document.fileWriteForm.b_writer.focus();
		  return false;
	}
	
	if(document.fileWriteForm.b_subject.value==""){
		  alert("Enter a subject");
		  document.fileWriteForm.b_subject.focus();
		  return false;
	}
	
	if(document.fileWriteForm.m_id.value==""){
		  alert("Enter your memberID");
		  document.fileWriteForm.m_id.focus();
		  return false;
	}
	
	if(document.fileWriteForm.i_id.value==""){
		  alert("Enter your itemID");
		  document.fileWriteForm.i_id.focus();
		  return false;
	}
	
	if(document.fileWriteForm.b_content.value==""){
		  alert("Enter your itemID");
		  document.fileWriteForm.b_content.focus();
		  return false;
	}
}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

<% 
	//request는 BoardFileWriteFormAction.execute(request,response)에서 온 것임!!
	BoardInfo boardInfo = (BoardInfo)request.getAttribute("boardInfo");
	System.out.println("Here is fileWriteForm.jsp get boardInfo b_num = "+ boardInfo.getB_num());
	System.out.println("getRef = " + boardInfo.getRef());
	System.out.println("getRe_step = " + boardInfo.getRe_step());
	//각 각 BoardWriteFormAction.execute(request,response)에서 request.setAttribute로 정의한 것을 얻은 부분임!
	//이 곳은 BoardFileWriteFormAction에서 setAttribute한 부분을 갖다가 씀!!
	int num=boardInfo.getB_num();
	int ref=boardInfo.getRef();
	int re_step=boardInfo.getRe_step();
	int re_level=boardInfo.getRe_level();
	
	//이쪽은 시험버전임!!m_id!!
	String i_id = boardInfo.getI_id();
	String m_id = boardInfo.getM_id();
	System.out.println("boardInfo's b_num = "+boardInfo.getB_num());
	System.out.println("boardInfo's ref = "+boardInfo.getRef());
	System.out.println("boardInfo's Re_step = "+boardInfo.getRe_step());
	System.out.println("boardInfo's memberID = "+boardInfo.getM_id());
	System.out.println("boardInfo's ItemID = "+boardInfo.getI_id());
	System.out.println("20190306 fileWriteForm까지는 값이 잘 받아짐!!하지만 과연 맞을까???! ");

	request.setAttribute("ref",ref);
	request.setAttribute("re_level",re_level);
	request.setAttribute("re_step",re_step);
%>
   
<body>
<center><b>File Writing</b>
<br>
<form method="post"  enctype="multipart/form-data" name="fileWriteForm" action="boardFileWritePro.bo" onsubmit="return writeSave()">
	<input type="hidden" name="b_num" value="<%=num%>">
	<input type="hidden" name="ref" value="<%=ref%>">
	<input type="hidden" name="re_step" value="<%=re_step%>">
	<input type="hidden" name="re_level" value="<%=re_level%>">
	
	<table width="400" border="1" cellspacing="0" cellpadding="0"
	   align="center">
	  	<tr bgcolor="#0099CC">
		   <td colspan="2" align="right" bgcolor="f567b6">
  			<input type="button" value="List" OnClick="window.location='boardList.bo'">	    </td>
	  	</tr>
	  	<tr>
		    <td  width="70"  bgcolor="f567b6" align="center"><center>name</center></td>
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
			      <%}%>
			</td>
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
	  
	  	<tr bgcolor="f567b6">
	   		<td  bgcolor="f567b6" align="center" >게시판이미지</td>
	    		<td bgcolor="#FFFFFF"><input name="b_image" type="file"></td>
      	</tr>
	  	<tr>
		    <td  width="70"  bgcolor="f567b6" align="center" >내 용</td>
		    <td  width="330" bgcolor="#FFFFFF" > 
				<textarea name="b_content" rows="13" cols="40"></textarea>
		    </td>
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
