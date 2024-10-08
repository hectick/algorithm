#include <string>
#include <vector>

using namespace std;

vector<long long> solution(int x, int n) {
    vector<long long> answer;
    answer.push_back(x);
    for(int i = 2; i <= n; i++) {
        answer.push_back(x + (long long)x*(i-1));
    }
    return answer;
}