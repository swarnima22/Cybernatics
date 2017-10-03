package com.cyber.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cyber.delegate.UserDelegate;
import com.cyber.util.UtilConstants;

/**
 * The CheckUserAction servlet class implements for to check wether the user is
 * there or not.
 */
public class CheckUserAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("userName");
		String target = request.getParameter("path");
		System.out.println(target);
		try {
			String user = new UserDelegate().checkUser(username);
			System.out.println(user);
			if (user == null) {
				request.setAttribute("status1", UtilConstants._USER_AVAILABLE);
			} else
				request.setAttribute("status1",
						UtilConstants._USER_NO_AVAILABLE);
		} catch (Exception e) {
			request.setAttribute("status1", e.getMessage());
		}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}

}
