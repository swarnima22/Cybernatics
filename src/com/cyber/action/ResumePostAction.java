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

import com.cyber.bean.ProfileTO;
import com.cyber.delegate.UserDelegate;
import com.cyber.util.UtilConstants;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class ResumePostAction extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		String path = "";
		boolean flag = false;
		Vector<ProfileTO> vprofile = new Vector<ProfileTO>();
		ProfileTO ProfileTO = new ProfileTO();
		Map map = request.getParameterMap();
		try {
			BeanUtils.populate(ProfileTO, map);
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			e1.printStackTrace();
		}
		try {
			flag = new UserDelegate().postResume(ProfileTO);
			if (flag) {
				request.setAttribute("status",
						UtilConstants._POST_RESUME_SUCCESS);
				path = UtilConstants._POST_RESUME;
			} else {
				request.setAttribute("status", UtilConstants._POST_RESUME_FAIL);
				path = UtilConstants._POST_RESUME;
			}
		} catch (Exception e) {
			e.printStackTrace();
			path = UtilConstants._POST_RESUME;
			request.setAttribute("status", UtilConstants._POST_RESUME_FAIL);
		}
		rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}