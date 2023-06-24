package Model;

import DAO.AmigoDAO;
import java.sql.SQLException;
import java.util.ArrayList;


public class Amigo {
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private int totalEmp = 0;
    
    private final AmigoDAO dao;
    
    //metdo construtor vazio
    public Amigo() {
        this.dao = new AmigoDAO(); // Instanciando objeto para conectar no banco de dados
    }
    //METODO CONSTRUTOR
    public Amigo(int id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone; 
        
        this.dao = new AmigoDAO(); // Variavel objeto para conectar no banco de dados       
    }
    
    //METODO GETTERS E SETTERS
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTotalEmp() {
        return totalEmp;
    }

    public void setTotalEmp(int totalEmp) {
        this.totalEmp = totalEmp;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    // TO STRING 
    @Override
    public String toString() {
        return "Amigo{" + "id=" + id + ", nome=" + nome + ", telefone=" + telefone + '}';
    }
    
    // METODOS QUE CHAMAM O DAO PARA CONECTAR COM O BANCO DE DADOS
    
    public ArrayList getMinhaLista() {
        return dao.getMinhaLista();
    }
   
    
    public int maiorID() throws SQLException{
        return dao.maiorID();
    }
    
    
    public boolean InsertAmigoBD(String nome, String email, String telefone) throws SQLException {
        int id = this.maiorID() + 1;
        Amigo objeto = new Amigo(id, nome, email, telefone);
        dao.InsertAmigoDB(objeto);      
        return true;

    }
    public boolean DeleteAmigoBD(int id) {
        dao.DeleteAmigo(id);
        return true;
    }   

    public boolean UpdateAmigoBD(int id, String nome, String telefone, String email) {
        
        Amigo objeto = new Amigo(id, nome, telefone, email);
        dao.UpdateAmigo(objeto);
        return true;
        
    }
    public Amigo carregaAmigo(int id) {
        Amigo amigo = new Amigo();
        amigo = dao.CarregaAmigo(id);
        return amigo; 
        
    }
    
    public boolean fazerEmprestimo(int id) {
       dao.fazerEmprestimos(id);
       return true;
    }
    
}


          
   
