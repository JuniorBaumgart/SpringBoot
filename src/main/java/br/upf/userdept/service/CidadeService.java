package br.upf.userdept.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.upf.userdept.dto.CidadeDTO;
import br.upf.userdept.repository.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public CidadeDTO salvar(CidadeDTO dto) {
		return cidadeRepository.save(dto);
	}
	
	public List<CidadeDTO> listarTodos() {
		return cidadeRepository.findAll();
	}
	
	public Optional<CidadeDTO> buscarPorId(Long id) {
		return cidadeRepository.findById(id);
	}
	
	public void removerPorId(Long id) {
		cidadeRepository.deleteById(id);
	}
	
	public List<CidadeDTO> buscarPorParteDescricao(String descricao) {
		return cidadeRepository.findByDescricaoContaining(descricao);
	}
	
	public List<CidadeDTO> buscarPorUf(String uf) {
		return cidadeRepository.findByUf(uf);
	}
}
