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
    
    public static Integer generarNumeroRandom() {
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(50) + 1;        
    }
}
