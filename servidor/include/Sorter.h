//
// Created by loop on 19/05/18.
//
#ifndef SORT_SORTER_H
#define SORT_SORTER_H

#include "Song.h"

/*!
 * Clase utilizada para ancapsular todos los metodos de ordenamiento
 */
class Sorter
{
public:
    Sorter();

    /*!
     * metodo para ordenar por bubble sort
     * @param arr arreglo a ordenar
     * @param n cantidad de elementos del arreglo
     */
    void BubbleSort(Song arr[], int n);

    /*!
     * hacer radix sort
     * @param arr arreglo a ordenar
     * @param n tamanio del arreglo
     */
    void RadixSort(string arr[], int n);
     /*!
      * metodos auxiliares para imprimir arreglos
      * @param arr arreglo
      * @param n tamanio
      */
    void print(int arr[], int n);

    void println(int arr[], int n);

};

#endif //SORT_SORTER_H