package br.upf.userdept.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.upf.userdept.dto.UserDTO;
import br.upf.userdept.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	//Metodo serve para salvar ou atualizar um objeto
	//@param dto
	//@return
	public UserDTO salvar(UserDTO dto) {
		return userRepository.save(dto);
	}
	
	public List<UserDTO> listarTodos() {
		return userRepository.findAll();
	}
	
	public Optional<UserDTO> buscarPorId(Long id) {
		return userRepository.findById(id);
	}
	
	public void removerPorId(Long id) {
		userRepository.deleteById(id);
	}
	
	public List<UserDTO> buscarPorParteNome(String nome) {
		return userRepository.findByNomeContaining(nome);
	}
	
	public UserDTO buscarPorEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public List<UserDTO> buscarPorSenha (String senha) {
		return userRepository.findByPorSenha(senha);
	}
	
	public List<UserDTO> buscarPorDeptoId(Long deptoId) {
		return userRepository.findByPorDeptoId(deptoId);
	}
	
	public List<UserDTO> buscarPorCddId(Long cddId) {
		return userRepository.findByPorCddId(cddId);
	}

}
