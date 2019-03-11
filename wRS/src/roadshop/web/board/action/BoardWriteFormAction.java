package roadshop.web.board.action;
/*�� �κ��� ���� �����ؾ� ��!!*/

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import roadshop.actionforward.ActionForward;
import roadshop.web.board.vo.BoardInfo;


@Controller
public class BoardWriteFormAction implements BoardAction{

	//�߿��� ����!!!!
	//�� ������ request.getParameter("num")�� �ؾ� �Ѵٴ� ���̴�~~~
	//request.getParameter("b_num")�� �ϸ� ��� ���� �޾ƿ��� ���Ѵ�!!
	@RequestMapping("/main/boardWriteForm.bo")
	public ModelAndView boardWriteForm(HttpServletRequest request) throws Exception {
		//�Լ�(@ModelAttribute("article") BoardInfo article)
		//�� ������ �ٲٸ� �ȴ�!!
		int num = 0;
		int ref=1,re_step=0,re_level=0;
		String m_id="before";
		String i_id="item";
		System.out.println("Here is BoardWriteFormAction.execute()");

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

		System.out.println("boardWriteForm() "+"ReplyVO.num = "+boardInfo.getB_num()+", ReplyVO.ref = "+boardInfo.getRef()+", ReplyVO.re_step = "+boardInfo.getRe_step()
				+", ReplyVO.re_level = "+boardInfo.getRe_level()+", ReplyVO.m_id = "+boardInfo.getM_id() );
		String load = "../board/writeForm.jsp";

		mav.addObject("load",load);
		mav.addObject("boardInfo", boardInfo);		//�� i_id,m_id�� ���� ���� ����!!
//		mav.setViewName("../main/beforeMain.jsp");
		
		mav.setViewName(load);
		
		return mav;
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}
}
		
		
		
		/*MVC2�������� ó���� �κ���!!
public class BoardWriteFormAction implements BoardAction {
		 public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//�� ������ num=0,ref=1,re_step=0,re_level=0;���� �ʱ�ȭ��!!!
		int num=0,ref=1,re_step=0,re_level=0;
		//�� ���� �������Դϴ�.
		String m_id="before";
		String i_id="item";

		if(request.getParameter("num")!=null){
			//�ش� JSP�� ���޵� request�� ����� "num" �Ķ������ ���� �����Ѵٸ�! 
			//���⿡�� request.getParameter("num")�� ���� �޾ƿ�!!
			num=Integer.parseInt(request.getParameter("num"));
			ref=Integer.parseInt(request.getParameter("ref"));
			re_step=Integer.parseInt(request.getParameter("re_step"));
			re_level=Integer.parseInt(request.getParameter("re_level"));
			m_id=request.getParameter("m_id");
			i_id=request.getParameter("i_id");

			System.out.println("BoardWriteFormAction.execute()�� if�ȿ� ����!!DB�� ���� ��������!!\n "+"ReplyVO.num = "+num+", ReplyVO.ref = "+ref+", ReplyVO.re_step = "+re_step
						+", ReplyVO.re_level = "+re_level+", ReplyVO.m_id = "+m_id );
			System.out.println("==================================================="
					+"\nm_id = "+m_id+",i_id = "+i_id);
		}
		//�ش� JSP�� ���޵� request�� ����� "num" �Ķ������ ���� �������� �ʴ´ٸ�! 
		System.out.println("BoardWriteFormAction.execute()�� if���� ����!! DB�� ���� ��������!!\n "+"ReplyVO.num = "+num+", ReplyVO.ref = "+ref+", ReplyVO.re_step = "+re_step
				+", ReplyVO.re_level = "+re_level+", boardInfo.m_id = "+m_id);
		System.out.println("==================================================="
				+"\nm_id = "+m_id+",i_id = "+i_id);
		BoardInfo boardInfo = new BoardInfo();
		boardInfo.setB_num(num);
		boardInfo.setRef(ref);
		boardInfo.setRe_step(re_step);
		boardInfo.setRe_level(re_level);		
		//�� �ؿ��� �������Դϴ�.
		boardInfo.setM_id(m_id);
		boardInfo.setI_id(i_id);

		//sessionó�� ID�� �α����� �Ǿ��� ����!!
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		String load = "../board/writeForm.jsp";

		request.setAttribute("load",load);
		request.setAttribute("boardInfo", boardInfo);	//�� i_id,m_id�� ���� ���� ����!!
		ActionForward forward=new ActionForward();
		forward.setUrl("../main/beforeMain.jsp");
		System.out.println("Here is BoardWriteFormAction&&&return forward�� FrontController�� �̵� �׸���!!" +
				"" + forward.getUrl() +"���� �̵� �� ����!!");
		return forward;
	}
}

*/