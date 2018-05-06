package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.common.HibernateSessionFactory;
import com.model.Question;

public class CreateWenjuanDao {
	public int savedata(Question question){
		Session session;
		int num=0;
		try{
			//����HibernateSessionFactory���session
			session = HibernateSessionFactory.getSession();
			//�������
			Transaction trans=session.beginTransaction();
			//����־û���Ķ���,�����ڻ�����
			num=Integer.parseInt(session.save(question).toString());
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
	public List<Question> gets(){
		Session session;
		try{
			//����HibernateSessionFactory���session
			session = HibernateSessionFactory.getSession();
			//HQL���, Users�ǳ־û���
			String hql="from Question";
			//���Query����
			Query query=session.createQuery(hql);
			//ִ�в�ѯ
			List<Question> list=(List<Question>)query.list();
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}finally{
			//�ر�session
			HibernateSessionFactory.closeSession();
		}
	}
	public List<Question> queryByPage(int pageNo,int pageSize){
		//�õ�session
		Session session=null;
		try{
			session=HibernateSessionFactory.getSession();
			String queryString="from Question";
			Query query=session.createQuery(queryString);
			//ÿ�λ�ȡ��һ�����ݵ�����
			query.setFirstResult((pageNo-1)*pageSize); //������һҳ��ʾ�ĵ�һ����¼������
			//��һҳ��ʾ�ļ�¼����
			query.setMaxResults(pageSize); 
			
			//ÿ�����5����¼
			List<Question> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//�ر�session
			HibernateSessionFactory.closeSession();//����HibernateSessionFactory�ľ�̬�����ر�Session
		}	
	}
	public boolean deleteUserById(int id){
		boolean flag=true;
		//�õ�session
		Session session=null;
		Transaction transaction=null;
		try{
			session=HibernateSessionFactory.getSession();
			//����id�õ�Ҫ�޸ĵĶ���
			//Users user=(Users)session.get(Users.class, id);
			Question qq=(Question)session.load(Question.class, id);
			//��������
			transaction=session.beginTransaction();
			session.delete(qq);
			transaction.commit();
		}catch (Exception e) {
			e.printStackTrace();
			flag=false;
		}finally{//�ر�session
			HibernateSessionFactory.closeSession();//����HibernateSessionFactory�ľ�̬�����ر�Session
		}
		return flag;
	}
	public Question queryQuestionById(int id){
		//�õ�session
		Session session=null;
		try{
			session=HibernateSessionFactory.getSession();
			//hql���,Users������models���ʵ����,name��password����ʵ���������
			String queryString="from Question where id=?";
			//������ѯ
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, id);
			//ִ�в�ѯ��õĽ��,list�е�ÿһ��Ԫ�ش���һ��Users�Ķ���
			List<Question> list=queryObject.list();
			if(list.size()>0)
				return list.get(0);
			else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//�ر�session
			HibernateSessionFactory.closeSession();//����HibernateSessionFactory�ľ�̬�����ر�Session
		}
	}
	public boolean updatedata(int id,Question question1){
		boolean flag=true;
		//�õ�session
		Session session=null;
		Transaction transaction=null;
		try{
			session=HibernateSessionFactory.getSession();
			//����id�õ�Ҫ�޸ĵĶ���
			Question question=(Question)session.get(Question.class, id);
			question.setTitle(question1.getTitle());
			question.setType(question1.getType());
			question.setValueList(question1.getValueList());
			//��������
			transaction=session.beginTransaction();
			transaction.commit();
		}catch (Exception e) {
			e.printStackTrace();
			flag=false;
		}finally{//�ر�session
			HibernateSessionFactory.closeSession();//����HibernateSessionFactory�ľ�̬�����ر�Session
		}
		return flag;
	}
}
