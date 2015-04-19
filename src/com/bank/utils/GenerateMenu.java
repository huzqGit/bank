package com.bank.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.bank.vo.MenuPrivilegeVO;

public class GenerateMenu {
	private List<MenuPrivilegeVO> list;

	public GenerateMenu(List<MenuPrivilegeVO> list) {
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
	/*public String getDirectoryMenu()
	{
		sb=new StringBuffer("\n<ul id=\"the_tree\" class=\"easyui-tree\" animate=\"true\" dnd=\"false\">\n");
		for (MenuPrivilegeVO vo : list) {
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
	}*/
	
	public void loopDirectoryMenu(String parentId)
	{
		boolean isFirst = true;
		int subListSize=0;
		boolean isSubMenu="1".equals(parentId);
		for (MenuPrivilegeVO vo : list) {
			if(parentId.equals(vo.getMenuPId()+""))
			{
				if("0".equals(vo.getIsLeaf()))
				{
					if(isFirst&&!isSubMenu)
						sb.append("<ul>\n<li>\n<span><a href='javascript:void(0)' onclick=\"linkurl(this,'").append(vo.getMenuId()).append("')\">").append(vo.getMenuDescr()).append("</a>\n</span></li>");
					else if(isFirst&&isSubMenu)
						sb.append("<li>\n<span><a href='javascript:void(0)' onclick=\"linkurl(this,'").append(vo.getMenuId()).append("')\">").append(vo.getMenuDescr()).append("</a>\n</span></li>");
					else
						sb.append("<li>\n<span><a href='javascript:void(0)' onclick=\"linkurl(this,'").append(vo.getMenuId()).append("')\">").append(vo.getMenuDescr()).append("</a>\n</span></li>");
					isFirst=false;
				}
				else
				{
					if(!isSubMenu&&isFirst)
					{
						sb.append("<ul>\n<li>\n<span><a href='javascript:void(0)' onclick=\"linkurl(this,'").append(vo.getMenuId()).append("')\">").append(vo.getMenuDescr()).append("</a>\n</span>");
					}
					else if(isFirst&&isSubMenu)
					{
						sb.append("<li>\n<span><a href='javascript:void(0)' onclick=\"linkurl(this,'").append(vo.getMenuId()).append("')\">").append(vo.getMenuDescr()).append("</a>\n</span>");
					}
					else
						sb.append("<li>\n<span><a href='javascript:void(0)' onclick=\"linkurl(this,'").append(vo.getMenuId()).append("')\">").append(vo.getMenuDescr()).append("</a>\n</span>");
						//sb.append("<li><span ><div onclick=\"linkurl('").append(map.get("node_id")).append("')\">").append(map.get("node_name")).append(" </div>\n</span>");
					isFirst=false;
					loopDirectoryMenu(vo.getMenuId()+"");
				}
			}
		}
		if(!isSubMenu)
			sb.append("</ul>");
		sb.append("</li>");
	}
	
	public String getMenu() {
		sb.delete(0, sb.length());
		sb.append("<div style=\"width:200px;height:100%; margin-left:7px;\">\n<div class=\"arrowlistmenu\">\n");
		if(list==null){
			return "noAuthority";
		}
		for (MenuPrivilegeVO vo : list) {
			// 只从根节点开始进入循环
			if ("0".equals(vo.getIsLeaf()) && vo.getMenuPId() == 0) {
				 rootId = vo.getMenuId() + "";
				 if(cacheMap.get(rootId)==null)
				 {
					 newLoopMenu(vo.getMenuId() + "", true);
				 }
				 else
				 {
					 return cacheMap.get(rootId);
				 }
				break;
			}
		}
		sb.append("\n</div>\n</div>\n");
		System.out.println("生成的菜单："+sb.toString());
		return sb.toString();
	}
	
	int i=0;
	public void newLoopMenu(String parentId, boolean isSubMenu1) {
		boolean isSubMenu = false;
		boolean isFirst = true;
		int listSize=0;
		for (MenuPrivilegeVO vo : list) {
			if (parentId.equals(vo.getMenuPId() + "")) {
				String needcount = "";
				if ("0".equals(StringUtils.trimToNull(vo.getIsLeaf()))) {
					isSubMenu = rootId.equals(String.valueOf(vo.getMenuPId() + ""));
					//根节点的第一级节点
					if (isSubMenu) {
						i++;
						sb
						.append(
								"<div class=\"menuheader expandable\">\n")
							    .append(vo.getMenuDescr().toString())
							    .append(
								"</div>\n");
						sb.append("<ul class=\"categoryitems\">\n");
						isFirst = false;
						newLoopMenu(String.valueOf(vo.getMenuId() + ""), true);
					} else {
						listSize++;
						if (isFirst&&!isSubMenu1) {
							sb.append("<ul>\n");
							isFirst = false;
						}
						sb.append("<li>\n<a><span>\n").append(
								vo.getMenuDescr().toString()).append(
								"\n</span>\n</a>\n");
						newLoopMenu(String.valueOf(vo.getMenuId()), false);
						// 针对进入目录循环的接单在退出后需加上闭合标记
						sb.append("</li>\n");
					}
				}
				else
				{
					listSize++;
					isSubMenu = rootId.equals(String.valueOf(vo.getMenuPId()));
					if (isSubMenu) {
						sb
						.append(
								"<div class=\"menuheader expandable\">\n<span class='main_left_expand'>\n</span>\n")
								.append("<span>\n<a href=\"javascript:void(0)\" "+needcount+" onclick=\"linkurl(")
								.append("'" + vo.getIsLeaf() + "'").append(",")
								.append("'" + vo.getMenuUrl() + "'").append(",")
								.append("'" + vo.getMenuId() + "'")
								.append(",")
								.append("'" + vo.getMenuDescr() + "'").append(
										")\">").append(
												vo.getMenuDescr()).append(
										"</a>\n</span>\n</div>\n").append("<ul class=\"categoryitems\"></ul>\n");
					}
					else if(isFirst&&!isSubMenu1)
					{
						
						sb.append("<ul>\n");
						isFirst = false;
						sb.append("<li>\n<span>\n<a href=\"javascript:void(0)\" "+needcount+" onclick=\"linkurl(")
						.append("<span>\n<a href=\"javascript:void(0)\" "+needcount+" onclick=\"linkurl(")
						.append("'" + vo.getIsLeaf() + "'").append(",")
						.append("'" + vo.getMenuUrl() + "'").append(",")
						.append("'" + vo.getMenuId() + "'")
						.append(",")
						.append("'" + vo.getMenuDescr() + "'").append(
								")\">").append(
										vo.getMenuDescr()).append(
								"</a>\n</span>\n</li>\n");
					}
					else{
						
						sb.append("<li>\n<span>\n<a href=\"javascript:void(0)\" "+needcount+" onclick=\"linkurl(")
						.append("'" + vo.getIsLeaf() + "'").append(",")
						.append("'" + vo.getMenuUrl() + "'").append(",")
						.append("'" + vo.getMenuId() + "'")
						.append(",")
						.append("'" + vo.getMenuDescr() + "'").append(
								")\">").append(
										vo.getMenuDescr()).append(
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
		for (MenuPrivilegeVO vo : list) {
			if (parentId.equals(vo.getMenuPId() + "")) {
				// 目录节点
				if ("0".equals(vo.getIsLeaf())) {
					if (isFirst) {
						sb.append("<ul>\n");
						isFirst = false;
					}
					sb.append("<li>\n<span>").append(
							vo.getMenuDescr()).append("\n</span>\n");
					loopMenu(vo.getMenuId() + "", true);
					// 针对进入目录循环的接单在退出后需加上闭合标记
					sb.append("</li>\n");
				} else {
					if (isFirst) {
						sb.append("<ul>\n");
						isFirst = false;
					}
					String needcount = "";
					sb.append("<li>\n<span>\n<a href=\"javascript:void(0)\" "+needcount+" onclick=\"linkurl(")
							.append("'" + vo.getIsLeaf() + "'").append(",")
							.append("'" + vo.getMenuUrl() + "'").append(",")
							.append("'" + vo.getMenuId() + "'")
							.append(",")
							.append("'" + vo.getMenuDescr() + "'").append(
									")\">").append(
											vo.getMenuDescr()).append(
									"</a>\n</span>\n</li>\n");
				}
			}
		}
		sb.append("</ul>\n");
	}
}