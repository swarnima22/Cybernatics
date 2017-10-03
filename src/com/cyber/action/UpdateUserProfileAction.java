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
import com.cyber.util.UtilConstants;
import com.sun.org.apache.commons.beanutils.BeanUtils;

/**
 * The UpdateUserProfileAction servlet class implements for to Update
 * UserProfiles Details.
 */
public class UpdateUserProfileAction extends HttpServlet {
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
		boolean flag = false;
		String path = "";
		ProfileTO pro = new ProfileTO();
		Map map = request.getParameterMap();
		try {
			BeanUtils.populate(pro, map);
			flag = new UserDelegate().updateUser(pro);
			if (flag) {
				path = UtilConstants._STATUS;
				request.setAttribute("status", UtilConstants._UPDATE_SUCCESS);
			} else {
				path = UtilConstants._STATUS;
				request.setAttribute("status", UtilConstants._UPDATE_FAIL);
			}
		} catch (Exception e) {
			path = UtilConstants._STATUS;
			request.setAttribute("status", e.getMessage());
		}
		rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
