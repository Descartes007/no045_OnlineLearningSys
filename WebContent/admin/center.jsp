<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
	<!--
		body {
			margin-left: 0px;
			margin-top: 0px;
			margin-right: 0px;
			margin-bottom: 0px;
			overflow:hidden;
			table-layout:fixed;
		}
		-->
	</style>
  </head>
  
  <body>
		<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
		  <tr>
		    <td width="8" background="<%=path %>/img/main_29.gif">　</td>
		    <td align="center" valign="top">
			<iframe name="I1" src="<%=path %>/admin/middel.jsp" height="100%" width="100%" scrolling="no" border="0" frameborder="0">
			    浏览器不支持嵌入式框架，或被配置为不显示嵌入式框架。
			</iframe></td>
		    <td width="7" background="<%=path %>/img/main_32.gif">　</td>
		  </tr>
		</table>
</body>
</html>
