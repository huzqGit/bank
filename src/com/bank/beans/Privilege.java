package com.bank.beans;

import com.common.bean.BaseEntity;

public class Privilege extends BaseEntity<String>{
	private String privilegeId;
	private String privilegeType;
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
	@Override
	public boolean equalsIfIdNull(Object o) {
		return false;
	}
	@Override
	public int hashCodeIfIdNull() {
		return 0;
	}
}
