package com.action;

import com.dao.CreateWenjuanDao;
import com.model.Question;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateAction extends ActionSupport{
	int id;
	private Question question;
	CreateWenjuanDao cwd=new CreateWenjuanDao();
	public UpdateAction(){
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public CreateWenjuanDao getCwd() {
		return cwd;
	}
	public void setCwd(CreateWenjuanDao cwd) {
		this.cwd = cwd;
	}
	public String execute()throws Exception{
		if(cwd.updatedata(id, question)){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
