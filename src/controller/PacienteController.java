/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Endereco;
import model.EnderecoDAO;
import model.Paciente;
import model.PacienteDAO;
import model.Usuario;
import model.UsuarioDAO;
import view.AdicionaPaciente;
import view.Dashboard;

/**
 *
 * @author gil
 */
public class PacienteController {

    private AdicionaPaciente view;

    public PacienteController(AdicionaPaciente view) {
        this.view = view;
    }

    public PacienteController() {

    }

    public void salvar() throws SQLException {
        String nome = view.getCampoNome().getText();
        String cpf = view.getCampoCpf().getText();
        String cns = view.getCampoCns().getText();

        java.sql.Connection conexao;
        conexao = new Conexao().getConnection();

        Endereco novoEndereco = new Endereco();
        novoEndereco.setCep(view.getCampoCepPaciente().getText());
        novoEndereco.setRua(view.getCampoRuaPaciente().getText());
        novoEndereco.setNumero(view.getCampoNumeroPaciente().getText());
        novoEndereco.setBairro(view.getCampoBairroPaciente().getText());
        novoEndereco.setCidade(view.getCampoCidadePaciente().getText());
        novoEndereco.setUf(view.getCampoUfPaciente().getText());
        novoEndereco.setComplemento(view.getCampoComplementoPaciente().getText());

        EnderecoDAO enderecoDao = new EnderecoDAO(conexao);
        enderecoDao.insert(novoEndereco);

        Paciente novoPaciente = new Paciente(nome, cpf, cns, novoEndereco);

        try {
            PacienteDAO pacienteDao = new PacienteDAO(conexao);
            pacienteDao.insert(novoPaciente);
            JOptionPane.showMessageDialog(null, "Paciente cadastrado com sucesso");
            Dashboard dashboard = new Dashboard();
            dashboard.setVisible(true);
            dashboard.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(PacienteController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void update(Paciente paciente) throws SQLException {

        java.sql.Connection conexao;
        conexao = new Conexao().getConnection();

        try {
            PacienteDAO pacienteDao = new PacienteDAO(conexao);
            pacienteDao.update(paciente);
            JOptionPane.showMessageDialog(null, "Paciente atualizado com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(PacienteController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void delete(Paciente paciente) throws SQLException {
        java.sql.Connection conexao;
        conexao = new Conexao().getConnection();
        PacienteDAO pacienteDao = new PacienteDAO(conexao);
        pacienteDao.delete(paciente);
        JOptionPane.showMessageDialog(null, "Paciente deletado com sucesso");
    }

    public Paciente getPaciente(String cpf) throws SQLException {
        Connection minhaConexao = new Conexao().getConnection();
        PacienteDAO pacienteDAO = new PacienteDAO(minhaConexao);

        Paciente pacienteEncontrado = pacienteDAO.selectPorChave(cpf);
        return pacienteEncontrado;
    }
}
