package arqobj.aps3.Cliente;

import java.time.LocalDate;

import arqobj.aps3.ContaCorrente.ContaCorrente;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Cliente {

  @Id
  private Integer cpf;

  @Column(nullable = false)
  private String nome;
  private LocalDate dataNascimento;
  
  @Column(nullable = true)
  private String salario;

  @OneToOne(mappedBy = "cliente")
  private ContaCorrente contaCorrente;

  public Cliente() {}

  public ContaCorrente getContaCorrente() {
    return contaCorrente;
  }

  public void setContaCorrente(ContaCorrente contaCorrente) {
    this.contaCorrente = contaCorrente;
  }

  public Integer getCpf() {
    return cpf;
  }

  public void setCpf(Integer cpf) {
    this.cpf = cpf;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public LocalDate getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(LocalDate dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public String getSalario() {
    return salario;
  }

  public void setSalario(String salario) {
    this.salario = salario;
  }

}
