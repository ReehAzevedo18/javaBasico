public class Pessoa {

    // String[] nomes = new String[tam];
    // float[] pesos = new float[tam];
    // char[] sexos = new char[tam];

    //Fazendo o encapsulamento, deixando as variaveis como privada e os métodos como publico
    private String nome;
    private float peso;
    private Character sexo;

    //O método construtor é criado para dar instancia na classe quando for inicializado
    public Pessoa(){

    }

    public Pessoa(String nome, float peso, Character sexo){

    }

    public String getNome(){
        return nome;
    }
    
    public Pessoa setNome(String nome){
        this.nome = nome;
        return this;
    }

    public Float getPeso(){
        return peso;
    }

    public Pessoa setPeso(Float peso){
        this.peso = peso;
        return this;
    }

    public Character getSexo(){
        return sexo;
    }

    public Pessoa setSexo(Character sexo){
        this.sexo = sexo;
        return this;
    }
    
}
