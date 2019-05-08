package conneciton;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import com.mysql.jdbc.Driver;

//cria a conexão com o banco de dados 
import java.util.ResourceBundle;
public class ConnectionFactory {
    public ResultSet rs;
    private static final  String DRIVER = "com.mysql.jdbc.Driver"; //Auxiliar da conexão Java + SQL
    private static final  String URL = "jdbc:mysql://localhost:3306/cadastro"; //Diretório do banco de dados local
    private static final  String USER = "root"; // usuário do banco de dados
    private static final  String PASS = ""; // senha de acesso ao banco de dados
    
    // Tentando estabelecer uma conexão 
   public static Connection getConnection(){
       
      try{
          Class.forName(DRIVER);
          
          return DriverManager.getConnection(URL, USER, PASS);
      }catch (ClassNotFoundException | SQLException ex){
          throw new RuntimeException("New error");
      }
   }
    
    // Fechando a conecxão com o banco de dados
    public static void cloceConnection(Connection con){
    
        if(con != null){
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println("Erro: Close Connection"+ex); // retorna uma mensagem de erro indicando qual o erro
            }
        }
        
        
        //Terminando conexão com o banco junto ao Statement
    }
    public static void cloceConnection(Connection con, PreparedStatement stmt){
    
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException ex) {
            System.err.println("Erro: Close Connection stmt"+ex); // retorna uma mensagem de erro indicando qual o erro
            }
        }
        cloceConnection(con);
        
    }
    
    //Terminando conexão com o banco junto ao Statement e o ResultSet
    public static void cloceConnection(Connection con, PreparedStatement stmt,ResultSet res){
    
        if(res != null){
            try {
                res.close();
            } catch (SQLException ex) {
            System.err.println("Erro: Close Connection stmt e ResultSet"+ex); // retorna uma mensagem de erro indicando qual o erro
            }
        }
        cloceConnection(con, stmt);
        
    }
 
//Código utilizado para executar comandos SQL dentro do JAVA   
public void executaSQL(Connection con, String sql) throws SQLException{
    Statement stm = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
    rs=stm.executeQuery(sql);
}
        
}