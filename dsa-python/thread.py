import threading
import time

def worker(name):
    print(f"Thread {name} started")
    for i in range(5):
        print(f"Thread {name}: {i}")
        time.sleep(2)
    print(f"Thread {name} finished")

def main():
    threads = []
    for i in range(3):
        thread = threading.Thread(target=worker, args=(f"Thread {i}"))
        thread.start()
        threads.append(thread)

    for thread in threads:
        thread.join()

if __name__ == "__main__":
    main()