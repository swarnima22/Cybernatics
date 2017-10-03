<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"><html>

	<head>
		<!-- Include the javascript -->
		<script src="multifile_compressed.js">
</script>
		<script language="JavaScript"
			src="<%=request.getContextPath()
							+ "/scripts/gen_validatorv31.js"%>"
			type="text/javascript">
</script>
	</head>
	<body>
		<jsp:include page="Header.jsp"></jsp:include>
		<br />
		<center>
			<h3>
				<span class=subHead><br />Tips & Suggessitions Form </span>
			</h3>
		</center>
		<body>
			<!-- This is the form -->
			<form enctype="multipart/form-data"
				action="./TipsSuggessitionsAction" method="get" name='tips'>
				<table border='0' align="center">
					<th colspan="6" bgcolor="#999933">
						Tips & Suggessitions
					</th>
					<tr></tr>
					<tr></tr>
					<tr>
						<td align='right'>
							Citizen Name :
						</td>
						<td>
							<input type="text" name="citizenname" value="" />
						</td>
					</tr>
					<tr>
						<td align='right'>
							Citizen Email:
						</td>
						<td>
							<input type="text" name="email" value="" size="20" />
						</td>
					</tr>
					<tr>
						<td align='right'>
							Suggessition :
						</td>
						<td>
							<textarea name='suggesstions' value=''></textarea>
						</td>
					</tr>
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
							<input type='reset' name='Reset' value='clear' />
						</td>
					</tr>
				</table>
			</form>
			<jsp:include page="Footer.jsp"></jsp:include>
		</body>
		<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
var frmvalidator = new Validator("tips");
frmvalidator.addValidation("citizenname", "req", "Name is required");
frmvalidator.addValidation("email", "req", "Email is required");
frmvalidator.addValidation("suggesstions", "req", "suggesstions is required");
</script>
</html>