#include <iostream>

using namespace std;

class Node{
    public:
       int data;
       Node* left;
       Node* right;

       Node(int value){
        data = value;
        left = nullptr;
        right = nullptr;
       }
};

class BST{
    private:
       Node* root;

       Node* insertRecursively(Node* root,int value){
        if(root == nullptr){
            return new Node(value);
        }
        if(value < root->data){
            root->left = insertRecursively(root->left,value);
        }else if(value > root->data){
            root->right = insertRecursively(root->right,value);
        }
        return root;
       }

       Node* findMinNode(Node* node){
        while(node->left != nullptr){
            node = node->left;
        }
        return node;
       }

       Node* deleteRecursively(Node* root,int value){
        if(root == nullptr){
            return nullptr;
        }
        if(value < root->data){
            root->left = deleteRecursively(root->left,value);
        }else if(value > root->data){
            root->right = deleteRecursively(root->right,value);
        }else{
            if(root->left == nullptr){
                Node* temp = root->right;
                delete root;
                return temp;
            }else if(root->right == nullptr){
                Node* temp = root->left;
                delete root;
                return temp;
            }

            Node* minRightSubTree = findMinNode(root->right);
            root->data = minRightSubTree->data;
            root->right = deleteRecursively(root->right,minRightSubTree->data);
        }
        return root;
       }

       bool searchRecursively(Node* root,int value){
        if(root == nullptr){
            return false;
        }
        if(value == root->data){
            return true;
        }else if(value < root->data){
            return searchRecursively(root->left,value);
        }else{
            return searchRecursively(root->right,value);
        }
       }

       void inorderTraversalRecursive(Node* root){
        if(root != nullptr){
            inorderTraversalRecursive(root->left);
            cout<<root->data<<" ";
            inorderTraversalRecursive(root->right);
        }
       }

    public:
       BST(){
        root = nullptr;
       }

       void insert(int value){
        root = insertRecursively(root,value);
       }

       void remove(int value){
        root = deleteRecursively(root,value);
       }

       void search(int value){
        if(searchRecursively(root,value)){
            cout<<"Found"<<endl;
        }else{
            cout<<"Not Found"<<endl;
        }
       }

       void inorderTraversal(){
        inorderTraversalRecursive(root);
        cout<<endl;
       }
};

int main(){
    BST bst;

    bst.insert(5);
    bst.insert(3);
    bst.insert(7);
    bst.insert(2);
    bst.insert(4);
    bst.insert(6);
    bst.insert(8);

    bst.inorderTraversal();

    bst.remove(5);

    bst.inorderTraversal();

    int searchValue = 4;

    bst.search(searchValue);

    return 0;
}