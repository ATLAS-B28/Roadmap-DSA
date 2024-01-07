#include <fstream>
#include <iostream>
#include <string>

int main() {
    std::ifstream inputFile("C:/Users/abhij/Desktop/PrepV2/dsa-c-c++/basic-c++/hello.txt");

    if(inputFile.is_open()) {
        std::string line;
        while(std::getline(inputFile, line)) {
            std::cout << line << std::endl;
        }
        inputFile.close();
    } else {
        std::cerr << "Unable to open a file." << std::endl;
    }
    return 0;
}