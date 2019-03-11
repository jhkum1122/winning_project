package roadshop.web.board.action;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import roadshop.actionforward.ActionForward;
import roadshop.web.board.svc.BoardUpdateService;
import roadshop.web.board.vo.BoardInfo;

@Controller
public class BoardUpdateAction implements BoardAction{

	@RequestMapping("/main/boardUpdate.bo")
	public ModelAndView boardUpdate(@RequestParam(value="pageNum",defaultValue="1") String pageNum,
			@ModelAttribute("boardInfo") BoardInfo article
			) throws Exception {
		System.out.println("�� ���� boardUpdate()�Դϴ�.");
		

		ModelAndView mav = new ModelAndView();
		article.setB_reg_date(new Timestamp(System.currentTimeMillis()));
		boolean isSuccess=false;						//������Ʈ �������θ� ������ ����
		BoardUpdateService bus=new BoardUpdateService();
		System.out.println("���� �� isSuccess  = " + isSuccess);
		isSuccess=bus.modifyArticle(article);
		System.out.println("���� �� isSuccess  = " + isSuccess);

		if(isSuccess){
			mav.addObject("pageNum", pageNum);
			mav.addObject("article",article);
			mav.setViewName("../main/boardList.bo");		//�����ķ� �ϸ� ���ΰ�ħ �� insert������ ��� ����
		}else{
			System.out.println("������Ʈ ����");
		}
		return mav;
		
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}