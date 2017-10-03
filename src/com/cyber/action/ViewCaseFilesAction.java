package com.cyber.action;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cyber.bean.CaseTO;
import com.cyber.delegate.CaseDelegate;
import com.cyber.util.UtilConstants;

/**
 * The ViewCaseFilesAction servlet class implements for to get case related
 * files.
 */

public class ViewCaseFilesAction extends HttpServlet {
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
		String path = request.getRealPath("./images");
		int caseid = Integer.parseInt(request.getParameter("caseid"));
		String casename = request.getParameter("casename");
		Vector<CaseTO> vcase = null;
		try {
			vcase = new CaseDelegate().viewCaseFiles(caseid, path,casename);
			if (!vcase.isEmpty()) {
				request.setAttribute("status", UtilConstants.CASE_DETAILS_FILE);
				request.setAttribute("caseinfo", vcase);
				path = UtilConstants._VIEW_CASE_FILES;
			} else {
				request.setAttribute("status", UtilConstants.CASE_DETAILS_FAIL);
				path = UtilConstants._STATUS;
			}
		} catch (Exception e) {
			request.setAttribute("status", e.getMessage());
			path = UtilConstants._STATUS;
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
