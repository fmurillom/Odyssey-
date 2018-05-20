//
// Created by fmurillom on 17/05/18.
//

#ifndef LIVE555_AVLTREE_H
#define LIVE555_AVLTREE_H

#include<iostream>
#include "S_List.h"
#include "Song.h"

using namespace std;

/*!
 * Clase para implementar un arbol AVL
 */
class AVLTree
{
    /*!
     * Estructura que se encargara de representar las hojas del arbol.
     */
    struct node
    {

        std::string data;
        Song songData;
        node* left;
        node* right;
        int height;
    };

    node* root;

    /*!
     * metodo para vacear un nodo
     * @param t nodo que se desea vacear
     */
    void makeEmpty(node* t)
    {
        if(t == NULL)
            return;
        makeEmpty(t->left);
        makeEmpty(t->right);
        delete t;
    }

    /*!
     * Metodo encargado de insertar una hoja en el arbol
     * @param x identificador de la hoja a insertar
     * @param t nodo en el que se desea insertar
     * @return el nodo una ves fue insertado
     */
    node* insert(string x, node* t)
    {
        if(t == NULL)
        {
            t = new node;
            t->data = x;
            t->height = 0;
            t->left = t->right = NULL;
        }
        else if(!comesFirst(x, t->data))
        {
            t->left = insert(x, t->left);
            if(height(t->left) - height(t->right) == 2)
            {
                if(!comesFirst(x, t->left->data))
                    t = singleRightRotate(t);
                else
                    t = doubleRightRotate(t);
            }
        }
        else if(comesFirst(x, t->data))
        {
            t->right = insert(x, t->right);
            if(height(t->right) - height(t->left) == 2)
            {
                if(comesFirst(x, t->data))
                    t = singleLeftRotate(t);
                else
                    t = doubleLeftRotate(t);
            }
        }

        t->height = max(height(t->left), height(t->right))+1;
        return t;
    }

    /*!
     * metodo para realizar una rotacion derecha simple
     * @param t nodo que al rededor el cual se debe rotar
     * @return nodo rotado
     */
    node* singleRightRotate(node* &t)
    {
        node* u = t->left;
        t->left = u->right;
        u->right = t;
        t->height = max(height(t->left), height(t->right))+1;
        u->height = max(height(u->left), t->height)+1;
        return u;
    }
/*!
    * metodo para realizar una rotacion izquierda simple
    * @param t nodo que al rededor el cual se debe rotar
    * @return nodo rotado
    */
    node* singleLeftRotate(node* &t)
    {
        node* u = t->right;
        t->right = u->left;
        u->left = t;
        t->height = max(height(t->left), height(t->right))+1;
        u->height = max(height(t->right), t->height)+1 ;
        return u;
    }

    /*!
     * metodo para realizar una rotacion izquierda doble
     * @param t nodo que al rededor el cual se debe rotar
     * @return nodo rotado
     */
    node* doubleLeftRotate(node* &t)
    {
        t->right = singleRightRotate(t->right);
        return singleLeftRotate(t);
    }

    /*!
    * metodo para realizar una rotacion derecha doble
    * @param t nodo que al rededor el cual se debe rotar
    * @return nodo rotado
    */
    node* doubleRightRotate(node* &t)
    {
        t->left = singleLeftRotate(t->left);
        return singleRightRotate(t);
    }

    /*!
     * Metodo encargado de buscar el nodo minimo
     * @param t nodo por el cual comenzar
     * @return
     */
    node* findMin(node* t)
    {
        if(t == NULL)
            return NULL;
        else if(t->left == NULL)
            return t;
        else
            return findMin(t->left);
    }

    /*!
     * Metodo encargado de buscar el nodo maximo
     * @param t nodo por el cual empezar
     * @return
     */
    node* findMax(node* t)
    {
        if(t == NULL)
            return NULL;
        else if(t->right == NULL)
            return t;
        else
            return findMax(t->right);
    }

    /*!
     * metodo para eliminar un nodo del arbol
     * @param x nodo a eliminar
     * @param t donde empezar a buscar
     * @return
     */
    node* remove(string x, node* t)
    {
        node* temp;

        if(t == NULL)
            return NULL;

        else if(!comesFirst(x,  t->data))
            t->left = remove(x, t->left);
        else if(comesFirst(x , t->data))
            t->right = remove(x, t->right);


        else if(t->left && t->right)
        {
            temp = findMin(t->right);
            t->data = temp->data;
            t->right = remove(t->data, t->right);
        }

        else
        {
            temp = t;
            if(t->left == NULL)
                t = t->right;
            else if(t->right == NULL)
                t = t->left;
            delete temp;
        }
        if(t == NULL)
            return t;

        t->height = max(height(t->left), height(t->right))+1;

        if(height(t->left) - height(t->right) == 2)
        {

            if(height(t->left->left) - height(t->left->right) == 1)
                return singleLeftRotate(t);

            else
                return doubleLeftRotate(t);
        }

        else if(height(t->right) - height(t->left) == 2)
        {

            if(height(t->right->right) - height(t->right->left) == 1)
                return singleRightRotate(t);

            else
                return doubleRightRotate(t);
        }
        return t;
    }
/*!
 * retorna la altura en la que se encuentra el nodo deseado
 * @param t nodo que se desea saber la altura
 * @return altura del nodo
 */
    int height(node* t)
    {
        return (t == NULL ? -1 : t->height);
    }

    int getBalance(node* t)
    {
        if(t == NULL)
            return 0;
        else
            return height(t->left) - height(t->right);
    }
/*!
 * Funcion auxiliar para imprimir el arbol en notacion enorden
 * @param t nodo por el cual empezar
 */
    void inorder(node* t)
    {
        if(t == NULL)
            return;
        inorder(t->left);
        cout << t->data << " ";
        inorder(t->right);
    }

    /*!
  * metodo encargado de verificiar el orden alfabetico entre strings
  * @param wordA palabra 1
  * @param wordB parlabra 1
  * @return true si wordA > wordB
  */
    bool comesFirst(std::string wordA, std::string wordB){
        S_List<string> *letter = new S_List<string>;
        letter->add("A");
        letter->add("B");
        letter->add("C");
        letter->add("D");
        letter->add("E");
        letter->add("F");
        letter->add("G");
        letter->add("H");
        letter->add("I");
        letter->add("J");
        letter->add("K");
        letter->add("L");
        letter->add("M");
        letter->add("N");
        letter->add("O");
        letter->add("P");
        letter->add("Q");
        letter->add("R");
        letter->add("S");
        letter->add("T");
        letter->add("U");
        letter->add("V");
        letter->add("W");
        letter->add("X");
        letter->add("Y");
        letter->add("Z");
        for(int i = 0; i < wordA.size(); i++){
            string letter1(&wordA[i]);
            string letter2(&wordB[i]);
            letter1 = toupper(letter1[0]);
            letter2 = toupper(letter2[0]);
            if(letter->search(letter1) > letter->search(letter2)){
                return true;
            }
            if(letter->search(letter1) < letter->search(letter2)){
                return false;
            }
        }
    }

public:
    AVLTree()
    {
        root = NULL;
    }

    void insert(string x)
    {
        root = insert(x, root);
    }

    void remove(string x)
    {
        root = remove(x, root);
    }

    void display()
    {
        inorder(root);
        cout << endl;
    }
};

#endif //LIVE555_AVLTREE_H
