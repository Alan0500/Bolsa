/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.security.Principal;
import java.util.HashSet;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Empresa;
import modelo.EmpresaDAO;
/**
 *
 * @author Alan
 */
//Etiqueta para decirle a jsf que esta clase es un controlador
@ManagedBean
//Etiqueta para que viva este bean hasta que se cambie de pagina. util para jax
@ViewScoped

public class GuardaEmpresa {
    private String nombre;
    private String oficinas;
    private Integer numempleados;
    private String contacto;
    private Set vacantes = new HashSet(0);
    
    public String getNombre() {
        return nombre;
    }
    public String getOficinas() {
        return oficinas;
    }
    public Integer getNumEmpleados() {
        return numempleados;
    }
    public String getContacto() {
        return contacto;
    }
    public Set getVacantes() {
        return vacantes;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setOficinas(String oficinas) {
        this.oficinas=oficinas;
    }
    public void setNumEmpleados(Integer numempleados) {
        this.numempleados=numempleados;
    }
    public void setContacto(String contacto) {
        this.contacto=contacto;
    }
    public void setVacantes(Set vacantes) {
        this.vacantes=vacantes;
    }
    /**
     * peticion que guarda un proyecto 
     */
    public String guardaEmpresa(){
        Empresa p = new Empresa();
        p.setNombre(nombre);
        p.setOficinas(oficinas);
        p.setNumempleados(numempleados);
        p.setVacantes(vacantes);
        p.setContacto(contacto);
        EmpresaDAO pd = new EmpresaDAO();
        pd.nuevaEmpresa(p);
        
        return "inicio";
    }
}
