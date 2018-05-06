package com.action;

import java.util.List;

import com.dao.CreateWenjuanDao;
import com.model.Question;
import com.opensymphony.xwork2.ActionSupport;

public class QueryAction extends ActionSupport{
	List<Question> ls; //�־û��༯��
	private Question question;
	CreateWenjuanDao cwd=new CreateWenjuanDao();
	private int id; //������ʾ���ݵ�����
	private final int pageSize=5; //ÿҳ��ʾ��¼�ĸ���
	private int pageNo=1; //������,�ӵ�1ҳ��ʼ��ʾ
	private int currentPage; //��ǰҳ
	private int totalPage; //��ҳ��
	
	public List<Question> getLs() {
		return ls;
	}
	public void setLs(List<Question> ls) {
		this.ls = ls;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public QueryAction(){
		
	}
	public String execute()throws Exception{
		ls=cwd.gets();
		if(ls.size()%pageSize==0){
			totalPage=ls.size()/pageSize;
		}else{
			totalPage=ls.size()/pageSize+1;
		}
		if(pageNo<=0){
			pageNo=1;
		}else if(pageNo>totalPage){
			pageNo=totalPage;
		}
		ls=cwd.queryByPage(pageNo,pageSize);
		currentPage=pageNo;
		if(ls!=null){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
