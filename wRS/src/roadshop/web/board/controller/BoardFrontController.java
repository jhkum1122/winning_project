package roadshop.web.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.servlet.HttpServletBean;

import roadshop.actionforward.ActionForward;
import roadshop.web.board.action.BoardAction;
import roadshop.web.board.action.BoardContentAction;
import roadshop.web.board.action.BoardDeleteFormAction;
import roadshop.web.board.action.BoardDeleteProAction;
import roadshop.web.board.action.BoardFileUpdateFormAction;
import roadshop.web.board.action.BoardFileUpdateProAction;
import roadshop.web.board.action.BoardFileWriteProAction;
import roadshop.web.board.action.BoardListAction;
import roadshop.web.board.action.BoardSearchKeywordAction;
import roadshop.web.board.action.BoardUpdateAction;
import roadshop.web.board.action.BoardUpdateFormAction;
import roadshop.web.board.action.BoardWriteFormAction;
import roadshop.web.board.action.BoardWriteProAction;
import roadshop.web.board.action.BoardFileWriteFormAction;

/**
 * Servlet implementation class BoardFrontController
 */
public class BoardFrontController extends HttpServletBean {
	private static final long serialVersionUID = 1L;
	private static int count =1;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Before doProcess~~~!!!");
		request.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("euc-kr");
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(count+"FrontController in process()");
		request.setCharacterEncoding("UTF-8");

		String requestURI=request.getRequestURI();
		//	/wRS/main/boardContent.bo
		System.out.println(count+"controllerPath ="+requestURI);

		String context=request.getContextPath();
		// /wRS/main/boardContent.bo
		System.out.println(count+"contex ="+context);

		String command=requestURI.substring(context.length());
		// /boardWriteForm.bo ��ȯ
		System.out.println(count+"command ="+command);

		BoardAction action=null;
		ActionForward forward=null;

		if(command.equals("/main/boardWriteForm.bo")){
			action = new BoardWriteFormAction();

			try{
				/*System.out.println("FrontController==>>Here is in"
						+command
						+"���Ŀ� BoardWriteFormAction���� �Ѿ!!");*/
				//action.setURL();�� ���� forward�� �����Ŵ �ش� page�� �Ѿ!
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/main/boardWritePro.bo")){
			 action = new BoardWriteProAction();		
			 
			 try{
				/* System.out.println("afterAction and FrontController==>>Here is in"+command+
						 "���Ŀ� BoardWriteProAction���� �Ѿ!!");*/
			    forward = action.execute(request, response);
			   }
			   catch(Exception e){
			    e.printStackTrace();
			   }
		}else if(command.equals("/main/boardList.bo")){
			
			action=new BoardListAction();
			/*System.out.println("afterAction and FrontController==>>Here is in"+command+
					 "���Ŀ� BoardListAction���� �Ѿ!!");*/
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/main/boardContent.bo")){
			action=new BoardContentAction();
//			System.out.println("afterAction and FrontController==>>Here is in"+command+
//					 "���Ŀ� BoardContentAction���� �Ѿ!!");
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/main/boardUpdateForm.bo")){
			
//			System.out.println("afterAction and FrontController==>>Here is in"+command+
//					 "���Ŀ� BoardUpdateFormAction���� �Ѿ!!");
			action=new BoardUpdateFormAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/main/boardUpdate.bo")){
			//�� ���� updateForm.jsp���� ��� ������ �Է��ϰ�, �����ϱ� ��ư�� �������� �� ������
			//�ش� ��ɾ ����!
			action=new BoardUpdateAction();
//			System.out.println("FrontController==>>Here is in"+command+
//					"\n���Ŀ� BoardUpdateAction���� �Ѿ!!�̹� BoardUpdateAction()�� ������");
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/main/boardDeleteForm.bo")){
			action=new BoardDeleteFormAction();
			
//			System.out.println("FrontController==>>Here is in"+command+
//					"���Ŀ� BoardDeleteFormAction���� �Ѿ!!");
			try{
				forward=action.execute(request, response);
			}catch (Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/main/boardDelete.bo")){
			action=new BoardDeleteProAction();
//			System.out.println("FrontController==>>Here is in"+command+
//					"���Ŀ� BoardDeleteProAction���� �Ѿ!!");
			try{
				forward=action.execute(request, response);
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		//�� ���� �˻������ �����ϱ� ���� ����!!
		else if(command.equals("/main/searchKeyword.bo")){
			action=new BoardSearchKeywordAction();
//			System.out.println("FrontController==>>Here is in"+command+
//					"���Ŀ� BoardSearchKeywordAction���� �Ѿ!!");
			try{
				forward=action.execute(request, response);
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		
		
		//file�� ���ε� �ϴ� �κ���!!
		else if(command.equals("/main/boardFileWriteForm.bo")){
			
//			System.out.println("FrontController==>>Here is in"
//			+command
//			+"���Ŀ� BoardFileUploadFormAction���� �Ѿ!!");
//			
			action = new BoardFileWriteFormAction();
			 
			 try{
				 System.out.println("afterAction and FrontController==>>Here is in"+command+
						 "���Ŀ� BoardFileUploadAction���� �Ѿ!!");
			    forward = action.execute(request, response);
			 }
			 catch(Exception e){
			    e.printStackTrace();
			 }
		}
		else if(command.equals("/main/boardFileWritePro.bo")){
			 action = new BoardFileWriteProAction();			
			 
			 try{
//				 System.out.println("afterAction and FrontController==>>Here is in"+command+
//						 "���Ŀ� BoardFileUploadProAction���� �Ѿ!!");
			     forward = action.execute(request, response);
			 }
			 catch(Exception e){
			    e.printStackTrace();
			 }
		}
		else if(command.equals("/main/boardFileUpdateForm.bo")){
//			System.out.println("FrontController==>>Here is in"
//				+command
//				+"���Ŀ� BoardFileUpdateFormAction���� �Ѿ!!");
			action = new BoardFileUpdateFormAction();
			
			try{
//				System.out.println("afterAction and FrontController==>>Here is in"+command+
//							 "���Ŀ� BoardFileUploadAction���� �Ѿ!!");
				forward = action.execute(request, response);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		else if(command.equals("/main/boardFileUpdatePro.bo")){
//			System.out.println("FrontController==>>Here is in"
//					+command
//					+"���Ŀ� BoardFileUpdateProAction���� �Ѿ!!");
			action = new BoardFileUpdateProAction();
			try{
//				System.out.println("afterAction and FrontController==>>Here is in"+command+
//				 "���Ŀ� BoardFileUploadAction���� �Ѿ!!");
				forward = action.execute(request, response);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		if(forward!=null){
			if(forward.isRedirect()){
				response.sendRedirect(forward.getUrl());
			}else{
				RequestDispatcher dis=request.getRequestDispatcher(forward.getUrl());
				dis.forward(request, response);
			}
		}
		count++;
	}
}
