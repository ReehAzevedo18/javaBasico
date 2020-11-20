public class ClassePadrao {

    protected String nome;

    public ClassePadrao(){

    }

    public ClassePadrao(String nome){
        this.nome = nome;
    }


    public String getNome() {
        return "Pessoa: " + this.getNome();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
