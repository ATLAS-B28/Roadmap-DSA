#include "SampleH.h"
#include <iostream>

using namespace N;
using namespace std;

void my_class::do_something()
{
    cout << "Hello World!" << endl;
}
int main() {
    my_class myObj;
    myObj.do_something();
    return 0;
}