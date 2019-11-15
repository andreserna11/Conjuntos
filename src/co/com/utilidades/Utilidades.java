/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.utilidades;

import java.util.Random;

/**
 *
 * @author sala203
 */
public class Utilidades {
    
    public static Integer TAMANO_CONJUNTO = 10;
    public static Integer RANGO_NUMEROS = 20;
    
    public static Integer generarNumeroRandom() {
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(RANGO_NUMEROS) + 1;        
    }
    
    public static Boolean elementoExisteVector(Integer elemento, Integer[] vec){
        for (int i = 0; i < vec.length; i++) {
            if(vec[i] != null && vec[i].equals(elemento))
                return true;            
        }
        return false;
    }
    
    public static void insertarElementoRandom(Integer index, Integer[] vec){
        Integer numero = Utilidades.generarNumeroRandom();
            if(!elementoExisteVector(numero, vec))
                vec[index] = numero;
            else
                insertarElementoRandom(index, vec);
    }
}
