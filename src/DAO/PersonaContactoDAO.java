package DAO;

import java.util.List;

import dominio.Dispositivo;
import dominio.PersonaContacto;

public class PersonaContactoDAO extends abstractDAO<PersonaContacto> {

	@Override
	public PersonaContacto find(Integer id) {
		return find(PersonaContacto.class, id);
	}

	@Override
	public List<PersonaContacto> findAll() {
		return findAll(PersonaContacto.class);
	}

}
