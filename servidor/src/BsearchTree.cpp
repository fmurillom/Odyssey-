//
// Created by fmurillom on 13/05/18.
//

#include "../include/BsearchTree.h"
template <class T>
void BsearchTree<T>::addHelper(NodeB<T> *root, T val) {
    if (root->value > val) {
        if (!root->left) {
            root->left = new Node<T>(val);
        } else {
            addHelper(root->left, val);
        }
    } else {
        if (!root->right) {
            root->right = new Node<T>(val);
        } else {
            addHelper(root->right, val);
        }
    }
}

template <class T>
void BsearchTree<T>::printHelper(NodeB<T> *root) {
    if (!root) return;
    printHelper(root->left);
    cout<<root->value<<' ';
    printHelper(root->right);
}

template <class T>
int BsearchTree<T>::nodesCountHelper(NodeB<T> *root) {
    if (!root) return 0;
    else return 1 + nodesCountHelper(root->left) + nodesCountHelper(root->right);
}

template <class T>
int BsearchTree<T>::heightHelper(NodeB<T> *root) {
    if (!root) return 0;
    else return 1 + max(heightHelper(root->left), heightHelper(root->right));
}

template <class T>
void BsearchTree<T>::printMaxPathHelper(NodeB<T> *root) {
    if (!root) return;
    cout<<root->value<<' ';
    if (heightHelper(root->left) > heightHelper(root->right)) {
        printMaxPathHelper(root->left);
    } else {
        printMaxPathHelper(root->right);
    }
}

template <class T>
bool BsearchTree<T>::deleteValueHelper(NodeB<T> *parent, NodeB<T> *current, T value) {
    if (!current) return false;
    if (current->value == value) {
        if (current->left == NULL || current->right == NULL) {
            Node<T> *temp = current->left;
            if (current->right) temp = current->right;
            if (parent) {
                if (parent->left == current) {
                    parent->left = temp;
                } else {
                    parent->right = temp;
                }
            } else {
                this->root = temp;
            }
        } else {
            NodeB<T> *validSubs = current->right;
            while (validSubs->left) {
                validSubs = validSubs->left;
            }
            T temp = current->value;
            current->value = validSubs->value;
            validSubs->value = temp;
            return deleteValueHelper(current, current->right, temp);
        }
        delete current;
        return true;
    }
    return deleteValueHelper(current, current->left, value) ||
           deleteValueHelper(current, current->right, value);
}

template <class T>
void BsearchTree<T>::add(T val) {
    if (root) {
        this->addHelper(root, val);
    } else {
        root = new Node<T>(val);
    }
}

template <class T>
void BsearchTree<T>::print() {
    printHelper(this->root);
}

template <class T>
int BsearchTree<T>::nodesCount() {
    return nodesCountHelper(root);
}

template <class T>
int BsearchTree<T>::height() {
    return heightHelper(this->root);
}

template <class T>
void BsearchTree<T>::printMaxPath() {
    printMaxPathHelper(this->root);
}

template <class T>
bool BsearchTree<T>::deleteValue(T value) {
    return this->deleteValueHelper(NULL, this->root, value);
}
template <class T>
bool BsearchTree::searchUsr(string usr, NodeB<T> *root) {
    if(!root) return false;
    searchUsr(usr, root->left);
    if(root->usr.getUsrName() == usr) return true;
    searchUsr(usr, root->right);
}
