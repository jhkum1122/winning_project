<!-- 

	�� ���� �� ����������page����
	�ۻ���<Button>�� ������ �� ������ page�� ��Ÿ��!!!


	�� �������� �ۻ����� ���� �۹�ȣ,//���� �� ���� �������� �����ֱ����� ��������ȣ
	�� �����!!
	
	�ۻ���<button>�� ������ �� 
	boardDelete.bo������ �̿��Ѵ�!!post������� �̵�!!
	
	�۸�Ϻ��⸦ ��ũ�� �����ؼ� ������ �̿��ϰ� �Ѵ�!!

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
	//�� ���� �� ������ Ȯ���ϴ� �κ�����!!! �ش� ���� �۹�ȣ(num), �ش��page��ȣ(pageNum)�� ����´�!
	int num=(Integer)request.getAttribute("num");//�ۻ����� ���� �۹�ȣ
	String pageNum=(String)request.getParameter("pageNum");//���� �� ���� �������� �����ֱ����� ��������ȣ
%>
<form action="boardDelete.bo" method="post">
	<input type="hidden" name="num" value="<%=num %>" align="center"/>
	<input type="hidden" name="pageNum" value="<%=pageNum %>" align="center"/>
	<input type="submit" value="�ۻ���"  align="center"/><br/>
	<input type="button" value="�ۻ������" OnClick="window.location='boardList.bo'" align="center"/>

</form>

</center>
</body>
</html>