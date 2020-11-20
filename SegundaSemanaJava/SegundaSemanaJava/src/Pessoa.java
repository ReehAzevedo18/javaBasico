//extens = HERANÇA
public class Pessoa extends ClassePadrao {

    // String[] nomes = new String[tam];
    // float[] pesos = new float[tam];
    // char[] sexos = new char[tam];

    //Fazendo o encapsulamento, deixando as variaveis como privada e os métodos como publico
    private float peso;
    private Character sexo;

    //O método construtor é criado para dar instancia na classe quando for inicializado
    public Pessoa(){
        super();
    }

    public Pessoa(String nome, float peso, Character sexo){
        //Como está extendido a ClassePadrao não é necessário declarar a variavel nome que já consta na outra classe, e nem criar ela aqui, eu apenas utilizo o setNome(nome) pra referenciar ela 
        this.setNome(nome);
        this.peso = peso;
        this.sexo = sexo;
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
