package arqobj.aps3.Cliente;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
  public List<Cliente> findByNome(String nome);
  
}
