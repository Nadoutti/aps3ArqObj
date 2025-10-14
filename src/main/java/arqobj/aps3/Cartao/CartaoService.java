package arqobj.aps3.Cartao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CartaoService {

  @Autowired
  private CartaoRepository cartaoRepository;

  public Cartao criarCartao(Cartao cartao) {
    return cartaoRepository.save(cartao);
  }

  public List<Cartao> getCartoes() {
    return cartaoRepository.findAll();
  }

  public List<Cartao> getCartoesByNumeroConta(Integer numeroConta) {
    return cartaoRepository.findByContaCorrente_Numero(numeroConta);
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
