package roadshop.web.board.svc;
import static roadshop.db.jdbcUtil.*;

import java.sql.Connection;
import roadshop.web.board.dao.BoardDAO;
import roadshop.web.board.vo.PagingInfo;

public class PagingService {
	//pageSize(param) = �� �������� �ִ� ��(article)�� ũ�⸦ �ǹ��Ѵ�!
	//pageNum(param) = ���� �������� ��Ÿ���� pageNo
	public PagingInfo getPagingInfo(String pageNum, int pageSize) throws Exception{
		// TODO Auto-generated method stub
		int currentPage = Integer.parseInt(pageNum);		//���� �������� ��Ÿ��!!
		int startRow = (currentPage - 1) * pageSize + 1;	//�� �������� ���� article(record)�� ��Ÿ��!	
		int count = 0;
		//�� ���ڵ�(article) �� ���� ������ ����
		int number = 0;		//����number�� �˷��ִ� localNumbers
		//�� ��ȣ�� ������ ����
		
		System.out.println("Here is PagingService.getPagingInfo");

		Connection con=con();		
		BoardDAO dao=new BoardDAO(con);
		
		System.out.println("after Connection & BoardDAO");

		count = dao.selectArticleCount();	//�� ������ ���� DB�� ����Ǿ� �ִ� ���� ������ �˾ƿ�!
		
		System.out.println("after BoardDAO.selectArticleCount()");

		number = count - ((currentPage - 1) * pageSize);
		//��ü ���ڵ� ���� : 134
		//���� ������ : 2
		//134 - (2 - 1) * 10 -----> 124
				
		int pageCount=0;
		int startPage=0;
		int endPage=0;
		
		//���� �ϳ��� ������ ���� ����¡ ó����
		if(count > 0){
			//�� ������ �� ���� ���ϴ� �κ�
			pageCount = count/pageSize + ((count % pageSize) == 0 ? 0 : 1);
		
			//�ϳ��� ������ �׷��� ���� ������
			startPage = (int) ((currentPage - 1) / 10) * 10 + 1;
			
			//�ϳ��� ������ �׷쿡 ��µ� ������ ��
			int pageBlock = 10;
		
			//�� ������ �׷쿡 ��µǴ� ������ ������ ��ȣ
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
		//�ᱹ, ���� page��ȣ, ����page��ȣ,������page��ȣ,page�� ����,��(record)�� ��
		//�� page�� record��, �� page���� �����ϴ� ��(record)�� ��ȣ�� ��� ����
	}
	
	
	
	//���� ī�װ����� count�� ����
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