#include <iostream>

class Node {
public:
	int value;
	Node* prev;
};

// add rear
Node* add(int value, Node* rear) {
	Node* added = new Node;
	added->value = value;
	added->prev = nullptr;

	if (rear == nullptr) {
		rear = added;
	}

	else {
		added->prev = rear;
		rear = added;
	}

	return rear;
}

// delete rear
Node* deleteRear(Node* rear){
	Node* tmp = rear;
	rear = rear->prev;
	delete(tmp);
	return rear;
}


int main() {

	Node* rear = nullptr;
	rear = add(1, rear);
	rear = add(2, rear);
	rear = deleteRear(rear);

}