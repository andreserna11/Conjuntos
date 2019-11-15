/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.vector.entidades;

import co.com.interfaces.IConjunto;
import co.com.utilidades.Utilidades;
import java.util.Arrays;

/**
 *
 * @author sala203
 */
public class ConjuntoVectorUniversal {

    private static ConjuntoVector universal;

    private ConjuntoVectorUniversal() {
    }

    public static IConjunto obtenerUniversal() {
        if (universal == null) {
            Integer[] vec = new Integer[Utilidades.TAMANO_CONJUNTO];
            universal = new ConjuntoVector(vec);
            for (int i = 0; i < Utilidades.TAMANO_CONJUNTO; i++) {
                int dato;
                boolean pertenece = false;
                do {
                    dato = Utilidades.generarNumeroRandom();
                } while (universal.pertenece(dato));
                vec[i] = (dato);
            }
            mostrarUniversal();
        }
        return universal;
    }

    public static String mostrarUniversal() {
        obtenerUniversal();
        return universal.toString();
    }

}
