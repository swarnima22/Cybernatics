<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"><%@ page
	language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
	<head>
		<base href="<%=basePath%>">

			<title>My JSP 'AboutUs.jsp' starting page</title>

			<meta http-equiv="pragma" content="no-cache">
				<meta http-equiv="cache-control" content="no-cache">
					<meta http-equiv="expires" content="0">
						<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
							<meta http-equiv="description" content="This is my page">
								<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	</head>

	<body>
		<jsp:include page="Header.jsp"></jsp:include>
		<center> <font color='blue'>
		<h3>
			AboutUs
		</h3>
		</font> </center>
		<table>
			<tr>
				<td>
					<img src="./images/slanted-image-of-hq.jpg">
				</td>
				<td>
					The Secret Intelligence Service (SIS), often known as MI6, collects
					Britain's foreign intelligence. The Service is based at Vauxhall
					Cross in London. Its Chief is Sir John Sawers. SIS provides Her
					Majesty's Government with a global covert capability to promote and
					defend the national security and economic well-being of the United
					Kingdom.
				</td>
			</tr>
		</table>
		<br>
			<h2>
				<center> <font color='blue'>
				<h3>
					SIS and the media
				</h3>
				</font></center>
			</h2>

			<p>
				Enquiries from the media are conducted through a dedicated FCO press
				officer in
				<a title="This link opens in a new window" target="_blank"
					href="http://www.fco.gov.uk/en/news/contact-press-office/">FCO
					Press Office</a>.&nbsp;Because of the secret nature of our work, it's
				been the policy of SIS and successive Governments not to comment on
				operations, staff, agents, or relations with foreign intelligence
				services.&nbsp;SIS does not have a Press Office.
			</p>
			<br>
	</body>

</html>
