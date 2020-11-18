public class Livro {
    
    Integer anoPublicacao;
    String nome;
    String author;    
    String editora;
    Integer classificacao;

    public Livro(){

    }

    public Livro(Integer anoPublicacao, String nome, String author, String editora, Integer classificacao){
        this.anoPublicacao = anoPublicacao;
        this.nome = nome;
        this.author = author;
        this.editora = editora;
        this.classificacao = classificacao;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public Livro setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Livro setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public Livro setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getEditora() {
        return editora;
    }

    public Livro setEditora(String editora) {
        this.editora = editora;
        return this;
    }

    public Integer getClassificacao() {
        return classificacao;
    }

    public Livro setClassificacao(Integer classificacao) {
        this.classificacao = classificacao;
        return this;
    }
}
