//
// Created by fmurillom on 13/05/18.
//

#ifndef LIVE555_BSEARCHTREE_H
#define LIVE555_BSEARCHTREE_H

#include <iostream>
#include <math.h>
#include <fstream>
#include "User.h"
#include "cajun/json/reader.h"
#include "cajun/json/writer.h"

using namespace std;

template <class T, class B>
struct NodeB {
    T value;
    B userData;
    NodeB<T, B> *left;
    NodeB<T, B> *right;

    NodeB(T val, B userData) {
        this->value = val;
        this->userData = userData;
        this->left = NULL;
        this->right = NULL;
    }

    NodeB(T val, NodeB<T, B> *left, NodeB<T, B> *right) {
        this->value = val;
        this->left = left;
        this->right = right;
    }
};

template <class T, class B>
class BsearchTree{
private:
    NodeB<T, B> *root;

    void addHelper(NodeB<std::string, B> *root, std::string val, B usrData) {
        if (comesFirst(root->value, val)) {
            if (!root->left) {
                root->left = new NodeB<T, B>(val, usrData);
            } else {
                addHelper(root->left, val, usrData);
            }
        } else {
            if (!root->right) {
                root->right = new NodeB<T, B>(val, usrData);
            } else {
                addHelper(root->right, val, usrData);
            }
        }
    }

    void printHelper(NodeB<T, B> *root) {
        if (!root) return;
        printHelper(root->left);
        cout<<root->value<<' ';
        printHelper(root->right);
    }

    int nodesCountHelper(NodeB<T, B> *root) {
        if (!root) return 0;
        else return 1 + nodesCountHelper(root->left) + nodesCountHelper(root->right);
    }

    int heightHelper(NodeB<T, B> *root) {
        if (!root) return 0;
        else return 1 + max(heightHelper(root->left), heightHelper(root->right));
    }

    void printMaxPathHelper(NodeB<T, B> *root) {
        if (!root) return;
        cout<<root->value<<' ';
        if (heightHelper(root->left) > heightHelper(root->right)) {
            printMaxPathHelper(root->left);
        } else {
            printMaxPathHelper(root->right);
        }
    }

    bool deleteValueHelper(NodeB<T, B>* parent, NodeB<T, B>* current, T value) {
        if (!current) return false;
        if (current->value == value) {
            if (current->left == NULL || current->right == NULL) {
                NodeB<T, B>* temp = current->left;
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
                NodeB<T, B>* validSubs = current->right;
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

    bool searchUsrHelper(string usr, NodeB<T, B> *root, bool &found) {
        if(!root) return false;
        if(root->value == usr){
            found = true;
            return true;
        }
        if(!found){
            searchUsrHelper(usr, root->left, found);
            searchUsrHelper(usr, root->right, found);
        }
        return found;
    }

    void toJsonHelper(NodeB<T, B> *root, json::Array &usrArray){
        using namespace json;
        if(!root) return;
        toJsonHelper(root->left, usrArray);
        Object json;
        Array genreArray;
        Array friendArray;
        json["UserName"] = String(root->userData.getUsrName());
        json["Password"] = String(root->userData.getHashPass());
        json["Name"] = String(root->userData.getName());
        json["Age"] = String(root->userData.getAge());
        for(int i = 0; i < root->userData.getFavGenres().getSize(); i++){
            std::string aux = root->userData.getFavGenres().get(i);
            genreArray.Insert(String(aux));
        }
        for(int i = 0; i < root->userData.getFriendList().getSize(); i++){
            std::string aux = root->userData.getFriendList().get(i);
            friendArray.Insert(String(aux));
        }
        json["Genre"] = genreArray;
        json["Friend"] = friendArray;
        json["Fsize"] = Number(root->userData.getFriendList().getSize());
        json["Gsize"] = Number(root->userData.getFavGenres().getSize());
        usrArray.Insert(json);
        toJsonHelper(root->right, usrArray);
    }


public:
    void add(T val, B usrData) {
        if (root) {
            this->addHelper(root, val, usrData);
        } else {
            root = new NodeB<T, B>(val, usrData);
        }
    }

    void print() {
        printHelper(this->root);
    }

    int nodesCount() {
        return nodesCountHelper(root);
    }

    int height() {
        return heightHelper(this->root);
    }

    void printMaxPath() {
        printMaxPathHelper(this->root);
    }

    bool deleteValue(T value) {
        return this->deleteValueHelper(NULL, this->root, value);
    }

    bool searchUsr(string usr) {
        bool found = false;
        return this->searchUsrHelper(usr, this->root, found);
    }

    void toJson(){
        using namespace json;
        Object jsonInfo;
        Array usrArray;
        toJsonHelper(root, usrArray);
        jsonInfo["size"] = Number(usrArray.Size());
        jsonInfo["users"] = usrArray;
        ofstream file("../coms/userDb.json");
        Writer::Write(jsonInfo, file);
        file.close();
    }

};

#endif //LIVE555_BSEARCHTREE_H
