package DAO;

import java.util.List;
import dominio.Empresa;

public class EmpresaDAO extends abstractDAO<Empresa> {

	@Override
	public Empresa find(Integer id) {
		return find(Empresa.class, id);
	}

	@Override
	public List<Empresa> findAll() {
		return findAll(Empresa.class);
	}

	
	
}
