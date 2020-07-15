package com.boaglio.casadocodigo.mongodb;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "seriados")
public class Seriado implements Serializable {

	private static final long serialVersionUID = -2944144005656142035L;

	@Id
	private String id;

	private String nome;
	private List<String> personagens;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<String> getPersonagens() {
		return personagens;
	}

	public void setPersonagens(List<String> personagens) {
		this.personagens = personagens;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (nome == null ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) { return true; }
		if (obj == null) { return false; }
		if (getClass() != obj.getClass()) { return false; }
		Seriado other = (Seriado) obj;
		if (nome == null) {
			if (other.nome != null) { return false; }
		} else if (!nome.equals(other.nome)) { return false; }
		return true;
	}

	@Override
	public String toString() {
		return "Seriado [id=" + id + ", nome=" + nome + ", personagens=" + personagens + "]";
	}

}
