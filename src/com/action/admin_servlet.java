package com.action;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DB;
import com.orm.TAdmin;

public class admin_servlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
		
		if(type.endsWith("adminMana"))
		{
			adminMana(req, res);
		}
		if(type.endsWith("adminAdd"))
		{
			adminAdd(req, res);
		}
		if(type.endsWith("adminDel"))
		{
			adminDel(req, res);
		}
	}
	
	public void adminMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List adminList=new ArrayList();
		String sql="select * from t_admin";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				TAdmin admin=new TAdmin();
				admin.setUserId(rs.getInt("userId"));
				admin.setUserName(rs.getString("userName"));
				admin.setUserPw(rs.getString("userPw"));
				adminList.add(admin);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("adminList", adminList);
		req.getRequestDispatcher("admin/admin/adminMana.jsp").forward(req, res);
	}
	public void adminAdd(HttpServletRequest req,HttpServletResponse res)
	{
		String userName=req.getParameter("userName");
		String userPw=req.getParameter("userPw");
		String sql="insert into t_admin(userName,userPw) values(?,?)";
		Object[] params={userName,userPw};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "admin?type=adminMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	
	public void adminDel(HttpServletRequest req,HttpServletResponse res)
	{
		System.out.println(req.getParameter("userId")+"**");
		String sql="delete from t_admin where userId="+Integer.parseInt(req.getParameter("userId"));
		Object[] params={};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "admin?type=adminMana");
		
        String targetURL = "/common/success.jsp";
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
