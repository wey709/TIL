#include <iostream>

using namespace std;

class Node {
public:
    int value;
    Node* next;

};


void Traversal(Node* n) {
    while (n != nullptr) {
        cout << (*n).value << endl;
        n = n->next;
    }
}

Node* Push(Node* head, int value) {
    Node* pushed = new Node();
    (*pushed).value = value;
    (*pushed).next = head;
    head = pushed;
    return head;
}



void Insert(Node* prev, int value) {
    Node* inserted = new Node();
    (*inserted).value = value;
    Node* tmp = prev->next;
    (*inserted).next = tmp;
    prev->next = inserted;

}

void Append(Node* head, int value) {
    Node* appended = new Node();
    while (head->next != nullptr) {
        head = head->next;
    }
    appended->value = value;
    appended->next = nullptr;

    head->next = appended;
}


int main() {
    Node* first = NULL;
    Node* second = NULL;
    Node* third = NULL;

    first = new Node(); //new는 address를 반환
    second = new Node();
    third = new Node();

    (*first).value = 1;
    (*first).next = second;
    (*second).value = 2;
    (*second).next = third;
    (*third).value = 3;
    (*third).next = nullptr;

    Node* head = first;

    head = Push(head, 0);
    Insert(second, 5);
    Append(head, 7);

    Traversal(head);

    return 0;
}