<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Vector"%>
<%@page import="com.cyber.bean.CaseTO"%>
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
				<span class="style13">Report Export to : <a href="./ExportXLS" target="_blank"><font color="brown">XLS</font></a></span><br/>
					<tr bgcolor='white'>

						<td align='center'>
							<b>AgencyId</b>
						</td>

						<td align='center' width='200'>
							<b>AgencyName</b>
						</td>
						<td align='center' width='100'>
							<b>AgencyDescription</b>
						</td>
						<td align='center' width='100'>
							<b>Address</b>
						</td>
						<td align='center' width='100'>
							<b>Contact</b>
						</td>
						<td align='center' width='100'>
							<b>AgencyChief</b>
						</td>
					</tr>

					<c:forEach var="agency" items="${agency}">
						<tr>
							<c:choose>
								<c:when test="${sessionScope.role eq 'DefenceMinistry'}">
									<td align='center'>
										<b>${agency.agencyid}
										</b>
									</td>

								</c:when>

								<c:otherwise>
									<td align='center'>
										<b>${agency.agencyid }</b>
									</td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${sessionScope.role eq 'DefenceMinistry'}">
									<td align='center'>
										<b>${agency.agencyname}
										</b>
									</td>

								</c:when>

								<c:otherwise>
									<td align='center'>
										<b>${agency.agencyname}</b>
									</td>
								</c:otherwise>
							</c:choose>



							<td align='center'>
								<b> ${agency.agencydescription}</b>
							</td>
							<td align='center'>
								<b> ${agency.agencyaddress}</b>
							</td>
							<td align='center'>
								<b> ${agency.agencycontact}</b>
							</td>
							<td align='center'>
								<b> ${agency.loginid}</b>
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
		<% String report="";
           report+=" <table align='center' border=1 bgcolor='#A1B2C3' width='70%' cellpadding='10'>";
           report+=" <caption><h3>District Budget Details</h3> </caption>"; 
           report+=" <tr><td>AgencyId</td><td>AgencyName</td><td>AgencyDescription</td><td>Address</td><td>Contacts</td><td>AgencyCheif</td></tr>"; 
      
			Vector v=(Vector)request.getAttribute("agency"); 
				 Iterator it=v.listIterator();
				while(it.hasNext()){
				CaseTO r=(CaseTO)it.next();
								
	report+= "<tr><td align='center'><b>"+r.getAgencyid()+"</b></td><td align='center'><b>"+r.getAgencyname()+"</td><td align='center'><b>"+r.getAgencydescription()+"</b></td><td align='center'><b>"+r.getAgencyaddress()+"</b></td><td align='center'><b>"+r.getAgencycontact()+"</b></td><td align='center'><b>"+r.getLoginid()+"</b></td></tr>";
		}
		report+="</table>";
		session.setAttribute("Report",report);
		
		%>
		<jsp:include page="Footer.jsp"></jsp:include>
	</body>
</html>
