package roadshop.web.board.svc;

import java.util.List;
import java.sql.*;
import static roadshop.db.jdbcUtil.*;
import roadshop.web.board.dao.BoardDAO;
import roadshop.web.board.vo.BoardInfo;


public class BoardListService {
	
	//�ش��������� ��µ� �� ���(articleList) ����
	//startRow = �����ϴ� ����ȣ!!,pageSize= �Ѱ��� �������� ��Ÿ���ִ� ���� ����
	public List<BoardInfo> getArticleList(int startRow, int pageSize) throws Exception{
		// TODO Auto-generated method stub
		System.out.println("�̰��� BoardListService.getArticleList() �Դϴ�.");
		System.out.println("�̰��� �� ������ DB�� �����ϰ�, \n DAO�� �ִ� selectArticleList(startRow, pageSize)�� ȣ���մϴ�.");
		Connection con= con();
		BoardDAO dao=new BoardDAO(con);
		
		List<BoardInfo> articleList=dao.selectArticleList(startRow, pageSize);
		//���ϴ� �������Դϴ�.!!�ſ� �����ؾ���!!
		//articleList=dao.getArticleList(startRow, pageSize);
		System.out.println("getArticleList() ���� selectArticleList(startRow, pageSize)�� ȣ���� �� �Դϴ�.");
		close(con);
		
		return articleList;//�ش��������� ��µ� �� ���(articleList) ����
	}
}