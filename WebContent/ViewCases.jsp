<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Vector"%>
<%@page import="com.cyber.bean.CaseTO"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	int count = 0;
	String Reports = "";
	Iterator it = null;
	CaseTO pro=null;
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
		<span class="style13">Report Export to : <a href="./ExportXLS" target="_blank"><font color="brown">XLS</font></a></span><br/>
			<table>
				<form name="" action="" method="post">
					
			<form name='cases' method='post' action='DeleteCases'>
				<table>
					<tr bgcolor='white'>
						<td align='center'>
							<b>CaseId</b>
						</td>
						<td align='center' width='200'>
							<b>CaseName</b>
						</td>
						<td align='center' width='100'>
							<b>CaseReg Date</b>
						</td>
						<td align='center' width='100'>
							<b>CaseDetails</b>
						</td>
						<td align='center' width='100'>
							<b>CaseStatus</b>
						</td>

					</tr>
					<c:forEach var="cases" items="${cases}">
						<tr>
							<c:choose>
								<c:when test="${sessionScope.role eq 'DefenceMinistry'}">
									<td align='center'>
										<b><a href="./ViewUpdateCases?caseid=${cases.caseid}">${cases.caseid}</a>
										</b>
									</td>
								</c:when>
								<c:otherwise>
									<td align='center'>
										<b>${cases.caseid }</b>
									</td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${sessionScope.role eq 'DefenceMinistry'}">
									<td align='center'>
										<b><a href="./ViewCaseFiles?caseid=${cases.caseid }">${cases.casename}</a>
										</b>
									</td>
								</c:when>
								<c:otherwise>
									<td align='center'>
										<b>${cases.casename}</b>
									</td>
								</c:otherwise>
							</c:choose>
							<td align='center'>
								<b> ${cases.caseregdate}</b>
							</td>
							<td align='center'>
								<b> ${cases.casedescription}</b>
							</td>
							<td align='center'>
								<b> ${cases.casestatus}</b>
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
           report+=" <caption><h3>Case Details</h3> </caption>"; 
           report+=" <tr><td>CaseId</td><td>CaseName</td><td>CaseRegistrationDetails</td><td>CaseDetails</td><td>Case Status</td></tr>"; 
      
			Vector v=(Vector)request.getAttribute("cases"); 
				 it=v.listIterator();
				while(it.hasNext()){
				CaseTO r=(CaseTO)it.next();
								
	report+= "<tr><td align='center'><b>"+r.getCaseid()+"</b></td><td align='center'><b>"+r.getCasename()+"</td><td align='center'><b>"+r.getCaseregdate()+"</b></td><td align='center'><b>"+r.getCasedescription()+"</b></td><td align='center'><b>"+r.getCasestatus()+"</b></td></tr>";
		}
		report+="</table>";
		session.setAttribute("Report",report);
		
		%>
		
		<jsp:include page="Footer.jsp"></jsp:include>
	</body>
</html>
