package GUI.components;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;

import net.sf.jasperreports.engine.JRException;

import org.hibernate.service.jta.platform.internal.JBossAppServerJtaPlatform;

import reports.DispositivoBajaReport;
import reports.abstractDateReport;

import GUI.PanelResumen;
import GUI.DataTableModel.SistemaOperativoDataTableModel;

import com.toedter.calendar.JDateChooser;

import dominio.SistemaOperativo;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public abstract class  DateReportDialog extends JDialog implements ActionListener {
	
	protected JDateChooser dateFrom;
	protected JDateChooser dateTo;
	private JButton btn;
	
	private JSpinner jSpinner1;

	public DateReportDialog(JFrame parent){
		super(parent, "report", true);
		 if (parent != null) {
		      Dimension parentSize = parent.getSize(); 
		      Point p = parent.getLocation(); 
		      setLocation(p.x + parentSize.width / 4, p.y + parentSize.height / 4);
		      setSize(parentSize);
		    }

			initGUI();
		//setVisible(true);
	}
	
	private void initGUI() {
		try {
			{
				
				dateFrom = new JDateChooser();
				dateTo = new JDateChooser();
				btn = new JButton("Abre Report");
				btn.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e){
						abstractDateReport report= getDateReport();
							//DispositivoBajaReport report = new DispositivoBajaReport(dateFrom.getDate(), dateTo.getDate());
							try {
								report.showReport();
							} catch (JRException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
					}
				});

				getContentPane().add(dateFrom, BorderLayout.NORTH);
				getContentPane().add(dateTo, BorderLayout.CENTER);
				getContentPane().add(btn, BorderLayout.SOUTH);
				btn.addActionListener(this);
				pack();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	protected abstract abstractDateReport getDateReport();
	
	  public void actionPerformed(ActionEvent e) {
		    setVisible(false); 
		    dispose(); 
		  }

}
