#include <iostream>
#include <cppcms/application.h>
#include <cppcms/applications_pool.h>
#include <cppcms/service.h>
#include <cppcms/http_response.h>
#include <fstream>
#include <sstream>

class OdysseyServer : public cppcms::application{
public:
    OdysseyServer(cppcms::service &srv) :
            cppcms::application(srv){}
    virtual void main(std::string url);
};

std::stringstream readFromHtml(std::string filename){
    std::string directory = "../html/";
    directory.append(filename);
    std::ifstream file(directory);
    std::stringstream ss;
    ss << file.rdbuf();
    return ss;

}

void OdysseyServer::main(std::string /*url*/) {
    response().out() << readFromHtml("index.html").str();
}

int main(int argc, char ** argv){
    try{
        cppcms::service srv(argc, argv);
        srv.applications_pool().mount(cppcms::applications_factory<OdysseyServer>());
        srv.run();
    }
    catch(std::exception const &e){
        std::cerr << e.what() << std::endl;
    }
}