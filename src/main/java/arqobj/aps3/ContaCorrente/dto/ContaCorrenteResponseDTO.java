package arqobj.aps3.ContaCorrente.dto;

import arqobj.aps3.ContaCorrente.ContaCorrente;

public record ContaCorrenteResponseDTO(Float saldo, Float limite) {

  public static ContaCorrenteResponseDTO toDto(ContaCorrente contaCorrente) {

    return new ContaCorrenteResponseDTO(contaCorrente.getSaldo(), contaCorrente.getLimite());
  }
}
