#include <iostream>

using namespace std;

enum Color{
    RED,
    GREEN,
    BLUE
};
int main(){
    Color fav = GREEN;

    if(fav == RED){
        cout<<"RED"<<endl;
    }else if(fav == GREEN){
        cout<<"GREEN"<<endl;
    }else if(fav == BLUE){
        cout<<"BLUE"<<endl;
    }
    return 0;
}