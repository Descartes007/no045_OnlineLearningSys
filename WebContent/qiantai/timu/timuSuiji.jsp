<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <LINK href="<%=path %>/css/css.css" type=text/css rel=stylesheet>
  </head>
  
  <BODY text=#000000  leftMargin=0 topMargin=0>
	<div class="wrap"> 
		<TABLE  cellSpacing=0 cellPadding=0 width="100%" align=center border=0  background="<%=path %>/img/reservation01.gif">
				<TR height="90">
					<TD align="center">
					    <jsp:include flush="true" page="/qiantai/inc/incTop1.jsp"></jsp:include> 
					</TD>
				</TR>
		</TABLE>
		
		
		<TABLE id=guide cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
				<TR>
					<TD align="left">
						<jsp:include flush="true" page="/qiantai/inc/incTop2.jsp"></jsp:include>
					</TD>
				</TR>
		</TABLE>

        <TABLE class=MainTable style="MARGIN-TOP: 0px" cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
				<TR>
				    <TD class=Side vAlign=top align=right width="25%">
						<jsp:include flush="true" page="/qiantai/inc/incLeft.jsp"></jsp:include>
					</TD>
					<td width="1">&nbsp;</td>
					<TD class=Side vAlign=top align=right width="75%">
						<TABLE class=dragTable cellSpacing=0 cellPadding=0 width="100%" border=0>
								<TR>
									<TD class=head>
										<SPAN class=TAG>在线自测</SPAN>
									</TD>
								</TR>
								<TR align="left">
									<TD height="5"></TD>
								</TR>
								<TR align="left" height="500">
									<TD>
									    <table align="left">
									        <tr>
									           <td width="12"></td>
									           <td>
									               <form action="<%=path %>/timu?type=timuSuiji_defen" name="" method="post">		
														<c:forEach items="${sessionScope.timuList}"  varStatus="sta" var="timu">
														<table cellspacing="1" cellpadding="1">
															<tr>
																<td>
																	${sta.index+1 }：${timu.name }(<font color="red">${timu.fenshu }分</font>)
																	&nbsp;&nbsp;&nbsp;
																</td>
															</tr>
															<tr>
																<td align="left">
																	    A:<input type="radio" name="${timu.id}" value="A" style="border: 0"/>${timu.xuanxianga }<br/>
																	    B:<input type="radio" name="${timu.id}" value="B" style="border: 0"/>${timu.xuanxiangb }<br/>
																	    C:<input type="radio" name="${timu.id}" value="C" style="border: 0"/>${timu.xuanxiangc }<br/>
																	    D:<input type="radio" name="${timu.id}" value="D" style="border: 0"/>${timu.xuanxiangd }<br/>
																</td>
															</tr>
														</table>
														<br/>
														</c:forEach>
														<hr>
														<c:forEach items="${requestScope.jiandatiList}" var="jiandati" varStatus="stauts">
														     <table border="0">
																<tr align='center'>
																    <td width="100%" align="left">
																        ${stauts.index+1}:${jiandati.name }
																    </td>
																</tr>
																<tr align='center'>
																    <td width="100%">
																        <FCK:editor instanceName="${jiandati.id+33}" value="请输入答案"  basePath="/fckeditor" width="350" height="150" toolbarSet="Basic">
											                            </FCK:editor>
																    </td>
																</tr>
															 </table>
															 <hr>
														</c:forEach>
														<input type="submit" value="确定"/>
													</form>
									           </td>
									        </tr>
									    </table>
									</TD>
								</TR>
								<TR align="left">
									<TD height="5"></TD>
								</TR>
						</TABLE>
					</TD>
				</TR>
		</TABLE>
		<jsp:include flush="true" page="/qiantai/inc/incFoot.jsp"></jsp:include>
    </div>
  </BODY>
</html>