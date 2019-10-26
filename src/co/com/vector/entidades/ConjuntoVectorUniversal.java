/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.vector.entidades;

import co.com.interfaces.IConjunto;
import co.com.listas.entidades.ConjuntoLista;
import co.com.utilidades.Utilidades;

/**
 *
 * @author sala203
 */
public class ConjuntoVectorUniversal {
    
    private static ConjuntoLista universal;
        
    private ConjuntoVectorUniversal() {
    }
    
    public static IConjunto obtenerUniversal() {
        if (universal == null) {
            universal = new ConjuntoLista();
            for (int i = 0; i < Utilidades.TAMANO_CONJUNTO; i++) universal.agregar(Utilidades.generarNumeroRandom());
        }
        return universal;
    }
    
}
