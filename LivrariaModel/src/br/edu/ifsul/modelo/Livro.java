/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author 20172PF.CC0095
 */
@Entity
@Table(name = "livro")
public class Livro extends LivroBasico implements Serializable {
    
    @NotBlank(message = "O codigo de barras deve ser informado")
    @Length(max = 20, message = "O codigo de barras não pode ter mais que {max} caracteres")
    @Column(name = "codigo_barras", length = 20, nullable = false)
    private String codigoBarras;
    
    @Column(name = "numero_paginas", nullable = false)
    private Integer numeroPaginas;
    
    @Column(name = "ativo", nullable = false)
    private Boolean ativo;
    
    @NotNull(message = "O cadastro deve ser informado")
    @Temporal(TemporalType.DATE)
    @Column(name = "cadastro", nullable = false)
    private Calendar cadastro;
    
    @Min(value = 0, message = "O valor não pode ser negativo")
    @NotNull(message = "O valor deve ser informado")
    @Column(name = "valor", nullable = false, columnDefinition = "numeric(12, 2)")
    private Double valor;

    @NotNull(message = "O idioma deve ser informado")
    @ManyToOne
    @JoinColumn(name = "idioma", referencedColumnName = "id", 
            nullable = false, foreignKey = @ForeignKey(name = "fk_livro_cidade"))
    private Idioma idioma;
    
    @NotNull(message = "O formato deve ser informado")
    @ManyToOne
    @JoinColumn(name = "formato", referencedColumnName = "id", 
            nullable = false, foreignKey = @ForeignKey(name = "fk_livro_formato"))
    private Formato formato;
    
    @NotNull(message = "O catalogo deve ser informado")
    @ManyToOne
    @JoinColumn(name = "catalogo", referencedColumnName = "id", nullable = false)
    private Catalogo catalogo;
    
    public Livro() {
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(Integer numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Calendar getCadastro() {
        return cadastro;
    }

    public void setCadastro(Calendar cadastro) {
        this.cadastro = cadastro;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }
    
}
