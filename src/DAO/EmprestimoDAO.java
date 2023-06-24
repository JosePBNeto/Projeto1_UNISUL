/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import Model.Amigo;
import Model.Emprestimo;
import Model.Ferramenta;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;



public class EmprestimoDAO {
    
        // ARRAY LIST DE EMPRESTIMOS
        public static ArrayList<Emprestimo> Lista = new ArrayList<>();
        
        // METODO CONECTAR NO BANCO DE DADOS
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
    
    
    // METODO PARA PEGAR O MAIOR ID DA TABLE EMPRESTIMOS
    public int maiorID() throws SQLException {

        int maiorID = 0;
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM emprestimos");
            res.next();
            maiorID = res.getInt("id");

            stmt.close();

        } catch (SQLException ex) {
        }

        return maiorID;
    }
    
    // METODO PARA PEGAR OS DADOS DA TABELA EMPRESTIMOS
    public ArrayList getMinhaLista() {
        
        Lista.clear(); // Limpa nosso ArrayList

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM emprestimos");
            
            while (res.next()) {

                int id = res.getInt("id");
                int amigoId = res.getInt("amigo_id");
                int ferramentaID = res.getInt("ferramenta_id");               
                Date dataEmp = res.getDate("data_emprestimo");
                Date dataDev = res.getDate("data_devolucao");
                boolean stats = res.getBoolean("status");
                
                Amigo amigo = new Amigo();
                amigo = amigo.carregaAmigo(amigoId);          
                Ferramenta ferr = new Ferramenta();             
                ferr = ferr.carregaFerramenta(ferramentaID);
                
                 Emprestimo objeto1 = new Emprestimo(id, amigo, ferr, dataEmp, dataDev, stats);
                
                
                Lista.add(objeto1);
                
            }

            stmt.close();
            
            // SE NOME DA FERRAMNETA OU AMIGO TIVER "NULL", TROCAR PARA "DELETED" 
            for (Emprestimo e : Lista) {
                if (e.getAmigo().getNome() == null) {
                    e.getAmigo().setNome("DELETADO");
                }
                if (e.getFerramenta().getNome() == null) {
                    e.getFerramenta().setNome("DELETADO");
                }
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return Lista;
    }
    
    
    public boolean InsertEmprestimoDB(Emprestimo objeto) {
        
        String sql = "INSERT INTO emprestimos(id, ferramenta_id, amigo_id, data_emprestimo, data_devolucao) VALUES (?,?,?,?,?)";
        
        try {
            PreparedStatement ps = this.getConexao().prepareStatement(sql);
            
            java.sql.Date sqlDateEmprestimo = new java.sql.Date(objeto.getDataEmprestimo().getTime());
            java.sql.Date sqlDateDevolucao = new java.sql.Date(objeto.getDataDevolucao().getTime());

            ps.setInt(1, objeto.getId());
            ps.setInt(2, objeto.getFerramenta().getId());
            ps.setInt(3, objeto.getAmigo().getId()); 
            ps.setDate(4, sqlDateEmprestimo);           
            ps.setDate(5, sqlDateDevolucao);
            
            ps.execute();
            ps.close();
            
            return true;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
           
    }

    public Emprestimo CarregarEmprestimo(int id){
    
        Emprestimo emprestimo = new Emprestimo();
        Amigo amigo = new Amigo();
        Ferramenta ferramenta = new Ferramenta();
        
        emprestimo.setId(id);
        
        try {
            Statement s = this.getConexao().createStatement();
            ResultSet r;
            r = s.executeQuery("SELECT id, ferramenta_id, amigo_id, data_emprestimo, data_devolucao FROM emprestimos WHERE id = " + id);
            r.next();
           
            
           emprestimo.setAmigo(amigo.carregaAmigo(r.getInt("amigo_id")));
           emprestimo.setFerramenta(ferramenta.carregaFerramenta(r.getInt("ferramenta_id")));
           emprestimo.setDataEmprestimo(r.getDate("data_emprestimo"));
           emprestimo.setDataDevolucao(r.getDate("data_devolucao"));
    
           
           s.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return emprestimo;  
    }
    
    public boolean SetStatus(int id, boolean status) {
        String sql = "UPDATE emprestimos SET status = ? WHERE id = ?";
        try {
            PreparedStatement ps = this.getConexao().prepareStatement(sql);
            
            ps.setBoolean(1, status);
            ps.setInt(2, id);
            ps.execute();
            ps.close();
            return true;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }  
    
    }
    
    public boolean setAmigoIdToNull (int id) {
        String stmt = "UPDATE emprestimos SET amigo_id = null WHERE amigo_id = " + id;
        try {
            PreparedStatement ps = this.getConexao().prepareStatement(stmt);

            ps.execute();
            ps.close();  
            
            return true;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }          
    }
    
    public boolean setFerramentaIdToNull (int id) {
        String stmt = "UPDATE emprestimos SET ferramenta_id = null WHERE ferramenta_id = " + id;
        try {
            PreparedStatement ps = this.getConexao().prepareStatement(stmt);

            ps.execute();
            ps.close();  
            
            return true;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }          
    }  
    
}




