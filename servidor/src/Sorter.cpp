//
// Created by loop on 19/05/18.
//
#include <array>
#include <iostream>
#include <cstdio>
#include <string>
#include "../include/Sorter.h"
#include "../include/S_List.h"

using namespace std;

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
    return true;
}

Sorter::Sorter(){}
//--------------------------------------------------------------------------------------------------------------------------------------
void swap(Song *x, Song *y)
{
    Song temp = *x;
    *x = *y;
    *y = temp;
}
void Sorter::BubbleSort(Song arr[], int n)
{
    int i, j;
    bool swapped;
    for(i = 0; i < n-1; i++)
    {
        swapped = false;
        for (j = 0; j < n-i-1; j++)
        {
            if(comesFirst(arr[j].getAlbum(), arr[j+1].getAlbum()))
            {
                swap(&arr[j], &arr[j+1]);
                swapped = true;
            }
        }
        if(swapped == false)
        {
            break;
        }
    }
}
//------------------------------------------------------------------------------------------------------------------------------------------------

using std::string;

size_t getMax(string arr[], int n){
    size_t max = arr[0].size();
    for (int i = 1; i < n; i++){
        if (arr[i].size()>max)
            max = arr[i].size();
    }
    return max;
}

void countSort(string a[], int size, size_t k){
    string *b = NULL; int *c = NULL;
    b = new string[size];
    c = new int[257];



    for (int i = 0; i <257; i++){
        c[i] = 0;
        //cout << c[i] << "\n";
    }
    for (int j = 0; j <size; j++){
        c[k < a[j].size() ? (int)(unsigned char)a[j][k] + 1 : 0]++;            //a[j] is a string
        //cout << c[a[j]] << endl;
    }

    for (int f = 1; f <257; f++){
        c[f] += c[f - 1];
    }

    for (int r = size - 1; r >= 0; r--){
        b[c[k < a[r].size() ? (int)(unsigned char)a[r][k] + 1 : 0] - 1] = a[r];
        c[k < a[r].size() ? (int)(unsigned char)a[r][k] + 1 : 0]--;
    }

    for (int l = 0; l < size; l++){
        a[l] = b[l];
    }

    // avold memory leak
    delete[] b;
    delete[] c;
}


void Sorter::RadixSort(string b[], int r){
    size_t max = getMax(b, r);
    for (size_t digit = max; digit > 0; digit--){ // size_t is unsigned, so avoid using digit >= 0, which is always true
        countSort(b, r, digit - 1);
    }

}
//---------------------------------------------------------------------------------------------------------------------------------
void Sorter::print(int arr[], int n)
{
    for(int i = 0; i < n; i++)
    {
        cout << arr[i] << " ";
    }
}
void Sorter::println(int arr[], int n)
{
    for(int i = 0; i < n; i++)
    {
        cout << arr[i] << " ";
    }
    cout << endl;
}