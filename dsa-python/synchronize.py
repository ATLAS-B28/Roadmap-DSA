import logging
import threading
import time
import concurrent.futures

class FakeDB:
    def __init__(self):
        self.value = 0
        self._lock = threading.Lock()

    def lock_updates(self, name):
        logging.info("Thread %s has lock", name)
        logging.debug("Thread %s about to lock", name)

        with self._lock:
            logging.debug("Thread %s has lock", name)
            local_copy = self.value
            local_copy += 1
            time.sleep(0.1)
            self.value = local_copy
            logging.debug("Thread %s about to release lock")
        logging.debug("Thread %s after release", name)
        logging.info("Thread %s got value: %d", name, self.value)


logging.basicConfig(
    level=logging.DEBUG,
    format="(%(threadName)-10s) %(message)s",
)

db = FakeDB()

if __name__ == "__main__":
    logging.info("Main    : before creating thread")
    with concurrent.futures.ThreadPoolExecutor(max_workers=2) as executor:
         for i in range(3):
              executor.submit(db.lock_updates, i)
              