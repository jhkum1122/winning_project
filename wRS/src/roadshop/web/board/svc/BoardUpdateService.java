package roadshop.web.board.svc;

import java.sql.*;
import static roadshop.db.jdbcUtil.*;

import roadshop.web.board.dao.BoardDAO;
import roadshop.web.board.vo.BoardInfo;

public class BoardUpdateService {

	public boolean modifyArticle(BoardInfo article) throws Exception{

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