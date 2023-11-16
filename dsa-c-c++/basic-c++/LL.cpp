#include <iostream>

using namespace std;

struct Node{
    int data;
    Node* next;
};

class LL{
    private:
       Node* head;
    
    public:
       LL(){
        head = nullptr;
       }
       void insert(int value){
        Node* newNode = new Node;
        newNode->data = value;
        newNode->next = nullptr;

        if(head == nullptr){
            head = newNode;
        }else{
            Node* temp = head;
            while(temp->next != nullptr){
                temp = temp->next;
            }
            temp->next = newNode;
        }
       }
       void display(){
        Node* temp = head;
        while(temp != nullptr){
            cout << temp->data << " ";
            temp = temp->next;
        }
        cout<<endl;
       }
       void update(int oldVal,int newVal){
        Node* curr = head;
        while(curr != nullptr){
            if(curr->data == oldVal){
                curr->data = newVal;
                return;
            }
            curr = curr->next;
        }
       }
       void remove(int value){
        if(head == nullptr){
            return;
        }
        if(head->data == value){
            Node* temp = head;
            head = head->next;
            delete temp;
            return;
        }

        Node* curr = head;
        Node* prev = nullptr;

        while(curr != nullptr && curr->data != value){
            prev = curr;
            curr = curr->next;
        }

        if(curr != nullptr){
            prev->next = curr->next;
            delete curr;
        }
       }
};

int main(){
    LL list;

    list.insert(1);
    list.insert(2);
    list.insert(3);
    list.insert(4);

    list.display();

    list.remove(3);

    list.display();

    list.update(2,5);

    list.display();

    return 0;
}