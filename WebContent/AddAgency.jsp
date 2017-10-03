<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"><%@ taglib
	prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page errorPage="UserExceptionHandler1.jsp"%>
<head>
	<!-- Include the javascript -->
	<script src="multifile_compressed.js">
</script>
	<script>
function addElement_image() {
	var ni = document.getElementById('myDivImage');
	var numi = document.getElementById('theValue');
	var num = (document.getElementById('theValue').value - 1) + 2;
	numi.value = num;
	var newdiv = document.createElement('div');
	var divIdName = 'my' + num + 'DivImage';
	newdiv.setAttribute('id', divIdName);
	newdiv.innerHTML = '<td><p><input name="image[image_'
			+ num
			+ ']" type="file" value="Add" ><input name="ch" type="checkbox" id="checkbox2"	 value="image[image_'
			+ num + ']" checked/></td>';
	ni.appendChild(newdiv);
}

function removeElement_image(divNum) {
	var d = document.getElementById('myDivImage');
	var olddiv = document.getElementById(divNum);
	d.removeChild(divNum);
}</script>
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
	<form action="./AddAgencyAction" name='case' method="get">
		<center> <b><font color='red'>Add Agency Form</font> </b> </center>
		<table border='0' align="center">
			<th colspan="6" bgcolor="#999933">
				Agency Details
			</th>
			<tr></tr>
			<tr></tr>
			<tr>
				<td align='right'>
					Agency Name :
				</td>
				<td>
					<input type="text" name="agencyname" value="" />
				</td>
			</tr>
			<tr>
				<td align='right'>
					Agency Description :
				</td>
				<td>
					<textarea type="text" name="agencydescription" value=""></textarea>
				</td>
			</tr>
			<tr>
				<td align='right'>
					Agency Address :
				</td>
				<td>
					<input type="text" name="agencyaddress" value="" size="20" />
				</td>
			</tr>
			<tr>
				<td align='right'>
					Agency Contact :
				</td>
				<td>
					<input type="text" name="agencycontact" value="" size="20" />
				</td>
			</tr>
			<tr>
				<td align='right'>
					Agency Chiefs
				</td>
				<td>
					<select name="caseid" id="select">
						<option>
							--SELECT--
						</option>
						<c:if test="${not empty agencychiefnames}">
							<c:forEach var="agency" items="${agencychiefnames}">
								<option value="${agency.userid}">
									${agency.loginid}
								</option>
							</c:forEach>
						</c:if>
					</select>
				</td>
				<tr>
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
var frmvalidator = new Validator("case");

frmvalidator
		.addValidation("agencyname", "req", "Please enter your Agency Name");
frmvalidator.addValidation("agencyaddress", "req",
		"Please enter Agency Description");
frmvalidator.addValidation("agencyaddress", "req",
		"Please enter Agency Address");
frmvalidator.addValidation("agencycontact", "req",
		"Please enter Agency Contact");
frmvalidator.addValidation("caseid", "dontselect=0");
</script>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</br>
</br>
</br>
</br>
</br>
</br>
</html>