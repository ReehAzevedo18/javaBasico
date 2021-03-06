package TerceiraSemanaJava.TerceiraSemanaJava.src.br.com.terceira.conexao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MinhaConexao{

    private static final String PORTA="3306";
    private static final String SCHEMA="bd_afrodev";
    private static final String DRIVER="com.mysql.cj.jdbc.Driver";
    private static final String PARAMS = "?serverTimezone=UTC&useSSL=false";
    private static final String SERVIDOR="localhost";
    private static final String USUARIO="root";
    
    
    
    

    private static Connection instance = null;

    public static void main(String[] args){
        getInstance();

        try{
            PreparedStatement ps = instance.prepareStatement("SELECT 1 as primeiro FROM dual ");
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                rs.getInt("primeiro");
            }
        }catch(SQLException e){
            System.err.println(e.toString());
        }
            
    }

    //synchronized = Simula uma fila de acesso, é executado numa ordem
    public synchronized static Connection getInstance(){
        try{
            if(instance == null || instance.isClosed()){
                instance = conectar();
                
            }else if(!instance.isValid(0)){
                instance.close();
                instance = conectar();
            }
        }catch(Exception e){
            System.err.printf("Erro: ", e.toString());
        }finally{
            return instance;
        }
       
    }

    private static Connection conectar()  
    
        throws IllegalAccessException, InstantiationException, ClassNotFoundException, SQLException {
        
        Class.forName(DRIVER).newInstance();

        Connection con = DriverManager.getConnection("jdbc:mysql://" + SERVIDOR + ":" 
        + PORTA + "/" + SCHEMA + PARAMS, USUARIO , "");

        return con;
        
    }
}