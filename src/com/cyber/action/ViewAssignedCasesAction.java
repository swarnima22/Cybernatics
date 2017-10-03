package com.cyber.action;

import java.io.IOException;
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
 * The ViewAssignedCasesAction servlet class implements for to view assign case
 * details.
 */
public class ViewAssignedCasesAction extends HttpServlet {

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

		Vector<CaseTO> vcas = null;
		try {
			vcas = new CaseDelegate().viewAssignedCaseDetails();
			if (!vcas.isEmpty()) {
				request.setAttribute("status",
						UtilConstants._VIEW_ASSIGNED_CASE_DETAILS_SUCCESS);
				request.setAttribute("assigniedcases", vcas);
				path = UtilConstants._VIEW_ASSIGNED_CASES;
			} else {

				request.setAttribute("status",
						UtilConstants._VIEW_ASSIGNED_CASE_DETAILS_FAIL);
				path = UtilConstants._VIEW_ASSIGNED_CASES;

			}

		} catch (Exception e) {
			request.setAttribute("status", e.getMessage());
			path = UtilConstants._VIEW_ASSIGNED_CASES;
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
