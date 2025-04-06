package br.upf.userdept.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.upf.userdept.dto.CidadeDTO;
import br.upf.userdept.dto.UserDTO;
import br.upf.userdept.service.CidadeService;

@RestController
@RequestMapping(value = "/userdept/cidade")
public class CidadeController {
	
	@Autowired
	private CidadeService cidadeService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping(value = "/inserir")
	@ResponseStatus(HttpStatus.CREATED)
	public CidadeDTO inserir(@RequestBody CidadeDTO cidadeDTO,
			@RequestHeader(value = "token") String token) {
		return cidadeService.salvar(cidadeDTO);
	}
	
	@GetMapping(value = "listarTodos")
	@ResponseStatus(HttpStatus.OK)
	public List<CidadeDTO> listarTodos(@RequestHeader(value = "token") String token) {
		return cidadeService.listarTodos();
	}
	
	@GetMapping(value = "/buscarPorId")
	@ResponseStatus(HttpStatus.OK)
	public CidadeDTO buscarPorId(@RequestHeader(value = "id") Long id,
			@RequestHeader(value = "token") String token) {
		return cidadeService.buscarPorId(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
						"Cidade nao encontrada"));
	}
	
	@DeleteMapping(value = "/delete")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerCidade(@RequestHeader(value = "id") Long id,
			@RequestHeader(value = "token") String token) {
		cidadeService.buscarPorId(id)
		.map(cidade -> {
			cidadeService.removerPorId(cidade.getId());
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
				"Cidade nao encontrada."));
	}
	
	@GetMapping(value = "/buscarPorParteDescricao")
	@ResponseStatus(HttpStatus.OK)
	public List<CidadeDTO> buscarPorParteDescricao(@RequestHeader(value = "descricao") String descricao,
			@RequestHeader(value = "token") String token) {
		return cidadeService.buscarPorParteDescricao(descricao);
	}
	
	@PutMapping(value = "/atualizar")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizar(@RequestBody CidadeDTO cidade,
			@RequestHeader(value = "token") String token) {
		cidadeService.buscarPorId(cidade.getId()).map(cidadeBase -> {
			
			modelMapper.map(cidade, cidadeBase);
			cidadeService.salvar(cidadeBase);
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
				"Cidade nao encontrada."));
	}
}
