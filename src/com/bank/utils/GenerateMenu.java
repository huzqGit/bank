package com.bank.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateMenu {
	private List<Map<Object, Object>> list;

	public GenerateMenu(List<Map<Object, Object>> list) {
		this.list = list;
	}

	// StringBuffer sb=new
	// StringBuffer("<ul id=\"the_tree\" class=\"easyui-tree\" animate=\"true\" dnd=\"false\">");
	StringBuffer sb = new StringBuffer(); 
	
	private String rootId="";
	public static Map<String, String> cacheMap=new HashMap<String, String>();
	
	
	/**
	 * select t.*, (select count(node_id) from risk.t_menu where p_id=t.node_id) as isleaf  from risk.t_menu t order by seq
	 * @return
	 */
	public String getDirectoryMenu()
	{
		sb=new StringBuffer("\n<ul id=\"the_tree\" class=\"easyui-tree\" animate=\"true\" dnd=\"false\">\n");
		for (Map<Object, Object> map : list) {
			if("-1".equals(map.get("p_id").toString()))
			{
				sb.append("<li>\n<span><a href='javascript:void(0)' onclick=\"linkurl(this,'").append(map.get("node_id")).append("')\">").append(map.get("node_name")).append("</a>\n</span>\n<ul>");
				loopDirectoryMenu(map.get("node_id").toString());
				sb.append("</ul>\n</li>\n");
				break;
			}
		}
		sb.append("</ul>");
		return sb.toString();
	}
	public void loopDirectoryMenu(String parentId)
	{
		boolean isFirst = true;
		int subListSize=0;
		boolean isSubMenu="1".equals(parentId);
		for (Map<Object, Object> map : list) {
			if(parentId.equals(map.get("p_id").toString()))
			{
				if("0".equals(map.get("isleaf").toString()))
				{
					if(isFirst&&!isSubMenu)
						sb.append("<ul>\n<li>\n<span><a href='javascript:void(0)' onclick=\"linkurl(this,'").append(map.get("node_id")).append("')\">").append(map.get("node_name")).append("</a>\n</span></li>");
					else if(isFirst&&isSubMenu)
						sb.append("<li>\n<span><a href='javascript:void(0)' onclick=\"linkurl(this,'").append(map.get("node_id")).append("')\">").append(map.get("node_name")).append("</a>\n</span></li>");
					else
						sb.append("<li>\n<span><a href='javascript:void(0)' onclick=\"linkurl(this,'").append(map.get("node_id")).append("')\">").append(map.get("node_name")).append("</a>\n</span></li>");
					isFirst=false;
				}
				else
				{
					if(!isSubMenu&&isFirst)
					{
						sb.append("<ul>\n<li>\n<span><a href='javascript:void(0)' onclick=\"linkurl(this,'").append(map.get("node_id")).append("')\">").append(map.get("node_name")).append("</a>\n</span>");
					}
					else if(isFirst&&isSubMenu)
					{
						sb.append("<li>\n<span><a href='javascript:void(0)' onclick=\"linkurl(this,'").append(map.get("node_id")).append("')\">").append(map.get("node_name")).append("</a>\n</span>");
					}
					else
						sb.append("<li>\n<span><a href='javascript:void(0)' onclick=\"linkurl(this,'").append(map.get("node_id")).append("')\">").append(map.get("node_name")).append("</a>\n</span>");
						//sb.append("<li><span ><div onclick=\"linkurl('").append(map.get("node_id")).append("')\">").append(map.get("node_name")).append(" </div>\n</span>");
					isFirst=false;
					loopDirectoryMenu(map.get("node_id").toString());
				}
			}
		}
		if(!isSubMenu)
			sb.append("</ul>");
		sb.append("</li>");
	}
	
	public String getMenu() {
		sb.delete(0, sb.length());
		sb.append("<div class=\"accMain\">\n<div class=\"arrowlistmenu\">\n");
		if(list==null){
			return "noAuthority";
		}
		for (Map<Object, Object> map : list) {
			// 只从根节点开始进入循环
			if ("0".equals(map.get("ISLEAF").toString())
					&& "0".equals(map.get("PARENTID").toString())) {
				// System.out.println(map.get("MENUID").toString());
				// sb.append("<li><span>").append(
				// map.get("MENUNAME").toString()).append("\n</span>");
				 rootId = map.get("MENUID").toString();
				 if(cacheMap.get(rootId)==null)
				 {
					 newLoopMenu(map.get("MENUID").toString(), true);
				 }
				 else
				 {
					 return cacheMap.get(rootId);
				 }
				break;
			}
		}
		sb.append("\n</div>\n</div>\n");
		//cacheMap.put(rootId, sb.toString());
		//System.out.println("生成的菜单："+cacheMap.get(rootId));
		return sb.toString();
	}
	int i=0;
	public void newLoopMenu(String parentId, boolean isSubMenu1) {
		boolean isSubMenu = false;
		boolean isFirst = true;
		int listSize=0;
		for (Map<Object, Object> map : list) {
			if (parentId.equals(map.get("PARENTID").toString())) {
				String needcount = "";
				if ("0".equals(map.get("ISLEAF").toString())) {
					if(map.get("ISCOUNT")!=null&&map.get("ISCOUNT").equals("1")){
						needcount 	= "needcount='"+map.get("MENUID")+"'";
					}
					//System.out.println("rootId:"+rootId+"parentid:"+map.get("PARENTID")+"boolean:"+rootId.equals(String.valueOf(map.get("PARENTID"))));
					isSubMenu = rootId.equals(String.valueOf(map.get("PARENTID")));
					//根节点的第一级节点
					if (isSubMenu) {
						i++;
						sb
						.append(
								"<div class=\"menuheader expandable\">\n<span class=\"main_left_expand\"></span>\n")
								.append("<span><a href=\"javascript:void(0)\" "+needcount+" onclick=\"linkurl(")
								.append("'" + map.get("ISLEAF") + "'").append(",")
								.append("'" + map.get("MODULEID") + "'")
								.append(",")
								.append("'" + map.get("MENUNAME") + "'").append(")\" menuid='"+map.get("MENUID").toString()+"'>")
							    .append(map.get("MENUNAME").toString())
							    .append("</a></span>\n")
							    .append(
								"</div>\n");
						sb.append("<ul class=\"categoryitems\">\n");
						isFirst = false;
						newLoopMenu(String.valueOf(map.get("MENUID").toString()), true);
					} else {
						listSize++;
						if (isFirst&&!isSubMenu1) {
							sb.append("<ul>\n");
							isFirst = false;
						}
						sb.append("<li>\n<a><span>\n").append(
								map.get("MENUNAME").toString()).append(
								"\n</span>\n</a>\n");
						newLoopMenu(String.valueOf(map.get("MENUID").toString()), false);
						// 针对进入目录循环的接单在退出后需加上闭合标记
						sb.append("</li>\n");
					}
				}
				else
				{
					listSize++;
					isSubMenu = rootId.equals(String.valueOf(map.get("PARENTID")));
					if (isSubMenu) {
						if(map.get("ISCOUNT")!=null&&map.get("ISCOUNT").equals("1")){
							needcount = "needcount='"+map.get("MODULEID")+"'";
						}
						
						sb
						.append(
								"<div class=\"menuheader expandable\">\n<span class='main_left_expand'>\n</span>\n")
								.append("<span>\n<a href=\"javascript:void(0)\" "+needcount+" onclick=\"linkurl(")
								.append("'" + map.get("OPENMODE") + "'").append(",")
								.append("'" + map.get("ISLEAF") + "'").append(",")
								.append("'" + map.get("URL") + "'").append(",")
								.append("'" + map.get("MODULEID") + "'")
								.append(",")
								.append("'" + map.get("MENUNAME") + "'").append(
										")\">").append(
										map.get("MENUNAME").toString()).append(
										"</a>\n</span>\n</div>\n").append("<ul class=\"categoryitems\"></ul>\n");
					}
					else if(isFirst&&!isSubMenu1)
					{
				 
						if(map.get("ISCOUNT")!=null&&map.get("ISCOUNT").equals("1")){
							needcount = "needcount='"+map.get("MODULEID")+"'";
						}
						
						sb.append("<ul>\n");
						isFirst = false;
						sb.append("<li>\n<span>\n<a href=\"javascript:void(0)\" "+needcount+" onclick=\"linkurl(")
						.append("'" + map.get("OPENMODE") + "'").append(",")
						.append("'" + map.get("ISLEAF") + "'").append(",")
						.append("'" + map.get("URL") + "'").append(",")
						.append("'" + map.get("MODULEID") + "'")
						.append(",")
						.append("'" + map.get("MENUNAME") + "'").append(
								")\">").append(
								map.get("MENUNAME").toString()).append(
								"</a>\n</span>\n</li>\n");
					}
					else{
						if(map.get("ISCOUNT")!=null&&map.get("ISCOUNT").equals("1")){
							needcount = "needcount='"+map.get("MODULEID")+"'";
						}
						
						sb.append("<li>\n<span>\n<a href=\"javascript:void(0)\" "+needcount+" onclick=\"linkurl(")
						.append("'" + map.get("OPENMODE") + "'").append(",")
						.append("'" + map.get("ISLEAF") + "'").append(",")
						.append("'" + map.get("URL") + "'").append(",")
						.append("'" + map.get("MODULEID") + "'")
						.append(",")
						.append("'" + map.get("MENUNAME") + "'").append(
								")\">").append(
								map.get("MENUNAME").toString()).append(
								"</a>\n</span>\n</li>\n");
					}
				}
			}
		}
		//只要存在子节点的子节点就必须带有闭合标记
		if(listSize>0&&!isSubMenu)
		sb.append("</ul>");
	}

	public void loopMenu(String parentId, boolean isDirectory) {
		boolean isFirst = true;
		for (Map<Object, Object> map : list) {
			if (parentId.equals(map.get("PARENTID").toString())) {
				// 目录节点
				if ("0".equals(map.get("ISLEAF").toString())) {
					if (isFirst) {
						sb.append("<ul>\n");
						isFirst = false;
					}
					sb.append("<li>\n<span>").append(
							map.get("MENUNAME").toString()).append("\n</span>\n");
					loopMenu(map.get("MENUID").toString(), true);
					// 针对进入目录循环的接单在退出后需加上闭合标记
					sb.append("</li>\n");
				} else {
					if (isFirst) {
						sb.append("<ul>\n");
						isFirst = false;
					}
					String needcount = "";
					if(map.get("ISCOUNT")!=null&&map.get("ISCOUNT").equals("1")){
						needcount = "needcount='"+map.get("MODULEID")+"'";
					}
					sb.append("<li>\n<span>\n<a href=\"javascript:void(0)\" "+needcount+" onclick=\"linkurl(")
							.append("'" + map.get("OPENMODE") + "'").append(",")
							.append("'" + map.get("ISLEAF") + "'").append(",")
							.append("'" + map.get("URL") + "'").append(",")
							.append("'" + map.get("MODULEID") + "'")
							.append(",")
							.append("'" + map.get("MENUNAME") + "'").append(
									")\">").append(
									map.get("MENUNAME").toString()).append(
									"</a>\n</span>\n</li>\n");
				}
			}
		}
		sb.append("</ul>\n");
	}
}