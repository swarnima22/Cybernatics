<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
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
			<font color='white'><h1>
					Careers at SIS
				</h1>
			</font>




			<div id="main-section"
				class="content-area-background-green-with-gradient">

				<div class="small-flash-container">
					<div id="banner-flash-container">
						<div class="careers-home-non-flash">
							<div>
								<p>
									A career at SIS in the international intelligence arena is like
									no other. Although there are fewer vacancies than usual on the
									site due to public sector cutbacks, there are still roles
									available. Explore the site to see where your skills might fit
									in.
								</p>

								<h2>
									<font color='blue'>Incomparable Careers</font>
								</h2>
								<p>
									Where else could you watch history in the making and pretend
									you had a boring day at the office?
								</p>
							</div>
							<div>
								<ul>
									<li>
										<font color='blue'><h3>
												Operation Officers video transcript
											</h3>
										</font>
									</li>
									<br>
									After graduating with a degree in History & Politics, and an
									unsatisfying stint making lots of money for other people in the
									private sector, I decided to try working for the Government.
									From an early age I had always been drawn to the idea of
									working in intelligence, but never really knew how to go about
									getting into it. In 2001, SIS had not begun to advertise
									openly, so I answered a bland-sounding advert for work in a UK
									Government department with opportunities for foreign travel.
									Needless to say, I was surprised and pleased when - after I
									signed the Official Secrets Act - it was revealed to be a
									recruitment campaign for SIS. Shortly after my second
									interview, 9/11 occurred - this made me all the more eager to
									join up. After an intensive and challenging initial training
									course, I joined a small team working on counter-narcotics.
									There was a great camaraderie between us, a positive outlook
									and a real sense of collective achievement when things went to
									plan. One of my enduring beliefs about SIS is that despite (and
									perhaps because of) friendly rivalry, everybody wants everybody
									else to succeed, and to gather secret intelligence and return
									safely from wherever in the world they happen to have gone to
									get it.
									<li>
										<font color='blue'><h3>
												Administrator video transcript
											</h3>
										</font>
									</li>
									<br>
									After graduating from university, I started working for a small
									manufacturing business. A few months later having decided that
									I wanted a change of direction, I successfully applied for a
									job in SIS. In some ways the experience of joining SIS was much
									like that of university - moving to a new city, other new
									entrants joining at the same time, a coffee shop, a gym,
									organised social events - but this time I was being paid, had a
									pension and the work was secret. My first two weeks at SIS were
									taken up with an induction course, a good way of understanding
									the aims of the Service and how it achieves them. It was also a
									chance to meet other new entrants. At the end of the induction
									I was allocated the first of the three jobs I have held since
									joining. My first job was a short stint in Records Management
									which gave me a good introduction to working in SIS and allowed
									me to develop skills which have been useful in my subsequent
									posts. I have gained further skills and knowledge through a
									wide variety of training courses which my line managers have
									encouraged me to attend. Some of these courses are specific to
									SIS work and others are more general such as 'Effective
									Writing' or the 'European Computer Driving Licence'.
									<li>
										<a href="/transcripts/technology-video-transcript.html">Technology
											video transcript</a>
									</li>
									<li>
										<a
											href="/transcripts/corporate-services-video-transcript.html">Corporate
											services video transcript</a>
									</li>
									<li>
										<a
											href="/transcripts/language-specialist-video-transcript.html">Language
											specialist video transcript</a>
									</li>

									<li>
										<a
											href="/transcripts/trades-and-services-video-transcript.html">Trades
											&amp; Services video transcript</a>
									</li>
								</ul>
							</div>
	</body>
</html>
