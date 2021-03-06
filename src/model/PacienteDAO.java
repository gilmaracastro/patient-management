/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author gil
 */
public class PacienteDAO {

    private final Connection connection;

    public PacienteDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(Paciente paciente) throws SQLException {
        String sql = "INSERT into paciente(nome, cpf, cns, cep) values(?,?,?,?);";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, paciente.getNome());
        statement.setString(2, paciente.getCpf());
        statement.setString(3, paciente.getCns());
        statement.setString(4, paciente.getEndereco().getCep());
        statement.execute();
    }

    private ArrayList<Paciente> pesquisa(PreparedStatement statement) throws SQLException {
        ArrayList<Paciente> todosPacientes = new ArrayList<Paciente>();
        statement.execute();

        ResultSet resultSet = statement.getResultSet();

        while (resultSet.next()) {

            String cpf = resultSet.getString("cpf");

            String nome = resultSet.getString("nome");
            String cns = resultSet.getString("cns");

            Paciente pacienteComDadosDoBanco = new Paciente(nome, cpf, cns);
            todosPacientes.add(pacienteComDadosDoBanco);
        }
        return todosPacientes;
    }

    public Paciente selectPorChave(String cpf) throws SQLException {
        String sql = "select * from paciente where cpf = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, cpf);
        return pesquisa(statement).get(0);
    }

    public void update(Paciente paciente) throws SQLException {
        String sql = "update paciente set nome = ?, cns = ? WHERE cpf = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, paciente.getNome());
        statement.setString(2, paciente.getCns());
        statement.setString(3, paciente.getCpf());
        statement.execute();
    }

    public void delete(Paciente paciente) {
        String sql = "delete from paciente WHERE cpf = ?";
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, paciente.getCpf());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
