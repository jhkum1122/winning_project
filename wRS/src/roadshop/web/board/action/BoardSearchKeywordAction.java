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
		ArrayList<BoardInfo> selectedList = null;			//결과 값을 리턴 할 ArticleList임!!
		int pageSize = 10;
		PagingService pS=new PagingService();
		PagingInfo pagingInfo=pS.getPagingInfo(pageNum, pageSize, category, keyword);
		BoardSearchService bSS = new BoardSearchService();
		//지금까지는 category별로 몇개의 갯수가 있는 지를 확인함!!
		//아직 category로 나뉘지 않음!! getCategoryList()에서 category별로 record를 갖고 올 것임!
		selectedList = bSS.getCategoryList(keyword,category, pagingInfo.getStartRow(),pageSize);
		
		if(selectedList.size() > 0){
			//작성자가 일치하는 부분을 찾음!!
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
