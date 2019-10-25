/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.vector.entidades;

import co.com.utilidades.Utilidades;

/**
 *
 * @author sala203
 */
public class ConjuntoVectorUniversal extends AbstractConjuntoVector{
    
    public ConjuntoVectorUniversal(){
        this.cantidad = Utilidades.TAMANO_CONJUNTO;
        this.vec = new Integer[this.cantidad];
        for (int i = 0; i < this.cantidad; i++) {            
            Utilidades.insertarElementoRandom(i, this.vec);
        }
    }       
    
}
