package reports;

import java.util.Date;

public class DispositivoRenovarReport extends abstractDateReport {

	public DispositivoRenovarReport(Date to, String tipo) {
		super(null, to, tipo);
		this.tipo = tipo;
	}

	@Override
	protected String getFile() {
		return "./reports/dispositivoRenovar" + tipo +".jasper";
	}

}
