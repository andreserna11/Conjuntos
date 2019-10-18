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
        for (int i = 1; i <= 10; i++) conjuntoLista.agregar(i);
        System.out.println("posicion \"1\": " + conjuntoLista.posicion(1));
        System.out.println("posicion \"5\": " + conjuntoLista.posicion(5));
        System.out.println("posicion \"7\": " + conjuntoLista.posicion(7));
        System.out.println("posicion \"10\": " + conjuntoLista.posicion(10));
        System.out.println("posicion \"27\": " + conjuntoLista.posicion(27));
    }
}
