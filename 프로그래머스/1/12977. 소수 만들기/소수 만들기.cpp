#include <vector>
#include <iostream>
#include <cmath>

using namespace std;

int answer = 0;

bool isPrime(int n) {
    if(n == 1) return false;
    for(int i = 2; i <= sqrt(n); i++) {
        if(n % i == 0) {
            return false;
        }
    }
    return true;
}

void combination(vector<int> nums, int start, vector<int> choice) {
    if(choice.size() == 3) {
        int n = choice[0] + choice[1] + choice[2];
        if(isPrime(n)) {
            answer++;
        }
        return;
    }
    
    for(int i = start; i < nums.size(); i++) {
        choice.push_back(nums[i]);
        combination(nums, i+1, choice);
        choice.erase(choice.end()-1);
    }
}

int solution(vector<int> nums) {
    vector<int> choice;
    combination(nums, 0, choice);
    return answer;
}
