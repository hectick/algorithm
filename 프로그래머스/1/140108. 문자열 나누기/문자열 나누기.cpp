#include <string>
#include <vector>
#include <iostream>

using namespace std;

int xCount = 0;
int otherCount = 0;
int answer = 0;

void func(string s) {
    if(s.size() == 0) return;
    
    int xCount = 0;
    int otherCount = 0;
    char x = s[0];
    
    for(int i = 0; i < s.size(); i++) {
        if(s[i] == x) xCount++;
        else otherCount++;
        
        if(xCount == otherCount && i+1 < s.size()){
            string newStr = s.substr(i+1, s.size());
            answer++;
            func(newStr);
            return;
        }
    }
    answer++;
    return;
}

int solution(string s) {
    func(s);
    return answer;
}