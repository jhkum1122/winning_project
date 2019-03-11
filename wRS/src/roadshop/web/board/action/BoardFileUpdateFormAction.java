package roadshop.web.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import roadshop.actionforward.ActionForward;
import roadshop.web.board.svc.BoardFileUpdateFormService;
import roadshop.web.board.vo.BoardInfo;

@Controller
public class BoardFileUpdateFormAction implements BoardAction {

	@RequestMapping("/main/boardFileUpdateForm.bo")
	public ModelAndView boardFileUpdateForm(@RequestParam(value="pageNum",defaultValue="1") String pageNum,
			@RequestParam(value="num") int num) throws Exception {
		System.out.println("����� boardFileUpdateForm()�Դϴ�.!!");
		ModelAndView mav = new ModelAndView();
		BoardFileUpdateFormService bufs=new BoardFileUpdateFormService();
		BoardInfo article=bufs.getFileUpdateArticle(num);
		
		String load = "../board/fileUpdateForm.jsp";

		mav.addObject("load",load);
		mav.addObject("article", article);
		mav.addObject("pageNum", pageNum);
		//forward.setUrl("boardList.bo");
		//����� �κ��Դϴ�.
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