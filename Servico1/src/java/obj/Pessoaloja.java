package obj;
// Generated 16/11/2016 21:28:18 by Hibernate Tools 4.3.1



/**
 * Pessoaloja generated by hbm2java
 */
public class Pessoaloja  implements java.io.Serializable {


     private Integer idPessoaLoja;
     private Loja loja;
     private Pessoa pessoa;

    public Pessoaloja() {
    }

    public Pessoaloja(Loja loja, Pessoa pessoa) {
       this.loja = loja;
       this.pessoa = pessoa;
    }
   
    public Integer getIdPessoaLoja() {
        return this.idPessoaLoja;
    }
    
    public void setIdPessoaLoja(Integer idPessoaLoja) {
        this.idPessoaLoja = idPessoaLoja;
    }
    public Loja getLoja() {
        return this.loja;
    }
    
    public void setLoja(Loja loja) {
        this.loja = loja;
    }
    public Pessoa getPessoa() {
        return this.pessoa;
    }
    
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }




}

