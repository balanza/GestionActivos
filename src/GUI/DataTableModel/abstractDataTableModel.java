package GUI.DataTableModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.*;

import persistence.IEntity;


import DAO.EmpresaDAO;
import DAO.abstractDAO;
import dominio.Empresa;

public abstract class abstractDataTableModel<T> extends DefaultTableModel implements TableModelListener {
	
	protected abstractDAO dao;
	protected ArrayList<Integer> dirtyRows = new ArrayList<Integer>();
	private boolean fireChangeEvent = false;
	

	public abstractDataTableModel(String[] columnNames) {
		super(null, columnNames);	
		this.addTableModelListener(this);
		fireChangeEvent = true;
		
	}

	
	public boolean isValid(T record){
		return true;
	}
	
	public void refresh(){
		fireChangeEvent = false;
		List<T> l = (List<T>) dao.findAll();
		clear();
		for(T e : l){
			try {
				this.add(e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}		
		fireChangeEvent = true;
		cleanAllRow(); //fresh data
	} 
	
	
	public void appendEmptyRow(){
		fireChangeEvent = false;
		addRow(getEmptyRow());
	//	insertRow(getRowCount(), getEmptyRow());
		fireChangeEvent = true;
	}
	
	public void saveRow(int row){
		T record = getByRowIndex(row);
		
		if(isValid(record)){
			if(((IEntity)record).getId() == 0){
				dao.create(record);
				setValueAt(((IEntity)record).getId(), row, 0);
			}else{
				dao.update(record);
			}
			cleanRow(row);	
		}
		
	}
	
	
	public void saveAllRow(){
		
		for(int i=0; i<this.getRowCount(); i++){
			
			saveRow(i);		
		}
		cleanAllRow();
		
	}
	
	
	@Override
	public Class getColumnClass(int c) {
		try{
	        return getValueAt(0, c).getClass();
		} catch(Exception ignore){
			return super.getColumnClass(c);
		}
    }
	
	@Override
	public boolean isCellEditable(int row, int cell){
		return cell!=0;
	}
	
	public void clear(){
		while (getRowCount()>0){
			removeRow(0);
		}		
	}
	
	public Integer getIdentityValue(int row){

		int id = (Integer)this.getValueAt(row, 0); 
		return id;
	}
	
	public abstract void add(T e) throws Exception;
	
	public void deleteByRowIndex(int row){
		int id = getIdentityValue(row);
		dao.delete(id);
		this.removeRow(row);		
	}
	
	@Override 
	public void removeRow(int row){
		super.removeRow(row);
	}
	
	public void removeByIdentityValue(int id){
		
		int row = 0;
		int count = this.getRowCount();
		while(row < count){
			int _id = (Integer)this.getValueAt(row, 0); 
			if(_id == id){
				
				this.removeRow(row);
			}
			row++;
		}
				
	}
	
	public int getRowByIdentityValue(int id){
		
		int row = 0;
		int count = this.getRowCount();
		while(row < count){
			int _id = (Integer)this.getValueAt(row, 0); 
			if(_id == id){
				return row;
			}
			row++;
		}
		
		return -1;
				
	}
	
	public abstract T getByRowIndex(int index);
	
	

	public void setDirtyRow(int id){
		if(!isDirty(id)){
			dirtyRows.add(id);
			//TODO: row appearance
		}
	}
	
	public void setDirtyColumn(int id, int col){
		//TODO: column appearance
		setDirtyRow(id);		
	}
	
	public void cleanRow(int id){
		if(isDirty(id)){
			dirtyRows.remove(dirtyRows.indexOf(id));
			//TODO: row appearance
			//TODO: column appearance
		}
	}
	
	public void cleanAllRow(){
		dirtyRows =  new ArrayList<Integer>();
	}
	
	public boolean isDirty(int id){
		return dirtyRows.contains(id);
	}
	
	public Vector<Comparable> getEmptyRow(){
		Vector<Comparable> row = new Vector<Comparable>();
		for(int i=0; i<getColumnCount(); i++){
			row.add((Comparable) null);
		}
		return row;
	}


	@Override
	public void tableChanged(TableModelEvent e) {
		if(fireChangeEvent){
			
	        int row = e.getFirstRow();
	        int column = e.getColumn();
	        
	        //TODO: gestire le nuove righe
	        try{
		        int id = (Integer)getValueAt(row, 0);
		       // setDirtyColumn(id, column);
	        } catch(Exception ignore){}
	        
	        /*
	        TableModel model = (TableModel)e.getSource();
	        String columnName = model.getColumnName(column);
	        Object data = model.getValueAt(row, column);
	        */
		
		}
	}
}
