#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;


int main(){

    long long n;
    vector<int> order;
    
    cin >> n;

    int tmp;
    for(int i=0; i<6;i++){
        cin >> tmp;
        order.push_back(tmp);
    }

    int min_one = order[0];
    for(int i=0;i<6;i++){
        if(min_one>order[i]){
            min_one = order[i]; 
        }
    }

    int max_one = order[0];
    int total = 0;
    for(int i=0;i<6;i++){
        if(max_one<order[i]){
            max_one = order[i];
        }
        total += order[i];
    }

    int case_one = total - max_one;



    int min_two = order[0] + order[1];
    int current_num=0;
    for(;current_num<6;current_num++){
        for(int i=0;i<6;i++){
            if(current_num+i==5 || current_num==i){
                continue;
            }
            if(min_two>order[current_num] + order[i]){
                min_two = order[current_num] + order[i];
            }
            
        } 
    }

    int min_th=order[0]+order[1]+order[2];

    for(current_num=0;current_num<6;current_num++){
    
        for(int i=0;i<6;i++){
            if(current_num+i==5 || current_num==i){
                continue;
            }
            for(int j=0;j<6;j++){
                if((i+j==5) ||(current_num+j==5) ||j==current_num || j==i){
                    continue;
                }
                if(min_th>order[current_num]+order[i]+order[j]){
                    min_th = order[current_num]+order[i]+order[j];
                }
            }

        }
    }



    long long overall = 4*min_th + (4*(n-1)+4*(n-2))*min_two + ((n-2)*(n-1)*4+(n-2)*(n-2))*min_one;
    
    if(n==1){
        cout<<case_one<<endl;
    }
    else{
        cout<<overall<<endl;
        // cout<<min_th<<min_two<<min_one<<endl;

    }


 return 0;
}
