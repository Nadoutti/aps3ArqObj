package arqobj.aps3.ContaCorrente;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contaCorrente")
public class ContaCorrenteController {

  @Autowired
  private ContaCorrenteService service;

  @GetMapping
  public HashMap<String, ContaCorrente> getContasCorrentes() {
    return service.getContasCorrente();
  }

  @GetMapping("/{numeroConta}")
  public ContaCorrente getContaCorrente(@PathVariable String numeroConta) {
    return service.getContaCorrente(numeroConta);
  }

  @PostMapping
  public ContaCorrente criarContaCorrente(@RequestHeader(name = "token") String token,
      @RequestBody ContaCorrente conta) {
    return service.criarContaCorrente(conta);
  }

  @PostMapping("/saque/{numeroConta}")
  public Float saque(@RequestHeader(name = "token") String token, @PathVariable String numeroConta, float valor) {
    return service.saque(numeroConta, valor);
  }

  @PostMapping("/deposito/{numeroConta}")
  public Float deposito(@RequestHeader(name = "token") String token, @PathVariable String numeroConta, float valor) {
    return service.deposito(numeroConta, valor);
  }

  @GetMapping("/movimentacoes/{numeroConta}")
  public ArrayList<Float> listaMovimentacoes(@PathVariable String numeroConta) {
    return service.listaMovimentacoes(numeroConta);
  }

}
