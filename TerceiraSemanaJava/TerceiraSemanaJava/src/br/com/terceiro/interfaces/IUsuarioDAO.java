package TerceiraSemanaJava.TerceiraSemanaJava.src.br.com.terceiro.interfaces;

import java.util.List;

import TerceiraSemanaJava.TerceiraSemanaJava.src.br.com.terceiro.models.Usuario;

public interface IUsuarioDAO {

    Usuario buscarUsuario(Long id);
    
    List<Usuario> buscarUsuarios();

    List<Usuario> buscarUsuarioPorParteDoNome(String nome);

    Integer cadastrarUsuario(Usuario u, String senha);

    Boolean verificarUsuarioESenha(String usuario, String senha);

    Integer deletarUsuario(Long id);

    Integer editarUsuario(Usuario u);

}