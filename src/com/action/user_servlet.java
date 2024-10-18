package com.action;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DB;
import com.orm.TAdmin;
import com.orm.Tuser;
import com.service.liuService;

public class user_servlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
		
		
		if(type.endsWith("userReg"))
		{
			userReg(req, res);
		}
		if(type.endsWith("userLogout"))
		{
			userLogout(req, res);
		}
	}
	
	
	public void userReg(HttpServletRequest req,HttpServletResponse res)
	{
		int type=Integer.parseInt(req.getParameter("type1"));
		String xuehao_jiaoshihao=req.getParameter("xuehao_jiaoshihao");
		String id=String.valueOf(new Date().getTime());
		String loginname=req.getParameter("loginname");
		String loginpw=req.getParameter("loginpw");
		
		if(type==1)
		{
			if(liuService.getTeabyjiaoshihao(xuehao_jiaoshihao)==false)
			{
				req.setAttribute("msg", "输入的教师号不正确。没有此老师");
			}
			if(liuService.getTeabyjiaoshihao(xuehao_jiaoshihao)==true)
			{
				String sql="insert into t_user values(?,?,?,?,?)";
				Object[] params={id,loginname,loginpw,xuehao_jiaoshihao,1};
				DB mydb=new DB();
				mydb.doPstm(sql, params);
				mydb.closed();
				req.setAttribute("msg", "注册成功,你的用户名是："+loginname+"&nbsp;&nbsp;&nbsp;&nbsp;密码是："+loginpw);
			}
		}
		if(type==2)
		{
			if(liuService.getStubyxuehao(xuehao_jiaoshihao)==false)
			{
				req.setAttribute("msg", "输入的学号不正确。没有此学生");
			}
			if(liuService.getStubyxuehao(xuehao_jiaoshihao)==true)
			{
				String sql="insert into t_user values(?,?,?,?,?)";
				Object[] params={id,loginname,loginpw,xuehao_jiaoshihao,2};
				DB mydb=new DB();
				mydb.doPstm(sql, params);
				mydb.closed();
				
				req.setAttribute("msg", "注册成功,你的用户名是："+loginname+"&nbsp;&nbsp;&nbsp;&nbsp;密码是："+loginpw);
			}
		}
		
		
		
        String targetURL = "/common/add_success.jsp";
		dispatch(targetURL, req, res);
	}
	
	
	
	public void userLogout(HttpServletRequest req,HttpServletResponse res)
	{
		req.getSession().setAttribute("user", null);
		String targetURL = "/qiantai/default.jsp";
		dispatch(targetURL, req, res);		
	}
	
	public void dispatch(String targetURI,HttpServletRequest request,HttpServletResponse response) 
	{
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(targetURI);
		try 
		{
		    dispatch.forward(request, response);
		    return;
		} 
		catch (ServletException e) 
		{
                    e.printStackTrace();
		} 
		catch (IOException e) 
		{
			
		    e.printStackTrace();
		}
	}
	public void init(ServletConfig config) throws ServletException 
	{
		super.init(config);
	}
	
	public void destroy() 
	{
		
	}
}
