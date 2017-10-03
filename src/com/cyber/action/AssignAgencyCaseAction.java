package com.cyber.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cyber.bean.CaseTO;
import com.cyber.delegate.CaseDelegate;
import com.cyber.util.UtilConstants;

/**
 * The AssignAgencyCaseAction servlet class implements for to view Assign Case
 * to Agency details.
 */
public class AssignAgencyCaseAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		boolean flag1 = false;
		boolean flag2 = false;
		String path = "";
		HttpSession session = request.getSession();
		int userid = (Integer) session.getAttribute("userid");
		System.out.println(userid);
		CaseTO caseto = new CaseTO();
		Vector<CaseTO> vcaseto1 = new Vector<CaseTO>();
		Vector<CaseTO> vcaseto2 = new Vector<CaseTO>();
		try {
			vcaseto1 = new CaseDelegate().viewAgencyCaseNames(userid);
			vcaseto2 = new CaseDelegate().viewAgentNames(userid);
		} catch (Exception e) {
			request.setAttribute("status", e.getMessage());
			path = UtilConstants._STATUS;
		}
		if (vcaseto1 != null && vcaseto2 != null) {
			request.setAttribute("status", UtilConstants._VIEW_AGENT_CASES);
			request.setAttribute("vcaseto1", vcaseto1);
			request.setAttribute("vcaseto2", vcaseto2);
			path = UtilConstants._AGENT_CASES;
		} else {
			request.setAttribute("status",
					UtilConstants._ADD_AGENT_DETAILS_FAIL);
			path = UtilConstants._STATUS;
		}
		rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
