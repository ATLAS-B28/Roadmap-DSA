
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void hello() {
    printf("Hello World!\n");
}

void vars() {
    int a = 10;
    float b = 3.14f;
    char c = 'A';
    double d = 2.1709;
    printf("a = %d, b = %f, c = %c, d = %lf\n", a, b, c, d);
}

void arrays() {
    int arr[5] = {1,2,3,4,5};
    for(int i = 0; i < 5; i++) {
        printf("%d\n", arr[i]);
    }
    printf("\n");
}

void pointers() {
    int x = 45;
    int *ptr = &x;
    printf("Value: %d, Address: %p, Pointer value: %d\n", x, ptr, *ptr );
}

int add(int a, int b) {
    return a + b;
}

struct Point {
    int x, y;
};

void structures() {
    struct Point p = {10, 40};
    printf("Point: (%d, %d)\n", p.x, p.y);
}

void dynamic() {
    int *arr = (int*)malloc(5 * sizeof(int));
    for(int i = 0; i < 5; i++) {
        arr[i] = i + 1;
        printf("%d", arr[i]);
    }
    free(arr);
    printf("\n");
}

void strings() {
    char str1[] = "Hello";
    char str2[] = "World";
    char res[20];
    strcpy_s(res, sizeof(res), str1);
    strcat_s(res, sizeof(res), " ");
    strcat_s(res, sizeof(res), str2);
    printf("%d\n", res);
}

void swap(int *a, int *b) {
    int temp =*a;
    *a = *b;
    *b = temp;
}

enum Color {RED, GREEN, BLUE};

void enums() {
    enum Color c = BLUE;
    printf("Color: %d\n", c);
}

int fact(int n) {
    return (n <= 1) ? 1 : n * fact(n - 1);
}
int main() {
    hello();
    vars();
    arrays();
    pointers();
    printf("Sum: %d\n", add(5, 10));
    structures();
    dynamic();
    strings();
    int x = 10, y = 20;
    swap(&x, &y);
    printf("x = %d, y = %d\n", x, y);
    enums();
    printf("Factorial: %d\n", fact(5));
    return 0;
}