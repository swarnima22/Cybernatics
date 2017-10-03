package com.cyber.action;

import java.io.IOException;
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
 * The TipsSuggessitionsAction servlet class implements for to post Tips &
 * suggessition.
 */
public class TipsSuggessitionsAction extends HttpServlet {

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
			flag = new UserDelegate().postSuggesstion(pro);
			if (flag) {
				request.setAttribute("status", UtilConstants._POST_TIPS);
				path = UtilConstants._POST_TIPS_HOME;
			} else {
				request.setAttribute("status", UtilConstants._POST_TIPS_FAILED);
				path = UtilConstants._POST_TIPS_HOME;
			}
		} catch (Exception e) {
			request.setAttribute("status", e.getMessage());
			path = UtilConstants._POST_TIPS_HOME;
		}
		rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
