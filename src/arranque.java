import javax.swing.SwingUtilities;

import dominio.*;

import org.hibernate.*;

import GUI.VentanaPrincipal;

import persistence.UtilityHibernate;

public class arranque {
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VentanaPrincipal inst = new VentanaPrincipal();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	

	/**
	 * @param args
	public static void main(String[] args) {
		Session session = UtilityHibernate.getSessionFactory().openSession();
		Transaction t =   session.beginTransaction();
		
		Departamento dep = new Departamento();
		{
			dep.setNombre("depart new");
		}
		PersonaContacto pers = new PersonaContacto();
		{
			pers.setNombre("Gino");
			pers.setTelefono("34432");
		}
		Empresa emp = new Empresa();
		{
			emp.setNombre("mercadona");
		}		
		
		Dispositivo imp = new Impresora();
		{
			imp.setMarca("apple");
			imp.setNumSerie("I0998");	
			imp.setPersonaContacto(pers);
			imp.setDepartamento(dep);	
			imp.setEmpresa(emp);
		}
		
		Impresora imp2 = new Impresora();
		{
			imp2.setMarca("dell");
			imp2.setNumSerie("I0968");	
			imp2.setPersonaContacto(pers);
			imp2.setDepartamento(dep);	
			imp2.setEmpresa(emp);
		}
		
		
		try{
			
		session.save(dep);
		session.save(emp);
		session.save(pers);
		session.save(imp);
		
		session.save(dep);
		session.save(emp);
		session.save(pers);
		session.save(imp2);

		t.commit();
		} catch(Exception e){
			int a = 0;
			a = a*2;
		}
		session.close();
	}
	 */

}
