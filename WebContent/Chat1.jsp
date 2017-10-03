<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<%
	if (request.getParameter("t") != null
			&& request.getParameter("t").equals("1")) {
%>
<html>
	<head>
		<meta http-equiv="Refresh" content="5">
		<script type="text/javascript" src="scripts/project.js"></script>
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	</head>
	<body>
		<jsp:include page="Header.jsp"></jsp:include>

		<%
			String text0 = (String) application.getAttribute("text0");
				String text1 = (String) application.getAttribute("text1");
				String text2 = (String) application.getAttribute("text2");
				String text3 = (String) application.getAttribute("text3");
				String text4 = (String) application.getAttribute("text4");
				String text5 = (String) application.getAttribute("text5");
				String text6 = (String) application.getAttribute("text6");
				String text7 = (String) application.getAttribute("text7");
				out
						.println("<DIV style='position: absolute; top: 270px; left: 800px; width: 200px; height: 25px><center'><h1></center>");
				out.println("<center><table width='90%' align='left'>");
				out.println("<tr><td align='left'><font size=2>");
				if (text0 != null) {
					out.println(text0);
				}
				out.println("</font></td></tr>");
				out.println("<tr><td align='left'><font size=2>");
				if (text1 != null) {
					out.println(text1);
				}
				out.println("</font></td></tr>");
				out.println("<tr><td align='left'><font size=2>");
				if (text2 != null) {
					out.println(text2);
				}
				out.println("</font></td></tr>");
				out.println("<tr><td align='left'><font size=2>");
				if (text3 != null) {
					out.println(text3);
				}
				out.println("</font></td></tr>");
				out.println("<tr><td align='left'><font size=2>");
				if (text4 != null) {
					out.println(text4);
				}
				out.println("</font></td></tr>");
				out.println("<tr><td align='left'><font size=2>");
				if (text1 != null) {
					out.println(text5);
				}
				out.println("</font></td></tr>");
				out.println("<tr><td align='left'><font size=2>");
				if (text6 != null) {
					out.println(text6);
				}
				out.println("</font></td></tr>");
				out.println("<tr><td align='left'><font size=2>");
				if (text7 != null) {
					out.println(text7);
				}
				out.println("</font></td></tr>");
				out.println("</table></center></div>");
		%>
		<%
			} else {
				if (request.getParameter("textarea1") != null) {
					String name = request.getParameter("text1");
					String text0 = (String) application.getAttribute("text0");
					String text1 = (String) application.getAttribute("text1");
					String text2 = (String) application.getAttribute("text2");
					String text3 = (String) application.getAttribute("text3");
					String text4 = (String) application.getAttribute("text4");
					String text5 = (String) application.getAttribute("text5");
					String text6 = (String) application.getAttribute("text6");
					String text7 = (String) application.getAttribute("text7");
					application.setAttribute("text7", text6);
					application.setAttribute("text6", text5);
					application.setAttribute("text5", text4);
					application.setAttribute("text4", text3);
					application.setAttribute("text3", text2);
					application.setAttribute("text1", text0);
					application.setAttribute("text2", text1);
					application.setAttribute("text0", " <b>" + name + ":</b>"
							+ request.getParameter("textarea1"));
				}
		%>
	
<html>
	<head>
	<body bgcolor='skyblue'>
		<form name="form1" method="post" onsubmit="return validateFields()">
			<%
				String loginname = (String) session.getAttribute("loginid");
			%>
			<center>
				<div
					style="top: 0; left: 99; position: absolute; z-index: 1; visibility: show;">
					<%
						if (request.getParameter("text1") != null) {
					%>
					<input type="hidden" name="text1" value="<%=loginname%>" />
					<%
						} else {
					%>
					<input type="hidden" name="text1" value="<%=loginname%>" />
					<%
						}
					%>
					<table align='right' >

						<tr>
							<td>
								<strong> Enter your text Here:</strong>
							</td>
							<td>
							<td align='left'>
								<a href="./AdminHome.jsp" target=_top>close</a>
							</td>
						</tr>
						<tr>
							<td><br>
							<textarea name="textarea1" rows="3" cols="20"></textarea>
							<br></td>
						</tr>
						<tr>
							<td>
								<input type="submit" value="submit">
							</td>
						</tr>

					</table>
		</form>
		<script language="javascript">
   document.form1.textarea1.focus()
   </script>
		<!-- content will go here -->
	</body>
</html>
<%
	}
%>