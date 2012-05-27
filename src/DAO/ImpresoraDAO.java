package DAO;

import java.util.List;

import dominio.*;

public class ImpresoraDAO extends DispositivoDAO<Impresora> {

	@Override
	public Impresora find(Integer id) {
		return find(Impresora.class, id);
	}

	@Override
	public List<Impresora> findAll() {
		return findAll(Impresora.class);
	}
	
}
