package TerceiraSemanaJava.TerceiraSemanaJava.src.br.com.terceira;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.mysql.cj.jdbc.Driver;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import TerceiraSemanaJava.TerceiraSemanaJava.src.br.com.terceira.conexao.MinhaConexao;
import TerceiraSemanaJava.TerceiraSemanaJava.src.br.com.terceiro.dao.UsuarioDAO;
import TerceiraSemanaJava.TerceiraSemanaJava.src.br.com.terceiro.models.Usuario;
import TerceiraSemanaJava.TerceiraSemanaJava.src.br.com.terceiro.util.Leitor;


public class Principal {

    private static Connection conn = null;

    public static void main(String[] args){

            UsuarioDAO dao = new UsuarioDAO();
            Scanner sc = new Scanner(System.in);
            Integer menu = 0;
            
            if(login(sc, dao) == 1){
                do{
                    menu = Leitor.lerValor("1) Buscar Todos\n2) Cadastrar\n3) Editar\n4) Deletar \n", sc, menu);
                    Leitor.limparTela();

                    switch(menu.intValue()){
                        case 1:
                            buscarUsuarios(dao);
                            break;
                        case 2:
                            cadastrarUsuario(dao, sc);
                            break;
                        case 3:
                            editarUsuario(dao, sc);
                            break;
                        case 4:
                            deletarUsuario(dao, sc);
                            break;
                        default:
                            System.out.println("Opção inválida!");
                            break;
                    }
                }while(menu == 0);
            }
            System.out.println("Saindo ...");
    }

    private static void deletarUsuario(UsuarioDAO dao, Scanner sc){

        Usuario usuarioSelecionado = buscarUsuarioPorParteDoNome(dao, sc, 
        "Qual identificador do usuário de que deseja deletar?");

            if(usuarioSelecionado  != null){
                    if(dao.deletarUsuario(usuarioSelecionado.getIdt()) > 0){
                        System.out.printf("Usuário deletado com sucesso! \n", usuarioSelecionado.getNme_usuario());
                    }else{
                        System.out.printf("Não foi possivel deletar o usuário %d", usuarioSelecionado.getNme_usuario());
                    }
            }else{
                System.out.println("Nenhum usuário para deletar!");
            }
    }

    private static void editarUsuario(UsuarioDAO dao, Scanner sc){
        Usuario usuarioSelecionado = buscarUsuarioPorParteDoNome(dao, sc, 
        "Qual identificador do usuário que deseja editar?");

        imprimirValorUsuario(usuarioSelecionado);
        String novoNomeDeUsuario = Leitor.lerValor("Qual o novo valor de nome ? ", sc);
        usuarioSelecionado.setNme_usuario(
            novoNomeDeUsuario == null || novoNomeDeUsuario.equals("") ? usuarioSelecionado.getNme_usuario()
                : novoNomeDeUsuario);

            String novoLoginUsuario = Leitor.lerValor("Qual o login que deseja utilizar?", sc);
            usuarioSelecionado.setUsr_usuario(novoLoginUsuario == null || novoLoginUsuario.equals("") ? usuarioSelecionado.getUsr_usuario() : novoLoginUsuario);
        
            if( dao.editarUsuario(usuarioSelecionado) > 0){
                System.out.println("Usuário editado com sucesso!");
            }else{
                System.out.println("Não foi possivel editar o usuário, tente novamente!");
            }
       
    }

    public static Usuario buscarUsuarioPorParteDoNome(UsuarioDAO dao, Scanner sc, String perguntaSelecao){
        List<Usuario> usuarios = dao.buscarUsuarioPorParteDoNome(
                Leitor.lerValor("Qual o nome do usuario que está buscando?", sc));

            if(usuarios.size() > 1){
                imprimirValorUsuario(usuarios.get(0));
                if(Leitor.lerValor("É esse usuário que você procura?", sc, false)){
                    return usuarios.get(0);
                }
            }else if(usuarios.size() == 0){
                System.out.println("Nenhum usuário encontrado!");
            }else{
                usuarios.forEach(usuario -> {
                    imprimirValorUsuario(usuario);
                });
                Long identificadoUsuarioSelecionado = Leitor.lerValor(perguntaSelecao, sc, 0L);
                return buscarNaListaUsuarioPorIdentificador(usuarios, identificadoUsuarioSelecionado);
            }
            return null;
    }

    private static Usuario buscarNaListaUsuarioPorIdentificador(List<Usuario> usuarios, Long identificadorUsuarioSelecionado){
        Usuario u = null;
        for(int i=0; i < usuarios.size(); i++){
            if(usuarios.get(i).getIdt().equals(identificadorUsuarioSelecionado)){
                u = usuarios.get(i);
            }
        }
        return u;
    }

    public static void imprimirValorUsuario(Usuario usuario){
        System.out.printf("Identificador: %d\nNome: %s\nUsuario: %s\n", usuario.getIdt(), usuario.getNme_usuario(),
        usuario.getUsr_usuario());
    }

    private static void cadastrarUsuario(UsuarioDAO dao, Scanner sc){
        Usuario u = new Usuario();

        try {
            u.setNme_usuario(Leitor.lerValor("Qual o nome do usuário?", sc));
            u.setUsr_usuario(Leitor.lerValor("Qual o login que deseja utilizar?", sc));
            String senha = Leitor.lerValor("Qual a senha?", sc);
                
                if(dao.cadastrarUsuario(u, senha) > 0){
                    System.out.println("Usuário Cadastrado com sucesso!");
                }else{
                    System.out.println("Usuário não foi cadastrado...");
                }
        } catch (Exception e) {
            System.out.println("Um erro ocorreu ao tentar cadastrar o usuário");
        }
    }

    public static void buscarUsuarios(UsuarioDAO dao){
        List<Usuario> usuarios = dao.buscarUsuarios();
            usuarios.forEach(usuario ->
                System.out.printf("Identificador: %d\nNome: %s\nUsuario: %s\n", usuario.getIdt(), usuario.getNme_usuario(),
                usuario.getUsr_usuario()));
    }

    /**
	 * 
	 * Crie um método login: Retorna true (Caso usuário e senha esteja correto) e
	 * false(Quando usuário e senha estiver errado) Informe "Login realizado com
	 * sucesso!" caso true ou "Seu Usuário ou senha Estão incorretos", informe
	 * novamente. (crie um loop com a opção para sair)
	 */

     private static Integer login(Scanner sc, UsuarioDAO dao){
         Integer testeLogin = 0;
         Boolean tentarNovamente = false;

                do{
                    tentarNovamente = false;
                    String usuario = Leitor.lerValor("Usuario: ",sc );
                    String senha = Leitor.lerValor("Senha: ",sc );

                        if(dao.verificarUsuarioESenha(usuario, senha)){
                            System.out.println("Login realizado com sucesso!");
				            testeLogin = 1;
                        }else{
                            System.out.println("Seu usuário ou senha estão incorretos");
				            tentarNovamente = Leitor.lerValor("Gostaria de tentar novamente - Sim/Nao :", sc, tentarNovamente);
                        }
                    
                }while(testeLogin == 0 || tentarNovamente);
                return testeLogin;
     }
}
