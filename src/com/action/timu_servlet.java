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
import com.orm.Tjiandati;
import com.orm.Ttimu;
import com.service.liuService;

public class timu_servlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
		
		
		if(type.endsWith("timuAdd"))
		{
			timuAdd(req, res);
		}
		if(type.endsWith("timuMana"))
		{
			timuMana(req, res);
		}
		if(type.endsWith("timuDel"))
		{
			timuDel(req, res);
		}
		
		if(type.endsWith("timuSuiji"))
		{
			timuSuiji(req, res);
		}
		if(type.endsWith("timuSuiji_defen"))
		{
			timuSuiji_defen(req, res);
		}
		
	}
	
	
	public void timuAdd(HttpServletRequest req,HttpServletResponse res)
	{
		String name=req.getParameter("name");
		String xuanxianga=req.getParameter("xuanxianga");
		String xuanxiangb=req.getParameter("xuanxiangb");
		
		String xuanxiangc=req.getParameter("xuanxiangc");
		String xuanxiangd=req.getParameter("xuanxiangd");
		String daan=req.getParameter("daan");
		int fenshu=Integer.parseInt(req.getParameter("fenshu"));
		String del="no";
		
		String sql="insert into t_timu(name,xuanxianga,xuanxiangb,xuanxiangc,xuanxiangd,daan,fenshu,del) values(?,?,?,?,?,?,?,?)";
		Object[] params={name,xuanxianga,xuanxiangb,xuanxiangc,xuanxiangd,daan,fenshu,del};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "timu?type=timuMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
        
	}
	
	
	public void timuDel(HttpServletRequest req,HttpServletResponse res)
	{
		int id=Integer.parseInt(req.getParameter("id"));
		
		String sql="update t_timu set del='yes' where id=?";
		Object[] params={id};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "timu?type=timuMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	

	public void timuMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List timuList=new ArrayList();
		String sql="select * from t_timu where del='no'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Ttimu timu=new Ttimu();
				
				timu.setId(rs.getInt("id"));
				timu.setName(rs.getString("name"));
				timu.setXuanxianga(rs.getString("xuanxianga"));
				timu.setXuanxiangb(rs.getString("xuanxiangb"));
				
				timu.setXuanxiangc(rs.getString("xuanxiangc"));
				timu.setXuanxiangd(rs.getString("xuanxiangd"));
				timu.setDaan(rs.getString("daan"));
				timu.setFenshu(rs.getInt("fenshu"));
				
				
				timuList.add(timu);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("timuList", timuList);
		req.getRequestDispatcher("admin/timu/timuMana.jsp").forward(req, res);
	}
	
	public void timuSuiji(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
        List<Integer> timu_idList=liuService.getAllTimuId();;
		
		int[] timu_id=liuService.Random(timu_idList, 3);//随机抽取不同的3个题目的id
		
		List timuList=new ArrayList();
		for(int i=0;i<timu_id.length;i++)
		{
			timuList.add(liuService.getTimuById(timu_id[i]));
		}
		
		
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
		req.getSession().setAttribute("timuList", timuList);
		req.getRequestDispatcher("qiantai/timu/timuSuiji.jsp").forward(req, res);
	}
	
	
	public void timuSuiji_defen(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
        int fenshu=0;
		
		List timuList=(List)req.getSession().getAttribute("timuList");
		for(int i=0;i<timuList.size();i++)
		{
			Ttimu timu=(Ttimu)timuList.get(i);
			String timuDaan=timu.getDaan();
			String timuDaan_user=req.getParameter(String.valueOf(timu.getId()));
			if(timuDaan.equalsIgnoreCase(timuDaan_user))
			{
				fenshu+=timu.getFenshu();
			}
		}
		
		req.setAttribute("message", "本次单选题得分："+fenshu);
		req.getRequestDispatcher("qiantai/timu/timuSuiji_defen.jsp").forward(req, res);
		
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
