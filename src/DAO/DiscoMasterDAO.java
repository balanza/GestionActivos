package DAO;

import java.util.List;
import dominio.*;

public class DiscoMasterDAO extends abstractDAO<DiscoMaster> {

	@Override
	public DiscoMaster find(Integer id) {
		return find(DiscoMaster.class, id);
	}

	@Override
	public List<DiscoMaster> findAll() {
		return findAll(DiscoMaster.class);
	}

}
