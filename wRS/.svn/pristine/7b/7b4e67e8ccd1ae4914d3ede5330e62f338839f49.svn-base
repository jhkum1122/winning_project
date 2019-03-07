package roadshop.web.board.svc;

import java.sql.*;
import static roadshop.db.jdbcUtil.*;

import roadshop.web.board.dao.BoardDAO;
import roadshop.web.board.vo.BoardInfo;

public class BoardUpdateFormService {

	//이 곳은 해당 DB를 연결하는 부분을 담당하고 있습니다.
	public BoardInfo getUpdateArticle(int num) throws Exception{
		
		System.out.println("이 곳은 BoardUpdateFormService.getUpdateArticle(int num)입니다.");
		Connection con=con();
		BoardDAO dao=new BoardDAO(con);
		//해당글(article) 1개를 갖고오는 기능!!
		//해당 컬럼에 맞게 바꿔줌!!
		BoardInfo article=dao.selectUpdateArticle(num);
		close(con);
		return article;
	}

}
