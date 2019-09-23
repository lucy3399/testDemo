package singleton;

/**
 * Created by zhuting on 2019/9/21.
 */
public class Singleton {
        private volatile static Singleton uniqueInstance;
        private Singleton() {}
        public static Singleton getInstance() {
            if (uniqueInstance == null) {
                synchronized (Singleton.class){
                    if(uniqueInstance == null){//进入区域后，再检查一次，如果仍是null,才创建实例
                        uniqueInstance = new Singleton();
                    }
                }
            }
            return uniqueInstance;
        }

}
