<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<title>My JSP 'Header.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
<script type="text/javascript">
function disableBackButton() {
	window.history.forward();
}
setTimeout("disableBackButton()", 0);
</script>
	</head>

	<body onload="javascript:disableBackButton()" bgcolor='skyblue'>
		<img src="./images/img_banner02.jpg" align='top' height='220'
			width='1400'>
		<c:choose>
			<c:when test="${sessionScope.role eq 'AgentChief'}">
				<jsp:include page="AgentChiefMenu.jsp" />
			</c:when>

			<c:when test="${sessionScope.role eq 'DefenceMinistry'}">
				<jsp:include page="DefenceMinistryMenu.jsp" />
			</c:when>
			<c:when test="${sessionScope.role eq 'Agent'}">
				<jsp:include page="AgentMenu.jsp" />
			</c:when>
			<c:otherwise>
				<jsp:include page="HomeMenu.jsp"></jsp:include>
			</c:otherwise>
		</c:choose>


		<br />
		<br />

		<center>
		<font color="red">
		<b> <c:if test="${requestScope.status!='null'}">

				<c:out value="${requestScope.status}"></c:out>
			</c:if> </b>
		</font>

		</center>
	</body>
</html>
