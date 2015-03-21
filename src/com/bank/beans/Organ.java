package com.bank.beans;

import com.common.bean.BaseEntity;

/**
 * Organ Bean
 * @author huzq
 *
 */
public class Organ extends BaseEntity<Integer> {
	private String organId;// 机构ID
	private String organName;// 机构名称
	private String organPid;// 机构父ID
	private String organShort;// 机构简称

	public String getOrganId() {
		return organId;
	}

	public void setOrganId(String organId) {
		this.organId = organId;
	}

	public String getOrganName() {
		return organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}

	public String getOrganShort() {
		return organShort;
	}

	public void setOrganShort(String organShort) {
		this.organShort = organShort;
	}

	public String getOrganPid() {
		return organPid;
	}

	public void setOrganPid(String organPid) {
		this.organPid = organPid;
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
