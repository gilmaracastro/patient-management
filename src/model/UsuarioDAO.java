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

/**
 *
 * @author gil
 */
public class UsuarioDAO {

    private final Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean existeNoBancoPorUsuarioESenha(Usuario usuario) throws SQLException {
        String sql = "select * from usuario where cpfusuario = ? and senhausuario = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, usuario.getCpfUsuario());
        statement.setString(2, usuario.getSenhaUsuario());
        statement.execute();

        ResultSet resultSet = statement.getResultSet();

        return resultSet.next();
    }

    public void insert(Usuario usuario) throws SQLException {
        String sql = "INSERT into tusurio(usuario, senha) values(?,?);";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, usuario.getCpfUsuario());
        statement.setString(2, usuario.getSenhaUsuario());
        statement.execute();
    }
}
