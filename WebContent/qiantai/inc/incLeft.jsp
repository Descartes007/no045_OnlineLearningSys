<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <script type="text/javascript">
         
      </script>
  </head>
  
  <body>
        <TABLE width="100%" height="160" border=0 cellPadding=0 cellSpacing=0 class=dragTable>
				<TR>
					<TD class=head>
						<SPAN class=TAG>用户登录</SPAN>
					</TD>
				</TR>
				<TR>
					<TD class=middle align=left>
					    <jsp:include flush="true" page="/qiantai/userlogin/userlogin.jsp"></jsp:include> 
					</TD>
				</TR>
		</TABLE>
		<TABLE width="100%" height="160" border=0 cellPadding=0 cellSpacing=0 class=dragTable>
				<TR>
					<TD class=head>
						<SPAN class=TAG>网站公告</SPAN>
					</TD>
				</TR>
				<TR>
					<TD class=middle align=left>
					   <table width="100%">
						     <c:forEach items="${sessionScope.gonggaoList}" var="gonggao">
						          <tr>
						             <td align="center"><a href="<%=path %>/gonggao?type=gonggaoDetailQian&id=${gonggao.id}" title="">${gonggao.title}</a></td>
						          </tr>
						     </c:forEach>
					   </table> 
					</TD>
				</TR>
		</TABLE>
		<TABLE width="100%" height="160" border=0 cellPadding=0 cellSpacing=0 class=dragTable>
				<TR>
					<TD class=head>
						<SPAN class=TAG>日历表</SPAN>
					</TD>
				</TR>
				<TR>
					<TD class=middle align=left>
					    <jsp:include flush="true" page="/qiantai/rili/rili.jsp"></jsp:include> 
					</TD>
				</TR>
		</TABLE> 
  </body>
</html>
