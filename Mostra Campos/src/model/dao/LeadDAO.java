/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import conneciton.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Lead;

/**
 *
 * @author Samuelson
 */
public class LeadDAO {

    public void create(Lead p) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO leads (Nome,Endereco,Idade,Curso)VALUES(?,?,?,?)");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getEndereco());
            stmt.setInt(3, p.getIdade());
            stmt.setString(4, p.getCurso());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
           ConnectionFactory.cloceConnection(con, stmt);
        }

    }

    public List<Lead> read() {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Lead> cadastros = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM leads");
            rs = stmt.executeQuery();

            while (rs.next()) {

                

                Lead pessoas = new Lead();
                
                pessoas.setNome(rs.getString("Nome"));
                pessoas.setEndereco(rs.getString("Endereco"));
                pessoas.setIdade(rs.getInt("Idade"));
                pessoas.setCurso(rs.getString("Curso"));
                cadastros.add(pessoas);
            }

        } catch (SQLException ex) {
                 Logger.getLogger(LeadDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.cloceConnection(con, stmt, rs);
        }

        return cadastros;

    }
    public List<Lead> readForDesc(String nome) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Lead> cadastros = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM leads WHERE Nome LIKE ?");
            stmt.setString(1, "%"+nome+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Lead p = new Lead();

                p.setNome(rs.getString("Nome"));
                p.setEndereco(rs.getString("Endereco"));
                p.setIdade(rs.getInt("Idade"));
                p.setCurso(rs.getString("Curso"));
                 cadastros.add(p);
            }

        } catch (SQLException ex) {
               Logger.getLogger(LeadDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.cloceConnection(con, stmt, rs);
        }

        return cadastros;

    }
/*
    public void update(Produto p) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE produto SET descricao = ? ,qtd = ?,preco = ? WHERE id = ?");
            stmt.setString(1, p.getDescricao());
            stmt.setInt(2, p.getQtd());
            stmt.setDouble(3, p.getPreco());
            stmt.setInt(4, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    public void delete(Produto p) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM produto WHERE id = ?");
            stmt.setInt(1, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }*/

}
