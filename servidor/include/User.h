//
// Created by fmurillom on 10/05/18.
//

#ifndef LIVE555_USER_H
#define LIVE555_USER_H

#include <iostream>
#include "S_List.h"
#include "Song.h"

using namespace std;

class User{
private:
    string usrName;
    string hashPass;
    string name;
    string age;
    S_List<string> *favGenres;
    S_List<string> *friendList;

public:

    User(){
        usrName = "";
        hashPass = "";
        name = "";
        age = "";
        favGenres = new S_List<string>;
        friendList = new S_List<string>;

    }


    User(const string &usrName, const string &hashPass, const string &name, string age, S_List<string> *favGenres,
         S_List<string> *friendList);

    const string &getUsrName() const;

    void setUsrName(const string &usrName);

    const string &getHashPass() const;

    void setHashPass(const string &hashPass);

    const string &getName() const;

    void setName(const string &name);

    string getAge() const;

    void setAge(string age);


    S_List<string> &getFavGenres() const;

    void addFavGenre(string genre);

    S_List<string> &getFriendList() const;

    void addFriend(string usr);


    bool operator==(const User &rhs) const {
        return usrName == rhs.usrName;
    }

    bool operator!=(const User &rhs) const {
        return !(rhs == *this);
    }

    friend ostream &operator<<(ostream &os, const User &user);

};

#endif //LIVE555_USER_H
