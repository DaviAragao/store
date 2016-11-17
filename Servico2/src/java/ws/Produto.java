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
@Table(name = "Produto")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
	@NamedQuery(name = "Produto.findByIdProduto", query = "SELECT p FROM Produto p WHERE p.idProduto = :idProduto"),
	@NamedQuery(name = "Produto.findByDescricao", query = "SELECT p FROM Produto p WHERE p.descricao = :descricao"),
	@NamedQuery(name = "Produto.findByMarca", query = "SELECT p FROM Produto p WHERE p.marca = :marca"),
	@NamedQuery(name = "Produto.findByValor", query = "SELECT p FROM Produto p WHERE p.valor = :valor"),
	@NamedQuery(name = "Produto.findByUnidadeMedida", query = "SELECT p FROM Produto p WHERE p.unidadeMedida = :unidadeMedida")})
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(name = "idProduto")
	private Integer idProduto;
	@Basic(optional = false)
        @NotNull
        @Size(min = 1, max = 60)
        @Column(name = "descricao")
	private String descricao;
	@Basic(optional = false)
        @NotNull
        @Size(min = 1, max = 60)
        @Column(name = "marca")
	private String marca;
	@Basic(optional = false)
        @NotNull
        @Size(min = 1, max = 60)
        @Column(name = "valor")
	private String valor;
	@Basic(optional = false)
        @NotNull
        @Size(min = 1, max = 60)
        @Column(name = "unidadeMedida")
	private String unidadeMedida;

	public Produto() {
	}

	public Produto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public Produto(Integer idProduto, String descricao, String marca, String valor, String unidadeMedida) {
		this.idProduto = idProduto;
		this.descricao = descricao;
		this.marca = marca;
		this.valor = valor;
		this.unidadeMedida = unidadeMedida;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idProduto != null ? idProduto.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Produto)) {
			return false;
		}
		Produto other = (Produto) object;
		if ((this.idProduto == null && other.idProduto != null) || (this.idProduto != null && !this.idProduto.equals(other.idProduto))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ws.Produto[ idProduto=" + idProduto + " ]";
	}
	
}
