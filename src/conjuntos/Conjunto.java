/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntos;

import co.com.interfaces.IConjunto;
import co.com.listas.entidades.ConjuntoLista;

public class Conjunto {

    public static void main(String[] args) throws Exception {
        ConjuntoLista conjunto1 = new ConjuntoLista();
        ConjuntoLista conjunto2 = new ConjuntoLista();
        ConjuntoLista conjunto3 = new ConjuntoLista();
        ConjuntoLista conjunto4 = new ConjuntoLista();
        ConjuntoLista conjunto5 = new ConjuntoLista();
        ConjuntoLista conjunto6 = new ConjuntoLista();
        for (int i = 5; i <= 10; i++) conjunto1.agregar(i);
        for (int i = 6; i <= 8; i++) conjunto2.agregar(i);
        for (int i = 3; i <= 18; i++) conjunto3.agregar(i);
        for (int i = 15; i <= 19; i++) conjunto5.agregar(i);
        for (int i = 15; i <= 19; i++) conjunto4.agregar(i);
        for (int i = 5; i <= 10; i++) conjunto6.agregar(i);
        conjunto1.pertenece(6);
        conjunto1.pertenece(777);
        System.out.println("conjunto 1:");
        conjunto1.mostrar();
        System.out.println("conjunto 2:");
        conjunto2.mostrar();
        System.out.println("conjunto 3:");
        conjunto3.mostrar();
        System.out.println("complemento conjunto 1:");
        ConjuntoLista conjuntoComplemento = (ConjuntoLista) conjunto1.complemento();
        conjuntoComplemento.mostrar();
        System.out.println("conjunto 2 es subconjunto 1: " + conjunto1.subconjunto(conjunto2));
        System.out.println("conjunto 3 es subconjunto 1: " + conjunto1.subconjunto(conjunto3));
        System.out.println("conjunto 1 es vacio: " + conjunto1.esVacio());
        System.out.println("conjunto 4 es vacio: " + conjunto4.esVacio());
        conjunto4.vaciar();
        System.out.println("conjunto 4 es vacio: " + conjunto4.esVacio());
        System.out.println("Union conjuntos 1 y 5");
        ConjuntoLista conjuntoUnion = (ConjuntoLista) conjunto1.union(conjunto5);
        conjuntoUnion.mostrar();
        System.out.println("Interseccion conjuntos 1 y 5");
        ConjuntoLista conjuntoInterseccion = (ConjuntoLista) conjunto1.interseccion(conjunto3);
        conjuntoInterseccion.mostrar();
        System.out.println("Diferencia conjuntos 3 y 1");
        ConjuntoLista conjuntoDiferencia = (ConjuntoLista) conjunto3.diferencia(conjunto1);
        conjuntoDiferencia.mostrar();
        System.out.println("Igualdad entre conjuntos 3 y 1: " + conjunto3.igualdad(conjunto1));
        System.out.println("Igualdad entre conjuntos 1 y 6: " + conjunto1.igualdad(conjunto6));
        
    }
}
