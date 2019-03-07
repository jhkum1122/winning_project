package roadshop.web.board.svc;

import java.sql.*;
import static roadshop.db.jdbcUtil.*;

import roadshop.web.board.dao.BoardDAO;
import roadshop.web.board.vo.BoardInfo;

public class BoardUpdateFormService {

	//�� ���� �ش� DB�� �����ϴ� �κ��� ����ϰ� �ֽ��ϴ�.
	public BoardInfo getUpdateArticle(int num) throws Exception{
		
		System.out.println("�� ���� BoardUpdateFormService.getUpdateArticle(int num)�Դϴ�.");
		Connection con=con();
		BoardDAO dao=new BoardDAO(con);
		//�ش��(article) 1���� ������� ���!!
		//�ش� �÷��� �°� �ٲ���!!
		BoardInfo article=dao.selectUpdateArticle(num);
		close(con);
		return article;
	}

}
