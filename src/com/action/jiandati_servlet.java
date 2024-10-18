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
import com.orm.Tgonggao;
import com.orm.Tjiandati;
import com.orm.Tuser;

public class jiandati_servlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
		
		
		if(type.endsWith("jiandatiAdd"))
		{
			jiandatiAdd(req, res);
		}
		if(type.endsWith("jiandatiMana"))
		{
			jiandatiMana(req, res);
		}
		if(type.endsWith("jiandatiDel"))
		{
			jiandatiDel(req, res);
		}
	}
	
	
	public void jiandatiAdd(HttpServletRequest req,HttpServletResponse res)
	{
		String name=req.getParameter("name");
		String daan=req.getParameter("daan");
		String del="no";
		
		String sql="insert into t_jiandati(name,daan,del) values(?,?,?)";
		Object[] params={name,daan,del};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "jiandati?type=jiandatiMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
        
	}
	
	
	public void jiandatiDel(HttpServletRequest req,HttpServletResponse res)
	{
		String sql="update t_jiandati set del='no' where id=?";
		Object[] params={Integer.parseInt(req.getParameter("id"))};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "jiandati?type=jiandatiMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}

	public void jiandatiMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List jiandatiList=new ArrayList();
		String sql="select * from t_jiandati where del='no'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tjiandati jiandati=new Tjiandati();
				
				jiandati.setId(rs.getInt("id"));
				jiandati.setName(rs.getString("name"));
				jiandati.setDaan(rs.getString("daan"));
				jiandati.setDel(rs.getString("del"));
				
				jiandatiList.add(jiandati);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		req.setAttribute("jiandatiList", jiandatiList);
		req.getRequestDispatcher("admin/jiandati/jiandatiMana.jsp").forward(req, res);
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
