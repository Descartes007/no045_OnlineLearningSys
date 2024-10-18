<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
        
        <script language="javascript">
        </script>
	</head>

	<body leftmargin="2" topmargin="9" background='<%=path %>/images/allbg.gif'>
			<form action="<%=path %>/timu?type=timuAdd" name="formAdd" method="post">
				     <table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
						<tr bgcolor="#EEF4EA">
					        <td colspan="3" background="<%=path %>/images/wbg.gif" class='title'><span>在线自测</span></td>
					    </tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						        题目名称：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						         <input type="text" name="name" size="50"/>
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" id="timuXuanxianga" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						        选项A：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						         <input type="text" name="xuanxianga" size="50"/>
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" id="timuXuanxiangb" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						        选项B：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						         <input type="text" name="xuanxiangb" size="50"/>
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" id="timuXuanxiangc" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						        选项C：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						         <input type="text" name="xuanxiangc" size="50"/>
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" id="timuXuanxiangd" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						        选项D：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						         <input type="text" name="xuanxiangd" size="50"/>
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" height="22" id="radioo">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						        正确答案：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <input type="text" name="daan" size="20"/>
						        (<font style="color: red;font-size: 11px;">
						            单选题的答案只能是A,B,C,D中的一个
						        </font>)
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" id="timuXuanxiangd" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						        分数：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						         <input type="text" name="fenshu" value="10" size="10" onpropertychange="onchange1(this.value)" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						        &nbsp;
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						       <input type="submit" value="提交"/>&nbsp; 
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
					 </table>
			</form>
   </body>
</html>
