package GUI.components;

import javax.swing.JFrame;

import reports.DispositivoBajaReport;
import reports.DispositivoRenovarReport;
import reports.abstractDateReport;

public class DispositivoRenovarDateReportDialog extends DateReportDialog{
	private String tipo;
	public DispositivoRenovarDateReportDialog(JFrame parent, String tipo) {
		super(parent);
		this.tipo = tipo;
		this.dateFrom.setVisible(false);
	}

	@Override
	protected abstractDateReport getDateReport() {
		return new DispositivoRenovarReport(dateTo.getDate(), tipo);
	}

}
