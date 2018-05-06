package com.action;

import java.util.List;

import com.dao.CreateWenjuanDao;
import com.model.Question;
import com.opensymphony.xwork2.ActionSupport;

public class JumptoFinishAction extends ActionSupport{
	List<Question> lq;
	CreateWenjuanDao cwd=new CreateWenjuanDao();
	public JumptoFinishAction(){
		
	}
	public List<Question> getLq() {
		return lq;
	}
	public void setLq(List<Question> lq) {
		this.lq = lq;
	}
	public CreateWenjuanDao getCwd() {
		return cwd;
	}
	public void setCwd(CreateWenjuanDao cwd) {
		this.cwd = cwd;
	}
	public String execute()throws Exception{
		lq=cwd.gets();
		if(lq!=null&&lq.size()>0){
			return SUCCESS;
		}
		return INPUT;
	}
}
