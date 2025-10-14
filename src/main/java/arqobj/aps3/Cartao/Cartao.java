package arqobj.aps3.Cartao;

import java.time.LocalDate;

import arqobj.aps3.ContaCorrente.ContaCorrente;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * Cartao
 */
@Entity
public class Cartao {

  @Id
  private Integer numeroCartao;

  @Column(nullable = false)
  private String tipo;
  private LocalDate validade;
  private String status;

  @ManyToOne
  @JoinColumn(name = "numero_conta")
  private ContaCorrente contaCorrente;

  public Cartao() {};

  public Cartao(Integer numeroCartao, String tipo, LocalDate validade) {
    this.numeroCartao = numeroCartao;
    this.tipo = tipo;
    this.validade = validade;
    this.status = "Ativo";
  }

  public ContaCorrente getContaCorrente() {
    return contaCorrente;
  }

  public boolean cancelarCartao() {
    if (status.equals("Ativo")) {
      status = "Cancelado";
      return true;
    }
    return false;
  }

  public boolean isExpired() {
    return validade.isBefore(LocalDate.now());
  }

  public Integer getNumeroCartao() {
    return numeroCartao;
  }

  public void setNumeroCartao(Integer numeroCartao) {
    this.numeroCartao = numeroCartao;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public LocalDate getValidade() {
    return validade;
  }

  public void setValidade(LocalDate validade) {
    this.validade = validade;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

}
