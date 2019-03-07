package roadshop.web.board.svc;

import static roadshop.db.jdbcUtil.*;

import java.sql.Connection;

import roadshop.web.board.dao.BoardDAO;
import roadshop.web.board.vo.BoardInfo;

public class BoardContentService {
	
	public BoardInfo getArticle(int num) throws Exception{
		// TODO Auto-generated method stub
		//param num = 글의 번호이다.b_num이라고 생각해도 무방함!!
		Connection con= con();
		BoardDAO dao=new BoardDAO(con);
		BoardInfo article=dao.selectArticle(num);
		
		System.out.println("이 곳은 BoardContentService입니다." +
				"BoardDAO.selectArticle()갖고 온 후 입니다.");
		return article;
	}
}