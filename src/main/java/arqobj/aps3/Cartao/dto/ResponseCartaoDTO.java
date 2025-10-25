package arqobj.aps3.Cartao.dto;

import arqobj.aps3.Cartao.Cartao;

public record ResponseCartaoDTO(String status, String tipo) {

  public static ResponseCartaoDTO toDto(Cartao cartao) {
    return new ResponseCartaoDTO(cartao.getStatus(), cartao.getTipo());
  }
}
