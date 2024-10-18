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
import com.orm.Tzuoye;

public class zuoye_servlet  extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
		
		
		if(type.endsWith("zuoyeAdd"))
		{
			zuoyeAdd(req, res);
		}
		if(type.endsWith("zuoyeMana"))
		{
			zuoyeMana(req, res);
		}
		if(type.endsWith("zuoyeDel"))
		{
			zuoyeDel(req, res);
		}
		if(type.endsWith("zuoyeAll"))
		{
			zuoyeAll(req, res);
		}
	}
	
	
	public void zuoyeAdd(HttpServletRequest req,HttpServletResponse res)
	{
		String id=String.valueOf(new Date().getTime());
		String mingcheng=req.getParameter("mingcheng");
		String fujian=req.getParameter("fujian");
		String fujianYuanshiming=req.getParameter("fujianYuanshiming");
		
		String shijian=new Date().toLocaleString();
		String del="no";
		
		String sql="insert into t_zuoye values(?,?,?,?,?,?)";
		Object[] params={id,mingcheng,fujian,fujianYuanshiming,shijian,del};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "zuoye?type=zuoyeMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
        
	}
	
	
	public void zuoyeDel(HttpServletRequest req,HttpServletResponse res)
	{
		String id=req.getParameter("id");
		
		String sql="update t_zuoye set del='no' where id=?";
		Object[] params={id};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "zuoye?type=zuoyeMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}

	public void zuoyeMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List zuoyeList=new ArrayList();
		String sql="select * from t_zuoye where del='no'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tzuoye zuoye=new Tzuoye();
				
				zuoye.setId(rs.getString("id"));
				zuoye.setMingcheng(rs.getString("mingcheng"));
				zuoye.setFujian(rs.getString("fujian"));
				zuoye.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
				zuoye.setShijian(rs.getString("shijian"));
				zuoyeList.add(zuoye);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("zuoyeList", zuoyeList);
		req.getRequestDispatcher("qiantai/zuoye/zuoyeMana.jsp").forward(req, res);
	}
	
	
	public void zuoyeAll(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List zuoyeList=new ArrayList();
		String sql="select * from t_zuoye where del='no'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tzuoye zuoye=new Tzuoye();
				
				zuoye.setId(rs.getString("id"));
				zuoye.setMingcheng(rs.getString("mingcheng"));
				zuoye.setFujian(rs.getString("fujian"));
				zuoye.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
				zuoye.setShijian(rs.getString("shijian"));
				zuoyeList.add(zuoye);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("zuoyeList", zuoyeList);
		req.getRequestDispatcher("qiantai/zuoye/zuoyeAll.jsp").forward(req, res);
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
