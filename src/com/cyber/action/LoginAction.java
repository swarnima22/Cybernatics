package com.cyber.action;

import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cyber.bean.ProfileTO;
import com.cyber.delegate.UserDelegate;
import com.cyber.exception.ConnectionException;
import com.cyber.exception.LoginException;
import com.cyber.util.UtilConstants;

/**
 * The LoginAction servlet class implements for to check login details
 * 
 */
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String target = "";
		HttpSession session = request.getSession();
		ProfileTO pro = new ProfileTO();
		Vector<ProfileTO> vpro = new Vector<ProfileTO>();
		String username = request.getParameter(UtilConstants._USERNAME);
		pro.setUserName(username);
		String password = request.getParameter(UtilConstants._PASSWORD);
		pro.setPassword(password);
		try {
			try {

				vpro = new UserDelegate().loginCheck(pro);
				Iterator it = vpro.listIterator();
				while (it.hasNext()) {
					pro = (ProfileTO) it.next();
					System.out.println("in LoginAction Role is.........."
							+ pro.getLogintype());
				}
			} catch (ConnectionException e) {
				throw new ServletException(
						"Server busy Plz Try after Some time");
			} catch (LoginException e) {
				RequestDispatcher rd = request
						.getRequestDispatcher(UtilConstants._LOGIN_FAILED_PAGE);
				rd.forward(request, response);
			}
			System.out.println(pro.getLogintype());
			if (pro.getLogintype().equalsIgnoreCase(UtilConstants._AGENT_CHIEF)) {
				session.setAttribute(UtilConstants._LOGINID, pro.getLoginid());
				session.setAttribute(UtilConstants._USERID, pro.getUserid());
				session.setAttribute(UtilConstants._ROLE, pro.getLogintype());
				System.out.println("LoginAction :" + pro.getLogintype());
				target = UtilConstants._ADMIN_HOME;
			} else if (pro.getLogintype().equalsIgnoreCase(
					UtilConstants._DEFENCE_MINISTRY)) {
				session.setAttribute(UtilConstants._LOGINID, pro.getLoginid());
				session.setAttribute(UtilConstants._USERID, pro.getUserid());
				session.setAttribute(UtilConstants._ROLE, pro.getLogintype());
				target = UtilConstants._ADMIN_HOME;
				System.out.println("LoginAction :" + pro.getLogintype());
				System.out.println("logind :" + pro.getLoginid());
				System.out.println("userid :" + pro.getUserid());
			} else if (pro.getLogintype()
					.equalsIgnoreCase(UtilConstants._AGENT)) {
				session.setAttribute(UtilConstants._LOGINID, pro.getLoginid());
				session.setAttribute(UtilConstants._USERID, pro.getUserid());
				session.setAttribute(UtilConstants._ROLE, pro.getLogintype());
				target = UtilConstants._ADMIN_HOME;
				System.out.println("LoginAction :" + pro.getLogintype());
				System.out.println("logind :" + pro.getLoginid());
				System.out.println("userid :" + pro.getUserid());
			} else {
				request.setAttribute("status", UtilConstants._INVALID_USER);
				target = UtilConstants._LOGIN_FAILED_PAGE;
			}
		} catch (NullPointerException e) {
			request.setAttribute("status", UtilConstants._INVALID_USER);
			target = UtilConstants._LOGIN_FAILED_PAGE;
		} catch (Exception e) {
			request.setAttribute("status", e.getMessage());
			target = UtilConstants._LOGIN_FAILED_PAGE;
		}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}
}
