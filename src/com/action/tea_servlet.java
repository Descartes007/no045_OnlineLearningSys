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
import com.orm.Ttea;

public class tea_servlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
		
		if(type.endsWith("teaMana"))
		{
			teaMana(req, res);
		}
		if(type.endsWith("teaAdd"))
		{
			teaAdd(req, res);
		}
		if(type.endsWith("teaDel"))
		{
			teaDel(req, res);
		}
	}
	
	
	public void teaAdd(HttpServletRequest req,HttpServletResponse res)
	{
		String bianhao=req.getParameter("bianhao");
		String name=req.getParameter("name");
		String sex=req.getParameter("sex");
		System.out.println(req.getParameter("age").trim());
		int age=Integer.parseInt(req.getParameter("age"));
		String del="no";
		String sql="insert into t_tea(bianhao,name,sex,age,del) values(?,?,?,?,?)";
		Object[] params={bianhao,name,sex,age,del};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "tea?type=teaMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	
	public void teaDel(HttpServletRequest req,HttpServletResponse res)
	{
		String sql="update t_tea set del='yes' where id="+Integer.parseInt(req.getParameter("id"));
		Object[] params={};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "tea?type=teaMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}

	public void teaMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List teaList=new ArrayList();
		String sql="select * from t_tea where del='no'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Ttea tea=new Ttea();
				tea.setId(rs.getInt("id"));
				tea.setBianhao(rs.getString("bianhao"));
				tea.setName(rs.getString("name"));
				tea.setSex(rs.getString("sex"));
				tea.setAge(rs.getInt("age"));
				teaList.add(tea);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("teaList", teaList);
		req.getRequestDispatcher("admin/tea/teaMana.jsp").forward(req, res);
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
