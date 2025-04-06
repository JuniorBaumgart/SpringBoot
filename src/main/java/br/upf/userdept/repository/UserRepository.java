package br.upf.userdept.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.upf.userdept.dto.UserDTO;

public interface UserRepository extends JpaRepository<UserDTO, Long> {
	
	public UserDTO findByEmail(String email);
	
	//montando query utilizando implementacoes prontas do Spring Data
	//pesquisa no campo name o que contem
	public List<UserDTO> findByNomeContaining(String name);
	
	//montando query utilizando JPQL
	@Query("SELECT u FROM UserDTO u WHERE u.senha =:senha ORDER BY u.id DESC")
	public List<UserDTO> findByPorSenha(@Param("senha") String senha);
	
	//montando query utilizando SQL Nativo
	@Query(nativeQuery = true, value = "select u.* from tb_user u inner join tb_department d on d.id = u.dpt_id"
	+ " where u.dpt_id =:dptId order by u.usr_nome asc")
	public List<UserDTO> findByPorDeptoId(@Param("dptId") Long dptId);
	
	@Query(nativeQuery = true, value = "select u.* from tb_user u inner join tb_cidade c on c.id = u.cdd_id"
	+ " where u.cdd_id =:cddId order by u.usr_nome asc")
	public List<UserDTO> findByPorCddId(@Param("cddId") Long cddId);
}


