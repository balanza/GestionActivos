package DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;

import dominio.AccionBaja;

import persistence.UtilityHibernate;

import java.util.List;

public abstract class abstractDAO<T> {
    protected Session session;
    protected Transaction tx;



    public void create(T obj){
    	 try {
             //startOperation();

             session = UtilityHibernate.getSessionFactory().openSession();
             tx = session.beginTransaction();
             
             session.save(obj);
             
             tx.commit();
             
             //endOperation();
         } catch (HibernateException e) {
             handleException(e);
             tx.rollback();
         } 

 		session.close();  
    }
    
    public void update(T obj){
    	try {
            //startOperation();

            session = UtilityHibernate.getSessionFactory().openSession();
            tx = session.beginTransaction();
            
            session.update(obj);
            
            tx.commit();
            
            //endOperation();
        } catch (HibernateException e) {
            handleException(e);
            tx.rollback();
        } 

		session.close();    	
    }
    
    
    public void save(T obj) { //to be split
        try {
            //startOperation();

            session = UtilityHibernate.getSessionFactory().openSession();
            tx = session.beginTransaction();
            
            session.saveOrUpdate(obj);
            
            tx.commit();
            
            //endOperation();
        } catch (HibernateException e) {
            handleException(e);
            tx.rollback();
        } 

		session.close();  
    }

    public void delete(T obj) {
        try {
        	session = UtilityHibernate.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(obj);
            
            tx.commit();
            
        } catch (HibernateException e) {
            handleException(e);
            tx.rollback();
        }
		session.close(); 
    }
    
    public void delete(int id) {
    	delete(find(id));
    }

    
    
    public abstract T find(Integer id);
    
    protected T find(Class clazz , Integer id) {
    	T obj = null;
        try {
        	session = UtilityHibernate.getSessionFactory().openSession();
            obj = (T) session.load(clazz, id);
           
        } catch (HibernateException e) {
            handleException(e);
        } 
        session.close();
        return obj;
    }
    
  

    public abstract List<T> findAll();

    @SuppressWarnings("unchecked")
	protected List<T> findAll(Class clazz) {
        List<T> objects = null;
        try {
        	session = UtilityHibernate.getSessionFactory().openSession();
            Query query = session.createQuery("from " + clazz.getName());
            objects = query.list();

        } catch (HibernateException e) {
            handleException(e);
        } 
        session.close();
        return objects;
    }
    

    protected void handleException(HibernateException e) throws DAOExceptions {
        //abortOperation();
        throw new DAOExceptions(e);
    }

    

    
    
    protected void startOperation() throws HibernateException {
        session = UtilityHibernate.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }
    
    protected void endOperation() throws HibernateException {
    	if(tx != null && tx.isActive()){
    		tx.commit();    		
    	}
        if(session != null){
        	try{
        		session.close();        		
        	} catch(Exception e){
        		throw new HibernateException(e.getMessage());
        	}        	
        }
        	
    }
    
    protected void abortOperation() throws HibernateException {
    	if(tx != null){
    		tx.rollback();    		
    	}
        if(session != null){
        	try{
        		session.close();        		
        	} catch(Exception e){
        		throw new HibernateException(e.getMessage());
        	}        	
        }
    }







}