package com.cyber.action;

import java.io.IOException;
import java.io.PrintWriter;
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

public class ViewTipsAction extends HttpServlet {

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
		Vector<ProfileTO> pro = new Vector<ProfileTO>();
		try {
			pro = new UserDelegate().viewTips();
			if (!pro.isEmpty()) {
				request.setAttribute("status",
						UtilConstants._VIEW_TIPS_SUGGESSITION_SUCCESS);
				request.setAttribute("tips", pro);
				path = UtilConstants._TIPS_SUGGESSTIONS;
			} else {
				request.setAttribute("status",
						UtilConstants._VIEW_TIPS_SUGGESSITION_FAIL);
				path = UtilConstants._TIPS_SUGGESSTIONS;
			}
		} catch (Exception e) {
			request.setAttribute("status", e.getMessage());
			path = UtilConstants._POST_TIPS_HOME;
		}
		rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
