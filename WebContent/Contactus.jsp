<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'Contactus.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body bgcolor='"skyblue"'>
		<jsp:include page="Header.jsp"></jsp:include>
		<!-- ImageReady Slices (home page.jpg) -->
		<div align="center">
			<table border="1" cellpadding="0" cellspacing="0"
				bordercolor="skyblue" id="Table_01">
				<tr>
					<td valign="top" bgcolor="skyblue">
						<img src="images/images.jpeg" width="222" height="295">
						<br>
					</td>
					<td align="left" valign="top" bgcolor="skyblue">

						<h1 class="documentFirstHeading">
							Secret Intelligence
						</h1>

						<p>
							William J. Donovan in 1941 had not intended his new intelligence
							service to become a &ldquo;spy&rdquo; agency, running espionage
							operations in foreign capitals. He wanted COI to support military
							operations in the field by providing research, propaganda, and
							commando support, but he quickly became convinced of the value of
							clandestine human reporting. In 1942 OSS established the Secret
							Intelligence Branch (SI) to open field stations, train case
							officers, run agent operations, and process reports in
							Washington. Headed from 1943 on by international executive and
							lawyer Whitney H. Shepardson, SI by the end of the war had become
							a full-fledged foreign intelligence service, with stations in
							Europe, Asia, and the Middle East, excellent liaison contacts
							with foreign services, and a growing body of operational
							doctrine.
						</p>
						<p>
					</td>
				</tr>
			</table>
			<table>
				<tr>
					<td>
						In November 1942, the most famous SI station chief, Allen W.
						Dulles, set up shop on &ldquo;Hitler&rsquo;s doorstep&rdquo; in
						the American legation in Bern, Switzerland. He found there a
						complicated and ever-shifting scene. Dulles quickly adopted a
						remnant of the fine prewar French military intelligence service,
						which gratefully provided him reports on German deployments in
						France that were prized by Allied invasion planners. He also found
						that Allied agents sent into Nazi Germany had scant hope of
						eluding the Gestapo, but that travel between the Reich and neutral
						Switzerland was free enough to bring a variety of Germans to him.
						Dulles established wide contacts with German
						&eacute;migr&eacute;s, resistance figures, and anti-Nazi
						intelligence officers (who linked him, through Hans Bernd
						Gisevius, to the tiny but daring opposition to Hitler in Germany
						itself). Although Washington barred Dulles from making firm
						commitments to the plotters of the 20 July 1944 attempt to
						assassinate Hitler, the conspirators nonetheless gave him reports
						on developments in Germany, including sketchy but accurate
						warnings of plans for Hitler&rsquo;s V-1 and V-2 missiles. In
						addition, Dulles was contacted by a German Foreign Ministry
						official, Fritz Kolbe, who volunteered to report from Berlin.
						Kolbe&rsquo;s periodic packets illuminated German foreign policy
						and military matters, and helped the British spot the German spy
						&ldquo;Cicero&rdquo; working in the household of the British
						ambassador to Turkey.
			
						<p>
							Secret Intelligence Branch operations by 1945 had extended beyond
							the running of operations in foreign capitals to encompass the
							actual penetration of Nazi Germany. Donovan wanted to replicate
							the successes that the SI mission in Algiers had had in running
							the &ldquo;Penny-Farthing&rdquo; network in Southern France, but
							Germany, with no organized Resistance, was a much tougher
							objective. SI&rsquo;s mission in London, led by William J. Casey,
							found a solution by adopting the methods of a successful OSS
							Morale Operations Branch project in Italy. Casey&rsquo;s
							unit&mdash;knowing that no Americans could survive in
							Hitler&rsquo;s Germany&mdash;learned how to find
							&ldquo;volunteer&rdquo; agents among the thousands of Axis
							prisoners-of-war in England. Casey&rsquo;s London SI trained the
							agents, provided them with meticulously prepared clothing,
							documentation, and equipment, and dropped nearly 200 of them into
							the Third Reich to gather intelligence in the last months of the
							war. Agent teams established themselves in Bremen, Munich, Mainz,
							Dusseldorf, Essen, Stuttgart, and Vienna&mdash;and even in
							Berlin. They paid a high price in casualties&mdash;36 were
							killed, captured, or missing at war&rsquo;s end&mdash;but the
							data they collected on industrial and military targets
							significantly aided the final Allied air and ground assaults on
							Germany.
						</p>
					</td>
				</tr>
				<tr>
					<td width="78%" height="579" colspan="2" valign="top">
						<br>
					</td>
				</tr>
				<tr valign="bottom">

					<td height="22" colspan="2" bgcolor="skyblue">
						<span class="style5"><span class="style6">&nbsp;&nbsp;&copy;
								2011 Cybernatic Protectors
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Developed by
								NIT<a> Technologies</a> </span> </span>
					</td>
				</tr>
			</table>
	</body>
</html>
