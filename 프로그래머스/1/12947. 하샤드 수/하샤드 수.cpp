#include <string>
#include <vector>

using namespace std;

bool solution(int x) {
    string str = to_string(x);
    int sum = 0;
    for(int i = 0; i < str.size(); i++) {
        sum += str[i] - '0';
    }
    if(x % sum == 0) return true;
    return false;
}