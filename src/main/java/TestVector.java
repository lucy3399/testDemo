import java.util.Vector;

/**
 * Created by zhuting on 2019/8/28.
 */
public class TestVector {
    public static void main(String[] args) {
        Vector vector = new Vector();
        vector.add("123");
        vector.add("456");
        vector.add("666");
    }




   /* public void execute(Runnable command) {
        if (command == null)
            throw new NullPointerException();
        *//*
         * Proceed in 3 steps:
         *
         * 1. If fewer than corePoolSize threads are running, try to
         * start a new thread with the given command as its first
         * task.  The call to addWorker atomically checks runState and
         * workerCount, and so prevents false alarms that would add
         * threads when it shouldn't, by returning false.
         *
         * 2. If a task can be successfully queued, then we still need
         * to double-check whether we should have added a thread
         * (because existing ones died since last checking) or that
         * the pool shut down since entry into this method. So we
         * recheck state and if necessary roll back the enqueuing if
         * stopped, or start a new thread if there are none.
         *
         * 3. If we cannot queue task, then we try to add a nd'f'dew
         * thread.  If it fails, we know we are shut down or saturated
         * and so reject the task.
         *//*
        int c = ctl.get(); //ctl表示控制状态的变量,原子整数,包装了两个逻辑字段,wokerCount有效的线程总数,2)线程池runState 好处后续介绍 ForkJoinPool介绍
        if (workerCountOf(c) < corePoolSize) {
            if (addWorker(command, true))  //第二个参数意为:是否数量局限于coreSize数目?true就是超过coreSize则不加
                return;
            c = ctl.get();
        }
        if (isRunning(c) && workQueue.offer(command)) {  //超过核心线程数,此处可以看出来并不是马上又开线程加入,而是先将任务加入workQueue
            int recheck = ctl.get();
            if (! isRunning(recheck) && remove(command))   //若线程池不在运行的状态,则拒绝这个任务
                reject(command);
            else if (workerCountOf(recheck) == 0)    //线程池中根本没有运行的线程,则初始化加上一个合理的线程,让其工作
                addWorker(null, false);
        }
        else if (!addWorker(command, false))   //若上一个大的if往workQueue中加入失败了,(原因可能是queue已经满了),
                                               // 则此处再尝试加入,但是是false意为不受到coreSize限制,但是会受到maxSize限制
            reject(command);   //若上述都不成功,说明到达了最大线程,则此处拒绝
    }*/
}

