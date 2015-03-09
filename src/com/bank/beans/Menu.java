package com.bank.beans;

import com.common.bean.BaseEntity;

/**
 * Menu Bean
 * @author huzq
 *
 */
public class Menu extends BaseEntity<Integer> {
	private String menuId;// 菜单ID
	private String menuDescr;// 菜单姓名
	private String menuUrl;// 菜单地址
	private String menuPid;// 菜单父ID
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public String getMenuDescr() {
		return menuDescr;
	}
	public void setMenuDescr(String menuDescr) {
		this.menuDescr = menuDescr;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public String getMenuPid() {
		return menuPid;
	}
	public void setMenuPid(String menuPid) {
		this.menuPid = menuPid;
	}
	@Override
	public boolean equalsIfIdNull(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int hashCodeIfIdNull() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
