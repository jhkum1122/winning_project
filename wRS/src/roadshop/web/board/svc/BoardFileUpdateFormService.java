package roadshop.web.board.svc;

import java.sql.Connection;
import static roadshop.db.jdbcUtil.*;

import roadshop.web.board.dao.BoardDAO;
import roadshop.web.board.vo.BoardInfo;

public class BoardFileUpdateFormService {

	public BoardInfo getFileUpdateArticle(int num) {
		// TODO Auto-generated method stub
		System.out.println("�� ���� BoardFileUpdateFormService.getFileUpdateArticle(int num)�Դϴ�.");
		Connection con=con();
		BoardDAO dao=new BoardDAO(con);
		//�ش��(article) 1���� �������� ���!!
		//�ش� �÷��� �°� �ٲ���!!
		BoardInfo article=dao.selectFileUpdateArticle(num);
		close(con);
		return article;
	}
}