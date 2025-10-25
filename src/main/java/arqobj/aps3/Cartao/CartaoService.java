package arqobj.aps3.Cartao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import arqobj.aps3.Cartao.dto.*;


@Service
public class CartaoService {

  @Autowired
  private CartaoRepository cartaoRepository;

  public CreatedCartaoDTO criarCartao(Cartao cartao) {
    Cartao cartaoCriado = cartaoRepository.save(cartao);

    return CreatedCartaoDTO.toDto(cartaoCriado);
  }

  public List<ResponseCartaoDTO> getCartoes() {
    return cartaoRepository.findAll().stream().map(cartao -> ResponseCartaoDTO.toDto(cartao)).toList();
  }

  public List<ResponseCartaoDTO> getCartoesByNumeroConta(Integer numeroConta) {
    return cartaoRepository.findByContaCorrente_Numero(numeroConta).stream().map(cartao -> ResponseCartaoDTO.toDto(cartao)).toList();
  }

  public Cartao cancelarCartao(Integer numeroCartao) {
    Cartao cartaoParaCancelar = cartaoRepository.findById(numeroCartao).get();

    if (cartaoParaCancelar == null) {
      throw new IllegalArgumentException("cartao nao encontrado");
    }

    cartaoParaCancelar.cancelarCartao();
    return cartaoRepository.save(cartaoParaCancelar);
  }

  public String verificarCartao(Integer numeroCartao) {
    Cartao cartaoParaVerificar = cartaoRepository.findById(numeroCartao).get();

    if (cartaoParaVerificar == null) {
      throw new IllegalArgumentException("cartao nao encontrado");
    }

    return cartaoParaVerificar.getStatus();
  }
}
