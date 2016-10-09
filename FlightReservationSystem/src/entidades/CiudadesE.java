/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author jossava
 */
public class CiudadesE {
    private int idCiudad=0;
    private String nombreciudad="";

    public CiudadesE(int idCiudad,String nombreciudad) {
        this.idCiudad=idCiudad;
        this.nombreciudad=nombreciudad;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombreCiudad() {
        return nombreciudad;
    }

    public void setNombreCiudad(String ciudad) {
        this.nombreciudad = ciudad;
    }
    
}
