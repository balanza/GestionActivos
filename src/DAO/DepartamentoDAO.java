package DAO;

import java.util.List;

import dominio.Departamento;

public class DepartamentoDAO extends abstractDAO<Departamento> {

	@Override
	public Departamento find(Integer id) {
		return find(Departamento.class, id);
	}

	@Override
	public List<Departamento> findAll() {
		return findAll(Departamento.class);
	}


}
