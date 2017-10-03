<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"><%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'AboutUs.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
		<jsp:include page="Header.jsp"></jsp:include>
		<center>
			<font color='blue'><h3>
					Success Stories
				</h3> </font>
		</center>
		<table>
			<tr>
				<td>
					<img src="./images/police.jpg">
				</td>
				<td>
					Ten Islamists were sentenced Thursday for their role in a planned
					attack on a Christmas market in Strasbourg. German secret
					investigators helped prevent the attack.
					<p style="margin: 0cm 0cm 0pt;" class="MsoNormal">
						The defendants from Algeria and Tunisia received up to 10 years in
						prison for trying to set off a bomb hidden in a pressure cooker.
						The fact that the bomb didn't go off and hurt thousands of people
						is a success story for Germany's secret service.
					</p>

					<p style="margin: 0cm 0cm 0pt;" class="MsoNormal">
						&nbsp;In late 2000, around the time of the planned attack,
						investigators from several agencies worked together on the case:
						They all had information about the so-called &quot;Frankfurt
						cell,&quot; but no agency would have been able to prevent the
						attack by itself.
					</p>
				</td>
			</tr>
		</table>
		<table>
			<tr>

				<td>
					Long before the eventual arrests, the German foreign intelligence
					service (BND) had received information via middlemen about a
					connection between some of the cell's members and the terror
					network of a certain Slimane Khalfaoi. As in most cases, the BND
					got its information from sources in Afghanistan and in the Arab
					world, where the agency has maintained good contacts for decades.



					Details about the Frankfurt cell were then passed on to Germany's
					internal intelligence service, the Office for the Protection of the
					Constitution (BfV), as some of the terrorists returned to Germany
					from Afghanistan, where they allegedly participated in terror
					training camps. BfV agents began listening in on cell members'
					conversations and alerted Germany's Federal Criminal Police Office
					(BKA) as the threat became imminent and the bomb attack was about
					to take place. BKA agents finally arrested the men -- a step
					neither BfV nor BND agents could have taken.
				</td>
				<td>
					<img src="./images/place.jpg">
				</td>
			</tr>
		</table>
		<table>
			<tr>
				<td>
					<img src="./images/police2.jpg">
				</td>
				<td>
					This cooperation also led to the arrests related to a planned
					attack on Iraqi Premier Ayad Allawi during his visit to Berlin in
					December. Police special units and state criminal police agents
					bugged phones and observed people. BfV agents had led them in the
					right direction. But according to Bavarian Interior Minister Günter
					Beckstein, investigators had no information from BND or its US
					counterpart, the CIA, about plans by the Ansar al-Islam
					organization to assassinate Allawi in Berlin. But Erich
					Schmidt-Eenboom, an intelligence expert, said he doubts Beckstein's
					statement. According to him BND officials have passed on
					information about Ansar al-Islam to BKA agents for years. "I
					believe that Beckstein deliberately doesn't reveal information," he
					said. "He should be informed better, what happens on the federal
					level as far as information exchange between intelligence agencies
					and police is concerned."

				</td>
			</tr>
		</table>

	</body>

</html>
