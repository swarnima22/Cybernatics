package com.cyber.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Vector;

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
 * The AssignCasesAction servlet class implements for to Assign cases to Agents
 * 
 */
public class AssignCasesAction extends HttpServlet {
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
		CaseTO caseto = new CaseTO();
		Vector<CaseTO> vcaseto1 = new Vector<CaseTO>();
		Vector<CaseTO> vcaseto2 = new Vector<CaseTO>();
		try {
			vcaseto1 = new CaseDelegate().viewAgencyNames();
			vcaseto2 = new CaseDelegate().viewCasesNames();
		} catch (Exception e) {
			request.setAttribute("status", e.getMessage());
			path = UtilConstants._STATUS;
		}
		if (vcaseto1 != null && vcaseto2 != null) {
			request.setAttribute("status", UtilConstants._VIEW_ASSIGN_CASES);
			request.setAttribute("vcaseto1", vcaseto1);
			request.setAttribute("vcaseto2", vcaseto2);
			path = UtilConstants._ASSIGN_CASES;
		} else {
			request.setAttribute("status",
					UtilConstants._VIEW_ASSIGN_CASES_FAIL);
			path = UtilConstants._STATUS;
		}
		rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
