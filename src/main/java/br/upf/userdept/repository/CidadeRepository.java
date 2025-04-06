package br.upf.userdept.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.upf.userdept.dto.CidadeDTO;

public interface CidadeRepository extends JpaRepository<CidadeDTO, Long> {
	
	//JPQL
	@Query("Select c FROM CidadeDTO c WHERE c.uf =:uf ORDER BY c.id DESC")
	public List<CidadeDTO> findByUf(@Param("uf") String uf);
	
	//NativeQuery
	@Query(nativeQuery = true, value = "SELECT * FROM tb_cidade WHERE cdd_descricao ILIKE %:descricao%")
	public List<CidadeDTO> findByDescricaoContaining(@Param("descricao") String descricao);

	
}
