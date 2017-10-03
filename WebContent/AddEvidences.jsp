<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>

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
	</head>
	<body>
		<jsp:include page="Header.jsp"></jsp:include>
		<br />
		<center>
		<h3>
			<span class=subHead><br />Add Case Evidences Form </span>
		</h3>
		</center>
		<body>
			<!-- This is the form -->
			<form enctype="multipart/form-data" action="./AddCaseEvidences"
				method="get">
				<table border='0' align="center">
					<th colspan="6" bgcolor="#999933">
						Case Details
					</th>
					<tr></tr>
					<tr></tr>
					<tr>
						<td align='right'>
							Case Name :
						</td>
						<td>
							<input type="text" name="casename"
								value="<%=request.getParameter("casename")%>" readonly />
							<input type="hidden" name="caseid"
								value="<%=request.getParameter("caseid")%>" />
							<input type="hidden" name="casename"
								value="<%=request.getParameter("casename")%>" />
						</td>
					</tr>

					<tr>
						<td align='right'>
							Case Evidences :
						</td>
						<td>
							<input type="button" id="add_more" value="Add More"
								onclick="addElement_image();" />

							<input type="hidden" value="0" id="theValue" />
							<div id="myDivImage"></div>
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
							<input type='reset' name='Reset' value='Reset' />
						</td>
					</tr>
				</table>
			</form>
			<jsp:include page="Footer.jsp"></jsp:include>
		</body>
</html>