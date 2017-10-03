<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	if (session.getAttribute("role") == null) {

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
			<form name='deleteemployee' method='post' action='DeleteResume'>
				<table border='1'>
					<c:if test="${not empty vpro}">
						<tr bgcolor='white'>
							<c:if test="${sessionScope.role eq 'DefenceMinistry'}">
								<td></td>
							</c:if>
							<c:if test="${sessionScope.role eq 'AgentChief'}">
								<td></td>
							</c:if>
							<td align='center'>
								<b>Applicant Mail</b>
							</td>
							<td align='center'>
								<b>Resume</b>
							</td>

						</tr>

						<c:forEach var="job" items="${vpro}">
							<tr>
								<c:if test="${sessionScope.role eq 'DefenceMinistry'}">
									<td>
										<u><input type="checkbox" name="ch" id="checkbox2"
												onclick="check1()" value="${job.resumepid }"> </u>
									</td>
								</c:if>
								<c:if test="${sessionScope.role eq 'AgentChief'}">
									<td>
										<u><input type="checkbox" name="ch" id="checkbox2"
												onclick="check1()" value="${job.resumepid }"> </u>
									</td>
								</c:if>
								<td align='center'>
									<u><b> ${job.email }</b> </u>
								</td>
								<td align='center'>
									<font color='red'><a href='${job.resumepath }'><b>
												DOWNLOAD</b> </a> </font>
								</td>


							</tr>
						</c:forEach>
						<c:if test="${sessionScope.role eq 'DefenceMinistry'}">
							<tr>
								<td align='center' colspan='8'>
									<input type="submit" value="Delete" />
								</td>
							</tr>
						</c:if>
						<c:if test="${sessionScope.role eq 'AgentChief'}">
							<tr>
								<td align='center' colspan='8'>
									<input type="submit" value="Delete" />
								</td>
							</tr>
						</c:if>
					</c:if>
				</table>
			</form>
		</center>
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<jsp:include page="Footer.jsp"></jsp:include>
	</body>
</html>
