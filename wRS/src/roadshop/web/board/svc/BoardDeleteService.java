package roadshop.web.board.svc;

import static roadshop.db.jdbcUtil.*;

import java.sql.Connection;

import roadshop.web.board.dao.BoardDAO;

public class BoardDeleteService {
	//이 곳에서는 num인자를 받아서 해당글이
	//DAO의 deleteArticle(num)를 통해서 제대로 실행 되었다면(삭제)
	public boolean deleteArticle(int num) throws Exception{
		Connection con=con();
		BoardDAO dao=new BoardDAO(con);
		boolean deleteSuccess=false;
		int deleteCount=0;
		System.out.println("이 곳은 service.deleteArticle(int num)입니다.");
		deleteCount=dao.deleteArticle(num);
		
		if(deleteCount>0){
			deleteSuccess=true;
			commit(con);
		}else{
			rollback(con);
		}
		close(con);
		return deleteSuccess;
	}
}