#include <iostream>
#include <algorithm>

using namespace std;
int main(){

    int n;
    bool equals=true;
    cout << "Array size: ";
    cin >> n;

    int arr[n], temp[n];
    for(int i=0; i<n; i++){
        cin >> arr[i];
        temp[i] = arr[i];
    } 

    sort(arr, arr+n);

    for(int i=0; i<n; i++){
        if(arr[i]!=temp[i]){
            equals=false;
            break;
        }

    }

    if(equals){
        cout << "Ascending";
    }else{
        cout << "Not ascending";
    }

}