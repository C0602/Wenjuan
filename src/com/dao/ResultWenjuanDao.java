package com.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.common.HibernateSessionFactory;
import com.model.QuestionResult;

public class ResultWenjuanDao {
	public int savedata(QuestionResult questionresult){
		Session session;
		int num=0;
		try{
			//调用HibernateSessionFactory获得session
			session = HibernateSessionFactory.getSession();
			//获得事物
			Transaction trans=session.beginTransaction();
			//保存持久化类的对象,保存在缓存里
			num=Integer.parseInt(session.save(questionresult).toString());
			//提交事物，写入数据库
			trans.commit();			
		}catch(Exception ex){
			ex.printStackTrace();
			return num;
		}finally{
			//关闭session
			HibernateSessionFactory.closeSession();
		}
		return num;
	}
}
