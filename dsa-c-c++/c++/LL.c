#include <stdio.h>
#include <stdlib.h>

struct Node
{
    /* data */
    int data;
    struct Node* next;
};

void printList(struct Node* n){
    while(n != NULL){
        printf("%d",n->data);
        n=n->next;
    }
    printf("\n");
}

void insertNode(struct Node** headRef, int newData){
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = newData;
    newNode->next = *headRef;
    *headRef = newNode; 
}

void deleteNode(struct Node** headRef, int key){
    struct Node* temp = *headRef;
    struct Node* prev = NULL;

    if(temp != NULL && temp->data == key){
        *headRef = temp->next;
        free(temp);
        return;
    }

    while(temp != NULL && temp->data != key){
        prev = temp;
        temp = temp->next;
    }

    if(temp == NULL){
        return;
    }
     prev->next = temp->next;
     free(temp);
}

int main(){
    struct Node* head = NULL;

    insertNode(&head, 3);
    insertNode(&head, 2);
    insertNode(&head, 1);
    insertNode(&head, 0);
    insertNode(&head, 4);

    printf("List: ");
    printList(head);

    deleteNode(&head,0);

    printf("List after deletion: ");
    printList(head);
    return 0;
}