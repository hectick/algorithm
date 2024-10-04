#include <string>
#include <vector>

using namespace std;

int solution(string s) {
    if(s[0] == '+') {
        s.erase(s.begin());
    }
    return stoi(s);
}