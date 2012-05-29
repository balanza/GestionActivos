package GUI.components;

import javax.swing.JFrame;

import reports.DispositivoBajaReport;
import reports.abstractDateReport;

public class DispositivoBajaDateReportDialog extends DateReportDialog{
	
	private String tipo;	
	public DispositivoBajaDateReportDialog(JFrame parent,  String tipo) {
		super(parent);
		this.tipo = tipo;
	}

	@Override
	protected abstractDateReport getDateReport() {
		return new DispositivoBajaReport(dateFrom.getDate(), dateTo.getDate(), tipo);
	}

}
