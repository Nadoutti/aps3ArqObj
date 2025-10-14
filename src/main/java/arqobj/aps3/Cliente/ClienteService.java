package arqobj.aps3.Cliente;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

  @Autowired
  private ClienteRepository clienteRepository;


  public Cliente criarCliente(Cliente cliente) {
    return clienteRepository.save(cliente);

  }

  public List<Cliente> getClientes() {
    return clienteRepository.findAll(); 
  }

  public Cliente getClienteByCpf(Integer cpf) {
    return clienteRepository.findById(cpf).get();
  }

  public Cliente atualizarCliente(Integer cpf, Cliente clienteAtualizado) {

    Cliente cliente = getClienteByCpf(cpf);

    if (cliente == null) {
      throw new IllegalArgumentException("Cliente com CPF " + cpf + " não encontrado.");
    }

    cliente.setNome(clienteAtualizado.getNome());
    cliente.setCpf(clienteAtualizado.getCpf());
    cliente.setDataNascimento(clienteAtualizado.getDataNascimento());
    cliente.setSalario(clienteAtualizado.getSalario());

    clienteRepository.save(cliente);

    return cliente;
  }

}
