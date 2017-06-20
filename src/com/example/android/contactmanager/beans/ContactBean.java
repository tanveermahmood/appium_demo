package com.example.android.contactmanager.beans;

import com.qmetry.qaf.automation.data.BaseDataBean;
import com.qmetry.qaf.automation.util.Randomizer;

public class ContactBean extends BaseDataBean {
	@Randomizer(length = 6)
	private String name;
	@Randomizer(format = "(999) 999 9999")
	private String phone;
	@Randomizer(length = 5, suffix = "@infostretch.com")
	private String email;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public static void main(String[] args) {
		ContactBean bean = new ContactBean();
		bean.fillRandomData();
		System.out.println(bean);
	}
}
