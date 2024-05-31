import logging
import threading
import time


def thread_func(name):
    logging.info("Thread %s: starting", name)
    time.sleep(3)
    logging.info("Thread %s: finishing", name)

if __name__ == "__main__":
    format = "%(asctime)s: %(message)s"
    logging.basicConfig(format=format, level=logging.INFO,
                        datefmt="%H:%M:%S")
    
    threads = list()

    for id in range(3):
        logging.info("Main : create and start thread %d.", id)
        x = threading.Thread(target=thread_func, args=(id,))
        threads.append(x)
        x.start()
    
    for id, thread in enumerate(threads):
        logging.info("Main  : before joining thread %d", id)
        thread.join()
        logging.info("Main  : thread %d done", id)