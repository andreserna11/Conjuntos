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
        ConjuntoLista conjuntoLista = new ConjuntoLista();
        ConjuntoLista conjuntoLista2 = new ConjuntoLista();
        ConjuntoLista conjuntoLista3 = new ConjuntoLista();
        for (int i = 1; i <= 10; i++) conjuntoLista.agregar(i);
        for (int i = 11; i <= 20; i++) conjuntoLista2.agregar(i);
        for (int i = 1; i <= 10; i++) conjuntoLista3.agregar(i);
        System.out.println("igualdad entre 1 y 2: " + conjuntoLista.igualdad(conjuntoLista2));
        System.out.println("igualdad entre 2 y 3: " + conjuntoLista2.igualdad(conjuntoLista3));
        System.out.println("igualdad entre 1 y 3: " + conjuntoLista.igualdad(conjuntoLista3));
        
    }
}
