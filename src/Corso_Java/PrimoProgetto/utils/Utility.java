package Corso_Java.PrimoProgetto.utils;

import Corso_Java.PrimoProgetto.model.Persona;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Utility {

	// metodo static che calcola l'et� della Persona 

	
			public static int getEta(LocalDate dataDiNascita)
			{
				
				return Period.between(dataDiNascita,LocalDate.now()).getYears();
				
			}
			
			
			public static String getData(LocalDate dataDiNascita)
			{
				DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
				return dataDiNascita.format(formatter);
				
			}

			//Prende in input la tupla del database e restituisce l'oggetto costruito di tipo Persona
			public static Persona getPersonaFromRawData(ResultSet rs) throws SQLException {
				Persona p = new Persona();
				p.setId(rs.getInt("ID"));
				p.setNome(rs.getString("nome"));
				p.setCognome(rs.getString("cognome"));
				p.setDataDiNascita(rs.getDate("DATA_DI_NASCITA").toLocalDate());
				p.setCf(rs.getString("cf"));

				return p;
			}

			//Prende in input la persona e la trasforma in una tupla del database
			public static void getRawDataFromPersona(Persona p, PreparedStatement ps) throws SQLException {
				ps.setString(1,p.getNome());
				ps.setString(2,p.getCognome());
				ps.setDate(3, Date.valueOf(p.getDataDiNascita()));
				ps.setString(4,p.getCf());
			}
	
	
}
