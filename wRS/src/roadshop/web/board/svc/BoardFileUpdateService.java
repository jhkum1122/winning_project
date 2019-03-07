package roadshop.web.board.svc;

import static roadshop.db.jdbcUtil.*;

import java.sql.Connection;

import roadshop.web.board.dao.BoardDAO;
import roadshop.web.board.vo.BoardInfo;

public class BoardFileUpdateService {

	public boolean modifyFileArticle(BoardInfo article) {

		boolean updateSuccess=false;
		int updateCount=0;
		Connection con=con();
		BoardDAO dao=new BoardDAO(con);
		
		updateCount=dao.updateArticle(article);//-1,0,1�� �ϳ�
		//1�� ����� update//// -1,0�� �׷��� ����
		if(updateCount>0){
			updateSuccess=true;
			commit(con);
		}else{
			rollback(con);
		}
		close(con);
		return updateSuccess;
	}
}
