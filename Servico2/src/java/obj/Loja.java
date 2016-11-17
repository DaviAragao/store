package obj;

public class Loja  implements java.io.Serializable {


     private Integer idLoja;
     private String nome;
     private String telefone;
     private String email;

    public Loja() {
    }

    public Loja(String nome, String telefone, String email) {
       this.nome = nome;
       this.telefone = telefone;
       this.email = email;
    }
   
    public Integer getIdLoja() {
        return this.idLoja;
    }
    
    public void setIdLoja(Integer idLoja) {
        this.idLoja = idLoja;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTelefone() {
        return this.telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
}


