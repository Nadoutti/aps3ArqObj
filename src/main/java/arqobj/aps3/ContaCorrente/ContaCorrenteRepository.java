package arqobj.aps3.ContaCorrente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Integer> {
  
  public ContaCorrente getByNumero(Integer number); 
}
