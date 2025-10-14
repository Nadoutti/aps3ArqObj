package arqobj.aps3.Autenticacao;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

  @Autowired
  private UsuarioService usuarioService;

  @PostMapping
  public Usuario cadastrarUsuario(@RequestBody Usuario usuario) {
    return usuarioService.cadastrarUsuario(usuario);
  }

  @GetMapping
  public Collection<Usuario> listaUsuarios() {
    return usuarioService.listarUsuarios();
  }

  @PostMapping("/login")
  public String login(@RequestBody Usuario usuario) {
    return usuarioService.login(usuario);
  }

}
