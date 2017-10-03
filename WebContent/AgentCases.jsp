<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<script language="JavaScript" src="scripts/gen_validatorv31.js"
			type="text/javascript">
</script>
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

		<script language="JavaScript" src="images/javascripts.js">
</script>
		<script language="JavaScript" src="images/pop-closeup.js">
</script>
	</head>
	<body>
		<jsp:include page="Header.jsp"></jsp:include>
		<br />
		<body>
			<!-- This is the form -->
			<form action="./AddAgentCaseAction" name='agency' method="get">
				<table border='0' align="center">
					<th colspan="6" bgcolor="#999933">
						Assign Cases
					</th>
					<tr></tr>
					<tr></tr>

					<tr>
						<td align='right'>
							Case Name :
						</td>
						<td>
							<select name="caseid" id="select">
								<option>
									--SELECT--
								</option>
								<c:if test="${not empty vcaseto1}">
									<c:forEach var="case" items="${vcaseto1}">
										<option value="${case.caseid}">
											${case.casename}
										</option>
									</c:forEach>
								</c:if>
							</select>

						</td>
						<tr>
							<tr>
								<td align='right'>
									Agent Name :
								</td>
								<td>
									<select name="agentid" id="select">
										<option>
											--SELECT--
										</option>
										<c:if test="${not empty vcaseto2}">
											<c:forEach var="agent" items="${vcaseto2}">
												<option value="${agent.userid}">
													${agent.loginid}
												</option>
											</c:forEach>
										</c:if>
									</select>
								</td>
								<tr>
									<tr>
										<td></td>
										<td>
										</td>
									</tr>
									<tr>
										<td align='right'>
											<input type='submit' name='submit' value='Add' />
										</td>
										<td align='left'>
											<input type='reset' name='Reset' value='Reset' />
										</td>
									</tr>
				</table>
			</form>
			<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
var frmvalidator = new Validator("agency");
frmvalidator.addValidation("caseid", "dontselect=0");
frmvalidator.addValidation("agentid", "dontselect=0");
</script>
			<jsp:include page="Footer.jsp"></jsp:include>
		</body>
</html>