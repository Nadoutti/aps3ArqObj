package arqobj.aps3.Autenticacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

  @Autowired
  private UsuarioRepository usuarioRepository; 

  private HashMap<String, Usuario> tokens = new HashMap<>();

  public Usuario cadastrarUsuario(Usuario usuario) {

    String password = usuario.getPassword();

    usuario.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
    return usuarioRepository.save(usuario);
  }

  public Collection<Usuario> listarUsuarios() {
    return usuarioRepository.findAll();
  }

  public String login(Usuario usuario) {

    Usuario user = usuarioRepository.findById(usuario.getEmail()).get();
    if (BCrypt.checkpw(usuario.getPassword(), user.getPassword())) {

      String token = UUID.randomUUID().toString();
      tokens.put(token, usuario);
      return token;
    }

    throw new RuntimeException("Usuário ou senha inválidos");

  }

  public Usuario validarToken(String token) {

    Usuario usuario = tokens.get(token);

    if (usuario == null) {
      throw new RuntimeException("Token invalido");
    }

    return usuario;

  }

}
