/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.entidades;

/**
 *
 * @author sala203
 */
public class Nodo {
    
    private Nodo ligaAnterior;
    private Boolean isPadre;
    private Character dato;
    private Nodo ligaSiguiente;
    
    public Nodo(){
        
    }

    public Nodo(Nodo ligaAnterior, Boolean isPadre, Character dato, Nodo ligaSiguiente) {
        this.ligaAnterior = ligaAnterior;
        this.isPadre = isPadre;
        this.dato = dato;
        this.ligaSiguiente = ligaSiguiente;
    }

    public Nodo getLigaAnterior() {
        return ligaAnterior;
    }

    public void setLigaAnterior(Nodo ligaAnterior) {
        this.ligaAnterior = ligaAnterior;
    }

    public Boolean getIsPadre() {
        return isPadre;
    }

    public void setIsPadre(Boolean isPadre) {
        this.isPadre = isPadre;
    }

    public Character getDato() {
        return dato;
    }

    public void setDato(Character dato) {
        this.dato = dato;
    }

    public Nodo getLigaSiguiente() {
        return ligaSiguiente;
    }

    public void setLigaSiguiente(Nodo ligaSiguiente) {
        this.ligaSiguiente = ligaSiguiente;
    }


    
}
