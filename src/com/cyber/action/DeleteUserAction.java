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
 * The DeleteUserAction servlet class implements for to delete user details
 * 
 */
public class DeleteUserAction extends HttpServlet {

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
		String ch[] = request.getParameterValues("ch");
		try {
			for (int i = 0; i < ch.length; i++) {

				flag = new UserDelegate().deleteUser(Integer.parseInt(ch[i]));
			}
			if (flag) {
				request.setAttribute("status",
						UtilConstants._DELETE_USER_SUCCESS);
				path = UtilConstants._STATUS;
			} else {
				request
						.setAttribute("status",
								UtilConstants._DELETE_USER__FAIL);
				path = UtilConstants._STATUS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("status", e.getMessage());
			path = UtilConstants._STATUS;
		}
		rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}
}
