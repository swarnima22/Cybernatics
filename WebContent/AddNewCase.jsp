<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
	<%@ page errorPage="UserExceptionHandler1.jsp"%>
	<head>
		<!-- Include the javascript -->
		<script src="multifile_compressed.js"></script>
		<script>	function addElement_image()
      {
        var ni = document.getElementById('myDivImage');
        var numi = document.getElementById('theValue');
        var num = (document.getElementById('theValue').value -1)+ 2;
        numi.value = num;
        var newdiv = document.createElement('div');
        var divIdName = 'my'+num+'DivImage';
        newdiv.setAttribute('id',divIdName);
    newdiv.innerHTML = '<td><p><input name="image[image_'+num+']" type="file" value="Add" ><input name="ch" type="checkbox" id="checkbox2"	 value="image[image_'+num+']" checked/></td>';
       ni.appendChild(newdiv);
     }
   
    function removeElement_image(divNum)
    {
       var d = document.getElementById('myDivImage');
       var olddiv = document.getElementById(divNum);
       d.removeChild(divNum);
    }</script>
		<script language="JavaScript" src="scripts/gen_validatorv31.js"
			type="text/javascript"></script>
		<script language="JavaScript" type="text/javascript"
			src="scripts/ts_picker.js"></script>
		<script language="JavaScript1.1" src="scripts/pass.js"></script>
		<script type="text/javascript" src="scripts/image.js"> </script>
		<script type="text/javascript" src="scripts/general.js"> </script>
		<script type="text/javascript" src="scripts/adi.js"> </script>
		<script type="text/javascript" src="scripts/form_validation.js"> </script>
		<script language="JavaScript" src="images/javascripts.js"></script>
		<script language="JavaScript" src="images/pop-closeup.js"></script>
	</head>
	<body>
		<jsp:include page="Header.jsp"></jsp:include>
		<br />
		<center>
			<h3>
				<span class=subHead><br />Add New Case Form </span>
			</h3>
		</center>

		<!-- This is the form -->
		<form enctype="multipart/form-data" action="./AddNewCaseAction"
			name='case' method="get">
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
						<input type="text" name="casename" value="" />
					</td>
				</tr>
				<tr>
					<td align='right'>
						Case Description :
					</td>
					<td>
						<input type="text" name="casedescription" value="" size="20" />
					</td>
				</tr>
				<tr>
					<td align='right'>
						CaseFiles :
					</td>
					<td>
						<input type="button" id="add_more" value="Add More" name='addfile'
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
		<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("case");
  
   frmvalidator.addValidation("casename","req","Please enter your Case Name");
   frmvalidator.addValidation("casedescription","req","Please enter CaseDescription");
      frmvalidator.addValidation("addfile","req","Please enter CaseDescription");
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