<%@ page language="java" pageEncoding="UTF-8"%>
<jsp:directive.page import="java.util.Date" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
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
<script type="text/javascript" src="<%=path%>/js/popup.js"></script>
<script type='text/javascript' src='<%=path %>/dwr/interface/loginService.js'></script>
<script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
<script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
<script language="javascript">
        
        var i=0;
        function catelogAll()
        {
            if(i==0)
            {
                document.getElementById("indicator").style.display="block";
                loginService.catelogAll(callback);
                i=1;
            }
            
        }
        function callback(data)
        {
            document.getElementById("indicator").style.display="none";
            DWRUtil.addOptions("catelog_id",data,"id","name");
        }
        
        function up()
		{
		    var pop=new Popup({ contentType:1,isReloadOnClose:false,width:400,height:200});
	        pop.setContent("contentUrl","<%=path%>/upload/upload.jsp");
			pop.setContent("title", "文件上传");
		    pop.build();
		    pop.show();
		}
</script>
</head>

<body leftmargin="2" topmargin="9" background='<%=path%>/img/allbg.gif'>
	<form action="<%=path%>/shipin?type=shipinAdd" name="formAdd"
		method="post">
		<table width="98%" align="center" border="0" cellpadding="4"
			cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom: 8px">
			<tr bgcolor="#EEF4EA">
				<td colspan="3" background="<%=path%>/img/wbg.gif" class='title'><span></span></td>
			</tr>
			<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<td width="15%" bgcolor="#FFFFFF" align="center">名称：</td>
				<td width="85%" bgcolor="#FFFFFF" align="left"><input
					type="text" name="title" /></td>
			</tr>
			<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						         视频分类：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <table border="0">
							           <tr> 
							               <td>  
							                  <select name="catelog_id" id="catelog_id" onclick="catelogAll()" style="width: 140px;">
									              <option value="0">请选择分类</option>
									          </select>
							               </td>
							               <td>
							                  <img id="indicator" src="<%=path %>/img/loading.gif" style="display:none"/>
							               </td>
							           </tr>
							    </table>
						    </td>
						</tr>
			<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<td width="15%" bgcolor="#FFFFFF" align="center">附件：</td>
				<td width="85%" bgcolor="#FFFFFF" align="left"><input
					type="text" name="fujian" id="fujian" size="30" readonly="readonly" />
					<input type="button" value="上传" onclick="up()" /> <input
					type="hidden" name="fujianYuanshiming" id="fujianYuanshiming" /></td>
			</tr>
			<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<td width="15%" bgcolor="#FFFFFF" align="center">介绍：</td>
				<td width="85%" bgcolor="#FFFFFF" align="left"><FCK:editor
						instanceName="content" basePath="/fckeditor" width="500"
						height="200" value="请输入内容" toolbarSet="Basic">
					</FCK:editor></td>
			</tr>
			<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<td width="15%" bgcolor="#FFFFFF" align="center">发布时间：</td>
				<td width="85%" bgcolor="#FFFFFF" align="left"><input
					type="text" name="shijian" value="<%=new Date().toLocaleString()%>" />
				</td>
			</tr>
			<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<td width="25%" bgcolor="#FFFFFF" align="right">&nbsp;</td>
				<td width="75%" bgcolor="#FFFFFF" align="left"><input
					type="submit" value="提交" />&nbsp; <input type="reset" value="重置" />&nbsp;
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
