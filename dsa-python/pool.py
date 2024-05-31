import concurrent.futures
import logging
import concurrent
import time

def thread_func(name):
    logging.info("Thread %s: starting", name)
    time.sleep(4)
    logging.info("Thread %s: finishing", name)

if __name__ == "__main__":
    format = "%(asctime)s : %(message)s"
    logging.basicConfig(format=format, 
                        level=logging.INFO, 
                        datefmt="%H:%M:%S")
    
    with concurrent.futures.ThreadPoolExecutor(max_workers=4) as exe:
        exe.map(thread_func, range(4))