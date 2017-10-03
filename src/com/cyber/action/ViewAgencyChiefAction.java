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
import javax.servlet.http.HttpSession;

import com.cyber.bean.ProfileTO;
import com.cyber.delegate.UserDelegate;
import com.cyber.util.UtilConstants;
import com.sun.org.apache.commons.beanutils.BeanUtils;

/**
 * The ViewAgencyChiefAction servlet class implements for to view Agency Chief
 * Details.
 */
public class ViewAgencyChiefAction extends HttpServlet {

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
		String target = "";
		Vector<ProfileTO> vemp = null;
		String usertype = request.getParameter("usertype");
		String path = request.getRealPath("./images");
		HttpSession session=request.getSession();
		try {
			vemp = new UserDelegate().viewListOfUsers(usertype, path,(Integer)session.getAttribute("userid"));
			if (!vemp.isEmpty()) {
				request.setAttribute("userlist", vemp);
				request.setAttribute("usertype", usertype);
				target = UtilConstants._USER_LIST;
			} else {
				request.setAttribute("status1", UtilConstants._USER_LIST_FAIL);
				target = UtilConstants._USER_LIST;
			}
		} catch (Exception e) {
			request.setAttribute("status1", e.getMessage());
			target = UtilConstants._USER_LIST;
		}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}

}
