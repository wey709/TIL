#include <iostream>
#include <vector>

using namespace std;

// insertion, bubble up
void Push(vector<int> &vec, int value) {
    vec.push_back(value);
    int i_end = vec.size() - 1;

    if (i_end > 0) {
        while (vec[(i_end - 1) / 2] < vec[i_end]) {
            int tmp = vec[(i_end - 1) / 2];
            vec[(i_end - 1) / 2] = vec[i_end];
            vec[(i_end)] = tmp;

            i_end = (i_end - 1) / 2;
            if (i_end == 0) {
                break;
            }
        }

    }
}

// extraction and deletion of max, bubble down
int Pop(vector<int>& vec) {
    if (vec.size() == 0) {
        return -1;
    }
    else
    {
        int max = vec[0];
        vec[0] = vec.back();
        vec.pop_back();
        int i = 0;


        while (vec[i] < vec[i * 2 + 1] || vec[i] < vec[i * 2 + 2]) {
            if (vec[i] < vec[i * 2 + 1]) {
                int tmp = vec[i];
                vec[i] = vec[i * 2 + 1];
                vec[i * 2 + 1] = tmp;
                
                if (2*i + 3 >= vec.size()) {
                    break;
                }
                i = 2 * i + 1;
                continue;
            }
            if (vec[i] < vec[i * 2 + 2]) {
                int tmp = vec[i];
                vec[i] = vec[i * 2 + 2];
                vec[i * 2 + 2] = tmp;
                
                if (2*i + 3 >= vec.size()) {
                    break;
                }
                i = 2 * i + 2;
            }
        }
        return max;
    }
}


int main() {

    vector<int> max_heap;
    Push(max_heap, 7);
    Push(max_heap, 1);
    Push(max_heap, 3);
    Push(max_heap, 5);
    Pop(max_heap);

    for (int i = 0; i < max_heap.size(); i++) {
        cout << max_heap[i] << endl;
    }
}