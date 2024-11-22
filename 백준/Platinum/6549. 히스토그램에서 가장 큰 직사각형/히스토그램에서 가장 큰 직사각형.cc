#include <bits/stdc++.h>
using namespace std;

int main(void){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    while(true){
        stack<pair<long long, int>> S;    //높이, 순서 저장
        int N;
        long long mx = 0;
        cin >> N;
        if(N == 0) break;

        int i;
        for(i = 0; i < N; i++){
            long long t;
            cin >> t;
            
            int w = i;
            while(!S.empty() && S.top().first > t){
                long long area = S.top().first * (i - S.top().second);
                w = S.top().second;
                S.pop();
                if(area > mx) mx = area;
            }

            S.push({t, w});
        }

        while(!S.empty()){
            long long area = S.top().first * (i - S.top().second);
            S.pop();
            if(area > mx) mx = area;
        }


        cout << mx << '\n';
    }
}