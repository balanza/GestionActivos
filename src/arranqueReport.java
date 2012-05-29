import java.sql.Connection;
import java.util.HashMap;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.query.JRHibernateQueryExecuterFactory;
import net.sf.jasperreports.view.JasperViewer;

import org.hibernate.Session;
import org.hsqldb.auth.HsqldbSlaveAuthBean;

import persistence.*;


public class arranqueReport {

	/**
	 * @param args
	 * @throws JRException 
	 */
	public static void main(String[] args) throws JRException {

Session sesion= UtilityHibernate.getSessionFactory().openSession();
UtilityHibernate.getSessionFactory().openSession();
HashMap parametros = new HashMap();



Connection connection = DBConnector.getConnection();

String fileName= "reports/dispositivoRenovar.jasper";
JasperPrint informe= JasperFillManager.fillReport(fileName,parametros, connection);
JasperViewer.viewReport(informe, false);

	}

}
