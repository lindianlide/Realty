package com.realty.base.utils;

import java.io.Serializable;
import java.util.List;

public interface GenericDao <T,PK extends Serializable> {
	public T findById(PK id);

	public List<T> findAll();

	public T save(T entity);

	public void update(T entity);

	public void delete(T entity);
}