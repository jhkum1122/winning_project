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
		System.out.println("이 곳은 boardUpdate()입니다.");
		

		ModelAndView mav = new ModelAndView();
		article.setB_reg_date(new Timestamp(System.currentTimeMillis()));
		boolean isSuccess=false;						//업데이트 성공여부를 저장할 변수
		BoardUpdateService bus=new BoardUpdateService();
		System.out.println("수정 전 isSuccess  = " + isSuccess);
		isSuccess=bus.modifyArticle(article);
		System.out.println("수정 후 isSuccess  = " + isSuccess);

		if(isSuccess){
			mav.addObject("pageNum", pageNum);
			mav.addObject("article",article);
			mav.setViewName("../main/boardList.bo");		//디스패쳐로 하면 새로고침 시 insert쿼리가 계속 실행
		}else{
			System.out.println("업데이트 실패");
		}
		return mav;
		
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}