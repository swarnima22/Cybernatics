<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<script language="JavaScript" type="text/javascript"
		src="scripts/ts_picker.js">
</script>
	<script language="JavaScript1.1" src="scripts/pass.js">
</script>
	<script type="text/javascript" src="scripts/image.js">
</script>
	<script type="text/javascript" src="scripts/general.js">
</script>
	<script type="text/javascript" src="scripts/adi.js">
</script>
	<script type="text/javascript" src="scripts/form_validation.js">
</script>

	<body>
		<jsp:include page="Header.jsp"></jsp:include>
		<center>
		</center>
		<form method='post'
			action="<%=request.getContextPath() + "/UpdateCase"%>" name="case">
			<center>
				<h3>
					Update Case Form
				</h3>
			</center>
			<table cellspacing=2 align="center" bgcolor="skyblue">
				<c:forEach var="case" items="${cases}">
					<tr>

						<td align='right'>
							<b>CaseName :</b>
						</td>
						<td>
							<input type='text' name='casename' value="${case.casename }"
								readonly>
						</td>
						<tr>
							<td align='right'>
								<b>Case Reg date :</b>
							</td>
							<td>
								<input type="text" name="caseregdate"
									value="${case.caseregdate}" size="20" readonly="readonly" />

							</td>
							<tr>
								<td align='right'>
									<b> Case Details :</b>
								</td>
								<td>
									<input type="text" name="casedescription"
										value="${case.casedescription}" size="20" />
								</td>
							</tr>
							<tr>
								<td align='right'>
									<b> Case Status :</b>
								</td>
								<td>
									<select name="casestatus">
										<option value="${case.casestatus}">
											${case.casestatus}
										</option>
										<option value="Open">
											open
										</option>
										<option value="ReOpen">
											ReOpen
										</option>
										<option value="Pending">
											Pending
										</option>
										<option value="Close">
											Close
										</option>
									</select>
								</td>
							</tr>

							<input type='hidden' name="caseid" value='${case.caseid }'>
							<tr>
								<td align='right'>
									<input type='submit' name=submit value='update'>
								</td>
							</tr>
				</c:forEach>
			</table>
		</form>


		<br />
		<jsp:include page="Footer.jsp"></jsp:include>
	</body>
</html>
