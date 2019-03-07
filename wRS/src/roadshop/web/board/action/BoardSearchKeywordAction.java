package roadshop.web.board.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import roadshop.actionforward.ActionForward;
import roadshop.web.board.svc.BoardSearchService;
import roadshop.web.board.svc.PagingService;
import roadshop.web.board.vo.BoardInfo;
import roadshop.web.board.vo.PagingInfo;

@Controller
public class BoardSearchKeywordAction implements BoardAction{

	@RequestMapping("/main/searchKeyword.bo")
	public ModelAndView boardSearchKeyword(String category, String keyword,
			@RequestParam(value="pageNum",defaultValue="1") String pageNum) throws Exception {
		ModelAndView mav = new ModelAndView();
		ArrayList<BoardInfo> selectedList = null;			//��� ���� ���� �� ArticleList��!!
		int pageSize = 10;
		PagingService pS=new PagingService();
		PagingInfo pagingInfo=pS.getPagingInfo(pageNum, pageSize, category, keyword);
		BoardSearchService bSS = new BoardSearchService();
		//���ݱ����� category���� ��� ������ �ִ� ���� Ȯ����!!
		//���� category�� ������ ����!! getCategoryList()���� category���� record�� ���� �� ����!
		selectedList = bSS.getCategoryList(keyword,category, pagingInfo.getStartRow(),pageSize);
		
		if(selectedList.size() > 0){
			//�ۼ��ڰ� ��ġ�ϴ� �κ��� ã��!!
			mav.addObject("pagingInfo", pagingInfo);
			//request.setAttribute("searchPageNum", searchPageNum);
			mav.addObject("selectedList", selectedList);
			mav.addObject("load", "../main/boardList.bo");
			mav.setViewName("../main/boardList.bo");
		}else{
			mav.addObject("selectedList", null);
			mav.addObject("load", "../main/boardList.bo");
			mav.setViewName("../main/boardList.bo");
		}
		return mav;
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
