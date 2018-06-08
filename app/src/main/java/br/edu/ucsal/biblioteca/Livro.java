package br.edu.ucsal.biblioteca;

import java.io.Serializable;

/**
 * Created by android on 20/04/2018.
 */

public class Livro implements Serializable {

    private String titulo;
    private String autor;
    private Integer edicao;
    private Integer anoLancamento;
    private String descricao;
    private String curso;


    @Override
    public String toString() {
        return titulo;
    }

    public Livro(String titulo, String autor, Integer edicao, Integer anoLancamento, String descricao, String curso) {
        this.titulo = titulo;
        this.autor = autor;
        this.edicao = edicao;
        this.anoLancamento = anoLancamento;
        this.descricao = descricao;
        this.curso = curso;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getEdicao() {
        return edicao;
    }

    public void setEdicao(Integer edicao) {
        this.edicao = edicao;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}