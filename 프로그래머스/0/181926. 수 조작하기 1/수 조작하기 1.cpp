#include <string>
#include <vector>

using namespace std;

int solution(int n, string control) {
    for(int i = 0; i < control.size(); i++) {
        char option = control[i];
        if(option == 'w') {
            n += 1;
        }else if(option == 's') {
            n -= 1;
        }else if(option == 'd') {
            n += 10;
        }else if(option == 'a') {
            n -= 10;
        }
    }
    return n;
}