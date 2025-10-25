package arqobj.aps3.Cliente;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import arqobj.aps3.Cliente.dto.ResponseClienteDTO;

@Service
public class ClienteService {

  @Autowired
  private ClienteRepository clienteRepository;


  public ResponseClienteDTO criarCliente(Cliente cliente) {
    Cliente clienteCriado =  clienteRepository.save(cliente);
    return ResponseClienteDTO.toDto(clienteCriado);

  }

  public List<ResponseClienteDTO> getClientes() {
    return clienteRepository.findAll().stream().map(cliente -> ResponseClienteDTO.toDto(cliente)).toList(); 
  }

  public Cliente getClienteByCpf(Integer cpf) {
    return clienteRepository.findById(cpf).get();
  }

  public ResponseClienteDTO atualizarCliente(Integer cpf, Cliente clienteAtualizado) {

    Cliente cliente = getClienteByCpf(cpf);

    if (cliente == null) {
      throw new IllegalArgumentException("Cliente com CPF " + cpf + " não encontrado.");
    }

    cliente.setNome(clienteAtualizado.getNome());
    cliente.setCpf(clienteAtualizado.getCpf());
    cliente.setDataNascimento(clienteAtualizado.getDataNascimento());
    cliente.setSalario(clienteAtualizado.getSalario());

    Cliente atualizado = clienteRepository.save(cliente);

    return ResponseClienteDTO.toDto(atualizado);

  }

}
