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
		}
		.STYLE1 {
			color: #767a7a;
			font-size: 12px;
		}
		-->
	</style>

  </head>
  
  <body>
     <table width="100%" border="0" cellspacing="0" cellpadding="0">
		  <tr>
		    <td width="22" height="30"><img src="<%=path %>/img/main_38.gif" width="22" height="30" /></td>
		    <td background="<%=path %>/img/main_40.gif">
		       <table width="100%" border="0" cellspacing="0" cellpadding="0">
			      <tr>
			        <td width="200" height="30">&nbsp;</td>
			        <td><div align="center" class="STYLE1">&nbsp;</div></td>
			        <td width="200"><div align="right" class="STYLE1">JAVA在线学习平台</div></td>
			      </tr>
		       </table>
		    </td>
		    <td width="28"><img src="<%=path %>/img/main_43.gif" width="28" height="30" /></td>
		  </tr>
</table>
  </body>
</html>
