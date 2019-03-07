package roadshop.web.board.svc;

import java.util.List;
import java.sql.*;
import static roadshop.db.jdbcUtil.*;
import roadshop.web.board.dao.BoardDAO;
import roadshop.web.board.vo.BoardInfo;


public class BoardListService {
	
	//해당페이지에 출력될 글 목록(articleList) 리턴
	//startRow = 시작하는 기사번호!!,pageSize= 한개의 페이지에 나타나있는 글의 갯수
	public List<BoardInfo> getArticleList(int startRow, int pageSize) throws Exception{
		// TODO Auto-generated method stub
		System.out.println("이곳은 BoardListService.getArticleList() 입니다.");
		System.out.println("이곳은 이 곳에서 DB를 연결하고, \n DAO에 있는 selectArticleList(startRow, pageSize)을 호출합니다.");
		Connection con= con();
		BoardDAO dao=new BoardDAO(con);
		
		List<BoardInfo> articleList=dao.selectArticleList(startRow, pageSize);
		//이하는 수정판입니다.!!매우 조심해야함!!
		//articleList=dao.getArticleList(startRow, pageSize);
		System.out.println("getArticleList() 에서 selectArticleList(startRow, pageSize)를 호출한 후 입니다.");
		close(con);
		
		return articleList;//해당페이지에 출력될 글 목록(articleList) 리턴
	}
}