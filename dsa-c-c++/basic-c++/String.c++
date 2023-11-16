#include <string>
#include <iostream>

using namespace std;

int main(){
    string str = "aditya";
    int len = str.length();
    string str1 = "Hello";
    string str2 = "World";
    string result = str1 + str2;
    cout << result << endl;
    str1 += str2;
    cout << str1 << endl;
    cout << str << endl;
    char first = str[0];
    char second = str[1];
    str[2] = '_';
    cout << first << endl;
    cout << second << endl;
    cout << str << endl;
}