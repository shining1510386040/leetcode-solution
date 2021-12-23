## leetcode题解
https://leetcode-cn.com

## 常用解法？

#### 1.动态规划问题？
    1.1 寻找转态方程
    1.2 寻找边界条件
    1.3 
#### 2.双指针问题？（滑动窗口问题）

#### 3.合理数据结构 优化空间复杂度和时间复杂度？

#### 4.多线程问题？

#### ReentrantLock 可重入锁？

    ReentrantLock主要利用CAS+AQS队列来实现。它支持公平锁和非公平锁，两者的实现类似。
    
    CAS：Compare and Swap，比较并交换。CAS有3个操作数：内存值V、预期值A、要修改的新值B。
    当且仅当预期值A和内存值V相同时，将内存值V修改为B，否则什么都不做。
    该操作是一个原子操作，被广泛的应用在Java的底层实现中。
    在Java中，CAS主要是由sun.misc.Unsafe这个类通过JNI调用CPU底层指令实现
    
#### ReentrantLock和synchronized比较?
   
    1.ReentrantLock和synchronized都是独占锁,只允许线程互斥的访问临界区。但是实现上两者不同:
     synchronized加锁解锁的过程是隐式的,用户不用手动操作,优点是操作简单，但显得不够灵活。
     一般并发场景使用synchronized的就够了；
     
     ReentrantLock需要手动加锁和解锁,且解锁的操作尽量要放在finally代码块中,保证线程正确释放锁。
     ReentrantLock操作较为复杂，但是因为可以手动控制加锁和解锁过程,在复杂的并发场景中能派上用场。
    
    2.ReentrantLock和synchronized都是可重入的。
    synchronized因为可重入因此可以放在被递归执行的方法上,且不用担心线程最后能否正确释放锁；
    
    而ReentrantLock在重入时要却确保重复获取锁的次数必须和重复释放锁的次数一样，
    否则可能导致其他线程无法获得该锁
    
#### synchronized 同步锁？

    1、wait()、notify/notifyAll() 方法是Object的本地final方法，无法被重写。
    
    2、wait()使当前线程阻塞，前提是 必须先获得锁，一般配合synchronized 关键字使用，即，一般在synchronized 同步代码块里使用 wait()、notify/notifyAll() 方法。
    
    3、 由于 wait()、notify/notifyAll() 在synchronized 代码块执行，说明当前线程一定是获取了锁的。
    
    当线程执行wait()方法时候，会释放当前的锁，然后让出CPU，进入等待状态。
    
    只有当 notify/notifyAll() 被执行时候，才会唤醒一个或多个正处于等待状态的线程，然后继续往下执行，直到执行完synchronized 代码块的代码或是中途遇到wait() ，再次释放锁。
    
    也就是说，notify/notifyAll() 的执行只是唤醒沉睡的线程，而不会立即释放锁，锁的释放要看代码块的具体执行情况。所以在编程中，尽量在使用了notify/notifyAll() 后立即退出临界区，以唤醒其他线程让其获得锁
    
    4、wait() 需要被try catch包围，以便发生异常中断也可以使wait等待的线程唤醒。
    
    5、notify 和wait 的顺序不能错，如果A线程先执行notify方法，B线程在执行wait方法，那么B线程是无法被唤醒的。
    
    6、notify 和 notifyAll的区别
    
    notify方法只唤醒一个等待（对象的）线程并使该线程开始执行。所以如果有多个线程等待一个对象，这个方法只会唤醒其中一个线程，选择哪个线程取决于操作系统对多线程管理的实现。notifyAll 会唤醒所有等待(对象的)线程，尽管哪一个线程将会第一个处理取决于操作系统的实现。如果当前情况下有多个线程需要被唤醒，推荐使用notifyAll 方法。比如在生产者-消费者里面的使用，每次都需要唤醒所有的消费者或是生产者，以判断程序是否可以继续往下执行。
    
    7、在多线程中要测试某个条件的变化，使用if 还是while？
    
    要注意，notify唤醒沉睡的线程后，线程会接着上次的执行继续往下执行。所以在进行条件判断时候，可以先把 wait 语句忽略不计来进行考虑；显然，要确保程序一定要执行，并且要保证程序直到满足一定的条件再执行，要使用while进行等待，直到满足条件才继续往下执行
#### LockSupport 锁？

        LockSupport类的核心方法其实就两个：park()和unpark()，其中park()方法用来阻塞当前调用线程，unpark()方法用于唤醒指定线程。
        这其实和Object类的wait()和signal()方法有些类似，但是LockSupport的这两种方法从语意上讲比Object类的方法更清晰，而且可以针对指定线程进行阻塞和唤醒。
    
        LockSupport类使用了一种名为Permit（许可）的概念来做到阻塞和唤醒线程的功能，可以把许可看成是一种(0,1)信号量（Semaphore），但与 Semaphore 不同的是，许可的累加上限是1。
        初始时，permit为0，当调用unpark()方法时，线程的permit加1，当调用park()方法时，如果permit为0，则调用线程进入阻塞状态。
    
   
   
