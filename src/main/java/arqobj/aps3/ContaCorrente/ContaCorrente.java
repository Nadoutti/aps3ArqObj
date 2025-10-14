package arqobj.aps3.ContaCorrente;

import java.util.*;

import arqobj.aps3.Cartao.Cartao;
import arqobj.aps3.Cliente.Cliente;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class ContaCorrente {

  @Id
  private Integer numero;

  @Column(nullable = false)
  private String agencia;

  @Column(nullable = true)
  private Float saldo;
  private Float limite;

  @OneToOne
  @JoinColumn(name = "cpf_cliente")
  private Cliente cliente;

  @OneToMany(mappedBy = "contaCorrente")
  private List<Cartao> cartoes;

  @ElementCollection
  private ArrayList<Float> movimentacoes;

  public ContaCorrente() {};

  public boolean cancelarCartao(String numeroCartao) {
    for (Cartao cartao : cartoes) {
      if (cartao.getNumeroCartao().equals(numeroCartao)) {
        cartao.cancelarCartao();
        System.out.println("Cartão " + numeroCartao + " cancelado com sucesso.");
        return true;
      }
    }
    return false;
  }

  public void addCartao(Cartao cartao) {
    cartoes.add(cartao);
  }

  public Cliente getCliente() {
    return cliente;
  }

  public Float saque(Float valor) {
    if (valor <= (saldo + limite)) {
      saldo -= valor;
      movimentacoes.add(-valor);
      return saldo;
    }
    return null;
  }

  public Float deposito(Float valor) {
    saldo += valor;
    movimentacoes.add(valor);
    return saldo;
  }

  public void listaCartoes() {

    for (Cartao cartao : cartoes) {
      System.out.println(cartao.getNumeroCartao());
    }

  }

  public ArrayList<Float> listaMovimentacoes() {

    return movimentacoes;

  }

  public String getAgencia() {
    return agencia;
  }

  public void setAgencia(String agencia) {
    this.agencia = agencia;
  }

  public Integer getNumero() {
    return numero;
  }

  public void setNumero(Integer numero) {
    this.numero = numero;
  }

  public Float getSaldo() {
    return saldo;
  }

  public Float getLimite() {
    return limite;
  }

}
