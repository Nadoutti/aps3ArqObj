package arqobj.aps3.ContaCorrente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import arqobj.aps3.ContaCorrente.dto.ContaCorrenteResponseDTO;

/**
 * ContaCorrenteService
 */
@Service
public class ContaCorrenteService {

  @Autowired
  private ContaCorrenteRepository contaCorrenteRepository;

  public ContaCorrenteResponseDTO getContaCorrenteDTO(Integer numeroConta) {
    ContaCorrente conta = contaCorrenteRepository.getByNumero(numeroConta);
    return ContaCorrenteResponseDTO.toDto(conta);
  }

  public ContaCorrente getContaCorrente(Integer numeroConta) {
    return contaCorrenteRepository.getByNumero(numeroConta);
  }

  public ContaCorrenteResponseDTO criarContaCorrente(ContaCorrente conta) {
    ContaCorrente contaCriada = contaCorrenteRepository.save(conta);
    return ContaCorrenteResponseDTO.toDto(contaCriada);
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

  public List<ContaCorrenteResponseDTO> getContasCorrente() {
    return contaCorrenteRepository.findAll().stream().map(conta -> ContaCorrenteResponseDTO.toDto(conta)).toList();
  }
}
