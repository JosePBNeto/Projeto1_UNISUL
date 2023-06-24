/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.EmprestimoDAO;
import Model.Amigo;
import Model.Ferramenta;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;


public class Emprestimo {
    
    private int id;
    private Amigo amigo;
    private Ferramenta ferramenta;
    private Date dataEmprestimo;
    private Date dataDevolucao;
    private boolean status = true;
   
    private final EmprestimoDAO dao;
    
    public Emprestimo(){
        this.dao = new EmprestimoDAO();
    }
    
   public Emprestimo(int id, Amigo amigo, Ferramenta ferramenta, Date dataEmprestimo, Date dataDevolucao){
       this.id = id;
       this.amigo = amigo;
       this.ferramenta = ferramenta;
       this.dataEmprestimo = dataEmprestimo;
       this.dataDevolucao = dataDevolucao;
       
       this.dao = new EmprestimoDAO();
   }
      public Emprestimo(int id, Amigo amigo, Ferramenta ferramenta, Date dataEmprestimo, Date dataDevolucao, boolean status){
       this.id = id;
       this.amigo = amigo;
       this.ferramenta = ferramenta;
       this.dataEmprestimo = dataEmprestimo;
       this.dataDevolucao = dataDevolucao;
       this.status = status;
       
       this.dao = new EmprestimoDAO();
   }
   
    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean atividade) {
        this.status = atividade;
    }
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Amigo getAmigo() {
        return amigo;
    }

    public void setAmigo(Amigo amigo) {
        this.amigo = amigo;
    }

    public Ferramenta getFerramenta() {
        return ferramenta;
    }

    public void setFerramenta(Ferramenta ferramenta) {
        this.ferramenta = ferramenta;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    @Override
    public String toString() {
        return "Emprestimo{" + "id=" + id + ", amigo=" + amigo + ", ferramenta=" + ferramenta + ", dataEmprestimo=" + dataEmprestimo + ", dataDevolucao=" + dataDevolucao + ", status=" + status + '}';
    }

   
   // METODOS DE CONEXAO COM DAO
    
    public ArrayList getMinhaLista() {
        return dao.getMinhaLista();
    }
    
    public int maiorID() throws SQLException {
        return dao.maiorID();
    }
    
    public boolean InsertEmprestimoBD(Amigo amigo, Ferramenta ferramenta, Date dataEmprestimo, Date dataDevolucao ) throws SQLException {
        int id = this.maiorID() + 1;
        Emprestimo objeto = new Emprestimo(id, amigo, ferramenta, dataEmprestimo, dataDevolucao);
        dao.InsertEmprestimoDB(objeto);

        return true;
    }
    
    public Emprestimo CarregaEmprestimo(int id) {
        Emprestimo emprestimo = new Emprestimo();
        emprestimo = dao.CarregarEmprestimo(id);
        return emprestimo;
    }
   public boolean SetStatusBD(int id, boolean status) {
       dao.SetStatus(id, status);
       return true;
   }
   public boolean setAmigoIdToNull(int id) {
       dao.setAmigoIdToNull(id);
       return true;
   }
   
   public boolean setFerramentaIdToNull(int id) {
       dao.setFerramentaIdToNull(id);
       return true;
   }
    
}
