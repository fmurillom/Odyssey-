//
// Created by fmurillom on 13/05/18.
//

#include "../include/User.h"
void User::addFavGenre(string genre) {
    this->favGenres->add(genre);
}

void User::addFriend(string usr) {
    this->friendList->add(usr);
}

User::User(const string &usrName, const string &hashPass, const string &name, string age, S_List<string> *favGenres,
           S_List<string> *friendList) : usrName(usrName), hashPass(hashPass), name(name), age(age), favGenres(favGenres),
                                       friendList(friendList) {}

const string &User::getUsrName() const {
    return usrName;
}

void User::setUsrName(const string &usrName) {
    User::usrName = usrName;
}

const string &User::getHashPass() const {
    return hashPass;
}

void User::setHashPass(const string &hashPass) {
    User::hashPass = hashPass;
}

const string &User::getName() const {
    return name;
}

void User::setName(const string &name) {
    User::name = name;
}

string User::getAge() const {
    return age;
}

void User::setAge(string age) {
    User::age = age;
}

S_List<string> &User::getFavGenres() const {
    return *favGenres;
}

S_List<string> &User::getFriendList() const {
    return *friendList;
}

ostream &operator<<(ostream &os, const User &user) {
    os << "usrName: " << user.usrName << " hashPass: " << user.hashPass << " name: " << user.name << " age: "
       << user.age;
    return os;
}
