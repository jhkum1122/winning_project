package roadshop.web.board.svc;

import static roadshop.db.jdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import roadshop.web.board.dao.BoardDAO;
import roadshop.web.board.vo.BoardInfo;

public class BoardSearchService {

	Connection con = con();
	BoardDAO boardDao = new BoardDAO(con);
	ArrayList<BoardInfo> check = new ArrayList<BoardInfo>();

	public ArrayList<BoardInfo> getCategoryList(String keyword,
			String category, int startRow, int pageSize) {
		check = boardDao.selectCategorySearchList(keyword,category,startRow,pageSize);
		System.out.println("BoardSearchService.getCategoryList()의 마지막부분 ");
		close(con);
		return check;
	}


}
