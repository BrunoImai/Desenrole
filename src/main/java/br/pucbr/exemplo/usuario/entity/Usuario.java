package br.pucbr.exemplo.usuario.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message = "ERR: 001 - O NOME NÃO PODE SER NULO")
    @Column(name = "NOME", nullable = false)
    private String nome;

    @NotNull(message = "ERR: 001 - O LOGIN NÃO PODE SER NULO")
    @Column(name = "LOGIN", nullable = false, unique = true)
    private String login;

    @NotNull(message = "ERR: 001 - A SENHA NÃO PODE SER NULA")
    @Column(name = "SENHA", nullable = false)
    private String senha;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
