package roadshop.web.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import roadshop.actionforward.ActionForward;

public interface BoardAction {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception;
}
