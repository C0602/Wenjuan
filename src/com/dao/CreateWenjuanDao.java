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
			//调用HibernateSessionFactory获得session
			session = HibernateSessionFactory.getSession();
			//获得事物
			Transaction trans=session.beginTransaction();
			//保存持久化类的对象,保存在缓存里
			num=Integer.parseInt(session.save(question).toString());
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
	public List<Question> gets(){
		Session session;
		try{
			//调用HibernateSessionFactory获得session
			session = HibernateSessionFactory.getSession();
			//HQL语句, Users是持久化类
			String hql="from Question";
			//获得Query对象
			Query query=session.createQuery(hql);
			//执行查询
			List<Question> list=(List<Question>)query.list();
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}finally{
			//关闭session
			HibernateSessionFactory.closeSession();
		}
	}
	public List<Question> queryByPage(int pageNo,int pageSize){
		//得到session
		Session session=null;
		try{
			session=HibernateSessionFactory.getSession();
			String queryString="from Question";
			Query query=session.createQuery(queryString);
			//每次获取第一条数据的索引
			query.setFirstResult((pageNo-1)*pageSize); //设置这一页显示的第一条记录的索引
			//这一页显示的记录个数
			query.setMaxResults(pageSize); 
			
			//每次最多5条记录
			List<Question> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//关闭session
			HibernateSessionFactory.closeSession();//调用HibernateSessionFactory的静态方法关闭Session
		}	
	}
	public boolean deleteUserById(int id){
		boolean flag=true;
		//得到session
		Session session=null;
		Transaction transaction=null;
		try{
			session=HibernateSessionFactory.getSession();
			//根据id得到要修改的对象
			//Users user=(Users)session.get(Users.class, id);
			Question qq=(Question)session.load(Question.class, id);
			//启开事物
			transaction=session.beginTransaction();
			session.delete(qq);
			transaction.commit();
		}catch (Exception e) {
			e.printStackTrace();
			flag=false;
		}finally{//关闭session
			HibernateSessionFactory.closeSession();//调用HibernateSessionFactory的静态方法关闭Session
		}
		return flag;
	}
	public Question queryQuestionById(int id){
		//得到session
		Session session=null;
		try{
			session=HibernateSessionFactory.getSession();
			//hql语句,Users代表是models里的实体类,name和password代表实体类的属性
			String queryString="from Question where id=?";
			//创建查询
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, id);
			//执行查询获得的结果,list中的每一个元素代表一个Users的对象
			List<Question> list=queryObject.list();
			if(list.size()>0)
				return list.get(0);
			else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//关闭session
			HibernateSessionFactory.closeSession();//调用HibernateSessionFactory的静态方法关闭Session
		}
	}
	public boolean updatedata(int id,Question question1){
		boolean flag=true;
		//得到session
		Session session=null;
		Transaction transaction=null;
		try{
			session=HibernateSessionFactory.getSession();
			//根据id得到要修改的对象
			Question question=(Question)session.get(Question.class, id);
			question.setTitle(question1.getTitle());
			question.setType(question1.getType());
			question.setValueList(question1.getValueList());
			//开启事物
			transaction=session.beginTransaction();
			transaction.commit();
		}catch (Exception e) {
			e.printStackTrace();
			flag=false;
		}finally{//关闭session
			HibernateSessionFactory.closeSession();//调用HibernateSessionFactory的静态方法关闭Session
		}
		return flag;
	}
}
