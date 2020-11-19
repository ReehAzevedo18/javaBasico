import java.util.Scanner;

public class ControleDeLivros {

    public static Livro alterarDadosDoLivro(Livro livro,Scanner sc){
        int alteracao = 0;
        Leitor.lerValor("Qual informação deseja alterar? \n1- Nome \n2- Autor \n3- Editora \n4- Classificação \n5- Ano de publicação",sc);
        
        if(alteracao == 1){
            livro.setNome(Leitor.lerValor("Informe o novo nome do livro:", sc));
            System.out.println("Nome editado com sucesso!");
        }else if(alteracao == 2){
            livro.setAuthor(Leitor.lerValor("Informe o novo autor do livro:", sc));
            System.out.println("Author editado com sucesso!");
        }else if(alteracao == 3){
            livro.setEditora(Leitor.lerValor("Informe a nova editora do livro:", sc));
            System.out.println("Editora editado com sucesso!");
        }else if(alteracao == 4){
            livro.setClassificacao(Leitor.lerValor("Informe a nova classificação do livro:", sc, livro.getClassificacao()));
            System.out.println("Nome editado com sucesso!");
        }else if(alteracao == 5){
            livro.setAnoPublicacao(Leitor.lerValor("Informe o ano de publicação do livro:", sc,livro.getAnoPublicacao()));
            System.out.println("Nome editado com sucesso!");
        }else{
            System.out.println("Selecione uma opção para alteração!");
        }
        return livro;
    }

    public static void listarLivros(Livro[] livros){
        for(int i=0; i < livros.length; i++){
            Boolean verificaSeTemValor = false;

            if(livros[i] != null){
                verificaSeTemValor = true;
                System.out.printf("Livro: %s \n",livros[i].getNome());
                System.out.printf("Autor: %s \n",livros[i].getAuthor());
                System.out.printf("Editora: %s \n",livros[i].getEditora());
                System.out.printf("Classificação: %s \n",livros[i].getClassificacao());
                System.out.printf("Ano de publicação: %s \n",livros[i].getAnoPublicacao());
            }if(!verificaSeTemValor){
                System.out.println("Cadastre um livro!");
            }
    }

    public static Livro cadastrarLivro(Livro livro, Scanner sc){
        if(livro == null){
            livro = new Livro();
        }

        System.out.println("***DADOS DO LIVRO***");

        livro.setNome(Leitor.lerValor("Digite o nome do livro: ", sc));

        livro.setAuthor(Leitor.lerValor("Digite o autor do livro: ", sc));

        livro.setEditora(Leitor.lerValor("Digite o nome da editora: ", sc));

        livro.setClassificacao(Leitor.lerValor("Digite a classificação: ", sc, livro.getClassificacao()));

        livro.setAnoPublicacao(Leitor.lerValor("Digite o ano de publicação: ", sc, livro.getAnoPublicacao()));

        System.out.println("***FIM DO CADASTRO***");
        return livro;
    }

    public static void imprimirRegistro(Livro l){
            if(l != null){
                System.out.printf("Nome: %s \nAutor: %s\nAno de Publicação: %dClassificação: %d\nEditora: ",
                l.getNome(), l.getAuthor(), l.getAnoPublicacao(), l.getClassificacao(), l.getEditora());
            }else{
                System.out.println("Nenhum livro cadastrado!");
            }
    }

    public static Livro deletarRegistro(Livro l){
        if(l != null){
            System.out.println("Registro deletado com sucesso!");
        }else{
            System.out.println("Não existe registro!");
        }
        return null;
    }

    
}
