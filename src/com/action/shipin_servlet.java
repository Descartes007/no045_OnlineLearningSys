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
import com.orm.Tshipin;
import com.service.liuService;

public class shipin_servlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
		
		
		if(type.endsWith("shipinAdd"))
		{
			shipinAdd(req, res);
		}
		if(type.endsWith("shipinMana"))
		{
			shipinMana(req, res);
		}
		if(type.endsWith("shipinDel"))
		{
			shipinDel(req, res);
		}
		if(type.endsWith("shipinDetail"))
		{
			shipinDetail(req, res);
		}
		if(type.endsWith("shipinAll"))
		{
			shipinAll(req, res);
		}
		if(type.endsWith("shipinDetailQian"))
		{
			shipinDetailQian(req, res);
		}
		
	}
	
	
	public void shipinAdd(HttpServletRequest req,HttpServletResponse res)
	{
		String id=String.valueOf(new Date().getTime());
		String title=req.getParameter("title");
		int catelog_id = Integer.parseInt(req.getParameter("catelog_id"));
		String content=req.getParameter("content");
		String fujian=req.getParameter("fujian");
		
		String fujianYuanshiming=req.getParameter("fujianYuanshiming");
		String shijian=req.getParameter("shijian");
		String del="no";
		
		String sql="insert into t_shipin values(?,?,?,?,?,?,?,?)";
		Object[] params={id,title,catelog_id,content,fujian,fujianYuanshiming,shijian,del};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "shipin?type=shipinMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
        
	}
	
	
	public void shipinDel(HttpServletRequest req,HttpServletResponse res)
	{
		String id=req.getParameter("id");
		
		String sql="delete from t_shipin where id=?";
		Object[] params={id};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "shipin?type=shipinMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	
	public void shipinDetail(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String id=req.getParameter("id");
		
		Tshipin shipin=new Tshipin();
		String sql="select * from t_shipin where id=?";
		Object[] params={id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			rs.next();
			shipin.setId(rs.getString("id"));
			shipin.setTitle(rs.getString("title"));
			shipin.setCatelog_id(rs.getInt("catelog_id"));
			shipin.setCatelog_name(liuService.getCatelogName(rs.getInt("catelog_id")));
			shipin.setContent(rs.getString("content"));
			shipin.setFujian(rs.getString("fujian"));
			shipin.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
			shipin.setShijian(rs.getString("shijian"));
				
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("shipin", shipin);
		req.getRequestDispatcher("admin/shipin/shipinDetail.jsp").forward(req, res);
	}
	
	
	public void shipinDetailQian(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String id=req.getParameter("id");
		
		Tshipin shipin=new Tshipin();
		String sql="select * from t_shipin where id=?";
		Object[] params={id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			rs.next();
			shipin.setId(rs.getString("id"));
			shipin.setTitle(rs.getString("title"));
			shipin.setCatelog_id(rs.getInt("catelog_id"));
			shipin.setCatelog_name(liuService.getCatelogName(rs.getInt("catelog_id")));
			shipin.setContent(rs.getString("content"));
			shipin.setFujian(rs.getString("fujian"));
			shipin.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
			shipin.setShijian(rs.getString("shijian"));
				
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("shipin", shipin);
		req.getRequestDispatcher("qiantai/shipin/shipinDetailQian.jsp").forward(req, res);
	}



	public void shipinMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List shipinList=new ArrayList();
		String sql="select * from t_shipin where del='no'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tshipin shipin=new Tshipin();
				
				shipin.setId(rs.getString("id"));
				shipin.setTitle(rs.getString("title"));
				shipin.setCatelog_id(rs.getInt("catelog_id"));
				shipin.setCatelog_name(liuService.getCatelogName(rs.getInt("catelog_id")));
				shipin.setContent(rs.getString("content"));
				shipin.setFujian(rs.getString("fujian"));
				shipin.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
				shipin.setShijian(rs.getString("shijian"));
				
				shipinList.add(shipin);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("shipinList", shipinList);
		req.getRequestDispatcher("admin/shipin/shipinMana.jsp").forward(req, res);
	}
	
	
	public void shipinAll(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List shipinList=new ArrayList();
		int catelog_id = Integer.parseInt(req.getParameter("catelog_id"));
		String sql="select * from t_shipin where catelog_id = ? and del='no'";
		String catelog_name = liuService.getCatelogName(catelog_id);
		Object[] params={catelog_id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tshipin shipin=new Tshipin();
				shipin.setId(rs.getString("id"));
				shipin.setTitle(rs.getString("title"));
				shipin.setCatelog_id(rs.getInt("catelog_id"));
				catelog_name = liuService.getCatelogName(rs.getInt("catelog_id"));
				shipin.setCatelog_name(liuService.getCatelogName(rs.getInt("catelog_id")));
				shipin.setContent(rs.getString("content"));
				shipin.setFujian(rs.getString("fujian"));
				shipin.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
				shipin.setShijian(rs.getString("shijian"));
				shipinList.add(shipin);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("shipinList", shipinList);
		req.setAttribute("catelog_name", catelog_name);
		req.getRequestDispatcher("qiantai/shipin/shipinAll.jsp").forward(req, res);
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
