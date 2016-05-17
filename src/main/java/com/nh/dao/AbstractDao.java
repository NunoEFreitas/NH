package com.nh.dao;

import java.io.Serializable;
<<<<<<< HEAD

import java.lang.reflect.ParameterizedType;

=======
import java.lang.reflect.ParameterizedType;
>>>>>>> origin/master
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao<PK extends Serializable, T> {
	
	private final Class<T> persistentClass;
	
	@SuppressWarnings("unchecked")
	public AbstractDao(){
		this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public T getByKey(PK key) {
		return (T) getSession().get(persistentClass, key);
	}

	public void persist(T entity) {
		getSession().persist(entity);
	}

	public void delete(T entity) {
		getSession().delete(entity);
	}
<<<<<<< HEAD
	
=======

        public void deleteById(PK id){
                getSession().delete(getByKey(id));
        }
         
>>>>>>> origin/master
	protected Criteria createEntityCriteria(){
		return getSession().createCriteria(persistentClass);
	}
        

}
