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
 * The ViewAgencyAction servlet class implements for to view All agencies
 * details.
 */
public class ViewAgencyAction extends HttpServlet {
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
			vcas = new CaseDelegate().viewAgencyDetails();
			if (!vcas.isEmpty()) {
				request.setAttribute("status",
						UtilConstants._VIEW_AGENCY_DETAILS_SUCCESS);
				request.setAttribute("agency", vcas);
				path = UtilConstants._VIEW_AGENCY;
			} else {

				request.setAttribute("status",
						UtilConstants._VIEW_AGENCY_DETAILS_FAIL);
				path = UtilConstants._VIEW_AGENCY;

			}

		} catch (Exception e) {
			System.out.println(e);
			request.setAttribute("status", e.getMessage());
			path = UtilConstants._VIEW_AGENCY;

		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
