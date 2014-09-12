package com.realty.base.utils;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
public abstract class GenericDaoHibernate<T, PK extends Serializable> implements GenericDao<T, PK> {
	private Class<T> clazz;
	HibernateDaoSupport hds=new HibernateDaoSupport();
	public GenericDaoHibernate() {
		clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public T findById(PK id) {
		Session session = HibernateSessionFactory.getSession();
		try{
			return (T) session.get(clazz, id);
		}catch (HibernateException e) {
			// TODO: handle exception
			throw e;
		}finally{
			session.close();
		}
	}

	public List<T> findAll() {
		Session session = HibernateSessionFactory.getSession();
		try{
			Query query = session.createQuery("from " + clazz.getName());
			return query.list();
		}catch (HibernateException e) {
			// TODO: handle exception
			throw e;
		}finally{
			session.close();
		}
		
	}
	public List<T> findAllpage(int pageNo,int pageSize) {
		Session session = HibernateSessionFactory.getSession();
		try{
			Query q = session.createQuery("from " + clazz.getName());
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
	
	public T save(T entity) {
		hds.save(entity);
		return entity;
	}

	public void update(T entity) {
		hds.update(entity);
	}

	public void delete(T entity) {
		hds.delete(entity);
	}
}
