<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"><%@ page language="java" import="java.util.*,java.io.*"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.cyber.bean.CaseTO;"%>
<%@ page errorPage="UserExceptionHandler.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String fileString = "";
	CaseTO ani = null;
%>
<%
	if (session.getAttribute("userid") == null) {

		RequestDispatcher rd = request
				.getRequestDispatcher("./LoginForm.jsp");
		rd.forward(request, response);
	}
%>

<html>
	<head>

		<script language="JavaScript"
			src="<%=request.getContextPath()
							+ "/scripts/gen_validatorv31.js"%>"
			type="text/javascript">
</script>



	</head>

	<body>

		<jsp:include page="Header.jsp"></jsp:include>

		<center>
			<h3>
				<font color="red">CASE INFORMATION</font>
			</h3>
		</center>
		<table border='0'>

			<%
				Vector c = (Vector) request.getAttribute("caseinfo");
				Iterator it = c.listIterator();
				while (it.hasNext()) {
					ani = (CaseTO) it.next();
			%>
			<tr>
				<td>
					<table>
						<td height="" width='800'>
							<%
								fileString = ani.getFilepath();
									System.out.println(fileString);
									String filetype = ani.getCasefile();
									System.out.println(filetype);
									if ((filetype.equals("jpg")) || (filetype.equals("jpeg"))
											|| (filetype.equals("png")) || (filetype.equals("bmp"))) {
							%>
							<img src='<%=fileString%>' height='100' width='100'>
							<%
								} else if ((filetype.equals("avi")) || (filetype.equals("mp3"))
											|| (filetype.equals("mp4")) || (filetype.equals("wmv"))) {
							%>
							<embed src='<%=fileString%>' loop=true autostart=false></embed>
							<%
								} else {
										File f1 = new File(fileString);
										FileInputStream fstream = new FileInputStream(f1);
										DataInputStream in = new DataInputStream(fstream);
										BufferedReader br = new BufferedReader(
												new InputStreamReader(in));
										String strLine;
										while ((strLine = br.readLine()) != null) {
											out.println(strLine);
										}
										in.close();
									}
							%>
						
						<td>
						</td>
						<%
							}
						%>

					</table>
					<br />
					<jsp:include page="Footer.jsp"></jsp:include>
	</body>
</html>
