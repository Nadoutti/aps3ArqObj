package arqobj.aps3.Cliente.dto;

import java.time.LocalDate;

import arqobj.aps3.Cliente.Cliente;
import arqobj.aps3.ContaCorrente.ContaCorrente;

public record ResponseClienteDTO(String nome, LocalDate dataNascimento, ContaCorrente contaCorrente) {

  public static ResponseClienteDTO toDto(Cliente cliente) {
    
    return new ResponseClienteDTO(cliente.getNome(), cliente.getDataNascimento(), cliente.getContaCorrente());
  }
}
