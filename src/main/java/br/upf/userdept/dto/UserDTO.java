package br.upf.userdept.dto;

import java.util.Date;
import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "tb_user")	
public class UserDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "usr_nome", nullable = false)
	private String nome;
	
	//esse campo é único no banco...
	@Column(name = "usr_email", nullable = false, unique=true)
	private String email;
	
	@Column(name = "usr_senha", nullable = false)
	private String senha;
	
	@Column(name = "usr_nascimento")
	private Date dataNascimento;
	
	@Transient //atributo nao sera persistido
	private String token;
	
	@ManyToOne //definindo a relação muitos-para-um
	@JoinColumn(name = "dpt_id")
	private DepartmentDTO department;
	
	@ManyToOne //definindo a relação muitos-para-um
	@JoinColumn(name = "cdd_id")
	private CidadeDTO cidade;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public DepartmentDTO getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentDTO department) {
		this.department = department;
	}
	
	public CidadeDTO getCidade() {
		return cidade;
	}

	public void setCidade(CidadeDTO cidade) {
		this.cidade = cidade;
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
		UserDTO other = (UserDTO) obj;
		return Objects.equals(id, other.id);
	}

	public UserDTO() {
		super();
	}

	@Override
	public String toString() {
		return "UserDTO [nome=" + nome + "]";
	}
	
	
	

	
	
	
}

