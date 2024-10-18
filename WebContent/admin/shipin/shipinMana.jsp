<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>
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

<link rel="stylesheet" type="text/css" href="<%=path%>/css/base.css" />

<script language="JavaScript" src="<%=path%>/js/public.js"
	type="text/javascript"></script>

<script language="javascript">
           function shipinAdd()
           {
              var url="<%=path%>/admin/shipin/shipinAdd.jsp";
              window.location.href=url;
           }
           
           function shipinDetail(id)
           {
                 var url="<%=path%>/shipin?type=shipinDetail&id="+id;
                 var n="";
                 var w="500px";
                 var h="400px";
                 var s="resizable:no;help:no;status:no;scroll:yes";
				 openWin(url,n,w,h,s);
           }
           
            function down1(fujianPath,fujianYuashiMing)
           {
               var url="<%=path%>/updown/updown.jsp?fujianPath="+fujianPath+"&fujianYuashiMing="+fujianYuashiMing;
		       url=encodeURI(url); 
               url=encodeURI(url); 
               window.open(url,"_self");
           }
       </script>
</head>

<body leftmargin="2" topmargin="2" background='<%=path%>/img/allbg.gif'>
	<table width="98%" border="0" cellpadding="2" cellspacing="1"
		bgcolor="#D1DDAA" align="center" style="margin-top: 8px">
		<tr bgcolor="#E7E7E7">
			<td height="14" colspan="5" background="<%=path%>/img/tbg.gif">&nbsp;&nbsp;</td>
		</tr>
		<tr align="center" bgcolor="#FAFAF1" height="22">
			<td width="20%">名称</td>
			<td width="20%">类别</td>
			<td width="20%">内容</td>
			<td width="10%">附件下载</td>
			<td width="20%">发布时间</td>
			<td width="20%">操作</td>
		</tr>
		<c:forEach items="${requestScope.shipinList}" var="shipin">
			<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<td bgcolor="#FFFFFF" align="center">${shipin.title}</td>
				<td bgcolor="#FFFFFF" align="center">
					${shipin.catelog_name}
				</td>
				<td bgcolor="#FFFFFF" align="center"><a href="#"
					onclick="shipinDetail(${shipin.id})" class="pn-loperator">查看内容</a>
				</td>
				<td bgcolor="#FFFFFF" align="center"><a href="#"
					onclick="down1('${shipin.fujian}','${shipin.fujianYuanshiming}')"
					style="font-size: 10px; color: red">down</a></td>
				<td bgcolor="#FFFFFF" align="center">${shipin.shijian}</td>
				<td bgcolor="#FFFFFF" align="center"><a class="pn-loperator"
					href="<%=path %>/shipin?type=shipinDel&id=${shipin.id}">删除</a></td>
			</tr>
		</c:forEach>
	</table>

	<table width='98%' border='0'
		style="margin-top: 8px; margin-left: 5px;">
		<tr>
			<td><input type="button" value="添加视频" style="width: 80px;"
				onclick="shipinAdd()" /></td>
		</tr>
	</table>
</body>
</html>
