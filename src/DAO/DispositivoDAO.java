package DAO;

import java.util.List;

import org.hibernate.HibernateException;

import dominio.Dispositivo;
import dominio.Ordenador;



public class DispositivoDAO<T> extends abstractDAO<T> {

	

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

	@Override
	public T find(Integer id) {
		return find(Dispositivo.class, id);
	}

	@Override
	public List<T> findAll() {
		return findAll(Dispositivo.class);
	}

	
}