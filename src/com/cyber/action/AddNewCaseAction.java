package com.cyber.action;

import java.io.File;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cyber.bean.CaseTO;
import com.cyber.crypt.util.EncryptFile1Util;
import com.cyber.delegate.CaseDelegate;
import com.cyber.util.UtilConstants;

/**
 * The AddNewCaseAction servlet class implements for to view Add New Case
 * details.
 */
public class AddNewCaseAction extends HttpServlet {
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
		int j;
		CaseTO cas = new CaseTO();
		boolean flag1 = false;
		boolean flag2 = false;
		String path = "";
		File file = null;
		String casename = request.getParameter("casename");
		String casedescription = request.getParameter("casedescription");
		cas.setCasename(casename);
		cas.setCasedescription(casedescription);
		if ((request.getParameter("image[image_1]")) != null) {
			if (!request.getParameter("image[image_1]").equals("")) {
				String ch[] = request.getParameterValues("ch");
				try {
					flag1 = new CaseDelegate().insestCaseNameDetails(cas);
				} catch (Exception e) {
					System.out.println(e);
				}

				for (j = 1; j <= ch.length; j++) {
					String filaname = request.getParameter("image[image_" + j
							+ "]");

					cas.setFilepath(filaname);
					try {
						flag2 = new CaseDelegate().insestCaseFile(cas);
					} catch (Exception e) {
						System.out.println(e);
					}
				}
				try {
					if (flag1 && flag2) {
						request.setAttribute("status",
								UtilConstants._ADD_CASE_DETAILS_SUCCESS);
						path = UtilConstants._STATUS;
					} else {
						request.setAttribute("status",
								UtilConstants._ADD_CASE_DETAILS_FAIL);
						path = UtilConstants._STATUS;
					}
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("status", e.getMessage());
					path = UtilConstants._STATUS;
				}
			} else {
				request.setAttribute("status", UtilConstants._ADD_CASE_FILE);
				path = UtilConstants._ADD_NEW_CASE;
			}
		} else {
			request.setAttribute("status", UtilConstants._ADD_CASE_FILE);
			path = UtilConstants._ADD_NEW_CASE;
		}
		rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
