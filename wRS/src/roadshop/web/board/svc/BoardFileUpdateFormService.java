package roadshop.web.board.svc;

import java.sql.Connection;
import static roadshop.db.jdbcUtil.*;

import roadshop.web.board.dao.BoardDAO;
import roadshop.web.board.vo.BoardInfo;

public class BoardFileUpdateFormService {

	public BoardInfo getFileUpdateArticle(int num) {
		// TODO Auto-generated method stub
		System.out.println("이 곳은 BoardFileUpdateFormService.getFileUpdateArticle(int num)입니다.");
		Connection con=con();
		BoardDAO dao=new BoardDAO(con);
		//해당글(article) 1개를 갖고오는 기능!!
		//해당 컬럼에 맞게 바꿔줌!!
		BoardInfo article=dao.selectFileUpdateArticle(num);
		close(con);
		return article;
	}
}
