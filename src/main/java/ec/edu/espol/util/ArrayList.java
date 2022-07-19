/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.util;

import java.lang.*;

/**
 * @param <E>
 * @author Andrea Mero Plaza
 */
public class ArrayList<E> implements List<E> {

    private E[] arreglo;
    private int capacidad;
    private int tam;

    public ArrayList() {
        capacidad = 10;
        arreglo = (E[]) new Object[capacidad];
        tam = 0;
    }

    public ArrayList(int capacidad) {
        this.capacidad = capacidad;
        arreglo = (E[]) new Object[capacidad];
        tam = 0;
    }

    @Override
    public boolean addFirst(E e) {
        // si e viene vacio
        if (e == null) {
            return false;
        }

        // la lista estaba vacia
        if (tam == 0) {
            arreglo[0] = e;
            tam = 1;
            return true;
        }

        // si el arreglo ya está lleno o a capacidad
        if (tam == capacidad) {
            crecerArreglo();
        }

        // la insercion debe desplazar elementos
        for (int i = tam - 1; i > 0; i--) {
            arreglo[i + 1] = arreglo[i];
        }
        arreglo[0] = e;
        tam++;
        return true;
    }

    private void crecerArreglo() {
        capacidad = capacidad * 2;
        E[] arreglo2 = (E[]) new Object[capacidad];
        for (int i = 0; i < tam; i++) {
            arreglo2[i] = arreglo[i];
        }
        arreglo = arreglo2;
    }

    @Override
    public boolean addLast(E e) {

        // si e viene vacio
        if (e == null) {
            return false;
        }

        // la lista estaba vacia
        if (tam == 0) {
            arreglo[0] = e;
            tam = 1;
            return true;
        }

        // si el arreglo ya está lleno o a capacidad
        if (tam == capacidad) {
            crecerArreglo();
        }

        arreglo[tam - 1] = e;
        tam++;

        return true;
    }

    @Override
    public E getFirst() {
        return arreglo[0];
    }

    @Override
    public E getLast() {
        return arreglo[tam - 1];
    }

    @Override
    public int indexOf(E e) {

        int index = 0;

        // si e viene vacio
        if (e == null) {
            return -1;
        }

        // la lista estaba vacia
        if (tam == 0) {
            return -1;
        }

        //busca el elemento E
        for (int i = 0; i < tam - 1; i++) {
            if (arreglo[i] == e) {
                index = i;
            } else {
                index = -1;
            }
        }

        return index;

    }

    // Retorna la cantidad de elementos en la lista.
    @Override
    public int size() {

        // la lista estaba vacia
        if (tam == 0) {
            return 0;
        }

        return capacidad;
        //return arreglo.length();
    }

    // Remueve el último elemento de la lista y retorna verdadero. Retorna falso si la lista estaba vacía antes de la remoción.
    @Override
    public boolean removeLast() {

        // la lista estaba vacia
        if (tam == 0) {
            return false;
        }

        arreglo[capacidad - 1] = null;
        capacidad--;

        return true;
    }

    // Remueve el primer elemento de la lista y retorna verdadero. Retorna falso si la lista estaba vacía antes de la remoción.
    @Override
    public boolean removeFirst() {

        E[] arregloTemp = (E[]) new Object[capacidad - 1];

        // la lista estaba vacia
        if (tam == 0) {
            return false;
        }

        for (int i = 1; i < capacidad - 1; i++) {
            arregloTemp[i] = arreglo[i];
        }

        capacidad--;

        return true;

    }

    // Inserta el elemento en la posición indicada por el índice y retorna verdadero si lo logra realizar.
    //  Retorna falso si el elemento es null
    //  Lanza una excepción si el indice es invalido (fuera del rango)
    @Override
    public boolean insert(int index, E e) {

        // si e viene vacio
        if (e == null) {
            return false;
        }


        // indice es invalido
        if (index < 0 || index >= tam) {
            throw new IndexOutOfBoundsException("Indice no está dentro del rango");
        }


        // si el arreglo ya está lleno o a capacidad
        if (tam == capacidad) {
            crecerArreglo();
        }

        // la insercion debe desplazar elementos
        for (int i = tam - 1; i > 0; i--) {

            if (i != index) {
                arreglo[i + 1] = arreglo[i];
            } else {
                break;
            }

        }

        capacidad++;

        return true;
    }

    // Modifica el elemento en la posición indicada por el índice y retorna verdadero si lo logra realizar.
    //  Retorna falso si el elemento es null
    //  Lanza una excepción si el indice es invalido (fuera del rango)
    @Override
    public boolean set(int index, E e) {

        // si e viene vacio
        if (e == null) {
            return false;
        }


        // indice es invalido
        if (index < 0 || index >= tam) {
            throw new IndexOutOfBoundsException("Indice no está dentro del rango");
        }

        for (int i = 0; i < tam; i++) {
            if (i == index) {
                arreglo[i] = e;
                break;
            }
        }

        return true;
    }

    // Retorna verdadero si la lista está vacía y falso si contiene nodos.
    @Override
    public boolean isEmpty() {
        // la lista estaba vacia
        if (tam == 0) {
            return true;
        } else {
            return false;
        }
    }

    // Recorre la lista para retornar el elemento en el índice indicado.
    //  Lanza una excepción si el indice es invalido (fuera del rango)
    @Override
    public E get(int index) {
        E element = null;
        // indice es invalido
        if (index < 0 || index >= tam) {
            throw new IndexOutOfBoundsException("Indice no está dentro del rango");
        }

        for (int i = 0; i < tam; i++) {
            if (i == index) {
                element = arreglo[i];
                break;
            }
        }

        return element;
    }

    // Retorna verdadero si el elemento se encuentra en la Lista y falso sino.
    //  También retorna falso si el elemento es null.
    @Override
    public boolean contains(E e) {

        // la lista estaba vacia
        if (tam == 0) {
            return false;
        }

        for (E element:
             arreglo) {
            if(element == e){
                return true;
            }
        }

        return  false;

    }

    // Remueve el elemento en la posición indicada por el índice y retorna verdadero si lo logra realizar.
    //  Retorna falso si el elemento es null
    //  Lanza una excepción si el indice es invalido (fuera del rango)
    @Override
    public boolean remove(int index) {

        // la lista estaba vacía
        if (tam == 0) {
            return false;
        }

        // indice está fuera del rango
        if (index < 0 || index >= tam) {
            throw new IndexOutOfBoundsException("Indice no está dentro del rango");
        }

        for (int i = 0; i < tam; i++) {

            if (i == index){
                if(arreglo[i] == null){
                    return false;
                }

                arreglo[i] = arreglo[i+1];

                for(int j = i; j < tam; i++){
                    arreglo[j] = arreglo[j+1];
                }
                capacidad--;
                return true;
            }
        }

        return true;

    }

}
