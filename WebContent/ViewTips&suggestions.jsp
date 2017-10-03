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
			<form name='cases' method='post' action='DeleteTipsAction'>
				<table>
					<tr bgcolor='white'>
						<td align='center'>
							<b></b>
						</td>

						<td align='center' width='200'>
							<b>Citizen Name</b>
						</td>
						<td align='center' width='100'>
							<b>Mail </b>
						</td>
						<td align='center' width='100'>
							<b>Tips & suggestions</b>
						</td>
					</tr>
					<c:forEach var="tips" items="${tips}">
						<tr>
							<c:choose>
								<c:when test="${sessionScope.role eq 'DefenceMinistry'}">
									<td align='center'>
										<input name="ch" type="checkbox" id="checkbox2"
											onClick="check1()" value="${tips.tipid }" />
									</td>
								</c:when>
								<c:otherwise>
									<td align='center'>
										<b>${tips.tipid }</b>
									</td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${sessionScope.role eq 'DefenceMinistry'}">
									<td align='center'>
										<b>${tips.citizen} </b>
									</td>
								</c:when>
								<c:otherwise>
									<td align='center'>
										<b>${tips.citizenname}</b>
									</td>
								</c:otherwise>
							</c:choose>
							<td align='center'>
								<b> ${tips.citizenemail}</b>
							</td>
							<td align='center'>
								<b> ${tips.tipssuggestions}</b>
							</td>
						</tr>
					</c:forEach>
					<tr>
					</tr>
					<tr>
						<td align='center' colspan='8'>
							<input type="submit" value="Delete" />
						</td>
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
