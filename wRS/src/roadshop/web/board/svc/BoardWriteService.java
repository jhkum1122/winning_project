package roadshop.web.board.svc;

import static roadshop.db.jdbcUtil.*;

import java.sql.Connection;

import roadshop.web.board.dao.BoardDAO;
import roadshop.web.board.vo.BoardInfo;
/*
	�� ���� �ش� ���� �� ������ �Ǿ����� Ȯ���ϴ� �κ���!!
	������ �� �Ǿ��ٸ� DB�� ���� �ִ� ���� �����Ŵ!!
	�׷��� �ʴٸ� rollback���Ѽ� insert�� �������� ����~!
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
			System.out.println("\nDAO.insertArticle����\nBoardWriteService.writeArticle()�� count > 0");
			commit(con);
			insertResult=true;
		}else{
			
			System.out.println("\nDAO.insertArticle����\nBoardWriteService.writeArticle()�� count <= 0");
			rollback(con);
		}
		close(con);
		return insertResult;
	}
}