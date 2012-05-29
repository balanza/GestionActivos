package reports;

import persistence.DBConnector;

import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public abstract class abstractDateReport {
	
	private Date dateFrom;
	private Date dateTo;
	public String tipo;
	
	public abstractDateReport(Date from, Date to, String tipo){
		dateFrom = from;
		dateTo = to;
		this.tipo = tipo;
	}
	
	public void showReport() throws JRException{
		HashMap parametros = new HashMap();
		
		parametros.put("DATE_FROM", dateFrom);
		parametros.put("DATE_TO", dateTo);
		parametros.put("TIPO", tipo);


		Connection connection = DBConnector.getConnection();

		String fileName= getFile();
		JasperPrint informe= JasperFillManager.fillReport(fileName,parametros, connection);
		JasperViewer.viewReport(informe, false);		
	}
	
	protected abstract String getFile(); 

}
