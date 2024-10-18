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
import com.orm.Tkecheng;
import com.service.liuService;

public class kecheng_servlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
		
		if(type.endsWith("kechengMana"))
		{
			kechengMana(req, res);
		}
		if(type.endsWith("kechengAdd"))
		{
			kechengAdd(req, res);
		}
		if(type.endsWith("kechengDel"))
		{
			kechengDel(req, res);
		}
		
		if(type.endsWith("kechengAll"))
		{
			kechengAll(req, res);
		}
		if(type.endsWith("kechengByStu"))
		{
			kechengByStu(req, res);
		}
	}
	
	
	public void kechengAdd(HttpServletRequest req,HttpServletResponse res)
	{
		String name=req.getParameter("name");
		String jieshao=req.getParameter("jieshao");
		String del="no";
		String sql="insert into t_kecheng(name,jieshao,del) values(?,?,?)";
		Object[] params={name,jieshao,del};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "kecheng?type=kechengMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	
	public void kechengDel(HttpServletRequest req,HttpServletResponse res)
	{
		String sql="update t_kecheng set del='yes' where id="+Integer.parseInt(req.getParameter("id"));
		Object[] params={};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "kecheng?type=kechengMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}

	public void kechengMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List kechengList=new ArrayList();
		String sql="select * from t_kecheng where del='no'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tkecheng kecheng=new Tkecheng();
				kecheng.setId(rs.getInt("id"));
				kecheng.setName(rs.getString("name"));
				kecheng.setJieshao(rs.getString("jieshao"));
				kechengList.add(kecheng);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("kechengList", kechengList);
		req.getRequestDispatcher("admin/kecheng/kechengMana.jsp").forward(req, res);
	}
	
	
	public void kechengAll(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List kechengList=new ArrayList();
		String sql="select * from t_kecheng where del='no'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tkecheng kecheng=new Tkecheng();
				kecheng.setId(rs.getInt("id"));
				kecheng.setName(rs.getString("name"));
				kecheng.setJieshao(rs.getString("jieshao"));
				kechengList.add(kecheng);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("kechengList", kechengList);
		req.setAttribute("stu_id", req.getParameter("stu_id"));
		req.getRequestDispatcher("admin/stu_xuanke/kechengAll.jsp").forward(req, res);
	}
	
	public void kechengByStu(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		int stu_id=Integer.parseInt(req.getParameter("stu_id"));
		
		List kechengList=new ArrayList();
		
		String sql="select * from t_stu_kecheng where stu_id=?";
		Object[] params={stu_id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tkecheng kecheng=new Tkecheng();
				kecheng.setId(rs.getInt("kecheng_id"));
				kecheng.setName(liuService.getKechengName(rs.getInt("kecheng_id")));
				kechengList.add(kecheng);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		System.out.println(kechengList.size());
		req.setAttribute("kechengList", kechengList);
		req.setAttribute("stu_id", stu_id);
		req.getRequestDispatcher("admin/stu_xuanke/kechengByStu.jsp").forward(req, res);
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
