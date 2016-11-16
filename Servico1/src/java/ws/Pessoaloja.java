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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aluno
 */
@Entity
@Table(name = "pessoaloja")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pessoaloja.findAll", query = "SELECT p FROM Pessoaloja p"),
    @NamedQuery(name = "Pessoaloja.findByIdPessoaLoja", query = "SELECT p FROM Pessoaloja p WHERE p.idPessoaLoja = :idPessoaLoja")})
public class Pessoaloja implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPessoaLoja")
    private Integer idPessoaLoja;
    @JoinColumn(name = "idLoja", referencedColumnName = "idLoja")
    @ManyToOne
    private Loja idLoja;
    @JoinColumn(name = "idPessoa", referencedColumnName = "idPessoa")
    @ManyToOne
    private Pessoa idPessoa;

    public Pessoaloja() {
    }

    public Pessoaloja(Integer idPessoaLoja) {
        this.idPessoaLoja = idPessoaLoja;
    }

    public Integer getIdPessoaLoja() {
        return idPessoaLoja;
    }

    public void setIdPessoaLoja(Integer idPessoaLoja) {
        this.idPessoaLoja = idPessoaLoja;
    }

    public Loja getIdLoja() {
        return idLoja;
    }

    public void setIdLoja(Loja idLoja) {
        this.idLoja = idLoja;
    }

    public Pessoa getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Pessoa idPessoa) {
        this.idPessoa = idPessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPessoaLoja != null ? idPessoaLoja.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoaloja)) {
            return false;
        }
        Pessoaloja other = (Pessoaloja) object;
        if ((this.idPessoaLoja == null && other.idPessoaLoja != null) || (this.idPessoaLoja != null && !this.idPessoaLoja.equals(other.idPessoaLoja))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ws.Pessoaloja[ idPessoaLoja=" + idPessoaLoja + " ]";
    }
    
}
