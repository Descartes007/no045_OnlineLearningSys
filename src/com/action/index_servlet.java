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
import com.orm.Tdoc;
import com.orm.Tgonggao;
import com.orm.Tuser;
import com.orm.Tzuoye;

public class index_servlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
		
		List gonggaoList=new ArrayList();
		String sql="select * from t_gonggao order by id desc";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tgonggao gonggao=new Tgonggao();
				
				gonggao.setId(rs.getString("id"));
				gonggao.setTitle(rs.getString("title"));
				gonggao.setContent(rs.getString("content"));
				gonggao.setShijian(rs.getString("shijian"));
				
				gonggaoList.add(gonggao);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		if(gonggaoList.size()>5)
		{
			gonggaoList=gonggaoList.subList(0, 5);
		}
		req.getSession().setAttribute("gonggaoList", gonggaoList);
		
		
		
		
		
		List zuoyeList=new ArrayList();
		String sql1111="select * from t_zuoye where del='no'";
		Object[] params1111={};
		DB mydb1111=new DB();
		try
		{
			mydb1111.doPstm(sql1111, params1111);
			ResultSet rs1111=mydb1111.getRs();
			while(rs1111.next())
			{
				Tzuoye zuoye=new Tzuoye();
				
				zuoye.setId(rs1111.getString("id"));
				zuoye.setMingcheng(rs1111.getString("mingcheng"));
				zuoye.setFujian(rs1111.getString("fujian"));
				zuoye.setFujianYuanshiming(rs1111.getString("fujianYuanshiming"));
				zuoye.setShijian(rs1111.getString("shijian"));
				zuoyeList.add(zuoye);
		    }
			rs1111.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("zuoyeList", zuoyeList);
		
		
		
		List docList=new ArrayList();
		String sql2222="select * from t_doc where del='no'";
		Object[] params2222={};
		DB mydb2222=new DB();
		try
		{
			mydb2222.doPstm(sql2222, params2222);
			ResultSet rs2222=mydb2222.getRs();
			while(rs2222.next())
			{
				Tdoc doc=new Tdoc();
				
				doc.setId(rs2222.getString("id"));
				doc.setTitle(rs2222.getString("title"));
				doc.setContent(rs2222.getString("content"));
				doc.setFujian(rs2222.getString("fujian"));
				doc.setFujianYuanshiming(rs2222.getString("fujianYuanshiming"));
				doc.setShijian(rs2222.getString("shijian"));
				
				docList.add(doc);
		    }
			rs2222.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("docList", docList);
		
		req.getRequestDispatcher("qiantai/index.jsp").forward(req, res);
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
