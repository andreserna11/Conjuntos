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
    
    private Nodo ligaLista;
    private Boolean isRaiz;
    private Character dato;
    private Nodo liga;
    
    public Nodo(){
        
    }

    public Nodo(Nodo ligaLista, Boolean isRaiz, Character dato, Nodo liga) {
        this.ligaLista = ligaLista;
        this.isRaiz = isRaiz;
        this.dato = dato;
        this.liga = liga;
    }

    public Nodo getLigaLista() {
        return ligaLista;
    }

    public void setLigaLista(Nodo ligaLista) {
        this.ligaLista = ligaLista;
    }

    public Boolean getIsRaiz() {
        return isRaiz;
    }

    public void setIsRaiz(Boolean isRaiz) {
        this.isRaiz = isRaiz;
    }

    public Character getDato() {
        return dato;
    }

    public void setDato(Character dato) {
        this.dato = dato;
    }

    public Nodo getLiga() {
        return liga;
    }

    public void setLiga(Nodo liga) {
        this.liga = liga;
    }
    
    
}
