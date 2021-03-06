/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author gil
 */
public class Usuario {
    private String cpfUsuario;
    private String senhaUsuario;
    
    public Usuario(String cpfUsuario, String senhaUsuario) {
        this.cpfUsuario = cpfUsuario;
        this.senhaUsuario = senhaUsuario;
    }    

    /**
     * @return the cpfUsuario
     */
    public String getCpfUsuario() {
        return cpfUsuario;
    }

    /**
     * @return the senhaUsuario
     */
    public String getSenhaUsuario() {
        return senhaUsuario;
    }
}
