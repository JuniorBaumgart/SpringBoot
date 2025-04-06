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

import br.upf.userdept.dto.DepartmentDTO;
import br.upf.userdept.service.DepartmentService;

@RestController
@RequestMapping(value = "/userdept/department")

public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping(value = "/inserir")
	@ResponseStatus(HttpStatus.CREATED)
	public DepartmentDTO inserir(@RequestBody DepartmentDTO departmentDTO,
			@RequestHeader(value = "token")String token) {
		return departmentService.salvar(departmentDTO);
	}
	
	@GetMapping(value = "listarTodos")
	@ResponseStatus(HttpStatus.OK)
	public List<DepartmentDTO> listarTodos(@RequestHeader(value = "token")String token) {
		return departmentService.listarTodos();
	}
	
	@GetMapping(value = "/buscarPorId")
	@ResponseStatus(HttpStatus.OK)
	public DepartmentDTO buscarPorId(@RequestHeader(value = "id") Long id,
			@RequestHeader(value = "token")String token) {
		return departmentService.buscarPorId(id)
				//caso cliente nao foi encontrado:
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
						"Department nao encontrado."));
	}
	
	@DeleteMapping(value = "/delete")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerUsuario(@RequestHeader(value = "id") Long id,
			@RequestHeader(value = "token")String token) {
		departmentService.buscarPorId(id) //antes de deletar, busca na base
		.map(department -> { //definindo a variavel no map
			departmentService.removerPorId(department.getId()); //caso encontre usuario
			return Void.TYPE;
			//caso nao encontre, retorna o status
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
				"Usuario nao encontrado."));
		}

//para implementar o atualizar, eh necessario incluir o metodo bean modelMapper()
//na classe UserdeptApplication.java
@PutMapping(value = "/atualizar")
@ResponseStatus(HttpStatus.NO_CONTENT)
public void atualizar(@RequestBody DepartmentDTO departmentDTO,
		@RequestHeader(value = "token")String token) {
	departmentService.buscarPorId(departmentDTO.getId()).map(departmentBase ->{ //definindo recurso do modelMap que verifica o que esta no parametro
																				//para atualizar na base
		modelMapper.map(departmentDTO,  departmentBase);
		departmentService.salvar(departmentBase); //salvar itens alterados
		return Void.TYPE;
	}).orElseThrow(() ->new ResponseStatusException(HttpStatus.BAD_REQUEST,
			"Usuario nao encontrado."));
	}
}
