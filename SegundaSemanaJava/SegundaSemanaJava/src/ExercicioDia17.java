import java.util.Scanner;

public class ExercicioDia17 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o tamanho do array: ");
        int tamanho = sc.nextInt();

        System.out.println("Escolha uma opção de 1 à 5, sendo: \n1 - Listar Todos \n2- Cadastrar Livro \n3- Editar livro \n4- Apresentar livro \n5- Deletar livro");
        int opcao = sc.nextInt();

        Livro[] livro = new Livro[tamanho];

        switch(opcao){
            case 1:
                for(int i=0; i < livro.length; i++){
                    if(livro[i] != null){
                        System.out.printf("Livro: %s \n",livro[i].getNome());
                        System.out.printf("Autor: %s \n",livro[i].getAuthor());
                        System.out.printf("Editora: %s \n",livro[i].getEditora());
                        System.out.printf("Classificação: %s \n",livro[i].getClassificacao());
                        System.out.printf("Ano de publicação: %s \n",livro[i].getAnoPublicacao());
                    }else{
                        System.out.println("Ainda não tem livro cadastrado!");
                    }
                }if(tamanho == 0){
                    System.out.println("Cadastre um livro!");
                }
                break;
            case 2:
                for(int i=0; i < livro.length; i++){
                    if(livro[i] == null){
                        System.out.println("Oba! Vamos cadastrar um novo livro!");
                        livro[i] = cadastrarLivro(livro[i], sc);
                        System.out.println("Livro cadastrado com sucesso!");
                    }
                }
                 break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }

    }

    private static Livro cadastrarLivro(Livro livro, Scanner sc){
        if(livro == null){
            livro = new Livro();
        }

        System.out.println("***DADOS DO LIVRO***");

        System.out.println("Nome: ");
        livro.setNome(livro.getNome());

        System.out.println("Autor: ");
        livro.setAuthor(livro.getAuthor());

        System.out.println("Editora: ");
        livro.setEditora(livro.getEditora());

        System.out.println("Classificação: ");
        livro.setClassificacao(livro.getClassificacao());

        System.out.println("Ano de publicação: ");
        livro.setAnoPublicacao(livro.getAnoPublicacao());

        System.out.println("***FIM DO CADASTRO***");
        return livro;
    }
}
