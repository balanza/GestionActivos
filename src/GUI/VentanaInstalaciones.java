package GUI;
import GUI.DataTableModel.SortedListModel;
import GUI.components.*;
import java.util.*;

import javax.swing.JDialog;
import javax.swing.JFrame;

import DAO.AplicacionDAO;
import dominio.*;

public class VentanaInstalaciones extends JFrame {

	private Ordenador ordenador;	
	private DualListBox dualList;
	

	
	public VentanaInstalaciones(Ordenador ordenador){
		super();
		this.ordenador = ordenador;
		initGUI();
	}
	
	private void initGUI() {
		
		dualList = new DualListBox();
		
		dualList.setDestinationChoicesTitle("destinacion");
		SortedListModel destinationModel = new SortedListModel();
		for(Object o: ordenador.getAplicaciones()){
			destinationModel.add(o);
		}
		dualList.setDestinationElements(destinationModel);
		
		
		dualList.setSourceChoicesTitle("Source");
		SortedListModel sourceModel = new SortedListModel();
		AplicacionDAO dao = new AplicacionDAO();
		for(Object o: dao.findAll()){
			if(destinationModel.contains(o)){
				sourceModel.add(o);	
			}
		}
		dualList.setSourceElements(sourceModel);
		
		
		

		
	}
	
	
	
	
	
}
