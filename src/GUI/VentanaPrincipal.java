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

import GUI.DataTableModel.*;

import javax.swing.SwingUtilities;
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
								
									PanelResumen<Ordenador> v = new PanelResumen(new OrdenadorDataTableModel());
									switchPanel(v);
									setTitle("Ordenadores");
							} catch(Exception ex){
								ex.printStackTrace();
							} 
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
									PanelResumen<Impresora> v = new PanelResumen(new ImpresoraDataTableModel());
									switchPanel(v);
									setTitle("Impresoras");
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
					contactoMenu = new JMenu("contactos");
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
					aplicacionMenu = new JMenu("aplicaciones");
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
					configuracionMenu = new JMenu("configuraciones");
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
					discoMenu = new JMenu("discoes");
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
		contentPanel.add(newpanel,BorderLayout.CENTER);
		oldpanel=newpanel;
		pack();
	}

}




