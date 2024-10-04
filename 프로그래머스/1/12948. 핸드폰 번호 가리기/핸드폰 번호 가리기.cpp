#include <string>
#include <vector>

using namespace std;

string solution(string phone_number) {
    int len = phone_number.end() - 4 - phone_number.begin();
    string str = "";
    for(int i = 0; i < len; i++) {
        str += "*";
    }
    return phone_number.replace(phone_number.begin(), phone_number.end()-4, str);
}