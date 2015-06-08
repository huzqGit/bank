package com.bank.vo;

public class MenuPrivilegeVO implements java.io.Serializable{
	
	private static final long serialVersionUID = -8135161673478500452L;
	private long menuId;
	private String menuDescr;
	private String menuUrl;
	private long menuPId;
	private String isLeaf;
	private String privilegeId;
	private String privilegeType;
	
	public MenuPrivilegeVO() {
		
	}
	
	public MenuPrivilegeVO(String isLeaf, long menuId) {
		this.isLeaf = isLeaf;
		this.menuId = menuId;
	}

	public long getMenuId() {
		return menuId;
	}

	public void setMenuId(long menuId) {
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

	public long getMenuPId() {
		return menuPId;
	}

	public void setMenuPId(long menuPId) {
		this.menuPId = menuPId;
	}

	public String getIsLeaf() {
		return isLeaf;
	}

	public void setIsLeaf(String isLeaf) {
		this.isLeaf = isLeaf;
	}

	public String getPrivilegeId() {
		return privilegeId;
	}

	public void setPrivilegeId(String privilegeId) {
		this.privilegeId = privilegeId;
	}

	public String getPrivilegeType() {
		return privilegeType;
	}

	public void setPrivilegeType(String privilegeType) {
		this.privilegeType = privilegeType;
	}

}