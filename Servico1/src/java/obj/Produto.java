package obj;
// Generated 16/11/2016 21:28:18 by Hibernate Tools 4.3.1



/**
 * Produto generated by hbm2java
 */
public class Produto  implements java.io.Serializable {


     private Integer idProduto;
     private String descricao;
     private String marca;
     private String valor;
     private String unidadeMedida;

    public Produto() {
    }

    public Produto(String descricao, String marca, String valor, String unidadeMedida) {
       this.descricao = descricao;
       this.marca = marca;
       this.valor = valor;
       this.unidadeMedida = unidadeMedida;
    }
   
    public Integer getIdProduto() {
        return this.idProduto;
    }
    
    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getMarca() {
        return this.marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getValor() {
        return this.valor;
    }
    
    public void setValor(String valor) {
        this.valor = valor;
    }
    public String getUnidadeMedida() {
        return this.unidadeMedida;
    }
    
    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }




}


