<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
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
		.STYLE1 {font-size: 12px}
		.STYLE2 {
			color: #03515d;
			font-size: 12px;
		}
		-->
		a:link {font-size:12px; text-decoration:none; color:#000000;}
		a:visited {font-size:12px; text-decoration:none; color:#000000;}
		a:hover {font-size:12px; text-decoration:none; color:#FF0000;}
		
		a.v1:link {font-size:12px; text-decoration:none; color:#03515d;}
		a.v1:visited {font-size:12px; text-decoration:none; color:#03515d;}
	</style>
	<script type="text/javascript">
	    function logout()
		{
		   if(confirm("确定要退出本系统吗??"))
		   {
			   window.parent.location="<%=path %>/login.jsp";
		   }
		}
	</script>
  </head>
  
  <body>
       <body>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="26" background="<%=path %>/img/main_03.gif">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="227" height="26" background="<%=path %>/img/main_01.gif">
								&nbsp;
							</td>
							<td>
								&nbsp;
							</td>
							<td width="60">
								<img src="<%=path %>/img/main_05.gif" width="60" height="26" />
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td height="64">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="257" valign="top" height="64" background="<%=path %>/img/main_06.gif" nowrap="nowrap">
								<table>
								   <tr height="7"><td></td></tr>
								   <tr>
								      <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
								      <td><div style="FONT-WEIGHT: bold; FONT-SIZE: 18pt; FILTER: Glow(Color=#00347F,Strength=4); WIDTH: 100%; COLOR: #ffffff; font-family: 黑体">JAVA在线学习系统</div></td>
								   </tr>
								</table>
							</td>
							<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="26" background="<%=path %>/img/main_07.gif">
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													<td height="26">
														<table width="100%" border="0" cellspacing="0"
															cellpadding="0">
															<tr>
																<td width="640" height="26">
																	<table width="100%" border="0" cellspacing="0"
																		cellpadding="0">
																		<tr>
																			<td width="30">
																				<div align="center">
																					<img src="<%=path %>/img/top_1.gif" width="14" height="14" />
																				</div>
																			</td>
																			<td nowrap="nowrap" class="STYLE1">
																				当前登录用户：${sessionScope.admin.userName }
																			</td>
																		</tr>
																	</table>
																</td>
																<td width="19">
																	<img src="<%=path %>/img/main_09.gif" width="19" height="26" />
																</td>
																<td width="352">
																	<table width="46%" border="0" align="right"
																		cellpadding="0" cellspacing="0">
																		<tr>
																			<td width="56">
																				<table width="45" border="0" cellspacing="0"
																					cellpadding="0">
																					<tr>
																						<td width="21">
																							<div align="center">
																								<img src="<%=path %>/img/top_2.gif" width="14"
																									height="14" />
																							</div>
																						</td>
																						<td width="35">
																							<div align="center" class="STYLE1">
																								<a href="#">首页</a>
																							</div>
																						</td>
																					</tr>
																				</table>
																			</td>
																			<td width="10">
																				<img src="<%=path %>/img/main_11.gif" width="6" height="26" />
																			</td>
																			<td width="56">
																				<table width="45" border="0" cellspacing="0"
																					cellpadding="0">
																					<tr>
																						<td width="21">
																							<div align="center">
																								<img src="<%=path %>/img/top_3.gif" width="14"
																									height="14" />
																							</div>
																						</td>
																						<td width="24">
																							<div align="center" class="STYLE1">
																								<a href="#">后退</a>
																							</div>
																						</td>
																					</tr>
																				</table>
																			</td>
																			<td width="10">
																				<img src="<%=path %>/img/main_11.gif" width="6" height="26" />
																			</td>
																			<td width="56">
																				<table width="45" border="0" cellspacing="0"
																					cellpadding="0">
																					<tr>
																						<td width="21">
																							<div align="center">
																								<img src="<%=path %>/img/top_4.gif" width="14"
																									height="14" />
																							</div>
																						</td>
																						<td width="24">
																							<div align="center" class="STYLE1">
																								<a href="#">前进</a>
																							</div>
																						</td>
																					</tr>
																				</table>
																			</td>
																			<td width="10">
																				<img src="<%=path %>/img/main_11.gif" width="6" height="26" />
																			</td>
																			<td width="56">
																				<table width="45" border="0" cellspacing="0"
																					cellpadding="0">
																					<tr>
																						<td width="21">
																							<div align="center">
																								<img src="<%=path %>/img/top_5.gif" width="14"
																									height="14" />
																							</div>
																						</td>
																						<td width="24">
																							<div align="center" class="STYLE1">
																								<a href="#">刷新</a>
																							</div>
																						</td>
																					</tr>
																				</table>
																			</td>
																			<td width="10">
																				<img src="<%=path %>/img/main_11.gif" width="6" height="26" />
																			</td>
																			<td width="102">
																				<table width="102" border="0" cellspacing="0"
																					cellpadding="0">
																					<tr>
																						<td width="22">
																							<div align="center">
																								<img src="<%=path %>/img/top_6.gif" width="14"
																									height="14" />
																							</div>
																						</td>
																						<td width="80">
																							<div align="center" class="STYLE1">
																								<a href="<%=path %>/admin/userinfo/userPw.jsp" target="I2">密码修改</a>
																							</div>
																						</td>
																					</tr>
																				</table>
																			</td>
																			<td width="10">
																				<img src="<%=path %>/img/main_11.gif" width="6" height="26" />
																			</td>
																			<td width="56">
																				<table width="45" border="0" cellspacing="0"
																					cellpadding="0">
																					<tr>
																						<td width="21">
																							<div align="center">
																								<img src="<%=path %>/img/top_7.gif" width="14"
																									height="14" />
																							</div>
																						</td>
																						<td width="24">
																							<div align="center" class="STYLE1">
																								<a href="#" onclick="logout()">退出</a>
																							</div>
																						</td>
																					</tr>
																				</table>
																			</td>
																		</tr>
																	</table>
																</td>
															</tr>
														</table>
													</td>
													<td width="12">
														<img src="<%=path %>/img/main_13.gif" width="12" height="26" />
													</td>
												</tr>
											</table>
										</td>
									</tr>
									<tr>
										<td height="38" background="<%=path %>/img/main_15.gif">
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													<td height="38">
														<table border="0" cellspacing="0" cellpadding="0">
															<tr>
																<td width="300" height="26" valign="top">
																	<span class="STYLE2">
																		 &nbsp; &nbsp;
																		 <SCRIPT>setInterval("clock.innerHTML=new Date().toLocaleString()+'&nbsp;&nbsp;'+''.charAt(new Date().getDay());",1000)</SCRIPT><SPAN id=clock></SPAN>&nbsp;&nbsp;&nbsp;
																	</span>
																</td>
															</tr>
														</table>
													</td>
													<td width="60">
														<div align="right">
															<img src="<%=path %>/img/main_17.gif" width="60" height="38" />
														</div>
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
  </body>
</html>
