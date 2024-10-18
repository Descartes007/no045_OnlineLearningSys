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
import com.orm.Tdoc;

public class doc_servlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
		
		
		if(type.endsWith("docAdd"))
		{
			docAdd(req, res);
		}
		if(type.endsWith("docMana"))
		{
			docMana(req, res);
		}
		if(type.endsWith("docDel"))
		{
			docDel(req, res);
		}
		if(type.endsWith("docDetail"))
		{
			docDetail(req, res);
		}
		if(type.endsWith("docAll"))
		{
			docAll(req, res);
		}
		if(type.endsWith("docDetailQian"))
		{
			docDetailQian(req, res);
		}
		
	}
	
	
	public void docAdd(HttpServletRequest req,HttpServletResponse res)
	{
		String id=String.valueOf(new Date().getTime());
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		String fujian=req.getParameter("fujian");
		
		String fujianYuanshiming=req.getParameter("fujianYuanshiming");
		String shijian=req.getParameter("shijian");
		String del="no";
		
		String sql="insert into t_doc values(?,?,?,?,?,?,?)";
		Object[] params={id,title,content,fujian,fujianYuanshiming,shijian,del};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "doc?type=docMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
        
	}
	
	
	public void docDel(HttpServletRequest req,HttpServletResponse res)
	{
		String id=req.getParameter("id");
		
		String sql="delete from t_doc where id=?";
		Object[] params={id};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "doc?type=docMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	
	public void docDetail(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String id=req.getParameter("id");
		
		Tdoc doc=new Tdoc();
		String sql="select * from t_doc where id=?";
		Object[] params={id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			rs.next();
			doc.setId(rs.getString("id"));
			doc.setTitle(rs.getString("title"));
			doc.setContent(rs.getString("content"));
			doc.setFujian(rs.getString("fujian"));
			doc.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
			doc.setShijian(rs.getString("shijian"));
				
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("doc", doc);
		req.getRequestDispatcher("admin/doc/docDetail.jsp").forward(req, res);
	}
	
	
	public void docDetailQian(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String id=req.getParameter("id");
		
		Tdoc doc=new Tdoc();
		String sql="select * from t_doc where id=?";
		Object[] params={id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			rs.next();
			doc.setId(rs.getString("id"));
			doc.setTitle(rs.getString("title"));
			doc.setContent(rs.getString("content"));
			doc.setFujian(rs.getString("fujian"));
			doc.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
			doc.setShijian(rs.getString("shijian"));
				
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("doc", doc);
		req.getRequestDispatcher("qiantai/doc/docDetailQian.jsp").forward(req, res);
	}



	public void docMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List docList=new ArrayList();
		String sql="select * from t_doc where del='no'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tdoc doc=new Tdoc();
				
				doc.setId(rs.getString("id"));
				doc.setTitle(rs.getString("title"));
				doc.setContent(rs.getString("content"));
				doc.setFujian(rs.getString("fujian"));
				doc.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
				doc.setShijian(rs.getString("shijian"));
				
				docList.add(doc);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("docList", docList);
		req.getRequestDispatcher("admin/doc/docMana.jsp").forward(req, res);
	}
	
	
	public void docAll(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List docList=new ArrayList();
		String sql="select * from t_doc where del='no'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tdoc doc=new Tdoc();

				doc.setId(rs.getString("id"));
				doc.setTitle(rs.getString("title"));
				doc.setContent(rs.getString("content"));
				doc.setFujian(rs.getString("fujian"));
				doc.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
				doc.setShijian(rs.getString("shijian"));
				
				docList.add(doc);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("docList", docList);
		req.getRequestDispatcher("qiantai/doc/docAll.jsp").forward(req, res);
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
