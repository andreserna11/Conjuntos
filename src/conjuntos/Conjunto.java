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
        for (int i = 3; i <= 24; i+=3) conjuntoLista.agregar(i);
        for (int i = 2; i <= 24; i+=2) conjuntoLista2.agregar(i);
        conjuntoLista.mostrar();
        ((ConjuntoLista) conjuntoLista.diferencia(conjuntoLista2)).mostrar();
        conjuntoLista2.mostrar();
        ((ConjuntoLista) conjuntoLista2.diferencia(conjuntoLista)).mostrar();
    }
}
