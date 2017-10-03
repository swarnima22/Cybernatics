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

import com.cyber.bean.ProfileTO;
import com.cyber.delegate.UserDelegate;
import com.cyber.exception.ConnectionException;
import com.cyber.util.UtilConstants;
import com.sun.org.apache.commons.beanutils.BeanUtils;

/**
 * The ChangePasswordAction servlet class implements for to Change old PasswordA
 * 
 */
public class ChangePasswordAction extends HttpServlet {
	/**
		 * 
		 */
	private static final long serialVersionUID = -2941564269120432640L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		boolean flag = false;
		String path = "";
		ProfileTO pro = new ProfileTO();
		Map map = request.getParameterMap();
		try {
			BeanUtils.populate(pro, map);
			flag = new UserDelegate().changePass(pro);
			if (flag) {
				request.setAttribute("status", UtilConstants._PASSWORD_SUCCESS);
				path = UtilConstants._USER_PASSWORD_CHANGE;
			} else {
				request.setAttribute("status", UtilConstants._PASSWORD_FAILED);
				path = UtilConstants._USER_PASSWORD_CHANGE;
			}
		} catch (Exception e) {
			request.setAttribute("status", e.getMessage());
			path = UtilConstants._USER_PASSWORD_CHANGE;
		}
		rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
