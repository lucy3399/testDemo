import sun.misc.Unsafe;

/**
 * Created by zhuting on 2019/8/27.
 */
public class TestThread {

   /* private static final long serialVersionUID = 2862133569453604235L;
//AtomicIntegerArray
    private static final Unsafe unsafe = Unsafe.getUnsafe();
    //base:第一个元素所在的基地址,基地址往后偏移则是其他元素地址
    //第0个在第0个的位置,若是int则往后取4个byte就取到了第一个int的数据,第i个int的取法 :long byteOffset(int i)方法
    private static final int base = unsafe.arrayBaseOffset(int[].class);
    private static final int shift;
    private final int[] array;

    static {
        //数据中的元素有多宽.因为是int,所以scale是4
        int scale = unsafe.arrayIndexScale(int[].class);
        if ((scale & (scale - 1)) != 0)
            throw new Error("data type scale not a power of two");
        //numberOfLeadingZeros[前导0]就是:二进制数字前面0的个数
        //因为一个int=4个byte,所以拿4来举例 :
        // 假设32位则 4的二进制位:0000 XXXX 0000 0100  前面有32-3=29个前导0
        shift = 31 - Integer.numberOfLeadingZeros(scale);  //所以shift 为31-29=2
    }

    private long checkedByteOffset(int i) {
        if (i < 0 || i >= array.length)
            throw new IndexOutOfBoundsException("index " + i);

        return byteOffset(i);
    }

    //如果基数是base,每个元素的长度是4个byte,那么第i个元素它的偏移量是多少:base+i*4
    private static long byteOffset(int i) {
        //下面<=>base+i*4 ,但是位运算更快
        // 具体:shift=2 则i<<2  <=>  二进制中后面加两个0 <=>二进制 *100 <=>*十进制的4
        return ((long) i << shift) + base;
    }*/



}
