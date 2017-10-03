package com.cyber.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cyber.bean.ProfileTO;
import com.cyber.delegate.UserDelegate;
import com.cyber.util.UtilConstants;
import com.sun.org.apache.commons.beanutils.BeanUtils;

/**
 * The RegisterAction servlet class implements for to insert user details.
 * 
 */
public class RegisterAction extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		HttpSession session = request.getSession();
		boolean flag = false;
		String path = "";
		ProfileTO pf = new ProfileTO();
		Map map = request.getParameterMap();
		try {
			pf.setLoginid((String) session.getAttribute(UtilConstants._ROLE));
			pf.setUserid((Integer) session.getAttribute(UtilConstants._USERID));
			BeanUtils.populate(pf, map);
			flag = new UserDelegate().insertNewUser(pf);
			if (flag) {
				path = UtilConstants._STATUS;
				request.setAttribute("status",
						UtilConstants._REGISTERED_SUCCESS);
			} else {
				path = UtilConstants._STATUS;
				request.setAttribute("status", UtilConstants._REGISTERED_FAIL);
			}
		} catch (Exception e) {
			path = UtilConstants._STATUS;
			request.setAttribute("status", e.getMessage());
		}
		rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
