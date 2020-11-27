package TerceiraSemanaJava.TerceiraSemanaJava.src.br.com.terceiro.models;

public class Usuario{

    private Long idt;
    private String nme_usuario;
    private String usr_usuario;

    public Usuario(){
        super();
    }

    public Usuario(Long idt, String nme_usuario, String  usr_usuario){
        super();
        this.idt = idt;
        this.nme_usuario= nme_usuario;
        this.usr_usuario = usr_usuario;
    }

    public Long getIdt() {
        return idt;
    }

    public void setIdt(Long idt) {
        this.idt = idt;
    }

    public String getNme_usuario() {
        return nme_usuario;
    }

    public void setNme_usuario(String nme_usuario) {
        this.nme_usuario = nme_usuario;
    }

    public String getUsr_usuario() {
        return usr_usuario;
    }

    public void setUsr_usuario(String usr_usuario) {
        this.usr_usuario = usr_usuario;
    }

    
}