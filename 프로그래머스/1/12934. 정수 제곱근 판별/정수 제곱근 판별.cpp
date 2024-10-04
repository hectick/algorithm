#include <string>
#include <vector>
#include <cmath>

using namespace std;

long long solution(long long n) {
    long long a = sqrt(n);
    if(pow(a, 2) == n) {
        return pow(a+1, 2);
    }
    return -1;
}