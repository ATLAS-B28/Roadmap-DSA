//Threads: C++ supports multithreading with 
//the <thread> header. You can create and manage threads using std::thread
/*
#include <iostream>
#include <thread>

void threadFunc() {
    std::cout << "Hello from thread!\n";
}

int main() {
    std::thread t(threadFunc);

    t.join();

    std::cout << "Hello from main!\n";
    return 0;
}*/

//Mutexes
/*
#include <iostream>
#include <thread>
#include <mutex>

std::mutex mtx; // mutex to protect the resource
 
void printNumber(int num) {
    std::lock_guard<std::mutex> lock(mtx);//lock the mutex using the lock_guard
    std::cout << "Number: " << num << std::endl; 
}

int main() {
    std::thread t1(printNumber, 1);
    std::thread t2(printNumber, 2);
    t1.join();
    t2.join();
    return 0;
}*/


//Conditional Variable
/*
#include <iostream>
#include <thread>
#include <mutex>
#include <condition_variable>

std::mutex mtx;
std::condition_variable cv;
bool ready = false;

void printMessage() {
    std::unique_lock<std::mutex> lock(mtx);
    cv.wait(lock, [] {return ready;}); //wait until ready is true
    std::cout << "Message: Hello!" << std::endl;
}

int main() {
    std::thread t(printMessage);
    std::this_thread::sleep_for(std::chrono::seconds(5));
    {
        std::lock_guard<std::mutex> lock(mtx);
        ready = true;
    }
    cv.notify_one();
    t.join();
    return 0;
}*/

//Atomic Operations

/*
#include <iostream>
#include <thread>
#include <atomic>

std::atomic<int> counter(0);

void incrementCounter() {
    for(int i = 0; i < 1000; ++i) {
        counter.fetch_add(1); //Automatically increments counter
    }
}

int main() {
    std::thread t1(incrementCounter);
    std::thread t2(incrementCounter);
    t1.join();
    t2.join();
    std::cout << "Counter Value: " << counter << std::endl;
    return 0;
}*/

//Futures and Promises

#include <iostream>
#include <thread>
#include <future>

int addNumbers(int a,int b) {
    std::this_thread::sleep_for(std::chrono::seconds(3));
    return a + b;
}

int main() {
    std::promise<int> promise;
    std::future<int> future = promise.get_future();

    std::thread t([&promise]() {
        int result = addNumbers(5, 7);
        promise.set_value(result);
    });

    std::cout << "Waiting for result..." << std::endl;
    int result = future.get();
    std::cout << "Result:  " << result << std::endl;

    t.join();
    return 0;
}