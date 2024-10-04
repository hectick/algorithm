#include <string>
#include <vector>

using namespace std;

int solution(string my_string, string is_suffix) {
    if(my_string.length() < is_suffix.length()) {
        return 0;
    }
    string s = my_string.substr(my_string.length() - is_suffix.length(), my_string.length());
    if(s == is_suffix) {
        return 1;
    }
    return 0;
}