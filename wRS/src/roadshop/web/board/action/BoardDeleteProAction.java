package roadshop.web.board.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import roadshop.actionforward.ActionForward;
import roadshop.web.board.svc.BoardDeleteService;

@Controller
public class BoardDeleteProAction implements BoardAction{

	@RequestMapping("/main/boardDelete.bo")
	public ModelAndView boardDeletePro(@RequestParam(value="pageNum",defaultValue="1") String pageNum,
			@RequestParam(value="num") int num) throws Exception {

		ModelAndView mav = new ModelAndView();
		String load = "../board/list.jsp";
		//../board/content.jsp
		BoardDeleteService bds=new BoardDeleteService();
		boolean isDeleteSuccess=false;
		isDeleteSuccess=bds.deleteArticle(num);

		if(isDeleteSuccess){
			System.out.println("글 삭제 성공!!!");
			mav.addObject("load",load);
			mav.addObject("pageNum", pageNum);
			mav.setViewName("../main/boardList.bo");
		}else{
			System.out.println("글 삭제 실패!!");
		}
		return mav;
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}