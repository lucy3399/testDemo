import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by zhuting on 2019/8/19.
 */
public enum TestSSHUtil2 {

    INSTANCE;

    private String hostName;
    private String userName;
    private Connection conn;
    private String password;


    public void init(String hostName,String userName, String password) throws IOException {
        this.hostName = hostName;
        this.userName = userName;
        this.password = password;
        this.conn = getConnection();
    }


    public Connection getConnection() throws IOException {
         Connection conn=null;
        boolean flg=false;
        try {
            conn = new Connection(hostName,22);
            conn.connect();//连接
            flg=conn.authenticateWithPassword(userName, password);//认证
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(!flg){
            throw new IOException("用户名或者密码错误");

        }
        return conn;
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
    public String execute(String... cmd) {

        Session session = null;
        byte[] bytes = new byte[1024];
        int length=-1;
        StringBuilder stringBuilder = new StringBuilder();

        try {
            session=  conn.openSession();
            session.execCommand(cmd[0]);
            InputStream is = session.getStderr();

            while((length=is.read(bytes))>=1){
                stringBuilder.append(new String (bytes,0,length));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(session!=null){
                session.close();
            }
        }
        return  stringBuilder.toString();
    }

}
