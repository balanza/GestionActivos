package GUI.components;

import javax.swing.JFrame;

import reports.DispositivoBajaReport;
import reports.DispositivoFinGaranciaReport;
import reports.abstractDateReport;

public class DispositivoFinGaranciaDateReportDialog extends DateReportDialog{
	private String tipo;
	public DispositivoFinGaranciaDateReportDialog(JFrame parent, String tipo) {
		super(parent);
	}

	@Override
	protected abstractDateReport getDateReport() {
		return new DispositivoFinGaranciaReport(dateFrom.getDate(), dateTo.getDate(), tipo);
	}

}
