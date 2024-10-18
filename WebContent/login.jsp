<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	    <style type="text/css">
		body {
			margin-left: 0px;
			margin-top: 0px;
			margin-right: 0px;
			margin-bottom: 0px;
			background-color: #1D3647;
		}
		.login_top_bg {background-image: url(<%=path %>/img/login-top-bg.gif);background-repeat: repeat-x;}
		.body {
			background-color: #EEF2FB;
			left: 0px;
			top: 0px;
			right: 0px;
			bottom: 0px;
		}
		
		.login-buttom-bg {
			background-image: url(<%=path %>/img/login-buttom-bg.gif);
			background-repeat: repeat-x;
		}
		.login-buttom-txt {
			font-family: Arial, Helvetica, sans-serif;
			font-size: 10px;
			color: #ABCAD3;
			text-decoration: none;
			line-height: 20px;
		}
		.login_txt {
			font-family: Arial, Helvetica, sans-serif;
			font-size: 12px;
			line-height: 25px;
			color: #333333;
		}
		.Submit {
			font-family: Arial, Helvetica, sans-serif;
			font-size: 12px;
			color: #629DAE;
			text-decoration: none;
			background-image: url(<%=path %>/img/Submit_bg.gif);
			background-repeat: repeat-x;
		}
		.login_bg {
			background-image: url(<%=path %>/img/login_bg.jpg);
			background-repeat: repeat-x;
		}
		.login_bg2 {
			background-image: url(<%=path %>/img/login-content-bg.gif);
			background-repeat: no-repeat;
			background-position: right;
		}
		
		.admin_txt {
			font-family: Arial, Helvetica, sans-serif;
			font-size: 12px;
			color: #FFFFFF;
			text-decoration: none;
			height: 38px;
			width: 100%;
			position: 固定;
			line-height: 38px;
		}
		.login_txt_bt {
			font-family: Arial, Helvetica, sans-serif;
			font-size: 18px;
			line-height: 25px;
			color: #666666;
			font-weight: bold;
		}
		.admin_topbg {
			background-image: url(<%=path %>/img/top-right.gif);
			background-repeat: repeat-x;
		}
		.txt_bt {
			font-family: Arial, Helvetica, sans-serif;
			font-size: 12px;
			line-height: 25px;
			font-weight: bold;
			color: #000000;
			text-decoration: none;
		}
		.left_topbg {
			background-image: url(<%=path %>/img/content-bg.gif);
			background-repeat: repeat-x;
		}
		.admin_toptxt {
			font-family: Arial, Helvetica, sans-serif;
			font-size: 12px;
			color: #4A8091;
			height: 18px;
			width: 100%;
			overflow: hidden;
			position: 固定;
		}
		
		.left_bt {
			font-family: Arial, Helvetica, sans-serif;
			font-size: 14px;
			font-weight: bold;
			color: #395a7b;
		}
		.left_bt2 {
			font-family: Arial, Helvetica, sans-serif;
			font-size: 12px;
			line-height: 25px;
			font-weight: bold;
			color: #333333;
		}
		.titlebt {
			font-size: 12px;
			line-height: 26px;
			font-weight: bold;
			color: #000000;
			background-image: url(<%=path %>/img/top_bt.jpg);
			background-repeat: no-repeat;
			display: block;
			text-indent: 15px;
			padding-top: 5px;
		}
		
		.left_txt {
			font-family: Arial, Helvetica, sans-serif;
			font-size: 12px;
			line-height: 25px;
			color: #666666;
		}
		.left_txt2 {
			font-family: Arial, Helvetica, sans-serif;
			font-size: 12px;
			line-height: 25px;
			color: #000000;
		}
		.nowtable {
			background-color: #e1e5ee;
			border-top-width: 1px;
			border-right-width: 1px;
			border-bottom-width: 1px;
			border-left-width: 1px;
			border-top-style: solid;
			border-top-color: #bfc4ca;
			border-right-color: #bfc4ca;
			border-bottom-color: #bfc4ca;
			border-left-color: #bfc4ca;
		}
		.left_txt3 {
			font-family: Arial, Helvetica, sans-serif;
			font-size: 12px;
			line-height: 25px;
			color: #003366;
			text-decoration: none;
		}
	
	
	
		.left_ts {
			font-family: Arial, Helvetica, sans-serif;
			font-size: 12px;
			line-height: 25px;
			font-weight: bold;
			color: #FF6600;
		}
		.line_table {
			border: 1px solid #CCCCCC;
		}
		.sec1 {
			CURSOR: hand;
			COLOR: #000000;
			font-family: Arial, Helvetica, sans-serif;
			font-size: 12px;
			line-height: 25px;
			border: 1px solid #B5D0D9;
			background-image: url(<%=path %>/img/right_smbg.jpg);
			background-repeat: repeat-x;
		}
		.sec2 {
			FONT-WEIGHT: bold;
			CURSOR: hand;
			COLOR: #000000;
			font-family: Arial, Helvetica, sans-serif;
			font-size: 12px;
			line-height: 25px;
			background-color: #e2e7ed;
			border: 1px solid #e2e7ed;
		}
		.main_tab {
			COLOR: #000000;
			BACKGROUND-COLOR: #e2e7ed;
			border: 1px solid #e2e7ed;
		}
		.MM a {
			font-family: Arial, Helvetica, sans-serif;
			font-size: 12px;
			line-height: 26px;
			color: #666666;
			background-image: url(<%=path %>/img/menu_bg.gif);
			background-repeat: no-repeat;
			list-style-type: none;
			list-style-image: none;
		}
		a:link {
			font-size: 12px;
			line-height: 25px;
			color: #333333;
			text-decoration: none;
		}
		a:hover {
			font-size: 12px;
			line-height: 25px;
			color: #666666;
			text-decoration: none;
		}
		a:visited {
			font-size: 12px;
			line-height: 25px;
			color: #333333;
			text-decoration: none;
		}
	
	
		.MM a:link {
			font-family: Arial, Helvetica, sans-serif;
			font-size: 12px;
			line-height: 26px;
			color: #666666;
			background-image: url(<%=path %>/img/menu_bg.gif);
			background-repeat: no-repeat;
			list-style-type: none;
			list-style-image: none;
		}
		</style>
		<script type='text/javascript' src='<%=path %>/dwr/interface/loginService.js'></script>
        <script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
        <script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
        
		<script language="javascript">
		function check1()
		{                                                                                         
		     if(document.ThisForm.userName.value=="")
			 {
			 	alert("请输入用户名");
				document.ThisForm.userName.focus();
				return false;
			 }
			 if(document.ThisForm.userPw.value=="")
			 {
			 	alert("请输入密码");
				document.ThisForm.userPw.focus();
				return false;
			 }
			 document.getElementById("indicator").style.display="block";
			 loginService.login(document.ThisForm.userName.value,document.ThisForm.userPw.value,0,callback);
		}
		
		function callback(data)
		{
		    document.getElementById("indicator").style.display="none";
		    if(data=="no")
		    {
		        alert("用户名或密码错误");
		    }
		    if(data=="yes")
		    {
		        alert("通过验证,系统登录成功");
		        window.location.href="<%=path %>/loginSuccess.jsp";
		    }
		    
		}
	    </script>
</head>
<body>
<table width="100%" height="166" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="42" valign="top">
       <table width="100%" height="42" border="0" cellpadding="0" cellspacing="0" class="login_top_bg">
	      <tr>
	        <td width="1%" height="21">&nbsp;</td>
	        <td height="42">&nbsp;</td>
	        <td width="17%">&nbsp;</td>
	      </tr>
       </table>
    </td>
  </tr>
  <tr>
    <td valign="top">
     <table width="100%" height="532" border="0" cellpadding="0" cellspacing="0" class="login_bg">
      <tr>
        <td width="49%" align="right"><table width="91%" height="532" border="0" cellpadding="0" cellspacing="0" class="login_bg2">
            <tr>
              <td height="138" valign="top"><table width="89%" height="427" border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td height="149">&nbsp;</td>
                </tr>
                <tr>
                  <td height="80" align="right" valign="top"></td>
                </tr>
                <tr>
                  <td height="198" align="right" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="35%">&nbsp;</td>
                      <td height="25" colspan="2" class="left_txt"></td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td height="25" colspan="2" class="left_txt"></td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td height="25" colspan="2" class="left_txt"></td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td width="30%" height="40"></td>
                      <td width="35%"></td>
                    </tr>
                  </table></td>
                </tr>
              </table></td>
            </tr>
            
        </table></td>
        <td width="1%" >&nbsp;</td>
        <td width="50%" valign="bottom"><table width="100%" height="59" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
              <td width="4%">&nbsp;</td>
              <td width="96%" height="38"><span class="login_txt_bt">JAVA在线学习系统</span></td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td height="21"><table cellSpacing="0" cellPadding="0" width="100%" border="0" id="table211" height="328">
                  <tr>
                    <td height="164" colspan="2" align="middle">
                        <FORM name="ThisForm" action="<%=path %>/adminLogin.action" method=post>
                        <table cellSpacing="0" cellPadding="0" width="100%" border="0" height="143" id="table212">
                          <tr>
                            <td width="13%" height="38" class="top_hui_text"><span class="login_txt">用户名：&nbsp;&nbsp; </span></td>
                            <td height="38" colspan="2" class="top_hui_text"><input name="userName" class="editbox4" value="" size="20">                            </td>
                          </tr>
                          <tr>
                            <td width="13%" height="35" class="top_hui_text"><span class="login_txt"> 密 码： &nbsp;&nbsp; </span></td>
                            <td height="35" colspan="2" class="top_hui_text"><input class="editbox4" type="password" size="20" name="userPw">
                              <img src="<%=path %>/img/luck.gif" width="19" height="18"> </td>
                          </tr>
                          <tr>
                            <td height="35" >&nbsp;</td>
                            <td width="20%" height="35" >
                                <input name="button" type="button" class="button" id="Submit" value="登 陆" onClick="check1()"> 
                                <img id="indicator" src="<%=path %>/img/loading.gif" style="display:none"/>
                            </td>
                            <td width="67%" class="top_hui_text"><input name="cs" type="reset" class="button" id="cs" value="重 置"></td>
                          </tr>
                        </table>
                        <br>
                    </form></td>
                  </tr>
                  <tr>
                    <td width="433" height="164" align="right" valign="bottom"><img src="<%=path %>/img/login-wel.gif" width="242" height="138"></td>
                    <td width="57" align="right" valign="bottom">&nbsp;</td>
                  </tr>
              </table></td>
            </tr>
          </table>
          </td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>