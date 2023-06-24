package DAO;

import Model.Amigo;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class AmigoDAO {
    
    // ARRAY LIST DE AMIGOS
    public static ArrayList<Amigo> Lista = new ArrayList<Amigo>();
    
    public AmigoDAO(){
    }
    
    // METODO PARA ACHAR O MAIOR ID NA TABELA AMIGOS
    public int maiorID() throws SQLException {
        int maiorID = 0;
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM amigos");
            res.next();
            maiorID = res.getInt("id");

            stmt.close();

        } catch (SQLException ex) {
        }

        return maiorID;
    }
        
        
    // METODO PARA CONECTAR COM O BANCO DE DADOS   
    public Connection getConexao() {

        Connection connection = null;  //inst�ncia da conex�o

        try {

            // Carregamento do JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Configurar a conex�o
            String server = "localhost"; //caminho do MySQL
            String database = "emprestimos_db";
            String url = "jdbc:mysql://" + server + ":3306/" + database + "?useTimezone=true&serverTimezone=UTC";
            String user = "root";
            String password = "mysql";

            connection = DriverManager.getConnection(url, user, password);

            // Testando..
            if (connection != null) {
                System.out.println("Status: Conectado!");
            } else {
                System.out.println("Status: N�O CONECTADO!");
            }

            return connection;

        } catch (ClassNotFoundException e) {  //Driver n�o encontrado
            System.out.println("O driver nao foi encontrado. " + e.getMessage() );
            return null;

        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar...");
            return null;
        }
    }
    
    // METODO PARA PEGAR DADOS DO BANCO DE DADOS, CRIAR OBJETOS COM OS DADOS E COLOCA-LOS EM UMA ARRAYLIST
    public ArrayList getMinhaLista() {
        
        Lista.clear(); 

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM amigos");
            while (res.next()) {

                String nome = res.getString("nome");            
                int id = res.getInt("id");
                String telefone = res.getString("telefone");
                String email = res.getString("email");
                int totalEmprestimo = res.getInt("totalEmp");
                
                Amigo objeto = new Amigo(id, nome, email, telefone);
                
                objeto.setTotalEmp(totalEmprestimo);

                Lista.add(objeto);
            }

            stmt.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return Lista;
    }
    
    // METODO PARA INSERIR DADOS NA TABELA AMIGOS A PARTIR DE UM OBJETO INSTANCIADO NA CAMADA VIEW
    public boolean InsertAmigoDB(Amigo objeto) {
        String sql = "INSERT INTO amigos(id, nome, telefone, email, totalEmp) VALUES(?,?,?,?,?)";
        
        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);
            
            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setString(3, objeto.getTelefone());
            stmt.setString(4, objeto.getEmail());
            stmt.setInt(5, objeto.getTotalEmp());
            
            stmt.execute();
            stmt.close();
            
            return true;
            
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
     
    }    
    
    // PEGA O PARAMETRO ID RECEBIDO E DELETA DA TABELA AMIGOS NO BANCO DE DADOS
    public boolean DeleteAmigo(int id) {
        try{
           Statement s = this.getConexao().createStatement();
           
           s.executeUpdate("DELETE FROM amigos WHERE id = " + id);
           s.close();
           
        } catch (SQLException e) {  
        }
        
        return true;
    }
    
    // ATUALIZA UMA LINHA NO BANCO DE DADOS A PARTIR DE UM OBJETO RECEBIDO DA CAMADA VIEW
    public boolean UpdateAmigo(Amigo amigo) {
        
        String stmt = "UPDATE amigos SET nome = ?, email = ?, telefone = ? WHERE id = ?";
        try {
            PreparedStatement ps = this.getConexao().prepareStatement(stmt);
            
            ps.setString(1, amigo.getNome());
            ps.setString(2, amigo.getEmail());
            ps.setString(3, amigo.getTelefone());
            ps.setInt(4, amigo.getId());
            ps.execute();
            ps.close();  
            
            return true;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }     
        
    }
    
    // CARREGA UMA LINHA DA TABLE AMIGOS
    public Amigo CarregaAmigo(int id){
    
        Amigo amg = new Amigo();
        amg.setId(id);
        
        try {
            Statement s = this.getConexao().createStatement();
            ResultSet r;
            r = s.executeQuery("SELECT id, nome, telefone, email FROM amigos WHERE id = " + id);
            r.next();
            
           amg.setNome(r.getString("nome"));
           amg.setTelefone(r.getString("telefone"));
           amg.setEmail(r.getString("email"));
           
           s.close();
           
           
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
        return amg;  
    }
    
    // RECEBE UM ID E ADICIONA +1 AO ATRIBUTO EMPRESTIMO 
    public boolean fazerEmprestimos(int id) {
        String st = "UPDATE amigos set totalEmp = totalEmp +1 WHERE id = ?";
        try {
            PreparedStatement ps = this.getConexao().prepareStatement(st);
            ps.setInt(1, id);
            ps.execute();
            ps.close();                      
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return true;
    }
    
}
