package roadshop.web.board.action;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import roadshop.actionforward.ActionForward;
import roadshop.web.board.svc.BoardListService;
import roadshop.web.board.svc.PagingService;
import roadshop.web.board.vo.BoardInfo;
import roadshop.web.board.vo.PagingInfo;

@Controller
public class BoardListAction implements BoardAction{
	
	@RequestMapping("/main/boardList.bo")
	public ModelAndView boardList(@RequestParam(value="pageNum",defaultValue="1") String pageNum) throws Exception {
		System.out.println("Here is BoardListAction.execute()");
		ModelAndView mav = new ModelAndView();

		System.out.println("before Paging service!");

		int pageSize = 10;		//page의 size를 나타냄!!
		PagingService ps=new PagingService();				//페이지 처리하는 객체를 만든다1!
		
		PagingInfo pagingInfo=ps.getPagingInfo(pageNum, pageSize);
		System.out.println("Here is BoardListAction.execute() before service function!");

		BoardListService bls = new BoardListService();
		List<BoardInfo> articleList=null;				//글들을 저장할 변수 설정
		System.out.println("Here is BoardListAction.execute() before service function!");

		if(pagingInfo.getCount()>0)
		{
			articleList = bls.getArticleList(pagingInfo.getStartRow(),pageSize);
		}

		String load = "../board/list.jsp";
		System.out.println("Here is BoardListAction.execute() before Load!");
		System.out.println("load string = " + load);

		mav.addObject("pagingInfo", pagingInfo);
		mav.addObject("articleList", articleList);
		mav.addObject("load",load);
		
		System.out.println("Here is BoardListAction.execute() after Load!");

//		mav.setViewName("../main/beforeMain.jsp");

		mav.setViewName(load);
		return mav;
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}