package arqobj.aps3.ContaCorrente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ContaCorrenteService
 */
@Service
public class ContaCorrenteService {

  @Autowired
  private ContaCorrenteRepository contaCorrenteRepository;


  public ContaCorrente getContaCorrente(Integer numeroConta) {
    return contaCorrenteRepository.getByNumero(numeroConta);
  }

  public ContaCorrente criarContaCorrente(ContaCorrente conta) {
    return contaCorrenteRepository.save(conta);
  }

  public Float saque(Integer numeroConta, Float valor) {

    ContaCorrente conta = getContaCorrente(numeroConta);

    if (conta == null) {
      throw new IllegalArgumentException("Conta com número " + numeroConta + " não encontrada.");
    }

    Float restante = conta.saque(valor);
    contaCorrenteRepository.save(conta);

    return restante;
  }

  public Float deposito(Integer numeroConta, Float valor) {
    ContaCorrente conta = getContaCorrente(numeroConta);

    if (conta == null) {
      throw new IllegalArgumentException("Conta com número " + numeroConta + " não encontrada.");
    }

    Float resultado = conta.deposito(valor);

    contaCorrenteRepository.save(conta);
    return resultado;

  }

  public List<Float> listaMovimentacoes(Integer numeroConta) {
    ContaCorrente conta = getContaCorrente(numeroConta);

    if (conta == null) {
      throw new IllegalArgumentException("Conta com número " + numeroConta + " não encontrada.");
    }

    return conta.listaMovimentacoes();
  }

  public List<ContaCorrente> getContasCorrente() {
    return contaCorrenteRepository.findAll();
  }
}
