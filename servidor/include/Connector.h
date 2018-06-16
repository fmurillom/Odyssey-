//
// Created by fmurillom on 14/06/18.
//

#ifndef LIVE555_CONNECTOR_H
#define LIVE555_CONNECTOR_H

#include <iostream>
#include <stdio.h>
#include <string.h>
#include <cppconn/connection.h>
#include <cppconn/resultset.h>

using namespace sql;

class Connector
{
public:

private:
    sql::Driver *driver;
    sql::Connection *connection;
    sql::Statement *stmt;

    std::string user;
    std::string password;
    std::string ip;
    std::string DBName;

public:
    Connector();
    ~Connector();
    Statement* getStatement();
    std::string getUser();
    std::string getPassword();
    std::string getIp();
    std::string getDBName();

    ResultSet* executeQuery(std::string query);
    void setDB(std::string DBName);
};

#endif //LIVE555_CONNECTOR_H
