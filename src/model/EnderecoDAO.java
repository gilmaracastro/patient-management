/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author gil
 */
public class EnderecoDAO {
    private final Connection connection;
    
    public EnderecoDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void insert(Endereco endereco) throws SQLException {
        String sql = "INSERT into endereco(cep,rua,numero,bairro,cidade,uf,complemento) values(?,?,?,?,?,?,?);";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, endereco.getCep());
        statement.setString(2, endereco.getRua());
        statement.setString(3, endereco.getNumero());
        statement.setString(4, endereco.getBairro());
        statement.setString(5, endereco.getCidade());
        statement.setString(6, endereco.getUf());
        statement.setString(7, endereco.getComplemento());
        statement.execute();
    }
}
