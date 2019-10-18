/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntos;

import java.util.Arrays;
import java.util.Scanner;

import co.com.listas.entidades.ConjuntoLista;
import co.com.vector.entidades.ConjuntoVector;

public class Conjunto {

    public static void main(String[] args) throws Exception {
        ConjuntoLista conjuntoLista1 = new ConjuntoLista();
        ConjuntoLista conjuntoLista2 = new ConjuntoLista();
        ConjuntoLista conjuntoLista3 = new ConjuntoLista();
        for (int i = 1; i <= 10; i++) conjuntoLista1.agregar(i);
        for (int i = 1; i <= 15; i++) conjuntoLista2.agregar(i);
        for (int i = 1; i <= 10; i++) conjuntoLista3.agregar(i);
        System.out.println("comparacion 1 y 2: " + conjuntoLista1.compararDimensionConjuntos(conjuntoLista2));
        System.out.println("comparacion 2 y 1: " + conjuntoLista2.compararDimensionConjuntos(conjuntoLista1));
        System.out.println("comparacion 2 y 3: " + conjuntoLista2.compararDimensionConjuntos(conjuntoLista3));
        System.out.println("comparacion 3 y 2: " + conjuntoLista3.compararDimensionConjuntos(conjuntoLista2));
        System.out.println("comparacion 1 y 3: " + conjuntoLista1.compararDimensionConjuntos(conjuntoLista3));
        System.out.println("comparacion 3 y 1: " + conjuntoLista3.compararDimensionConjuntos(conjuntoLista1));
        
    }
}
