#include <iostream>
#include <queue>

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

void inOrder(Node* treePointer) {
	if(treePointer!=nullptr){
		inOrder(treePointer->left_child);
		cout << treePointer->value << endl;
		inOrder(treePointer->right_child);
	}


}

void levelOrder(Node* root) {

	queue<Node*> q;
	q.push(root);
	while (true) {
		root = q.front();
		cout << q.front()->value << endl;
		q.pop();
		if (root->left_child != nullptr) {
			q.push(root->left_child);
		}
		if (root->right_child != nullptr) {
			q.push(root->right_child);
		}
		if (q.empty() && root->left_child == nullptr && root->right_child == nullptr) {
			break;
		}
	}


}

//preorder, postorder



int main() {
	Node* treePointer = nullptr;
	treePointer = Create(5, treePointer);
	Node* second = Lchild(10, treePointer);
	Node* third = Rchild(15, treePointer);
	Node* fourth = Lchild(20, second);
	Node* fifth = Rchild(25, third);
	// inOrder(treePointer);
	levelOrder(treePointer);
	//cout << treePointer->value << endl;
	//cout << second->value << endl;

}