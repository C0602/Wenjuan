package com.action;

import com.dao.CreateWenjuanDao;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteQuestionByIDAction extends ActionSupport{
	int id;
	CreateWenjuanDao cwd=new CreateWenjuanDao();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CreateWenjuanDao getCwd() {
		return cwd;
	}

	public void setCwd(CreateWenjuanDao cwd) {
		this.cwd = cwd;
	}

	public String execute()throws Exception{
		if(cwd.deleteUserById(id)){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
