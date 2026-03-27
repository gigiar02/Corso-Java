package Corso_Java.PrimoProgetto.model;

import java.time.LocalDate;
import java.util.Objects;

import Corso_Java.PrimoProgetto.utils.Utility;

public class Persona {

	private Integer id;
	private String nome;
	private String cognome;
	private LocalDate dataDiNascita;
	private String cf;
		
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}
	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}
	public String getCf() {
		return cf;
	}
	public void setCf(String cf) {
		this.cf = cf;
	}
	
	@Override
	public String toString() {
				
		return "id=" + id + ",nome=" + nome + ", cognome=" + cognome + ", dataDiNascita=" + Utility.getData(dataDiNascita) + ", et�: "+Utility.getEta(dataDiNascita)+", cf=" + cf;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cf, cognome, dataDiNascita, id, nome);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(cf, other.cf) && Objects.equals(cognome, other.cognome)
				&& Objects.equals(dataDiNascita, other.dataDiNascita) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome);
	}
	
	public Persona(Integer id, String nome, String cognome, LocalDate dataDiNascita, String cf) {
		
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.cf = cf;
	}
	
	public Persona() {
		
	}
	
	
}
