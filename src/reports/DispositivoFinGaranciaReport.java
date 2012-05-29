package reports;

import java.util.Date;

public class DispositivoFinGaranciaReport extends abstractDateReport {

	public DispositivoFinGaranciaReport(Date from, Date to, String tipo) {
		super(from, to, tipo);
		this.tipo = tipo;
	}

	@Override
	protected String getFile() {
		return "./reports/dispositivoFinGarancia" + tipo + ".jasper";
	}

}
