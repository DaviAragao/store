/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aluno
 */
@Entity
@Table(name = "Loja")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Loja.findAll", query = "SELECT l FROM Loja l"),
	@NamedQuery(name = "Loja.findByIdLoja", query = "SELECT l FROM Loja l WHERE l.idLoja = :idLoja"),
	@NamedQuery(name = "Loja.findByNome", query = "SELECT l FROM Loja l WHERE l.nome = :nome"),
	@NamedQuery(name = "Loja.findByTelefone", query = "SELECT l FROM Loja l WHERE l.telefone = :telefone"),
	@NamedQuery(name = "Loja.findByEmail", query = "SELECT l FROM Loja l WHERE l.email = :email")})
public class Loja implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(name = "idLoja")
	private Integer idLoja;
	@Basic(optional = false)
        @NotNull
        @Size(min = 1, max = 60)
        @Column(name = "nome")
	private String nome;
	@Basic(optional = false)
        @NotNull
        @Size(min = 1, max = 60)
        @Column(name = "telefone")
	private String telefone;
	// @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
	@Basic(optional = false)
        @NotNull
        @Size(min = 1, max = 60)
        @Column(name = "email")
	private String email;

	public Loja() {
	}

	public Loja(Integer idLoja) {
		this.idLoja = idLoja;
	}

	public Loja(Integer idLoja, String nome, String telefone, String email) {
		this.idLoja = idLoja;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}

	public Integer getIdLoja() {
		return idLoja;
	}

	public void setIdLoja(Integer idLoja) {
		this.idLoja = idLoja;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idLoja != null ? idLoja.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Loja)) {
			return false;
		}
		Loja other = (Loja) object;
		if ((this.idLoja == null && other.idLoja != null) || (this.idLoja != null && !this.idLoja.equals(other.idLoja))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ws.Loja[ idLoja=" + idLoja + " ]";
	}
	
}
