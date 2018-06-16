//
// Created by fmurillom on 14/06/18.
//

#include <stdlib.h>
#include <iostream>
#include "mysql_connection.h"
#include "include/Connector.h"
#include <cppconn/driver.h>
#include <exception.h>
#include <resultset.h>
#include <statement.h>
#include <stdio.h>


using namespace sql;

Connector::Connector()
{
    user = "root";
    password = "12345";
    ip = "127.0.0.1";
    DBName = "sys";


    /* Create a connection */
    driver = get_driver_instance();
    connection = driver->connect("tcp://"+ip+":3306", user, password);


    /* Connect to the MySQL database */
    connection->setSchema(DBName);
    stmt = connection->createStatement();
}
void Connector::setDB(std::string DBName)
{
    connection->setSchema(DBName);
}

sql::ResultSet* Connector::executeQuery(std::string query)
{
    sql::ResultSet *res = nullptr;
    try
    {
        //sql::Statement *_stmt = connection->createStatement();
        //stmt = _stmt;////////////////////////////////////////////////////////////////////////
        res = stmt->executeQuery(query);
    }
    catch(sql::SQLException e)
    {
        std::cout<< e.what() << std::endl;
    }
    catch(sql::InvalidArgumentException e)
    {
        std::cout<< e.what() << std::endl;
    }
    return res;
}

sql::Statement* Connector::getStatement(){return stmt;}
