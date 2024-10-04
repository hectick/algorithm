#include <string>
#include <iostream>
using namespace std;

bool solution(string s)
{
    int p = 0;
    int y = 0;
    for(int i = 0; i < s.size(); i++) {
        if(tolower(s[i]) == 'p') {
            p++;
        }else if(tolower(s[i]) == 'y') {
            y++;
        }
    }
    if(p == y) return true;
    return false;
}