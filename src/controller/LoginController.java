/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuario;
import model.UsuarioDAO;
import view.Dashboard;
import view.TelaLogin;

/**
 *
 * @author gil
 */
public class LoginController {
    private TelaLogin view;
    
    public LoginController(TelaLogin view) {
        this.view = view;
    }
    
    public void autenticar() throws SQLException {
        String cpf = view.getCampoCpf().getText();
        String senha = view.getCampoSenha().getText();
        
        Usuario usuarioAutenticar = new Usuario(cpf, senha);
        
        Connection conexao = new Conexao().getConnection();
        UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
        
        boolean existe = usuarioDao.existeNoBancoPorUsuarioESenha(usuarioAutenticar);
        
        if (existe) {
            Dashboard dasboard = new Dashboard();
            dasboard.setVisible(true);
            view.dispose();
        } else {
            JOptionPane.showConfirmDialog(view, "Usuario ou senha inválidos");
        }
    }
}
