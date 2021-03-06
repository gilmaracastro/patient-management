/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;

/**
 *
 * @author gil
 */
public class Paciente {
    private String cpf;
    private String nome;
    private String cns;
    private Endereco endereco;
    
    public Paciente(String nome, String cpf, String cns, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.cns = cns;
        this.endereco = endereco;
    }
    
     public Paciente(String nome, String cpf, String cns) {
        this.nome = nome;
        this.cpf = cpf;
        this.cns = cns;
    }
    
    public Paciente() {
        
    }

    public Paciente(Connection minhaConexao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cns
     */
    public String getCns() {
        return cns;
    }

    /**
     * @param cns the cns to set
     */
    public void setCns(String cns) {
        this.cns = cns;
    }    

    /**
     * @return the endereco
     */
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
