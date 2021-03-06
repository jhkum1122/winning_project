package roadshop.web.board.svc;
import static roadshop.db.jdbcUtil.*;

import java.sql.Connection;
import roadshop.web.board.dao.BoardDAO;
import roadshop.web.board.vo.PagingInfo;

public class PagingService {
	//pageSize(param) = 한 페이지에 있는 글(article)의 크기를 의미한다!
	//pageNum(param) = 현재 페이지를 나타내는 pageNo
	public PagingInfo getPagingInfo(String pageNum, int pageSize) throws Exception{
		// TODO Auto-generated method stub
		int currentPage = Integer.parseInt(pageNum);		//현재 페이지를 나타냄!!
		int startRow = (currentPage - 1) * pageSize + 1;	//한 페이지의 시작 article(record)를 나타냄!	
		int count = 0;
		//총 레코드(article) 개 수를 저장할 변수
		int number = 0;		//글의number를 알려주는 localNumbers
		//글 번호를 저장할 변수
		
		System.out.println("Here is PagingService.getPagingInfo");

		Connection con=con();		
		BoardDAO dao=new BoardDAO(con);
		
		System.out.println("after Connection & BoardDAO");

		count = dao.selectArticleCount();	//이 것으로 현재 DB에 저장되어 있는 글의 갯수를 알아옴!
		
		System.out.println("after BoardDAO.selectArticleCount()");

		number = count - ((currentPage - 1) * pageSize);
		//전체 레코드 개수 : 134
		//현재 페이지 : 2
		//134 - (2 - 1) * 10 -----> 124
				
		int pageCount=0;
		int startPage=0;
		int endPage=0;
		
		//글이 하나라도 존재할 때만 페이징 처리함
		if(count > 0){
			//총 페이지 개 수를 구하는 부분
			pageCount = count/pageSize + ((count % pageSize) == 0 ? 0 : 1);
		
			//하나의 페이지 그룹의 시작 페이지
			startPage = (int) ((currentPage - 1) / 10) * 10 + 1;
			
			//하나의 페이지 그룹에 출력될 페이지 수
			int pageBlock = 10;
		
			//한 페이지 그룹에 출력되는 마지막 페이지 번호
			endPage = startPage + pageBlock - 1;
			
			if(endPage > pageCount)
				endPage = pageCount;
		}
		PagingInfo info=new PagingInfo();
		info.setCount(count);
		info.setCurrentPage(currentPage);
		info.setEndPage(endPage);
		info.setB_number(number);
		info.setPageCount(pageCount);
		info.setStartPage(startPage);
		info.setStartRow(startRow);
				
		return info;
		//결국, 현재 page번호, 시작page번호,마지막page번호,page의 갯수,글(record)의 수
		//한 page의 record수, 한 page에서 시작하는 글(record)의 번호를 담고 있음
	}
	
	
	
	//들어온 카테고리로 count를 센다
	public PagingInfo getPagingInfo(String pageNum, int pageSize, String category, String keyword) throws Exception{
		int currentPage = Integer.parseInt(pageNum);		
		int startRow = (currentPage - 1) * pageSize + 1;		
		int count = 0;
		int number = 0;		
		Connection con=con();		
		BoardDAO dao=new BoardDAO(con);
		
		count = dao.selectCategoryCount(category,keyword);
		number = count - ((currentPage - 1) * pageSize);
						
		int pageCount=0;
		int startPage=0;
		int endPage=0;
		
		if(count > 0){
			pageCount = count/pageSize + ((count % pageSize) == 0 ? 0 : 1);
		
			startPage = (int) ((currentPage - 1) / 10) * 10 + 1;
			
			int pageBlock = 10;
		
			endPage = startPage + pageBlock - 1;
			
			if(endPage > pageCount)
				endPage = pageCount;
		}
		PagingInfo info=new PagingInfo();
		info.setCount(count);
		info.setCurrentPage(currentPage);
		info.setEndPage(endPage);
		info.setB_number(number);
		info.setPageCount(pageCount);
		info.setStartPage(startPage);
		info.setStartRow(startRow);
				
		return info;
	}
}