#include <iostream>
#include <queue>

using namespace std;

class MyQueue{
    private:
       queue<int> myQueue;
    
    public:
       void enqueue(int value){
        myQueue.push(value);
       }
       void dequeue(){
        if(!myQueue.empty()){
            myQueue.pop();
        }else{
            cout<<"Queue is empty"<<endl;
        }
       }
       int front(){
        if(!myQueue.empty()){
            return myQueue.front();
        }else{
            cout<<"Queue is empty"<<endl;
            return -1;
        }
       }
       int last(){
        if(!myQueue.empty()){
            return myQueue.back();
        }else{
            cout<<"Queue is empty"<<endl;
            return -1;
        }
       }
       bool empty(){
        return myQueue.empty();
       }
       int size(){
        return myQueue.size();
       }
};

int main(){
    MyQueue queue1;

    queue1.enqueue(1);
    queue1.enqueue(2);
    queue1.enqueue(3);

    cout<<"Front element: "<<queue1.front()<<endl;

    queue1.dequeue();

    cout<<"Front element: "<<queue1.front()<<endl;

    cout<<"Size: "<<queue1.size()<<endl;

    cout<<queue1.empty()<<endl;

    cout<<"Last element: "<<queue1.last()<<endl;
    return 0;
}