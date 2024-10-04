#include <string>
#include <vector>
#include <cmath>

using namespace std;

int solution(vector<int> num_list) {
    int multiple = 1;
    int sum = 0;
    for(int i = 0; i < num_list.size(); i++) {
        multiple *= num_list[i];
        sum += num_list[i];
    }
    if(multiple < pow(sum, 2)) {
        return 1;
    }
    return 0;
}