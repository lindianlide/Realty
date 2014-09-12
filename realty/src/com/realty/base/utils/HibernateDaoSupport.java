package com.realty.base.utils;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateDaoSupport {
	 Logger logger = Logger.getLogger("DAO");
	 

	public Session getSession(){
		return HibernateSessionFactory.getSession();
	}
	public List findByParameter(String hql){
		return this.findByParameter(hql,null);
	}
	public List findByParameter(String hql,Object param){
		return this.findByParameter(hql, new Object[]{param});
	}
	public List findByParameter(String hql,Object[] params){
		Session session=this.getSession();
		try{
			Query q=session.createQuery(hql);	
			if(params!=null){
				for(int i=0;i<params.length;i++){
					q.setParameter(i, params[i]);
				}
			}
			return q.list();
			
		}catch (HibernateException e) {
			// TODO: handle exception
			throw e;
		}finally{
			session.close();
		}	
	}
	public List findByParametersql(String sql,Object[] params){
		Session session=this.getSession();
		try{
			Query q=session.createSQLQuery(sql);	
			if(params!=null){
				for(int i=0;i<params.length;i++){
					q.setParameter(i, params[i]);
				}
			}
			return q.list();
			
		}catch (HibernateException e) {
			// TODO: handle exception
			throw e;
		}finally{
			session.close();
		}	
	}
	/*
	 * sql得到最大id
	 */
	 
	public List findByParametersql(String sql){
		Session session=this.getSession();
		try{
			Query q=session.createSQLQuery(sql);	
			
			return q.list();
			
		}catch (HibernateException e) {
			// TODO: handle exception
			throw e;
		}finally{
			session.close();
		}	
	}
	public List findByNamedParameter(String hql,String name,Object value){
		return this.findByNamedParameter(hql, new String[]{name}, new Object[]{value});
	}
	public List findByNamedParameter(String hql,String[] names,Object[] values){
		Session session=this.getSession();
		try{
			Query q=session.createQuery(hql);
			if(names!=null){
				for(int i=0;i<names.length;i++){
					q.setParameter(names[i], values[i]);
				}
			}
			return q.list();
			
		}catch (HibernateException e) {
			// TODO: handle exception
			throw e;
		}finally{
			session.close();
		}
	}
	public List findByNamedParameter(String hql,Map params){
		Session session=this.getSession();
		try{
			Query q=session.createQuery(hql);
			if(params!=null){
				q.setProperties(params);
			}
			return q.list();
			
		}catch (HibernateException e) {
			// TODO: handle exception
			throw e;
		}finally{
			session.close();
		}
	}
	public List findByNamedParameter(String hql,Map params,int pageNo,int pageSize){
		Session session=this.getSession();
		try{
			Query q=session.createQuery(hql);
			if(params!=null){
				q.setProperties(params);
			}
			q.setFirstResult((pageNo-1)*pageSize);
			q.setMaxResults(pageSize);
			return q.list();
			
		}catch (HibernateException e) {
			// TODO: handle exception
			throw e;
		}finally{
			session.close();
		}
	}
	public List findByParameter(String hql,Object[] params,int pageNo,int pageSize){
		Session session=this.getSession();
		try{
			Query q=session.createQuery(hql);
			if(params!=null){
				for(int i=0;i<params.length;i++){
					q.setParameter(i, params[i]);
				}
			}
			q.setFirstResult((pageNo-1)*pageSize);
			q.setMaxResults(pageSize);
			return q.list();
			
		}catch (HibernateException e) {
			// TODO: handle exception
			throw e;
		}finally{
			session.close();
		}
	}
	
	  
	public void save(Object obj) throws HibernateException{
		Session session=getSession();
		Transaction tran=null;
		try{
			tran=session.beginTransaction();
			session.save(obj);
			tran.commit();
		}catch(HibernateException e){
			logger.info(obj+"插入出错！");
			if(tran!=null)tran.rollback();
			throw e;			
		}finally{
			session.close();
		}
	}
	
	public void delete(Class clazz,Serializable id){
		Session session=this.getSession();
		Transaction tran=null;
		try{
			tran=session.beginTransaction();
			Object obj=session.get(clazz, id);
			session.delete(obj);
			tran.commit();
		}catch(HibernateException e){
			if(tran!=null)tran.rollback();
			throw e;
		}finally{
			session.close();
		}
	}
	public Object get(Class clazz,Serializable id) throws HibernateException{
		Session session=this.getSession();		
		try{
			return session.get(clazz,id);
			
		}catch(HibernateException e){
			throw e;
		}finally{
			session.close();
		}
	}
	public boolean delete(Object obj) throws HibernateException{
		Session session=this.getSession();
		Transaction tran=null;
		try{
			tran=session.beginTransaction();
			session.delete(obj);
			tran.commit();
			return true;
		}catch(HibernateException e){
			logger.info(obj+"删除出错！");
			if(tran!=null)tran.rollback();
			return false;
			//throw e;
		}finally{
			session.close();
			
		}
	}
	public void update(Object obj) throws HibernateException{
		Session session=this.getSession();
		Transaction tran=null;
		try{
			tran=session.beginTransaction();
			session.update(obj);
			tran.commit();
		}catch(HibernateException e){
			if(tran!=null)tran.rollback();
			throw e;
		}finally{
			session.close();
		}
	}
	
			
			public int batchsqlUpdate(String sql,Object[] params){
				int ret=0;
				Session session=this.getSession();
				Transaction t=null;;
				try{
					Query q=session.createSQLQuery(sql);
					t=session.beginTransaction();
					if(params!=null){
						for(int i=0;i<params.length;i++){
							q.setParameter(i, params[i]);
						}
					}
					ret=q.executeUpdate();
					t.commit();
				}catch(HibernateException e){
					if(t!=null) t.rollback();
					throw e;
				}finally{
					session.close();
				}
				return ret;
			}
	public int batchUpdate(String hql,Object[] params){
		int ret=0;
		Session session=this.getSession();
		Transaction t=null;;
		try{
			Query q=session.createQuery(hql);
			t=session.beginTransaction();
			if(params!=null){
				for(int i=0;i<params.length;i++){
					q.setParameter(i, params[i]);
				}
			}
			ret=q.executeUpdate();
			t.commit();
		}catch(HibernateException e){
			if(t!=null) t.rollback();
			throw e;
		}finally{
			session.close();
		}
		return ret;
	}
}
