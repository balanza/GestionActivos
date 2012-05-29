package GUI;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import javax.swing.WindowConstants;
import org.jdesktop.application.Application;

import dominio.*;

import DAO.AccionDAO;
import DAO.DispositivoDAO;
import DAO.OrdenadorDAO;
import GUI.DataTableModel.*;
import GUI.components.DateReportDialog;
import GUI.components.DispositivoBajaDateReportDialog;
import GUI.components.DispositivoFinGaranciaDateReportDialog;
import GUI.components.DispositivoRenovarDateReportDialog;

import javax.swing.*;


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
public class VentanaPrincipal extends JFrame {
	private JMenuBar jMenuBar1;
	private JMenuItem ordenadoresListMenuItem;
	private JMenuItem ordenadoresAmpliacionMenuItem;
	//private JMenuItem ordenadoresInstalacionMenuItem;
	private JMenuItem dispositivosBajaMenuItem;
	private JMenuItem dispositivosReparacionMenuItem;
	private JMenuItem dispositivosCambioDestinoMenuItem;
	private JMenuItem reportBajaMenuItem;
	private JMenuItem reportRenovarMenuItem;
	private JMenuItem reportFinGaranciaMenuItem;
	private JMenuItem reportBajaMenuItem2;
	private JMenuItem reportRenovarMenuItem2;
	private JMenuItem reportFinGaranciaMenuItem2;
	private JMenu empresasMenu;
	private JMenuItem empresasListMenuItem;
	private JMenu impresorasMenu;
	private JMenuItem impresoraListMenuItem;
	private JMenu departamentoMenu;
	private JMenuItem departamentoListMenuItem;
	private JMenu contactoMenu;
	private JMenuItem contactoListMenuItem;
	private JMenu aplicacionMenu;
	private JMenuItem aplicacionListMenuItem;
	private JMenu configuracionMenu;
	private JMenuItem configuracionListMenuItem;
	private JMenu discoMenu;
	private JMenuItem discoListMenuItem;
	private JMenu osMenu;
	private JMenuItem osListMenuItem;
	private JPanel contentPanel;
	private JMenu ordenadoresMenu;


	
	public VentanaPrincipal() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				this.setLayout(new BorderLayout());
				contentPanel = new JPanel();
				getContentPane().add(contentPanel, BorderLayout.CENTER);
			}
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					ordenadoresMenu = new JMenu("Ordenadores");
					jMenuBar1.add(ordenadoresMenu);
					{
						ordenadoresListMenuItem = new JMenuItem("lista");
						ordenadoresMenu.add(ordenadoresListMenuItem);
						ordenadoresListMenuItem.setName("ordenadoresListMenu");
						ordenadoresListMenuItem.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e){
									//load a resume frame into the content panel
							try{
								
									OrdenadorPanelResumen v = new OrdenadorPanelResumen();
									switchPanel(v);
									setTitle("Ordenadores");
							} catch(Exception ex){
								ex.printStackTrace();
							} 
							}
						});
					
					}
					{
						dispositivosBajaMenuItem = new JMenuItem("baja");
						ordenadoresMenu.add(dispositivosBajaMenuItem);
						dispositivosBajaMenuItem.setName("ordenadoresBajaMenu");
						dispositivosBajaMenuItem.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e){
									//load a resume frame into the content panel
							try{
								
									AccionBajaPanelResumen  v = new AccionBajaPanelResumen(new DispositivoDAO());
									switchPanel(v);
									setTitle("Bajas de dispositivos");
							} catch(Exception ex){
								ex.printStackTrace();
							} 
							}
						});
						
					
					}
					
					{
						ordenadoresAmpliacionMenuItem = new JMenuItem("ampliacion");
						ordenadoresMenu.add(ordenadoresAmpliacionMenuItem);
						ordenadoresAmpliacionMenuItem.setName("ordenadoresAmpliacionMenu");
						ordenadoresAmpliacionMenuItem.addActionListener(new java.awt.event.ActionListener() {
							public void actionPerformed(java.awt.event.ActionEvent e){
										//load a resume frame into the content panel
								try{
									
									AccionAmpliacionPanelResumen  v = new AccionAmpliacionPanelResumen(new OrdenadorDAO());
										switchPanel(v);
										setTitle("Ampliacion de equipo de los ordenadores");
								} catch(Exception ex){
									ex.printStackTrace();
								} 
								}
							});
					
					}
					{
						dispositivosReparacionMenuItem = new JMenuItem("reparacion");
						ordenadoresMenu.add(dispositivosReparacionMenuItem);
						dispositivosReparacionMenuItem.setName("ordenadoresReparacionMenu");
						dispositivosReparacionMenuItem.addActionListener(new java.awt.event.ActionListener() {
							public void actionPerformed(java.awt.event.ActionEvent e){
										//load a resume frame into the content panel
								try{
									
									AccionReparacionPanelResumen  v = new AccionReparacionPanelResumen(new DispositivoDAO());
										switchPanel(v);
										setTitle("Reparaciones de dispositivos");
								} catch(Exception ex){
									ex.printStackTrace();
								} 
								}
							});
					
					}
					{
						dispositivosCambioDestinoMenuItem = new JMenuItem("cambio destino");
						ordenadoresMenu.add(dispositivosCambioDestinoMenuItem);
						dispositivosCambioDestinoMenuItem.setName("ordenadoresCambioDestinoMenu");
						dispositivosCambioDestinoMenuItem.addActionListener(new java.awt.event.ActionListener() {
							public void actionPerformed(java.awt.event.ActionEvent e){
										//load a resume frame into the content panel
								try{
									
									AccionCambioDestinoPanelResumen  v = new AccionCambioDestinoPanelResumen(new DispositivoDAO());
										switchPanel(v);
										setTitle("Cambio de destino de dispositivos");
								} catch(Exception ex){
									ex.printStackTrace();
								} 
								}
							});
					
					}
					{
						reportBajaMenuItem = new JMenuItem("report baja");
						ordenadoresMenu.add(reportBajaMenuItem);
						reportBajaMenuItem.setName("reportBajaMenuItem");
						final JFrame that = this;
						reportBajaMenuItem.addActionListener(new java.awt.event.ActionListener() {
							public void actionPerformed(java.awt.event.ActionEvent e){
										//load a resume frame into the content panel
								DispositivoBajaDateReportDialog dialog = new DispositivoBajaDateReportDialog(that, "Ordenador");
								dialog.setVisible(true);
							}
						});
					
					}
					{
						reportRenovarMenuItem = new JMenuItem("report renovar");
						ordenadoresMenu.add(reportRenovarMenuItem);
						reportRenovarMenuItem.setName("reportRenovarMenuItem");
						final JFrame that = this;
						reportRenovarMenuItem.addActionListener(new java.awt.event.ActionListener() {
							public void actionPerformed(java.awt.event.ActionEvent e){
										//load a resume frame into the content panel
								DispositivoRenovarDateReportDialog dialog = new DispositivoRenovarDateReportDialog(that, "Ordenador");
								dialog.setVisible(true);
							}
						});
					
					}
					{
						reportFinGaranciaMenuItem = new JMenuItem("report fin garancia");
						ordenadoresMenu.add(reportFinGaranciaMenuItem);
						reportFinGaranciaMenuItem.setName("reportFinGaranciaMenuItem");
						final JFrame that = this;
						reportFinGaranciaMenuItem.addActionListener(new java.awt.event.ActionListener() {
							public void actionPerformed(java.awt.event.ActionEvent e){
										//load a resume frame into the content panel
								DispositivoFinGaranciaDateReportDialog dialog = new DispositivoFinGaranciaDateReportDialog(that, "Ordenador");
								dialog.setVisible(true);
							}
						});
					
					}
					
				}
				
				{
					impresorasMenu = new JMenu("Impresoras");
					jMenuBar1.add(impresorasMenu);
					{
						impresoraListMenuItem = new JMenuItem("lista");
						impresorasMenu.add(impresoraListMenuItem);
						impresoraListMenuItem.setName("impresoraListMenuItem");
						impresoraListMenuItem.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e){
									//load a resume frame into the content panel
								ImpresoraPanelResumen v = new ImpresoraPanelResumen();
									switchPanel(v);
									setTitle("Impresoras");
							}
						});
				}
					
					
					{
						dispositivosBajaMenuItem = new JMenuItem("baja");
						impresorasMenu.add(dispositivosBajaMenuItem);
						dispositivosBajaMenuItem.setName("dispositivosBajaMenu");
						dispositivosBajaMenuItem.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e){
									//load a resume frame into the content panel
							try{
								
									AccionBajaPanelResumen  v = new AccionBajaPanelResumen(new DispositivoDAO());
									switchPanel(v);
									setTitle("Bajas de dispositivos");
							} catch(Exception ex){
								ex.printStackTrace();
							} 
							}
						});
						
					
					}
					
					
					{
						dispositivosReparacionMenuItem = new JMenuItem("reparacion");
						impresorasMenu.add(dispositivosReparacionMenuItem);
						dispositivosReparacionMenuItem.setName("dispositivosReparacionMenu");
						dispositivosReparacionMenuItem.addActionListener(new java.awt.event.ActionListener() {
							public void actionPerformed(java.awt.event.ActionEvent e){
										//load a resume frame into the content panel
								try{
									
									AccionReparacionPanelResumen  v = new AccionReparacionPanelResumen(new DispositivoDAO());
										switchPanel(v);
										setTitle("Reparaciones de dispositivos");
								} catch(Exception ex){
									ex.printStackTrace();
								} 
								}
							});
					
					}
					{
						dispositivosCambioDestinoMenuItem = new JMenuItem("cambio destino");
						impresorasMenu.add(dispositivosCambioDestinoMenuItem);
						dispositivosCambioDestinoMenuItem.setName("dispositivosCambioDestinoMenu");
						dispositivosCambioDestinoMenuItem.addActionListener(new java.awt.event.ActionListener() {
							public void actionPerformed(java.awt.event.ActionEvent e){
										//load a resume frame into the content panel
								try{
									
									AccionCambioDestinoPanelResumen  v = new AccionCambioDestinoPanelResumen(new DispositivoDAO());
										switchPanel(v);
										setTitle("Cambio de destino de dispositivos");
								} catch(Exception ex){
									ex.printStackTrace();
								} 
								}
							});
					
					}
					{
						reportBajaMenuItem2 = new JMenuItem("report baja");
						impresorasMenu.add(reportBajaMenuItem2);
						reportBajaMenuItem2.setName("reportBajaMenuItem2");
						final JFrame that = this;
						reportBajaMenuItem2.addActionListener(new java.awt.event.ActionListener() {
							public void actionPerformed(java.awt.event.ActionEvent e){
										//load a resume frame into the content panel
								DispositivoBajaDateReportDialog dialog = new DispositivoBajaDateReportDialog(that, "Impresora");
								dialog.setVisible(true);
							}
						});
					
					}
					{
						reportRenovarMenuItem2 = new JMenuItem("report renovar");
						impresorasMenu.add(reportRenovarMenuItem2);
						reportRenovarMenuItem2.setName("reportRenovarMenuItem2");
						final JFrame that = this;
						reportRenovarMenuItem2.addActionListener(new java.awt.event.ActionListener() {
							public void actionPerformed(java.awt.event.ActionEvent e){
										//load a resume frame into the content panel
								DispositivoRenovarDateReportDialog dialog = new DispositivoRenovarDateReportDialog(that, "Impresora");
								dialog.setVisible(true);
							}
						});
					
					}
					{
						reportFinGaranciaMenuItem2 = new JMenuItem("report fin garancia");
						impresorasMenu.add(reportFinGaranciaMenuItem2);
						reportFinGaranciaMenuItem2.setName("reportFinGaranciaMenuItem2");
						final JFrame that = this;
						reportFinGaranciaMenuItem2.addActionListener(new java.awt.event.ActionListener() {
							public void actionPerformed(java.awt.event.ActionEvent e){
										//load a resume frame into the content panel
								DispositivoFinGaranciaDateReportDialog dialog = new DispositivoFinGaranciaDateReportDialog(that, "Impresora");
								dialog.setVisible(true);
							}
						});
					
					}
				
					
				{
					empresasMenu = new JMenu("Empresas");
					jMenuBar1.add(empresasMenu);
					
					{
						empresasListMenuItem = new JMenuItem("lista");
						empresasMenu.add(empresasListMenuItem);
						empresasListMenuItem.setName("empresasListMenuItem");
						empresasListMenuItem.addActionListener(new java.awt.event.ActionListener() {
							public void actionPerformed(java.awt.event.ActionEvent e){
									//load a resume frame into the content panel
									PanelResumen<Empresa> v = new PanelResumen<Empresa>(new EmpresaDataTableModel());
									switchPanel(v);
									setTitle("Empresas");
									
							}
						});
					}
				}

				{
					departamentoMenu = new JMenu("Departamentos");
					jMenuBar1.add(departamentoMenu);
					
					{
						departamentoListMenuItem = new JMenuItem("lista");
						departamentoMenu.add(departamentoListMenuItem);
						departamentoListMenuItem.setName("departamentoListMenuItem");
						departamentoListMenuItem.addActionListener(new java.awt.event.ActionListener() {
							public void actionPerformed(java.awt.event.ActionEvent e){
									//load a resume frame into the content panel
									PanelResumen<Departamento> v = new PanelResumen<Departamento>(new DepartamentoDataTableModel());
									switchPanel(v);
									setTitle("Departamento");
									
							}
						});
					}
				}
				{
					contactoMenu = new JMenu("Contactos");
					jMenuBar1.add(contactoMenu);
					
					{
						contactoListMenuItem = new JMenuItem("lista");
						contactoMenu.add(contactoListMenuItem);
						contactoListMenuItem.setName("contactoListMenuItem");
						contactoListMenuItem.addActionListener(new java.awt.event.ActionListener() {
							public void actionPerformed(java.awt.event.ActionEvent e){
									//load a resume frame into the content panel
									PanelResumen<PersonaContacto> v = new PanelResumen<PersonaContacto>(new PersonaContactoDataTableModel());
									switchPanel(v);
									setTitle("Persona Contacto");
									
							}
						});
					}
				}
				{
					aplicacionMenu = new JMenu("Aplicaciones");
					jMenuBar1.add(aplicacionMenu);
					
					{
						aplicacionListMenuItem = new JMenuItem("lista");
						aplicacionMenu.add(aplicacionListMenuItem);
						aplicacionListMenuItem.setName("aplicacionListMenuItem");
						aplicacionListMenuItem.addActionListener(new java.awt.event.ActionListener() {
							public void actionPerformed(java.awt.event.ActionEvent e){
									//load a resume frame into the content panel
									PanelResumen<Aplicacion> v = new PanelResumen<Aplicacion>(new AplicacionDataTableModel());
									switchPanel(v);
									setTitle("Aplicacion");
									
							}
						});
					}
				}
				{
					configuracionMenu = new JMenu("Configuraciones");
					jMenuBar1.add(configuracionMenu);
					
					{
						configuracionListMenuItem = new JMenuItem("lista");
						configuracionMenu.add(configuracionListMenuItem);
						configuracionListMenuItem.setName("configuracionListMenuItem");
						configuracionListMenuItem.addActionListener(new java.awt.event.ActionListener() {
							public void actionPerformed(java.awt.event.ActionEvent e){
									//load a resume frame into the content panel
								ConfiguracionTipoPanelResumen v = new ConfiguracionTipoPanelResumen();
									switchPanel(v);
									setTitle("Configuracion");
									
							}
						});
					}
				}
				{
					discoMenu = new JMenu("Discos");
					jMenuBar1.add(discoMenu);
					
					{
						discoListMenuItem = new JMenuItem("lista");
						discoMenu.add(discoListMenuItem);
						discoListMenuItem.setName("discoListMenuItem");
						discoListMenuItem.addActionListener(new java.awt.event.ActionListener() {
							public void actionPerformed(java.awt.event.ActionEvent e){
									//load a resume frame into the content panel
								DiscoMasterPanelResumen v = new DiscoMasterPanelResumen();
									switchPanel(v);
									setTitle("disco");
									
							}
						});
					}
				}
				{
					osMenu = new JMenu("Sistemas");
					jMenuBar1.add(osMenu);
					
					{
						osListMenuItem = new JMenuItem("lista");
						osMenu.add(osListMenuItem);
						osListMenuItem.setName("osListMenuItem");
						osListMenuItem.addActionListener(new java.awt.event.ActionListener() {
							public void actionPerformed(java.awt.event.ActionEvent e){
									//load a resume frame into the content panel
									PanelResumen<SistemaOperativo> v = new PanelResumen<SistemaOperativo>(new SistemaOperativoDataTableModel());
									switchPanel(v);
									setTitle("Sistemas Operativos");
									
							}
						});
					}
				}
			}
			}
			pack();
			this.setSize(900, 400);
			Application.getInstance().getContext().getResourceMap(getClass()).injectComponents(getContentPane());
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private JPanel oldpanel = null;
	protected void switchPanel(JPanel newpanel){
		if(oldpanel != null){			
		contentPanel.remove(oldpanel);
		}
		contentPanel.setLayout(new BorderLayout());
		contentPanel.add(newpanel,BorderLayout.CENTER);
		oldpanel=newpanel;
		pack();
	}

}




