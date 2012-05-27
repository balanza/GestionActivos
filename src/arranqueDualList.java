import javax.swing.SwingUtilities;

import dominio.*;

import org.hibernate.*;

import DAO.ImpresoraDAO;
import GUI.VentanaDualList;
import GUI.VentanaPrincipal;
import GUI.DataTableModel.SortedListModel;

import persistence.UtilityHibernate;

public class arranqueDualList {
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				SortedListModel initial = new SortedListModel();
				Impresora a = new Impresora();
				a.setNumInventario(1);
				a.setMarca("hp");
				Impresora b = new Impresora();
				b.setNumInventario(2);
				b.setMarca("xerox");
				Impresora c = new Impresora();
				c.setNumInventario(3);
				c.setMarca("siemens");
				initial.add(a);
				initial.add(b);
				initial.add(c);
				ImpresoraDAO dao = new ImpresoraDAO();
				VentanaDualList<Impresora> inst;
				try {
					inst = new VentanaDualList<Impresora>(dao, initial);
					inst.setLocationRelativeTo(null);
					inst.setVisible(true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
