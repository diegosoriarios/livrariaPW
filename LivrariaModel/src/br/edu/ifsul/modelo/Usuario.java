package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
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
 * @author Diego Soria Rios
 * @email diegosoriarios@gmail.com
 * @organization IFSUL - Campus Passo Fundo
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "usuario")
public class Usuario implements Serializable {
    
    @Id
    @NotBlank(message = "O nome de usuário deve ser informado")
    @Length(max = 20, message = "O nome de usuário não pode ter mais que {max} caracteres")
    @Column(name = "nome_usuario", length = 20, nullable = false)
    private String nomeUsuario;
    @NotBlank(message = "A senha deve ser informada")
    @Length(max = 20, message = "A senha não pode ter mais que {max} caracteres")
    @Column(name = "senha", length = 20, nullable = false)    
    private String senha;
    @NotNull(message = "A data de cadastro deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "data_cadastro", nullable = false)
    private Calendar dataCadastro;
    @NotBlank(message = "O nome  deve ser informado")
    @Length(max = 50, message = "O nome  não pode ter mais que {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)    
    private String nome;
    @NotBlank(message = "O email deve ser informado")
    @Length(max = 60, message = "O email não pode ter mais que {max} caracteres")
    @Column(name = "email", length = 60, nullable = false)    
    private String email;
    @NotBlank(message = "O telefone principal deve ser informado")
    @Length(max = 14, message = "O telefone principal pode ter mais que {max} caracteres")
    @Column(name = "telefone_principal", length = 14, nullable = false)     
    private String telefonePrincipal;
    @Length(max = 14, message = "O telefone alternativo pode ter mais que {max} caracteres")
    @Column(name = "telefone_alternativo", length = 14)         
    private String telefoneAlternativo;
    
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "permissoes", 
            joinColumns = 
                    @JoinColumn(name = "usuario", 
                            referencedColumnName = "nome_usuario", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "permissao", 
                    referencedColumnName = "nome", nullable = false))
    private Set<Permissao> permissoes = new HashSet<>();
    
    
    public Usuario(){
        dataCadastro = Calendar.getInstance();
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Calendar getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Calendar dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefonePrincipal() {
        return telefonePrincipal;
    }

    public void setTelefonePrincipal(String telefonePrincipal) {
        this.telefonePrincipal = telefonePrincipal;
    }

    public String getTelefoneAlternativo() {
        return telefoneAlternativo;
    }

    public void setTelefoneAlternativo(String telefoneAlternativo) {
        this.telefoneAlternativo = telefoneAlternativo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.nomeUsuario);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.nomeUsuario, other.nomeUsuario)) {
            return false;
        }
        return true;
    }

    public Set<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(Set<Permissao> permissoes) {
        this.permissoes = permissoes;
    }

}
