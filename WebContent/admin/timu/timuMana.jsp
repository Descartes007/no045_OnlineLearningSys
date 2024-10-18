<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		
		<script language="JavaScript" src="<%=path %>/js/public.js" type="text/javascript"></script>
		
        <script language="javascript">
           function timuAdd()
           {
              var url="<%=path %>/admin/timu/timuAdd.jsp";
              window.location.href=url;
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="63" background="<%=path %>/img/tbg.gif">&nbsp;&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="10%">名称</td>
					<td width="10%">选项A</td>
					<td width="10%">选项B</td>
					<td width="10%">选项C</td>
					
					<td width="10%">选项D</td>
					<td width="10%">答案</td>
					<td width="10%">分数</td>
					<td width="10%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.timuList}" var="timu">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${timu.name}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${timu.xuanxianga}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${timu.xuanxiangb}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${timu.xuanxiangc}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${timu.xuanxiangd}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${timu.daan}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${timu.fenshu}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<a class="pn-loperator" href="<%=path %>/timu?type=timuDel&id=${timu.id}">删除</a>
					</td>
				</tr>
				</c:forEach>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			      <input type="button" value="添加题目" style="width: 80px;" onclick="timuAdd()" />
			    </td>
			  </tr>
		    </table>
	</body>
</html>
