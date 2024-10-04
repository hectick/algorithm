#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> num_list) {
    int last = num_list[num_list.size()-1];
    int lastMinusOne = num_list[num_list.size()-2];
    if(last > lastMinusOne) {
        num_list.push_back(last - lastMinusOne);
        return num_list;
    }
    num_list.push_back(last*2);
    return num_list;
}