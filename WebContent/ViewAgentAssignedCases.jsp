<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	int count = 0;
%>
<%
	if (session.getAttribute("role") == null) {

		RequestDispatcher rd = request
				.getRequestDispatcher("./LoginForm.jsp");
		rd.forward(request, response);
%>
<%
	}
%>
<html>
	<head>
	</head>
	<body>
		<jsp:include page="Header.jsp"></jsp:include>
		<center>
			<form name='cases' method='post' action='DeleteCases'>
				<table>
					<tr bgcolor='white'>

						<td align='center'>
							<b>CaseAssignedId</b>
						</td>

						<td align='center' width='200'>
							<b>CaseName</b>
						</td>
						<td align='center' width='200'>
							<b>AgentName</b>
						</td>
						<td align='center' width='100'>
							<b>CaseReg Date</b>
						</td>
						<td align='center' width='100'>
							<b>CaseStatus</b>
						</td>
					</tr>

					<c:forEach var="cases" items="${assigniedcases}">
						<tr>
							<c:choose>
								<c:when test="${sessionScope.role eq 'AgentChief'}">
									<td align='center'>
										<b>${cases.caseassignid}</b>
									</td>

								</c:when>

								<c:otherwise>
									<td align='center'>
										<b>${cases.caseassignid }</b>
									</td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${sessionScope.role eq 'AgentChief'}">
									<td align='center'>
										<b><a href="./ViewCaseFiles?caseid=${cases.caseassignid }">${cases.casename}</a>
										</b>
									</td>

								</c:when>

								<c:otherwise>
									<td align='center'>
										<b>${cases.casename}</b>
									</td>
								</c:otherwise>
							</c:choose>
							<td align='center'>
								<b> ${cases.agentname}</b>
							</td>
							<td align='center'>
								<b> ${cases.caseregdate}</b>
							</td>
							<td align='center'>
								<b> ${cases.casestatus}</b>
							</td>
						</tr>
					</c:forEach>
					<tr>
					</tr>

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
