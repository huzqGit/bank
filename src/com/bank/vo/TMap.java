package com.bank.vo;

import com.common.bean.BaseEntity;

public class TMap extends BaseEntity<Long>{

	private static final long serialVersionUID = 4115201325331986197L;
	
	private Long mapid;
	private String mapkey;
	private String mapvalue;
	private String mapvalue_py;	//mapvalue的拼音格式(首拼)
	private String maptypes;	//映射类型
	private String remarks;
	
	
	public String getMapkey() {
		return mapkey;
	}
	public void setMapkey(String mapkey) {
		this.mapkey = mapkey;
	}
	public String getMapvalue() {
		return mapvalue;
	}
	public void setMapvalue(String mapvalue) {
		this.mapvalue = mapvalue;
	}
	public String getMapvalue_py() {
		return mapvalue_py;
	}
	public void setMapvalue_py(String mapvalue_py) {
		this.mapvalue_py = mapvalue_py;
	}
	public String getMaptypes() {
		return maptypes;
	}
	public void setMaptypes(String maptypes) {
		this.maptypes = maptypes;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public void setMapid(Long mapid) {
		this.mapid = mapid;
	}
	
	@Override
	public boolean equalsIfIdNull(Object o) {
		return false;
	}
	@Override
	public int hashCodeIfIdNull() {
		return 0;
	}
	public Long getMapid() {
		return mapid;
	}
	
}
