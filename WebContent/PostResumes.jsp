<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<HTML>
	<HEAD>
		<TITLE>Untitled Document</TITLE>
		<META http-equiv=Content-Type content="text/html; charset=iso-8859-1">
		<META content="Microsoft FrontPage 4.0" name=GENERATOR>
	</HEAD>
	<BODY text=#000000 leftMargin=0 topMargin=0>
		<jsp:include page="Header.jsp"></jsp:include>
		<center>
			<font color='red'>Upload your Updated Resume Here<font>
		</center>
		<br>
		<br>
		<br>
		<TABLE cellSpacing=0 cellPadding=0 width=780 border=0>
			<TBODY>
				<form name="post" action="./ResumePostAction" method="post">
					<TR>
						<TD height=2></TD>
					</TR>
					<TR>
						<TD vAlign=top height=321>
							<TABLE cellSpacing=0 cellPadding=0 width="790" border=0>
								<TBODY>
									<TR>
										<TD valign=top width=772>
											<font color="#4583c0"> </font>
											<b></b>
											<center>
												<table>


													<tr>
														<td align='right'>
															<font size="4" color="#4583c0">Applicant EmailID :</font>
															<input type='text' name='email' value=''>
														</td>
													</tr>
													<tr>
														<td>

															<font size="4" color="#4583c0"> Please select your
																Resume Path Here...</font>
														</td>
													</tr>
													<tr>
														<td align='right'>
															<input type='file' name='resumepath' value=''>
														</td>
													</tr>
													<tr>
														<td>
															<strong> <input type="submit" name="button"
																	value="Post" tabindex="2"
																	style="BACKGROUND-COLOR: linen"> </strong>
															<input type="reset" value="Clear" name="B2" tabindex="3"
																style="BACKGROUND-COLOR: linen">
														</td>
													</tr>
													</TD>
													</TR>
													</TBODY>
												</TABLE>
										</TD>
									</TR>
									</form>
								</TBODY>
							</TABLE>
	</BODY>
</HTML>
