/**
 * Created by zhuting on 2019/8/19.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

/**
 * Created by bpenv on 2017/6/21.
 */
public class SshUtil {
    //字符编码默认是utf-8
    private static String  DEFAULTCHART="UTF-8";
    private Connection conn;
    private String ip;
    private int port;
    private String userName;
    private String userPwd;

    public SshUtil(String ip,int port,String userName, String userPwd) {
        this.ip = ip;
        this.port = port;
        this.userName = userName;
        this.userPwd = userPwd;
    }


    public SshUtil() {

    }

    /**
     * 远程登录linux的主机
     * @author Ickes
     * @since  V0.1
     * @return
     *      登录成功返回true，否则返回false
     */
    public Boolean login() throws IOException {
        boolean flg=false;
        try {
            conn = new Connection(ip,port);
            conn.connect();//连接
            flg=conn.authenticateWithPassword(userName, userPwd);//认证
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(!flg){
            throw new IOException("用户名或者密码错误");

        }
        return flg;
    }


    /**
     * @author Ickes
     * 远程执行shell脚本或者命令
     * @param cmd
     *      即将执行的命令
     * @return
     *      命令执行完后返回的结果值
     * @since V0.1
     */
    public String execute(String cmd){
        String result="";
        try {
            if(login()){
                Session session= conn.openSession();//打开一个会话
                session.execCommand(cmd);
                //执行命令
                result=processStdout(session.getStdout(),DEFAULTCHART);
                System.out.println("//执行命令  :   "+result);
                //如果为得到标准输出为空，说明脚本执行出错了
                if(null!=result&&!"".equals(result)){
                    result=processStdout(session.getStderr(),DEFAULTCHART);
                    System.out.println("//执行命令2  :   "+result);
                }

                conn.close();
                session.close();
            }else{
                System.out.println("登录失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * @author Ickes
     * 远程执行shll脚本或者命令
     * @param cmd
     *      即将执行的命令
     * @return
     *      命令执行成功后返回的结果值，如果命令执行失败，返回空字符串，不是null
     * @since V0.1
     */
    public String executeSuccess(String cmd){
        String result="";
        try {
            if(login()){
                Session session= conn.openSession();//打开一个会话
                session.execCommand(cmd);//执行命令
                result=processStdout(session.getStdout(),DEFAULTCHART);
                conn.close();
                session.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 解析脚本执行返回的结果集
     * @author Ickes
     * @param in 输入流对象
     * @param charset 编码
     * @since V0.1
     * @return
     *       以纯文本的格式返回
     */
    private String processStdout(InputStream in, String charset) throws IOException {
        InputStream    stdout = new StreamGobbler(in);
        StringBuffer buffer = new StringBuffer();;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(stdout,charset));
            String line=null;
            while((line=br.readLine()) != null){
                buffer.append(line+"\n");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            stdout.close();
        }
        return buffer.toString();
    }

    public static void setCharset(String charset) {
        DEFAULTCHART = charset;
    }
    public Connection getConn() {
        return conn;
    }
    public void setConn(Connection conn) {
        this.conn = conn;
    }
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserPwd() {
        return userPwd;
    }
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public static String excuteCmd(String ip,Integer port,String userName,String userPwd,String cmds){
        String flag = "failed";
        SshUtil rec=new SshUtil(ip,port, userName,userPwd);
        StringBuilder stringBuilder = new StringBuilder();
        String execute = rec.execute(cmds);
        if(execute.contains("successful")){
            flag = "success";
        }
        return execute;
    }

    public static void main(String[] args) {
        SshUtil sshUtil = new SshUtil("172.16.100.150", 22, "root", "419217");
        System.out.println(sshUtil. execute("pwd1"));
//       System.out.println(sshUtil. execute("mysql -h 172.16.100.149 -P3307 -uroot -prootroot -e'select 1' "));

////        执行命令
//        System.out.println(sshUtil.execute("pwd"));
////        执行脚本
//        System.out.println(sshUtil.execute("cd /data/lugs/wrf/trajectory && ./trajectory.sh 2017 06 20 22 Beijing 113.2 30.4 600 -48"));
//        //这个方法与上面最大的区别就是，上面的方法，不管执行成功与否都返回，
//        //这个方法呢，如果命令或者脚本执行错误将返回空字符串
//        System.out.println(sshUtil.executeSuccess("cd /data/lugs/wrf/trajectory && ./trajectory.sh 2017 06 20 22 Beijing 113.2 30.4 600 -48"));
//        String create = "cd /data/lugs/wrf/trajectory && ./trajectory.sh 2017 06 20 22 trail     113.2 30.4 1000 -48";
//        String flag = SshUtil.excuteCmd("111.200.200.203", 2134, "lugs", "lugs@3clear", create);
//        String read = "cat /data/lugs/wrf/trajectory/trail_1000";
//        String flag1 = SshUtil.excuteCmd("111.200.200.203", 2134, "lugs", "lugs@3clear", read);
//        System.out.println(flag1);

    }
}

