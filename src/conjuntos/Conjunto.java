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
        ConjuntoLista subconjuntoLista = new ConjuntoLista();
        ConjuntoLista noSubconjuntoLista = new ConjuntoLista();
        for (int i = 1; i <= 10; i++) conjuntoLista.agregar(i);
        for (int i = 3; i <= 8; i++) subconjuntoLista.agregar(i);
        for (int i = 8; i <= 12; i++) noSubconjuntoLista.agregar(i);
        conjuntoLista.agregar(2);
        conjuntoLista.getLista().recorrerLista();
        System.out.println("---");
        subconjuntoLista.getLista().recorrerLista();
        System.out.println("es subconjunto: " + conjuntoLista.subconjunto(subconjuntoLista));
        noSubconjuntoLista.getLista().recorrerLista();
        System.out.println("es subconjunto: " + conjuntoLista.subconjunto(noSubconjuntoLista));
        conjuntoLista.pertenece(1);
        conjuntoLista.pertenece(2);

    }
}
