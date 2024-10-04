#include <string>
#include <vector>
#include <algorithm>

using namespace std;

long long solution(long long n) {
    vector<long long> v;
    
    long long divide = 10;
    while(n != 0) {
        long long a = n % divide;
        v.push_back(a);
        n = (n - a) / 10; 
    }
    sort(v.begin(), v.end());
    long long answer = 0;
    int k = 1;
    for(int i = 0; i < v.size(); i++) {
        answer += k*v[i];
        k *= 10;
    }
    return answer;
}