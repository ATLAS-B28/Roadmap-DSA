#include <fstream>
#include <iostream>
int main() {
    std::ofstream outputFile("hello.txt");

    if(outputFile.is_open()){
        outputFile << "Hello World form Aditya Bhambere!";//using << we do the writing
        outputFile.close();
        std::cout << "File write is complete." << std::endl;
    } else {
        std::cerr << "Unable to open the file." << std::endl;
    }

    return 0;
}