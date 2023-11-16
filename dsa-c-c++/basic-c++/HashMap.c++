#include <iostream>
#include <unordered_map>

using namespace std;

int main(){
    unordered_map<int,int> hashMap;

    hashMap.insert({1,10});
    hashMap.insert({2,20});
    hashMap.insert({3,30});

    cout<<"Size: "<<hashMap.size()<<endl;

    cout<<"Value at 1: "<<hashMap[1]<<endl;

    if(hashMap.count(3) > 0){
        cout<<"Found"<<endl;
    }

    hashMap[1] = 100;

    hashMap.erase(2);

    for(const auto& pair : hashMap){
        cout<<"Key: "<<pair.first<<" Value: "<<pair.second<<endl;
    }

    return 0;
}