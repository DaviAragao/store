package obj;
// Generated 16/11/2016 21:28:18 by Hibernate Tools 4.3.1



/**
 * Cliente generated by hbm2java
 */
public class Cliente  implements java.io.Serializable {


     private Integer idCliente;
     private String fiador;
     private String contatofiador;

    public Cliente() {
    }

    public Cliente(String fiador, String contatofiador) {
       this.fiador = fiador;
       this.contatofiador = contatofiador;
    }
   
    public Integer getIdCliente() {
        return this.idCliente;
    }
    
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    public String getFiador() {
        return this.fiador;
    }
    
    public void setFiador(String fiador) {
        this.fiador = fiador;
    }
    public String getContatofiador() {
        return this.contatofiador;
    }
    
    public void setContatofiador(String contatofiador) {
        this.contatofiador = contatofiador;
    }




}


