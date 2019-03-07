package roadshop.web.board.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import roadshop.actionforward.ActionForward;
import roadshop.web.board.svc.BoardContentService;
import roadshop.web.board.vo.BoardInfo;

@Controller
public class BoardContentAction implements BoardAction{

	@RequestMapping("/main/boardContent.bo")
	public ModelAndView boardContent(@RequestParam(value="pageNum",defaultValue="1") String pageNum,
			@RequestParam(value="num") int num) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		BoardContentService bcs=new BoardContentService();
		BoardInfo article=bcs.getArticle(num);

		String load = "../board/content.jsp";
		mav.addObject("load",load);
		mav.addObject("article", article);
		mav.addObject("pageNum", pageNum);
		
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