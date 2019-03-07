package roadshop.web.board.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import roadshop.actionforward.ActionForward;
import roadshop.web.board.svc.BoardUpdateFormService;
import roadshop.web.board.vo.BoardInfo;
@Controller
public class BoardUpdateFormAction implements BoardAction{

	@RequestMapping("/main/boardUpdateForm.bo")
	public ModelAndView boardUpdateForm(@RequestParam(value="pageNum",defaultValue="1") String pageNum,
			@RequestParam(value="num") int num) throws Exception {
		System.out.println("여기는 boardUpdateForm()입니다.!!");
		ModelAndView mav = new ModelAndView();
		
		BoardUpdateFormService bufs=new BoardUpdateFormService();
		BoardInfo article=bufs.getUpdateArticle(num);
		
		String load = "../board/updateForm.jsp";
		
		mav.addObject("load",load);
		mav.addObject("article", article);
		mav.addObject("pageNum", pageNum);
		//forward.setUrl("boardList.bo");
		//변경된 부분입니다.
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