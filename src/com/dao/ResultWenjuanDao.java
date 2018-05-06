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
			//����HibernateSessionFactory���session
			session = HibernateSessionFactory.getSession();
			//�������
			Transaction trans=session.beginTransaction();
			//����־û���Ķ���,�����ڻ�����
			num=Integer.parseInt(session.save(questionresult).toString());
			//�ύ���д�����ݿ�
			trans.commit();			
		}catch(Exception ex){
			ex.printStackTrace();
			return num;
		}finally{
			//�ر�session
			HibernateSessionFactory.closeSession();
		}
		return num;
	}
}
