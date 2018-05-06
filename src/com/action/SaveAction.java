package com.action;

import java.util.ArrayList;
import java.util.List;

import com.dao.CreateWenjuanDao;
import com.model.Question;
import com.opensymphony.xwork2.ActionSupport;

public class SaveAction extends ActionSupport{
	private Question question;
	CreateWenjuanDao cd=new CreateWenjuanDao();
	String[] str;
	public SaveAction(){
		
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public String[] getStr() {
		return str;
	}
	public void setStr(String[] str) {
		this.str = str;
	}
	
	public CreateWenjuanDao getCd() {
		return cd;
	}
	public void setCd(CreateWenjuanDao cd) {
		this.cd = cd;
	}
	public String execute()throws Exception{
		List<String> value=new ArrayList<String>();
		for(int i=0;i<str.length;i++){
			value.add(str[i]);
		}
		question.setValueList(value);
		if(cd.savedata(question)>0){
			return SUCCESS;
		}
		return INPUT;
	}
}
