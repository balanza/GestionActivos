package GUI.DataTableModel;

import java.util.*;
import org.apache.commons.lang3.*;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.hsqldb.lib.ArrayUtil;

import dominio.*;
import DAO.*;
import GUI.components.EntitySingleSelectorCellEditor;


public abstract class DispositivoDataTableModel<T> extends abstractDataTableModel<T>{

	public DispositivoDataTableModel(String[] columnNames) {
		super(ArrayUtils.addAll(  new String[]{"NUM INVENTARIO"
				, "MARCA"
				, "MODELO"
				, "NUM SERIE"
				, "EMPRESA"
				, "DEPARTAMENTO"
				, "CONTACTO"
				, "FECHA INSTALACION"
				, "FECHA FIN GARANTIA"
				, "FECHA COMPRA"
				, "PRECIO"
				, "FECHA BAJA"
				, "IP"
				, "OBSERVACIONES"
				, "PRIORIDAD"}, columnNames));
		
	
	}
	

	

	




	
	
}
