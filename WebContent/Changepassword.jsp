<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<%
	if (session.getAttribute("userid") == null) {

		RequestDispatcher rd = request
				.getRequestDispatcher("./LoginForm.jsp");
		rd.forward(request, response);
%>
<%
	}
%>

<html>
	<head>
		<style type="text/css">
.Title {
	font-family: Verdana;
	font-weight: bold;
	font-size: 8pt
}

.Title1 {
	font-family: Verdana;
	font-weight: bold;
	font-size: 8pt
}
</style>


		<script type="text/javascript">
function validator() {

	document.getElementById("pass").innerHTML = "";
	document.getElementById("change").innerHTML = "";

	if (document.getElementById("newpass").value == "") {

		document.getElementById("pass").innerHTML = "Plz Enter Password";
		return false;
	} else if (document.getElementById("new").value == "") {

		document.getElementById("pass").innerHTML = "Plz Enter New Password";
		return false;
	}

}
</script>


	</head>


	<body>
		<jsp:include page="Header.jsp"></jsp:include>

		<br />
		<br />
		<br />
		<br />
		<center>
			<span class=Title><h3>
					<font color="purple">Change Password Form</font>
				</h3>
			</span>
		</center>



		<form id="form3" name="newedesignation" method="post"
			action="./ChangePasswordAction" onsubmit="return validator();">
			<table border="0" align="center">
				<tr>
					<td>
						<span class=Title> Login Name : </span>
					</td>
					<td>
						<input type="text" name="userName"
							value="<%=session.getAttribute("loginid")%>" readonly />
					</td>
				</tr>
				<tr>
					<td>
						<span class=Title> Old Password : </span>
					</td>
					<td>
						<input type="password" name="oldpassword" id="newpass" />
						<div id="pass"></div>
					</td>
				</tr>
				<tr>
					<td>
						<span class=Title> New Password : </span>
					</td>
					<td>
						<input type="password" name="newpassword" id="new" />
						<div id="change"></div>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div align="center">
							<strong> <input type="submit" name="Submit"
									value="Change" /> </strong>
						</div>
					</td>
				</tr>
			</table>
		</form>

		<br />
		<jsp:include page="Footer.jsp"></jsp:include>
	</body>
</html>
