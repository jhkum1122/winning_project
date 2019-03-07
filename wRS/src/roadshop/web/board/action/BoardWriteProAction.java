package roadshop.web.board.action;
/*
 * 	writeForm.jsp�Է� �Ŀ� �� �κ��� �����!!
	insertArticle() ���Ŀ� �� �κп��� 
	writeForm���� �Էµ� ���� ���� �ϰ�
	BoardWriteService �� ȣ���Ų��
	ActionForward�� �̵���!!
 */
import java.io.PrintWriter;
import java.sql.Timestamp;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import roadshop.actionforward.ActionForward;
import roadshop.web.board.svc.BoardWriteService;
import roadshop.web.board.vo.BoardInfo;

@Controller
public class BoardWriteProAction implements BoardAction{
		//�� ��Ϲ�ư ���Ŀ� ���Ǵ� �κ���!!
	@RequestMapping("/main/boardWritePro.bo")
	public ModelAndView boardWriteProAction(BoardInfo article
			,HttpServletRequest request) throws Exception {
		
			ModelAndView mav=new ModelAndView();
			article.setB_reg_date(new Timestamp(System.currentTimeMillis()));
//			System.out.println("sssssssssssssssss"+article.getI_id());
//			System.out.println("sssssssssssssssss"+article.getB_subject());
//			System.out.println("BoardWriteProAction========================");
//			System.out.println("==================================================\n" +
//					"���� ����� �޾ƿԴ��� Ȯ���ϴ� �κ���!\n");
//			System.out.println("ReplyVO.num = "+article.getB_num()+", ReplyVO.ref = "+article.getRef()+", ReplyVO.re_step = "+article.getRe_step()
//					+",\n ReplyVO.re_level = "+article.getRe_level()+", boardInfo.m_id = "+article.getM_id()+", boardInfo.i_id = "+article.getI_id()
//					+", boardInfo.b_image = "+article.getB_image());
			System.out.println("BoardWriteProAction========================");
			System.out.println("==================================================\n" +
					"���� ����� �޾ƿԴ��� Ȯ���ϴ� �κ���!\n");
			System.out.println("ReplyVO.num = "+article.getB_num()+", ReplyVO.ref = "+article.getRef()+", ReplyVO.re_step = "+article.getRe_step()
					+",\n ReplyVO.re_level = "+article.getRe_level()+", boardInfo.m_id = "+article.getM_id()+", boardInfo.i_id = "+article.getI_id()
					+", boardInfo.b_image = "+article.getB_image());
			
			HttpSession session = request.getSession();
			String id = (String)session.getAttribute("id");
			
			BoardWriteService bws=new BoardWriteService();
			
			boolean isSuccess=bws.writeArticle(article);		
			//�̺κп��� �Է��� �� �Ǿ����� true��ȯ �׷��� ������ false��ȯ
			
			if(isSuccess){
				mav.addObject("bws",bws);
				mav.setViewName("../main/boardList.bo");
			}else{
				
				System.out.println("BoardWriteProAction���� bool���� false���!!! ����!!!!!" +
						"�ᱹ �ش�� ������ �ȵ� ����!!");
			}
			return mav;
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
