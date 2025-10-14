package arqobj.aps3.Cartao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Integer> {

    List<Cartao> findByContaCorrente_Numero(Integer numeroConta);
}
