/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author 20172PF.CC0095
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "livro_basico")
public class LivroBasico implements Serializable {
    
    @Id
    @NotBlank(message = "O ISBN deve ser informado")
    @Length(max = 20, message = "O ISBN não pode ter mais que {max} caracteres")
    @Column(name = "isbn", length = 20, nullable = false)
    private String ISBN;
    
    @NotBlank(message = "O titulo deve ser informado")
    @Length(max = 30, message = "O titulo não pode ter mais que {max} caracteres")
    @Column(name = "titulo", length = 30, nullable = false)    
    private String titulo;
    
    @NotBlank(message = "O resumo deve ser informada")
    @Length(max = 140, message = "O resumo não pode ter mais que {max} caracteres")
    @Column(name = "resumo", length = 140, nullable = false)    
    private String resumo;
    
    @NotBlank(message = "A editora deve ser informada")
    @Length(max = 20, message = "A editora não pode ter mais que {max} caracteres")
    @Column(name = "editora", length = 20, nullable = false)    
    private String editora;
    
    @NotNull(message = "A data de publicação deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "data_publicacao", nullable = false)
    private Calendar dataPublicacao;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "autores", 
            joinColumns = 
                    @JoinColumn(name = "livro_basico", 
                            referencedColumnName = "isbn", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "autor", 
                    referencedColumnName = "id", nullable = false))
    private Set<Autor> autores = new HashSet<>();

    public LivroBasico() {
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Calendar getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Calendar dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.ISBN);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LivroBasico other = (LivroBasico) obj;
        if (!Objects.equals(this.ISBN, other.ISBN)) {
            return false;
        }
        return true;
    }
    
    
    
}
