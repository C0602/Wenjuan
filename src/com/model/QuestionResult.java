package com.model;

import java.util.ArrayList;
import java.util.List;

public class QuestionResult {
	int id;
	String resulttitle;
	String resulttype;
	private List<String> questionList=new ArrayList<String>();
	private List<String> titleList=new ArrayList<String>();
	private List<String> typeList=new ArrayList<String>();
	public QuestionResult(){
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getResulttitle() {
		return resulttitle;
	}
	public void setResulttitle(String resulttitle) {
		this.resulttitle = resulttitle;
	}
	public String getResulttype() {
		return resulttype;
	}
	public void setResulttype(String resulttype) {
		this.resulttype = resulttype;
	}
	public List<String> getQuestionList() {
		return questionList;
	}
	public void setQuestionList(List<String> questionList) {
		this.questionList = questionList;
	}

	public List<String> getTitleList() {
		return titleList;
	}

	public void setTitleList(List<String> titleList) {
		this.titleList = titleList;
	}

	public List<String> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<String> typeList) {
		this.typeList = typeList;
	}
	
}
