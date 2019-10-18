/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.vector.entidades;

/**
 *
 * @author sala203
 */
public abstract class AbstractConjuntoVector {
    
    public Integer cantidad;
    public Integer[] vec;

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer[] getVec() {
        return vec;
    }

    public void setVec(Integer[] vec) {
        this.vec = vec;
    }
          
}
