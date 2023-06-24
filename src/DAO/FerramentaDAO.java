/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import Model.Ferramenta;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class FerramentaDAO {
    
    // ARRAY LIST DE FERRAMENTAS
    public static ArrayList<Ferramenta> Lista = new ArrayList<Ferramenta>();
    
    public FerramentaDAO(){      
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
    
    // METODO PARA PEGAR O MAIOR ID DA TABELA FERRAMENTAS
    public int maiorID() throws SQLException {

        int maiorID = 0;
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM ferramentas");
            res.next();
            maiorID = res.getInt("id");

            stmt.close();

        } catch (SQLException ex) {
        }

        return maiorID;
    }
    
    // METODO PARA PEGAR TODA A TABELA DE FERRAMENTAS E COLOCAR EM UMA ARRAY LIST INSTANCIANDO OBJETOS
    public ArrayList getMinhaLista() {
        
        Lista.clear(); // Limpa nosso ArrayList

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM ferramentas"); 
            while (res.next()) {

                int id = res.getInt("id");
                String nome = res.getString("nome");
                String marca = res.getString("marca");
                double custo = res.getDouble("custo");
                boolean disponibilidade = res.getBoolean("disponibilidade");               

                Ferramenta objeto = new Ferramenta(id, nome, marca, custo, disponibilidade);

                Lista.add(objeto);
            }

            stmt.close();

        } catch (SQLException ex) {
        }

        return Lista;
    }
    
    // METODO PARA INSERIR UMA LINHA NA TABELA DE FERRAMENTAS NO BANCO DE DADOS
    public boolean InsertFerramentaDB(Ferramenta objeto) {
        
        String sql = "INSERT INTO ferramentas(id, nome, marca, custo) VALUES(?,?,?,?)";
        
        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);
            
            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setString(3, objeto.getMarca());
            stmt.setDouble(4, objeto.getCusto());
            
            stmt.execute();
            stmt.close();
            
            return true;
            
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        } 
    }  
    
    // METODO PARA DELETAR UMA FERRAMENTA NO BANCO DE DADOS
    public boolean DeleteFerramenta(int id) {
        try{
           Statement s = this.getConexao().createStatement();
           
           s.executeUpdate("DELETE FROM ferramentas WHERE id = " + id);
           s.close();
           
        } catch (SQLException e) {  
        }
        
        return true;
    }
    
    // METODO PARA ATUALIZAR UMA LINHA NO BANCO DE DADOS
    public boolean UpdateFerramenta(Ferramenta ferramenta) {
        
        String stmt = "UPDATE ferramentas SET nome = ?, marca = ?, custo = ? WHERE id = ?";
        
        try {
            PreparedStatement ps = this.getConexao().prepareStatement(stmt);
            
            ps.setString(1, ferramenta.getNome());
            ps.setString(2, ferramenta.getMarca());
            ps.setDouble(3, ferramenta.getCusto());
            ps.setInt(4, ferramenta.getId());
            
           
            ps.execute();
            ps.close(); 
            
            return true;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }       
    }
    
    // METODO PARA CARREGAR UMA FERRAMENTA DO BANCO DE DADOS
    public Ferramenta CarregaFerramenta(int id){
    
        Ferramenta ferr = new Ferramenta();
        ferr.setId(id);
        
        try {
            Statement s = this.getConexao().createStatement();
            ResultSet r;
            r = s.executeQuery("SELECT id, nome, marca, custo, disponibilidade FROM ferramentas WHERE id = " + id);
            r.next();
                        
           ferr.setNome(r.getString("nome"));
           ferr.setMarca(r.getString("marca"));
           ferr.setCusto(r.getDouble("custo"));
           ferr.setDisponibilidade(r.getBoolean("disponibilidade"));
           
           s.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ferr;  
    }
    
    // METODO PARA DEIXAR A FERRAMENTA DISPONIVEL NO BANCO DE DADOS
    public void SetDisponivel(int id){
        
        try {
            Statement s = this.getConexao().createStatement();  
            s.executeUpdate("UPDATE ferramentas SET disponibilidade = true WHERE id = " + id);  
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    // METODO PARA DEIXAR A FERRAMENTA INDISPONIVEL NO BANCO DE DADOS
    public void SetIndisponivel(int id){
        
        try {
            Statement s = this.getConexao().createStatement();  
            s.executeUpdate("UPDATE ferramentas SET disponibilidade = false WHERE id = " + id);  
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
}
