#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int stringlen(char str[]) {
    int len = 0;
    while(str[len] != '\0') {
        len++;
    }
    return len;
}

void strCopy(char des[], char src[]) {
    int i = 0;
    while(src[i] != '\0') {
        des[i] = src[i];
        i++;
    }
    des[i] = '\0';
}

void stringConcat(char des[], char src[]) {
    int i = strlen(des);
    int j = 0;
    while(src[j] != '\0') {
        des[i++] = src[j++];
    }
    des[i] = '\0';
}

int strCompare(char str1[], char str2[]) {
    int i = 0;
    while(str1[i] != '\0' && str2[i] != '\0') {
        if(str1[i] != str2[i]) {
            return str1[i] - str2[i];
        }
        i++;
    }
    return str1[i] - str2[i];
}

void stringRev(char str[]) {
    int len = strlen(str);
    for(int i = 0; i < len; i++) {
        char temp = str[i];
        str[i] = str[len-1-i];
        str[len-1-i] = temp;
    }
}

void charFreq(char str[]) {
    int freq[256] = {0};
    for(int i = 0; str[i]; i++) {
        freq[str[i]]++;
    }
    for(int i = 0; i < 256; i++) {
        if(freq[i] > 0) {
            printf("%c : %d\n", i, freq[i]);    
        }
    }
}