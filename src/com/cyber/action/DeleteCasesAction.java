package com.cyber.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cyber.delegate.CaseDelegate;

/**
 * The DeleteCasesAction servlet class implements for to to delete case details.
 */
public class DeleteCasesAction extends HttpServlet {

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
				System.out.println(ch[i]);
				flag = new CaseDelegate().deleteCases(Integer.parseInt(ch[i]));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
