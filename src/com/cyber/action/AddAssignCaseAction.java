package com.cyber.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cyber.bean.CaseTO;
import com.cyber.delegate.CaseDelegate;
import com.cyber.util.UtilConstants;
import com.sun.org.apache.commons.beanutils.BeanUtils;

/**
 * The AddAssignCaseAction servlet class implements for to Add Assign Case
 * details.
 */
public class AddAssignCaseAction extends HttpServlet {

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
		boolean flag = false;
		String path = "";
		CaseTO caseto = new CaseTO();
		Map map = request.getParameterMap();
		try {
			BeanUtils.populate(caseto, map);
			flag = new CaseDelegate().assignCases(caseto);
		} catch (Exception e) {
			request.setAttribute("status", e.getMessage());
			path = UtilConstants._STATUS;
		}

		if (flag) {
			request.setAttribute("status",
					UtilConstants._ASSIGN_CASE_AGENCY_SUCCESS);
			path = UtilConstants._STATUS;
		} else {
			request.setAttribute("status",
					UtilConstants._ASSIGN_CASE_AGENCY_FAIL);
			path = UtilConstants._STATUS;
		}
		rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
