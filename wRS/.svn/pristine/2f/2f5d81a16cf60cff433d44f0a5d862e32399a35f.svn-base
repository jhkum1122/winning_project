package roadshop.web.board.svc;

import static roadshop.db.jdbcUtil.*;

import java.sql.Connection;

import roadshop.web.board.dao.BoardDAO;
import roadshop.web.board.vo.BoardInfo;

public class BoardFileUploadService {

	public boolean getBoardFileUpload(BoardInfo article) {
		// TODO Auto-generated method stub
		boolean isSuccess = false;
		
		Connection con = con();
		BoardDAO boardDAO = new BoardDAO(con);
		
		int count = boardDAO.insertArticle(article);
		if(count>0){
			System.out.println("\nDAO.insertArticle이후\nBoardFileUploadService.getBoardFileUpload()의 count > 0");
			isSuccess = true;
			commit(con);
		}
		else{
			System.out.println("\nDAO.insertArticle이후\nBoardFileUploadService.getBoardFileUpload()의 count <= 0");
			rollback(con);
		}
		close(con);
		return isSuccess;
	}
}
