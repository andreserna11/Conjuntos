/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.listas.entidades;

/**
 *
 * @author sala203
 */
public class Nodo {
    
    private Integer dato;
    private Nodo ligaSiguiente;
    
    public Nodo(){
        
    }

    public Nodo(Integer dato, Nodo ligaSiguiente) {
        this.dato = dato;
        this.ligaSiguiente = ligaSiguiente;
    }

    public Integer getDato() {
        return dato;
    }

    public void setDato(Integer dato) {
        this.dato = dato;
    }

    public Nodo getLigaSiguiente() {
        return ligaSiguiente;
    }

    public void setLigaSiguiente(Nodo ligaSiguiente) {
        this.ligaSiguiente = ligaSiguiente;
    }


    
}
