/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.util;

import java.util.NoSuchElementException;

/**
 *
 * @author Andrea Mero Plaza
 */

//clase nodo, que es donde se contienen
class Node<E> {

    //Guarda el contenido del nodo
    E data;
    //Guarda la dirección del nodo
    Node<E> next;

    Node(E data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList<E> implements List<E> {

    private Node head;

    private int tam = 0;

    public LinkedList() {
        this.head = null;
    }

    // Intenta insertar el elemento al inicio y retorna verdadero si lo logró hacer, falso sino
    @Override
    public boolean addFirst(E e) {

        //si el elemento está vacio
        if(e == null){
            return false;
        }

        // la lista estaba vacia
        if (tam == 0) {
            this.head.data = e;
            this.head.next = null;
            tam = 1;
            return true;
        }

        Node new_node = new Node<>(e);

        new_node.next = this.head;
        this.head = new_node;
        tam++;

        return true;
    }

    // Intenta insertar el elemento al final y retorna verdadero si lo logró hacer, falso sino
    @Override
    public boolean addLast(E e) {

        Node new_node = new Node<>(e);

        if(this.head == null){
            this.head = new_node;
            tam++;
            return true;
        }

        this.head.next = new_node;
        new_node.next = null;

        return  true;

    }

    // Retorna el primer elemento. Lanza una excepción si la lista está vacía.
    @Override
    public E getFirst() {

        if(tam == 0){
            throw new NoSuchElementException("Lista está vacia");
        }

        return (E) this.head.data;

    }

    // Retorna el último elemento. Lanza una excepción si la lista está vacía.
    @Override
    public E getLast() {

        if(tam == 0){
            throw new NoSuchElementException("Lista está vacia");
        }

        Node<E> temp = this.head;

        while (temp.next !=null ){
            temp = this.head;
        }

        return temp.data;
    }

    // Retorna la posición de E si se encuentra en la Lista. Retorna -1 si no lo encuentra.
    @Override
    public int indexOf(E e) {

        int index = 0;

        while ( this.head.data != null){
            if(this.head.data == e){
                return index;
            }
            index++;
        }

        index = -1;
        return index;
    }

    // Retorna la cantidad de elementos en la lista.
    @Override
    public int size() {
        return tam;
    }

    // Remueve el último elemento de la lista y retorna verdadero. Retorna falso si la lista estaba vacía antes de la remoción.
    @Override
    public boolean removeLast() {

        if (tam == 0){
            return false;
        }

        for (int i = 0; i < tam ; i++) {

            if(this.head.next == null){
                this.head.data = null;
            }
        }

        return true;

    }

    // Remueve el primer elemento de la lista y retorna verdadero. Retorna falso si la lista estaba vacía antes de la remoción.
    @Override
    public boolean removeFirst() {

        if(tam == 0){
            return false;
        }

        Node new_node = new Node<>(this.head.next);

        this.head.data = new_node.data;
        this.head.next = new_node.next;

        return true;

    }

    // Inserta el elemento en la posición indicada por el índice y retorna verdadero si lo logra realizar.
    // Retorna falso si el elemento es null
    // Lanza una excepción si el indice es invalido (fuera del rango)
    @Override
    public boolean insert(int index, E e) {

        if (e == null){
            return false;
        }

        if(index < 0 || index >= tam){
            throw new IndexOutOfBoundsException("Indice no está dentro del rango");
        }

        Node new_node = new Node<>(e);

        for (int i = 0; i < tam ; i++) {

            if(i == index){
                new_node.next = this.head;
                this.head = new_node;
                tam ++;
                break;
            }

        }

        return true;

    }

    // Modifica el elemento en la posición indicada por el índice y retorna verdadero si lo logra realizar.
    //  Retorna falso si el elemento es null
    //  Lanza una excepción si el indice es invalido (fuera del rango)
    @Override
    public boolean set(int index, E e) {
        if (e == null){
            return false;
        }

        if(index < 0 || index >= tam){
            throw new IndexOutOfBoundsException("Indice no está dentro del rango");
        }

        for (int i = 0; i < tam ; i++) {

            if(i == index){
                this.head.data = e;
                break;
            }

        }

        return true;

    }

    // Retorna verdero si la lista está vacía y falso si contiene nodos.
    @Override
    public boolean isEmpty() {

        if(tam == 0){
            return true;
        }else{
            return false;
        }

    }

    // Recorre la lista para retornar el elemento en el índice indicado.
    //  Lanza una excepción si el indice es invalido (fuera del rango)
    @Override
    public E get(int index) {

        if(tam == 0){
            return null;
        }

        if(index < 0 || index >= tam){
            throw new IndexOutOfBoundsException("Indice no está dentro del rango");
        }

        Node selected_node = null;
        int i = 0;

        while(this.head.next != null){
            if(i == index){
                selected_node = this.head;
            }
            i++;
        }

        return (E) selected_node;

    }

    // Retorna verdadero si el elemento se encuentra en la Lista y falso sino.
    //  También retorna falso si el elemento es null.
    @Override
    public boolean contains(E e) {

        if(e == null){
            return false;
        }

        for (int i = 0; i < tam ; i++) {

            if(this.head == e){
               return true;
            }else return false;

        }

        return true;
    }

    // Remueve el elemento en la posición indicada por el índice y retorna verdadero si lo logra realizar.
    //  Retorna falso si el elemento es null
    //  Lanza una excepción si el indice es invalido (fuera del rango)
    @Override
    public boolean remove(int index) {

        if(this.head == null){
            return false;
        }

        if(index < 0 || index >= tam){
            throw new IndexOutOfBoundsException("Indice no está dentro del rango");
        }

        Node new_node = this.head.next;

        for (int i = 0; i < tam ; i++) {

            if(i == index){
                this.head = new_node;
                break;
            }
        }

        return true;
    }


}
