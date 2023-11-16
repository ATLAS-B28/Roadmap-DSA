#include <iostream>
#include <stack>

using namespace std;

class MyStack{
    private:
       stack<int> myStack;

    public:
       void push(int value){
        myStack.push(value);
       }

       void pop(){
        if(!myStack.empty()){
            myStack.pop();
        }else{
            cout<<"Stack is empty"<<endl;
        }
       }
       int top(){
        if(!myStack.empty()){
            return myStack.top();
        }else{
            cout<<"Stack is empty"<<endl;
            return -1;
        }
       }
       bool empty(){
        return myStack.empty();
       }
       int size(){
        return myStack.size();
       }
};

int main(){
    MyStack stack1;

    stack1.push(1);
    stack1.push(2);
    stack1.push(3);

    cout<<"Top element: "<<stack1.top()<<endl;

    stack1.pop();

    cout<<"Top element: "<<stack1.top()<<endl;

    cout<<"Size: "<<stack1.size()<<endl;

    cout<<stack1.empty()<<endl;

    return 0;
}