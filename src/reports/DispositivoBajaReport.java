package reports;

import java.util.Date;

public class DispositivoBajaReport extends abstractDateReport {

	public DispositivoBajaReport(Date from, Date to, String tipo) {
		super(from, to, tipo);
		this.tipo = tipo;
	}

	@Override
	protected String getFile() {
		return "./reports/dispositivoBaja" + tipo + ".jasper";
	}

}
