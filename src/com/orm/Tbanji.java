package com.orm;

public class Tbanji
{
	private int id;
	private String name;
	private int zhuanye_id;
	private String del;
	
	private String zhuanye_name;
	public String getDel()
	{
		return del;
	}
	public void setDel(String del)
	{
		this.del = del;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	
	public int getZhuanye_id()
	{
		return zhuanye_id;
	}
	public void setZhuanye_id(int zhuanye_id)
	{
		this.zhuanye_id = zhuanye_id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getZhuanye_name()
	{
		return zhuanye_name;
	}
	public void setZhuanye_name(String zhuanye_name)
	{
		this.zhuanye_name = zhuanye_name;
	}

}
