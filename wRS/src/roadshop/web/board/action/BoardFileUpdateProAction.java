package roadshop.web.board.action;

import java.sql.Timestamp;
import java.util.Enumeration;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import roadshop.actionforward.ActionForward;
import roadshop.web.board.svc.BoardFileUpdateService;
import roadshop.web.board.vo.BoardInfo;

@Controller
public class BoardFileUpdateProAction implements BoardAction {

	@RequestMapping("/main/boardFileUpdatePro.bo")
	public ModelAndView boardFileUpdatePro(BoardInfo article
			,HttpServletRequest request,
			@RequestParam(value="pageNum",defaultValue="1") String pageNum) throws Exception {
		
		System.out.println("�� ���� boardFileUpdatePro()�Դϴ�.");
		ModelAndView mav=new ModelAndView();
		
		boolean isSuccess=false;
		
		String realFolder = ""; 			// ������ ���ε�� �������� �������� ��θ� ������ ���� 
		String saveFolder =""; 				//������ ���ε�� ���丮 ��
		String encType="utf-8";
		int maxSize = 5*1024*1024;
		ServletContext context = request.getServletContext();
		//ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		//"�����ϰ� ���� ��� c:\\workspace3\\board\\image"
		//�ش� ����� ���� ���� �������� ��θ� ������ �κ� ....

		try{
			
			MultipartRequest multi = new MultipartRequest(request,realFolder,maxSize,encType,
					new DefaultFileRenamePolicy());
			
			article.setB_writer(multi.getParameter("b_writer")) ;
			article.setB_subject(multi.getParameter("b_subject"));
			article.setB_image( multi.getParameter("b_image"));
			article.setB_content(multi.getParameter("b_content"));
			article.setI_id(multi.getParameter("i_id"));
			article.setM_id(multi.getParameter("m_id"));
			article.setB_reg_date(new Timestamp(System.currentTimeMillis()));
			article.setB_num(Integer.parseInt(multi.getParameter("b_num")));
			//article.setReadcount(Integer.parseInt(multi.getParameter("readcount"));
			article.setRef(Integer.parseInt(multi.getParameter("ref")));
			article.setRe_step(Integer.parseInt(multi.getParameter("re_step")));
			article.setRe_level(Integer.parseInt(multi.getParameter("re_level")));
			Enumeration files = multi.getFileNames();
			
			while(files.hasMoreElements()){
				String fileName = (String)files.nextElement();
				article.setB_image((String)multi.getOriginalFileName(fileName));
			}
//			System.out.println("BoardWriteProAction========================");
//			System.out.println("==================================================\n" +
//					"���� ����� �޾ƿԴ��� Ȯ���ϴ� �κ���!\n");
//			System.out.println("ReplyVO.num = "+article.getB_num()+", ReplyVO.ref = "+article.getRef()+", ReplyVO.re_step = "+article.getRe_step()
//					+",\nReplyVO.re_level = "+article.getRe_level()+", boardInfo.m_id = "+article.getM_id()+", boardInfo.i_id = "+article.getI_id()
//					+", boardInfo.b_image = "+article.getB_image());
//			
		}catch(Exception e){
			e.printStackTrace();
		}
		
//		HttpSession session = request.getSession();
//		String id = (String)session.getAttribute("id");
		
		//String load = "../board/writeForm.jsp";
		BoardFileUpdateService bFUS = new BoardFileUpdateService();
		isSuccess=bFUS.modifyFileArticle(article);
		
		if(isSuccess){
			mav.addObject("pageNum", pageNum);
			mav.addObject("article",article);
			mav.setViewName("../main/boardList.bo");		//�����ķ� �ϸ� ���ΰ�ħ �� insert������ ��� ����
		}
		else{
			System.out.println("BoardWriteProAction���� bool���� false���!!! ����!!!!!" +
					"�ᱹ �ش�� ������ �ȵ� ����!!");
			System.out.println("<script>");
			System.out.println("alert('��� ���� �Դϴ�')");
			System.out.println("history.back()");
			System.out.println("</script>");
		}
		return mav;
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}
}