package Corso_Java.PrimoProgetto.service;

import java.sql.SQLException;
import java.util.List;

import Corso_Java.PrimoProgetto.model.Persona;
import Corso_Java.PrimoProgetto.model.RepositoryCrud;

public class ServiceCrud {

	RepositoryCrud repo=new RepositoryCrud();


	public int insert(Persona p) {

		int record=0;

		try {
			record=repo.insert(p);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return record;

	}
	
	
	public List<Persona> selectAll()
	{
		List<Persona> list=null;
		try {
			list= repo.findAll();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
		
	}

	public  Persona findByID(int id) throws SQLException {
		return repo.findByID(id);
	}


	public Persona findByCf(String cf) throws SQLException {
		return repo.findByCf(cf);
	}

	public int delete(Persona p) throws SQLException {
		return repo.delete(p);
	}

	public int update(Persona p, Persona pNew) throws SQLException {
		return repo.update(p,pNew);
	}
}
