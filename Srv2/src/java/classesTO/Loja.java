package classesTO;


import java.util.HashSet;
import java.util.Set;

public class Loja
{
     private Integer idLoja;
     private String nome;
     private String telefone;
     private String email;
     private Set pessoalojas = new HashSet(0);

    public Loja() {
    }

	
    public Loja(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }
    public Loja(String nome, String telefone, String email, Set pessoalojas) {
       this.nome = nome;
       this.telefone = telefone;
       this.email = email;
       this.pessoalojas = pessoalojas;
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
    public Set getPessoalojas() {
        return this.pessoalojas;
    }
    
    public void setPessoalojas(Set pessoalojas) {
        this.pessoalojas = pessoalojas;
    }
}