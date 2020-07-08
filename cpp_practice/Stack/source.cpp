#include <iostream>

using namespace std;

class Node {
public:
	int value;
	Node* next;
};

Node* Push(int value, Node* top){
	Node* pushed = new Node();
	pushed->value = value;
	pushed->next = nullptr;
	

	if (top == nullptr) {
		top = pushed;
	}
	else {
		pushed->next = top;
		top = pushed;
	}

	return top;
}

Node* Pop(Node* top){
	Node* tmp = top;
	top = top->next;
	delete tmp;

	return top;
}

bool IsEmpty(Node* top){
	if (top == nullptr) {
		cout << "it's empty" << endl;
		return true;
	}
	else
		cout << "not empty" << endl;
		return false;
}

void Traverse(Node* top) {
	while (true) {
		cout << top->value << endl;
		top = top->next;
		if (top == nullptr) {
			break;
		}
	}

}


int main() {

	Node* top = nullptr;
	top = Push(1, top);
	top = Push(2, top);
	//top = Push(3, top);
	//top = Push(4, top);
	top = Pop(top);
	top = Pop(top);
	//Traverse(top);
	IsEmpty(top);

	return 0;
}