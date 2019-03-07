package roadshop.web.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import roadshop.actionforward.ActionForward;
import roadshop.web.board.vo.BoardInfo;
@Controller
public class BoardFileWriteFormAction implements BoardAction{

	@RequestMapping("/main/boardFileWriteForm.bo")
	public ModelAndView boardFileWriteForm(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
//		System.out.println("�� ���� BoardFileWriteFormAction.execute()�Դϴ�.");
		int num = 0;
		int ref=1,re_step=0,re_level=0;
		String m_id="before";
		String i_id="item";
		ModelAndView mav = new ModelAndView();
		if (request.getParameter("num")!=null) {
			num=Integer.parseInt(request.getParameter("num"));
			ref=Integer.parseInt(request.getParameter("ref"));
			re_step=Integer.parseInt(request.getParameter("re_step"));
			re_level=Integer.parseInt(request.getParameter("re_level"));
			m_id=request.getParameter("m_id");
			i_id=request.getParameter("i_id");
		}
		BoardInfo boardInfo = new BoardInfo();
		boardInfo.setB_num(num);
		boardInfo.setRef(ref);
		boardInfo.setRe_step(re_step);
		boardInfo.setRe_level(re_level);		
		//�� �ؿ��� �������Դϴ�.
		boardInfo.setM_id(m_id);
		boardInfo.setI_id(i_id);
		
		String load = "../board/fileWriteForm.jsp";

		mav.addObject("load",load);
		mav.addObject("boardInfo", boardInfo);	//�� i_id,m_id�� ���� ���� ����!!
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
