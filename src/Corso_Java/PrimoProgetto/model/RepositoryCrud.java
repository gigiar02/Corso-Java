package Corso_Java.PrimoProgetto.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Corso_Java.PrimoProgetto.utils.Connessione;
import Corso_Java.PrimoProgetto.utils.Utility;

public class RepositoryCrud {
	
	private PreparedStatement ps;
	private Connection conn= Connessione.getConnection();
	private ResultSet rs;
	Persona p;
	List<Persona> list; 
	
	
	public int insert(Persona p) throws SQLException
	{
		String sql="insert into persona(nome,cognome,data_di_nascita,cf) values(?,?,?,?)";
		
		//conn.setAutoCommit(false); // disattiviamo l'auto commit
			
			ps=conn.prepareStatement(sql);
			Utility.getRawDataFromPersona(p,ps);
		
			
		return ps.executeUpdate();
	}
	
	
	
	public List<Persona> findAll() throws SQLException
	{
		list=new ArrayList<Persona>();
		String sql="select * from persona";
		
		ps=conn.prepareStatement(sql);
		
		rs=ps.executeQuery(); //DQL
		
		while (rs.next()) {
			p= Utility.getPersonaFromRawData(rs);
			list.add(p);
		}
		
		return list;
		
	}

	//Ricerca una persona attraverso codice fiscale
	public Persona findByCf(String cf) throws SQLException {
		String query = "SELECT * FROM PERSONA WHERE" + cf  + " = P.CF";
		ps = conn.prepareStatement(query);
		rs = ps.executeQuery();

		if(rs == null){ return null;}
		return Utility.getPersonaFromRawData(rs);

	}

	//Ricerca una persona attraverso ID
	public Persona findByID(int ID) throws SQLException {
		String query = "SELECT * FROM PERSONA WHERE" + " " + ID  + " = ID";
		ps = conn.prepareStatement(query);
		rs = ps.executeQuery();
		if(rs == null){ return null;}
		rs.next();
		System.out.println(rs.getInt("id"));
		return Utility.getPersonaFromRawData(rs);

	}

	public int update(Persona p, Persona pNew) throws SQLException {
		String update = "UPDATE persona SET nome = ?, cognome = ?, data_Di_Nascita = ?, cf = ?  WHERE id = " + p.getId();
		ps = conn.prepareStatement(update);
		Utility.getRawDataFromPersona(pNew,ps);
		return ps.executeUpdate();
	}


	public int delete(Persona p) throws SQLException {
		String update = "DELETE FROM  PERSONA WHERE ID = " + p.getId();
		ps = conn.prepareStatement(update);
		return ps.executeUpdate();
	}
}
