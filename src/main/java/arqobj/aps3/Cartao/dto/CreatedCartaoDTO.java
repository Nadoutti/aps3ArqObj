package arqobj.aps3.Cartao.dto;

import arqobj.aps3.Cartao.Cartao;

public record CreatedCartaoDTO(Integer numeroCartao, String status, String tipo) {

  public static CreatedCartaoDTO toDto(Cartao cartao) {
    return new CreatedCartaoDTO(
      cartao.getNumeroCartao(),
      cartao.getStatus(),
      cartao.getTipo()
    );
  };
}
