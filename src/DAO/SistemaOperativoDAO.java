package DAO;

import java.util.List;
import dominio.*;

public class SistemaOperativoDAO extends abstractDAO<SistemaOperativo> {

	@Override
	public SistemaOperativo find(Integer id) {
		return find(SistemaOperativo.class, id);
	}

	@Override
	public List<SistemaOperativo> findAll() {
		return findAll(SistemaOperativo.class);
	}

}
