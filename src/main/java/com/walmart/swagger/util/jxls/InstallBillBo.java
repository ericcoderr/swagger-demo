package com.walmart.swagger.util.jxls;

import java.util.List;

public class InstallBillBo {
	private Double total;
	private List<Bill> list ;
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public List<Bill> getList() {
		return list;
	}
	public void setList(List<Bill> list) {
		this.list = list;
	}
	
}
