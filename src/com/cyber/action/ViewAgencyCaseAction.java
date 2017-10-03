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
 * The ViewAgentCaseAssingedAction servlet class implements for to view case
 * assigned agents details.
 */
public class ViewAgencyCaseAction extends HttpServlet {

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

		String path = "";
		HttpSession session = request.getSession();
		int userid = (Integer) session.getAttribute("userid");
		// int userid = Integer.parseInt(user);
		System.out.println(userid);
		Vector<CaseTO> vcas = null;
		try {
			vcas = new CaseDelegate().viewAgencyCaseDetails(userid);
			if (!vcas.isEmpty()) {
				request.setAttribute("status",
						UtilConstants._VIEW_AGENCY_CASE_DETAILS_SUCCESS);
				request.setAttribute("cases", vcas);
				path = UtilConstants._VIEW_AGENCY_CASES;
			} else {
				request.setAttribute("status",
						UtilConstants._VIEW_CASE_DETAILS_FAIL);
				path = UtilConstants._VIEW_AGENCY_CASES;
			}
		} catch (Exception e) {
			request.setAttribute("status", e.getMessage());
			path = UtilConstants._VIEW_AGENCY_CASES;
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
