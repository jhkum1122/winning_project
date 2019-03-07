package roadshop.web.board.svc;

import static roadshop.db.jdbcUtil.*;

import java.sql.Connection;

import roadshop.web.board.dao.BoardDAO;
import roadshop.web.board.vo.BoardInfo;

public class BoardContentService {
	
	public BoardInfo getArticle(int num) throws Exception{
		// TODO Auto-generated method stub
		//param num = ���� ��ȣ�̴�.b_num�̶�� �����ص� ������!!
		Connection con= con();
		BoardDAO dao=new BoardDAO(con);
		BoardInfo article=dao.selectArticle(num);
		
		System.out.println("�� ���� BoardContentService�Դϴ�." +
				"BoardDAO.selectArticle()���� �� �� �Դϴ�.");
		return article;
	}
}