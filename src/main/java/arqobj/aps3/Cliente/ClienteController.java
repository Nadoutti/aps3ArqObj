package arqobj.aps3.Cliente;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

  @Autowired
  private ClienteService clienteService;

  @PostMapping
  public Cliente criarCliente(@RequestHeader(name = "token") String token, @RequestBody Cliente cliente) {
    return clienteService.criarCliente(cliente);
  }

  @GetMapping
  public List<Cliente> getClientes() {
    return clienteService.getClientes();
  }

  @GetMapping("/{cpf}")
  public Cliente getClienteByCpf(@PathVariable Integer cpf) {
    return clienteService.getClientes().get(cpf);
  }

  @PutMapping("/atualizar/{cpf}")
  public Cliente atualizarCliente(@RequestHeader(name = "token") String token, @PathVariable Integer cpf,
      Cliente cliente) {
    return clienteService.atualizarCliente(cpf, cliente);

  }

}
