//bqasic start of thread
class MyThread extends Thread {
    override def run(): Unit = {
        println("Hello from MyThread!")
    }
   
}
//synchronization threads to avoid concurrent modifications

object SharedResource {
    private var counter = 0
    //previously val is immutable so for mutability use var
    def incrementCounter(): Unit = {
        this.synchronized {
            counter += 1
            println(s"Counter: $counter")
        }
    }
}

//using sleep



def main(args: Array[String]): Unit = {
        println("Hello from main!")
        val myThread = new MyThread()
        myThread.start()
        val thread1 = new Thread(() => SharedResource.incrementCounter())
        val thread2 = new Thread(() => SharedResource.incrementCounter())
  

        thread1.start()
        thread2.start()


        myThread.join()
        thread1.join()
        thread2.join()
}


