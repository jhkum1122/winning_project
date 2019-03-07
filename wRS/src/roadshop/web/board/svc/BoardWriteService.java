package roadshop.web.board.svc;

import static roadshop.db.jdbcUtil.*;

import java.sql.Connection;

import roadshop.web.board.dao.BoardDAO;
import roadshop.web.board.vo.BoardInfo;
/*
	이 곳은 해당 글이 잘 삽입이 되었는지 확인하는 부분임!!
	삽입이 잘 되었다면 DB에 값을 넣는 것을 실행시킴!!
	그렇지 않다면 rollback시켜서 insert를 실행하지 않음~!
*/
public class BoardWriteService {

	public boolean writeArticle(BoardInfo article) throws Exception{
		Connection con=con();
		BoardDAO dao=new BoardDAO(con);
		boolean insertResult=false;
		System.out.println("Here is BoardWriteService before insertArticle()");

		int count=dao.insertArticle(article);
		System.out.println("Here is BoardWriteService writeArticle() count = " + count);
		
		if(count>0){
			System.out.println("\nDAO.insertArticle이후\nBoardWriteService.writeArticle()의 count > 0");
			commit(con);
			insertResult=true;
		}else{
			
			System.out.println("\nDAO.insertArticle이후\nBoardWriteService.writeArticle()의 count <= 0");
			rollback(con);
		}
		close(con);
		return insertResult;
	}
}