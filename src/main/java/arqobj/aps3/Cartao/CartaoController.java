package arqobj.aps3.Cartao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cartao")
public class CartaoController {

  @Autowired
  private CartaoService cartaoService;

  @PostMapping
  public Cartao criarCartao(@RequestHeader(name = "token") String token, @RequestBody Cartao cartao) {
    return cartaoService.criarCartao(cartao);
  }

  @GetMapping("/all")
  public Object getCartoes() {
    return cartaoService.getCartoes();
  }

  @GetMapping("/all/{numeroConta}")
  public ArrayList<Cartao> getCartoesByNumeroConta(@PathVariable String numeroConta) {
    return cartaoService.getCartoesByNumeroConta(numeroConta);
  }

  @PostMapping("cancelar/{numeroCartao}")
  public Cartao cancelarCartao(@RequestHeader(name = "token") String token, @PathVariable String numeroCartao) {
    return cartaoService.cancelarCartao(numeroCartao);

  }

  @GetMapping("verificar/{numeroCartao}")
  public String verificarAtivo(@PathVariable String numeroCartao) {
    return cartaoService.verificarCartao(numeroCartao);

  }

}
