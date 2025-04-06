package br.upf.userdept.dto;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;	


@Entity //definindo que é uma classe tipo entidade
@Table(name = "tb_department") //mapeando a tabela
public class DepartmentDTO {

	@Id //definindo a chave primária
	//definindo a geração automática do valor da chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "dpt_nome", nullable = false)
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "DepartmentDTO [nome=" + nome + "]";
	}

	public DepartmentDTO() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DepartmentDTO other = (DepartmentDTO) obj;
		return Objects.equals(id, other.id);
	}	
	
	
}

