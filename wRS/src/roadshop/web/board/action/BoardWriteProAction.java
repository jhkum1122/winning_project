package roadshop.web.board.action;
/*
 * 	writeForm.jsp입력 후에 이 부분이 실행됨!!
	insertArticle() 이후에 이 부분에서 
	writeForm에서 입력된 값을 저장 하고
	BoardWriteService 를 호출시킨뒤
	ActionForward로 이동함!!
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
		//글 등록버튼 이후에 사용되는 부분임!!
	@RequestMapping("/main/boardWritePro.bo")
	public ModelAndView boardWriteProAction(BoardInfo article
			,HttpServletRequest request) throws Exception {
		
			ModelAndView mav=new ModelAndView();
			article.setB_reg_date(new Timestamp(System.currentTimeMillis()));
//			System.out.println("sssssssssssssssss"+article.getI_id());
//			System.out.println("sssssssssssssssss"+article.getB_subject());
//			System.out.println("BoardWriteProAction========================");
//			System.out.println("==================================================\n" +
//					"값을 제대로 받아왔는지 확인하는 부분임!\n");
//			System.out.println("ReplyVO.num = "+article.getB_num()+", ReplyVO.ref = "+article.getRef()+", ReplyVO.re_step = "+article.getRe_step()
//					+",\n ReplyVO.re_level = "+article.getRe_level()+", boardInfo.m_id = "+article.getM_id()+", boardInfo.i_id = "+article.getI_id()
//					+", boardInfo.b_image = "+article.getB_image());
			System.out.println("BoardWriteProAction========================");
			System.out.println("==================================================\n" +
					"값을 제대로 받아왔는지 확인하는 부분임!\n");
			System.out.println("ReplyVO.num = "+article.getB_num()+", ReplyVO.ref = "+article.getRef()+", ReplyVO.re_step = "+article.getRe_step()
					+",\n ReplyVO.re_level = "+article.getRe_level()+", boardInfo.m_id = "+article.getM_id()+", boardInfo.i_id = "+article.getI_id()
					+", boardInfo.b_image = "+article.getB_image());
			
			HttpSession session = request.getSession();
			String id = (String)session.getAttribute("id");
			
			BoardWriteService bws=new BoardWriteService();
			
			boolean isSuccess=bws.writeArticle(article);		
			//이부분에서 입력이 잘 되었으면 true반환 그렇지 않으면 false반환
			
			if(isSuccess){
				mav.addObject("bws",bws);
				mav.setViewName("../main/boardList.bo");
			}else{
				
				System.out.println("BoardWriteProAction에서 bool값이 false라면!!! 거짓!!!!!" +
						"결국 해당글 삽입이 안된 것임!!");
			}
			return mav;
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
