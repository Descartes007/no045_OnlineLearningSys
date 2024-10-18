<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
         function admin()
         {
            var url="<%=path %>/login.jsp";
            window.open(url,"_blank");
         } 
         function zuoyeFabu()
         {
            <c:if test="${sessionScope.user==null}">
                  alert("请先登录");
            </c:if>
            <c:if test="${sessionScope.user!=null && sessionScope.user.type==2}">
                  alert("你是学生用户不能发布作业");
            </c:if>
            <c:if test="${sessionScope.user!=null && sessionScope.user.type==1}">
                  var url="<%=path %>/zuoye?type=zuoyeMana";
                  window.location.href=url;
            </c:if>
         }
         
         function zuoyeXiazai()
         {
            <c:if test="${sessionScope.user==null}">
                  alert("请先登录");
            </c:if>
            <c:if test="${sessionScope.user!=null && sessionScope.user.type==2}">
                  var url="<%=path %>/zuoye?type=zuoyeAll";
                  window.location.href=url;
            </c:if>
            <c:if test="${sessionScope.user!=null && sessionScope.user.type==1}">
                  var url="<%=path %>/zuoye?type=zuoyeAll";
                  window.location.href=url;
            </c:if>
         }
         
         function liuyanAll()
         {
            <c:if test="${sessionScope.user==null}">
                  alert("请先登录");
            </c:if>
            
            <c:if test="${sessionScope.user!=null}">
                var url="<%=path %>/liuyan?type=liuyanAll";
				var targetWinName="newWin";
				var features="width="+screen.width-200+" ,height="+screen.height-150+" ,toolbar=no, top=0, left=0, menubar=no, scrollbars=yes, resizable=no,location=no, status=no"
				var new_win=window.open(url,targetWinName,features);
            </c:if>
         } 
      </script>
  </head>
  
  <body>
       <A href="<%=path %>/qiantai/default.jsp">首 页</A> &nbsp;&nbsp;
       <a href="#" onclick="zuoyeFabu()">发布作业</A> &nbsp;&nbsp;
       <a href="#" onclick="zuoyeXiazai()">下载作业</A> &nbsp;&nbsp;
       <A href="<%=path %>/doc?type=docAll">资料下载</A> &nbsp;&nbsp;
       <A href="<%=path %>/catelog?type=catelogAll">视频学习</A> &nbsp;&nbsp;
       <A href="<%=path %>/timu?type=timuSuiji">在线自测</A> &nbsp;&nbsp;
       <a href="#" onclick="liuyanAll()">留言板</A> &nbsp;&nbsp;
	   <a href="#" onclick="admin()">后台管理</a> &nbsp;&nbsp;
  </body>
</html>
