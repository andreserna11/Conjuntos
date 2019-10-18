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
        for (int i = 1; i <= 5; i++) conjuntoLista.agregar(i);
        conjuntoLista.mostrar();
        conjuntoLista.borrar(3);
        conjuntoLista.mostrar();
        conjuntoLista.borrar(5);
        conjuntoLista.mostrar();
        conjuntoLista.borrar(1);
        conjuntoLista.mostrar();
        
    }
}
