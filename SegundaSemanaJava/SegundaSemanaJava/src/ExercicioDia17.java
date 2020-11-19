import java.util.Scanner;

public class ExercicioDia17 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int tamanho = Leitor.lerValor("Digite o tamanho do array: ", sc, 0);
        int opcao = 0;
        menu(opcao, new Livro[tamanho], sc);
    }

    public static void menu(Integer opcao, Livro[] livros, Scanner sc){
        Integer nRegistro = 0;
        do{
            Leitor.lerValor("Escolha uma opção de 1 à 5, sendo: \n1 - Listar Todos \n2- Cadastrar Livro \n3- Editar livro \n4- Apresentar livro \n5- Deletar livro", sc);
            switch(opcao){
                case 1:
                   ControleDeLivros.listarLivros(livros);
                    break;
                case 2:
                  nRegistro = Leitor.lerValor("Qual o registro que deseja inserir?",sc, nRegistro);
                  livros[nRegistro - 1]  = ControleDeLivros.cadastrarLivro(livros[nRegistro - 1], sc);
                  Leitor.lerValor("Livro cadastrado com sucesso!",sc);
                 
                     break;
                case 3:
                   nRegistro = Leitor.lerValor("Digite o n° do registro do livro que deseja alterar?",sc, nRegistro);
                   livros[nRegistro - 1] = ControleDeLivros.alterarDadosDoLivro(livros[nRegistro - 1], sc);
                    break;
                case 4:
                    nRegistro = Leitor.lerValor("Digite o n° do registro do livro que deseja consultar?",sc, nRegistro);
                    ControleDeLivros.imprimirRegistro(livros[nRegistro - 1]);
                    break;
                case 5:
                nRegistro = Leitor.lerValor("Digite o n° do registro do livro que deseja deletar?",sc, nRegistro);
                livros[nRegistro - 1] = ControleDeLivros.deletarRegistro(livros[nRegistro - 1]);
                    break;
                default:
                    Leitor.lerValor("Opção inválida!",sc);
                    break;
            }


        }while(opcao != 0);
    }

   
}
