package com.cyber.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cyber.bean.CaseTO;
import com.cyber.delegate.CaseDelegate;
import com.cyber.util.UtilConstants;

/**
 * The AddCaseEvidences servlet class implements for to view Add Case Evidences
 * details.
 */
public class AddCaseEvidences extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		int j;
		CaseTO cas = new CaseTO();
		boolean flag1 = false;
		boolean flag2 = false;
		String path = "";

		int caseid = Integer.parseInt(request.getParameter("caseid"));
		String casename = request.getParameter("casename");
		cas.setCaseid(caseid);
		cas.setCasename(casename);
		if ((request.getParameter("image[image_1]")) != null) {
			if (!request.getParameter("image[image_1]").equals("")) {
				String ch[] = request.getParameterValues("ch");
				for (j = 1; j <= ch.length; j++) {
					String filaname = request.getParameter("image[image_" + j
							+ "]");
					System.out.println(filaname + "imagessssssssssssssssssss");
					cas.setCasefile(filaname);
					try {
						flag2 = new CaseDelegate().insestCaseEvicences(cas);
					} catch (Exception e) {
						System.out.println(e);
					}
				}
				try {
					if (flag2) {
						request
								.setAttribute(
										"status",
										UtilConstants._ADD_CASE_EVIDENCES_DETAILS_SUCCESS);
						path = UtilConstants._STATUS;
					} else {
						request.setAttribute("status",
								UtilConstants._ADD_CASE_EVICENCE_DETAILS_FAIL);
						path = UtilConstants._STATUS;
					}
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("status", e.getMessage());
					path = UtilConstants._STATUS;
				}
			} else {
				request.setAttribute("status", UtilConstants._ADD_CASE_FILE);
				path = UtilConstants._ADD_CASE_EVIDENCES;
			}
		} else {
			request.setAttribute("status", UtilConstants._ADD_CASE_FILE);
			path = UtilConstants._ADD_CASE_EVIDENCES;
		}

		rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
