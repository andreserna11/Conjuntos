/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntos;

import java.util.Arrays;
import java.util.Scanner;

import co.com.listas.entidades.ConjuntoLista;

public class Conjunto {

    public static void main(String[] args) throws Exception {
        ConjuntoLista conjuntoLista = new ConjuntoLista();
        ConjuntoLista conjuntoLista2 = new ConjuntoLista();
        conjuntoLista.agregar(1);
        System.out.println("Es vacío: " + conjuntoLista.esVacio());
        System.out.println("Es vacío: " + conjuntoLista2.esVacio());
    }
}
