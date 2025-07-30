#include <iostream>
#include <stdio.h>

using namespace std;

int main(){
    int arr[] =  {1,2,3,4,5,6};
    int first = arr[0];
    int fourth = arr[4];
    arr[1] = 10;
    int len = sizeof(arr)/sizeof(arr[0]);

    for(int i = 0; i < len; i++){
        printf("%d,\n",arr[i]);
    }

    if(arr[1] == 10){
        printf("true\n");
    }

    cout << "first: " << first << endl;
    cout << "fourth: " << fourth << endl;
    cout << "len: " << len << endl;
}