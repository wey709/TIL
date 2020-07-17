#include <iostream>

using namespace std;


class Node {
public:
	int value;
	Node* left_child;
	Node* right_child;
};



Node* Create(int value, Node* treePointer) {
	Node* root = new Node;
	root->value = value;
	treePointer = root;
	return treePointer;
}

bool IsEmpty(Node* treePointer) {
	if (treePointer == nullptr) {
		return true;
	}
	else {
		return false;
	}
}


Node* Lchild(int value, Node* treePointer){
	if (IsEmpty(treePointer)) {
		cout << "error" << endl;
	}
	else {
		Node* child = new Node;
		child->value = value;
		child->left_child = nullptr;
		child->right_child = nullptr;
		treePointer->left_child = child;
		return child;
	}

}

Node* Rchild(int value, Node* treePointer) {
	if (IsEmpty(treePointer)) {
		cout << "error" << endl;
	}
	else {
		Node* child = new Node;
		child->value = value;
		child->left_child = nullptr;
		child->right_child = nullptr;
		treePointer->right_child = child;
		return child;
	}
}

void Inorder(Node* treePointer) {
	if(treePointer!=nullptr){
		Inorder(treePointer->left_child);
		cout << treePointer->value << endl;
		Inorder(treePointer->right_child);
	}


}

//preorder, postorder, level-order



int main() {
	Node* treePointer = nullptr;
	treePointer = Create(5, treePointer);
	Node* second = Lchild(10, treePointer);
	Node* third = Rchild(15, treePointer);
	Node* fourth = Lchild(20, second);
	Node* fifth = Rchild(25, third);
	Inorder(treePointer);
	//cout << treePointer->value << endl;
	//cout << second->value << endl;

}