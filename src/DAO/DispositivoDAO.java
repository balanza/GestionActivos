package DAO;

import java.util.List;

import org.hibernate.HibernateException;

import dominio.Dispositivo;



public abstract class DispositivoDAO<T> extends abstractDAO<T> {

	

	@Override
	public void save(T x){
		
		Dispositivo o = (Dispositivo)x;
		
        try {
            startOperation();
            
            //Related objects
            DepartamentoDAO dep = new DepartamentoDAO();
            {
            	dep.save(o.getDepartamento());
            }
            EmpresaDAO emp = new EmpresaDAO();
            {
            	emp.save(o.getEmpresa());
            }
            PersonaContactoDAO pers = new PersonaContactoDAO();
            {
            	pers.save(o.getPersonaContacto());
            }
                      
            
            //Dispositivo
            session.saveOrUpdate(o);            
            
            endOperation();
            
        } catch (HibernateException e) {
            handleException(e);
        } 
		
	}

	
}