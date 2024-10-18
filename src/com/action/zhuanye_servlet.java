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
import com.orm.Tzhuanye;

public class zhuanye_servlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
		
		if(type.endsWith("zhuanyeMana"))
		{
			zhuanyeMana(req, res);
		}
		if(type.endsWith("zhuanyeAdd"))
		{
			zhuanyeAdd(req, res);
		}
		if(type.endsWith("zhuanyeDel"))
		{
			zhuanyeDel(req, res);
		}
	}
	
	
	public void zhuanyeAdd(HttpServletRequest req,HttpServletResponse res)
	{
		String name=req.getParameter("name");
		String jieshao=req.getParameter("jieshao");
		String del="no";
		String sql="insert into t_zhuanye(name,jieshao,del) values(?,?,?)";
		Object[] params={name,jieshao,del};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "zhuanye?type=zhuanyeMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	
	public void zhuanyeDel(HttpServletRequest req,HttpServletResponse res)
	{
		String sql="update t_zhuanye set del='yes' where id="+Integer.parseInt(req.getParameter("id"));
		Object[] params={};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "zhuanye?type=zhuanyeMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}

	public void zhuanyeMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List zhuanyeList=new ArrayList();
		String sql="select * from t_zhuanye where del='no'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tzhuanye zhuanye=new Tzhuanye();
				zhuanye.setId(rs.getInt("id"));
				zhuanye.setName(rs.getString("name"));
				zhuanye.setJieshao(rs.getString("jieshao"));
				zhuanyeList.add(zhuanye);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("zhuanyeList", zhuanyeList);
		req.getRequestDispatcher("admin/zhuanye/zhuanyeMana.jsp").forward(req, res);
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
