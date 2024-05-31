import __main__
import logging
import random
import threading

class Pipeline:

    def __init__(self):
        self.message = 0
        self.producer_lock = threading.Lock()
        self.consumer_lock = threading.Lock()
        self.consumer_lock.acquire()

    def get_msg(self, name):
        logging.debug("%s: about to acquire the getlock", name)
        self.consumer_lock.acquire()
        logging.debug("%s: have getlock", name)
        msg = self.message
        logging.debug("%s: about to release the getlock", name)
        self.producer_lock.release()
        logging.debug("%s: setlock released", name)
        return msg
    
    def set_msg(self, msg, name):
        logging.debug("%s: about to acquire the setlock", name)
        self.producer_lock.acquire()
        logging.debug("%s: have setlock", name)
        self.message = msg
        logging.debug("%s: about to release the setlock", name)
        self.consumer_lock.release()
        logging.debug("%s: getlock released", name)



SENTINAL = object()

def producer(pipeline):
    for id in range(10):
        msg = random.randint(1,101)
        logging.info("Producer get message: %s", msg)
        pipeline.set_msg(msg, "producer")

    pipeline.set_msg(SENTINAL, "Producer")

def consumer(pipline):
    msg = 0
    while msg is not SENTINAL:
          msg = pipline.get_msg("consumer")
          if msg is not SENTINAL:
               logging.info("Consumer get message: %s", msg)

if __main__ == "__main__":
    format = "%(asctime)s: %(message)s"
    logging.basicConfig(format=format, level=logging.INFO,
                        datefmt="%H:%M:%S")

    pipeline = Pipeline()
    producer_thread = threading.Thread(target=producer, args=(pipeline,))
    consumer_thread = threading.Thread(target=consumer, args=(pipeline,))

    producer_thread.start()
    consumer_thread.start()

    producer_thread.join()
    consumer_thread.join()

    logging.info("Main: done")
    
