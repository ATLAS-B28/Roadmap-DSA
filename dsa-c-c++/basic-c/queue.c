
#include <stdio.h>
#include <stdlib.h>

/*
typedef struct {
    int arr[MAX];
    int front, rear;

} Queue;

void initQueue(Queue *q) {
    q->front = q->rear = -1;
}

int isEmpty(Queue *q) {
    return q->front == -1;
}

int isFull(Queue *q) {
    return q->rear == MAX - 1;
}

void enqueue(Queue *q, int data) {
    if(isFull(q)) return;
    if(isEmpty(q)) q->front = 0;
    q->arr[++q->rear] = data;
}

int dequeue(Queue *q) {
    if(isEmpty(q)) return -1;
    int data = q->arr[q->front];
    if(q->front == q->rear) {
        q->front = q->rear = -1;
    } else {
        q->front++;
    }
    return data;
}

int front(Queue *q) {
    return isEmpty(q) ? -1 : q->arr[q->front];
}
*/

typedef struct Node {
    int data;
    struct Node *next;
} Node;

typedef struct {
    Node *front, *rear;
} Queue;

void initQueue(Queue *q) {
    q->front = q->rear = NULL;
}

int isEmpty(Queue *q) {
    return q->front == NULL;
}

void enqueue(Queue *q, int data) {
    Node *temp = (Node*)malloc(sizeof(Node));
    temp->data = data;
    temp->next = NULL;
    if(isEmpty(q)) {
        q->front = q->rear = temp;
    } else {
        q->rear->next = temp;
        q->rear = temp;
    }
}

int dequeue(Queue *q) {
    if(isEmpty(q)) {
        return -1;
    }
    Node *temp = q->front;
    int data = temp->data;
    q->front = q->front->next;
    if(q->front == NULL) {
        q->rear == NULL;
    }
    free(temp);
    return data;
}

int front(Queue *q) {
    return isEmpty(q) ? -1 : q->front->data;
}

int main() {
    Queue q;
    initQueue(&q);
    enqueue(&q, 10);
    enqueue(&q, 20);
    enqueue(&q, 30);
    printf("%d\n", dequeue(&q));
    printf("%d\n", front(&q));
    printf("%d\n", dequeue(&q));
    return 0;
}