package com.action;

import java.util.ArrayList;
import java.util.List;

import com.dao.ResultWenjuanDao;
import com.model.QuestionResult;
import com.opensymphony.xwork2.ActionSupport;

public class SaveresultAction extends ActionSupport{
	private ArrayList<String> choose;
	private ArrayList<String> title;
	private ArrayList<String> type;
	private QuestionResult questionResult;
	ResultWenjuanDao rwd=new ResultWenjuanDao();
	
	public ResultWenjuanDao getRwd() {
		return rwd;
	}

	public void setRwd(ResultWenjuanDao rwd) {
		this.rwd = rwd;
	}

	public QuestionResult getQuestionResult() {
		return questionResult;
	}

	public void setQuestionResult(QuestionResult questionResult) {
		this.questionResult = questionResult;
	}

	public ArrayList<String> getChoose() {
		return choose;
	}

	public void setChoose(ArrayList<String> choose) {
		this.choose = choose;
	}
	
	public ArrayList<String> getTitle() {
		return title;
	}

	public void setTitle(ArrayList<String> title) {
		this.title = title;
	}

	public ArrayList<String> getType() {
		return type;
	}

	public void setType(ArrayList<String> type) {
		this.type = type;
	}

	public String execute()throws Exception{
		questionResult.setQuestionList(choose);
		questionResult.setTitleList(title);
		questionResult.setTypeList(type);
		System.out.println(title.get(0));
		if(rwd.savedata(questionResult)>0){
			return SUCCESS;
		}
		return INPUT;
	}
}
