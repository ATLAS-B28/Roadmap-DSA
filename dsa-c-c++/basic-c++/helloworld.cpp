#include <iostream>
using namespace std;

int main(){
    //some data types
    float f1 = 35e3;
    double d1 = 12E4;
    long double d2 = 12e4;
    
    //operators
    int i1 = 10;
    i1 += i1;
    cout << i1 << endl;
    int i2 = 20;
    i2 %= 5;
    cout << i2 << endl;

    //comparisons
    cout << (i1 == i2) << endl;
    cout << (i1 != i2) << endl;
    double d3 = 12.6;
    cout << (i1 > d3) << endl;
    //print
    cout << "Hello World!" << endl;
    cout << "Float: " << f1 << endl;
    cout << "Double: " << d1 << endl;
    cout << "Long Double: " << d2 << endl;
    cout << "Integer with += assignment operator: " << i1 << endl;
    cout << "Integer wcith %= assignment operator: " << i2 << endl;
    return 0;
}