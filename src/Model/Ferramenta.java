/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.FerramentaDAO;
import java.sql.SQLException;
import java.util.ArrayList;

public class Ferramenta {
    
    private int id;
    private String nome;
    private String marca;
    private double custo;
    private boolean disponibilidade = true; 
    
    private final FerramentaDAO dao;
    
    // METODO CONSTRUTOR VAZIO
    public Ferramenta(){
        this.dao = new FerramentaDAO();
    }

    // METODO CONTRUTOR COM PARAMETROS 
    public Ferramenta(int id, String nome, String marca, double custo) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.custo = custo;
        this.dao = new FerramentaDAO();
    }
    
        // CONSTTRUTOR COM DISPONIBILIDADE
        public Ferramenta(int id, String nome, String marca, double custo, boolean disponibilidade) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.custo = custo;
        this.disponibilidade = disponibilidade;
        this.dao = new FerramentaDAO();
    }

    // GETTERS AND SETTERS
    public boolean getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    // TO STRING
    @Override
    public String toString() {
        return "Ferramenta{" + "id=" + id + ", nome=" + nome + ", marca=" + marca + ", custo=" + custo + ", disponibilidade=" + disponibilidade + '}';
    }
    
    // METODOS QUE CHAMAM A CAMADA DAO PARA CONECTAR COM O BANCO DE DADOS
    
    public ArrayList getMinhaLista() {
        return dao.getMinhaLista();
    }
    
    public int maiorID() throws SQLException{
        return dao.maiorID();
    }
    
    public boolean InsertFerramentaBD(String nome, String marca, double custo) throws SQLException {
        int id = this.maiorID() + 1;
        Ferramenta objeto = new Ferramenta(id, nome, marca, custo);
        dao.InsertFerramentaDB(objeto);
        return true;
    }
        
    public boolean DeleteFerramentaoBD(int id) {
        dao.DeleteFerramenta(id);
        return true;
    } 
 
    public boolean UpdateFerramentaBD(int id, String nome, String marca, double custo) {
        
        Ferramenta objeto = new Ferramenta(id, nome, marca, custo);
        dao.UpdateFerramenta(objeto);
        return true;      
    }
    
    public Ferramenta carregaFerramenta(int id) {
        Ferramenta objeto = new Ferramenta();
        
        objeto = dao.CarregaFerramenta(id);
        return objeto;
        
    }  
    
    public boolean setDisponivel(int id) {       
       dao.SetDisponivel(id);
       return true;      
    }
    
    public boolean setIndisponivel(int id) {       
       dao.SetIndisponivel(id);
       return true;       
    }
    
    public double calcularTotal() {
        ArrayList<Ferramenta> lista = new ArrayList<>();
        lista = this.getMinhaLista();
        double total = 0;
        for (Ferramenta f : lista) {
            total += f.getCusto();
        }
        
        return total;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}

