package TestDB;

import java.util.Arrays;
import java.util.List;

/**
 *
 *
 现有多台DB,每台DB有属性 dbName数据库名称，ldcName机房名称，是否要求同机房ldcFlag[0,1]，该db文件下标fileIndex，该下标文件中最后一行行号maxPos（该值>=0），该db延时时间delayTime。
 所谓的maxPos最新的（需要考虑该db文件下标fileIndex）
 Eg：db1有 文件fileIndex为1：maxPos为327 ，db2 有文件fileIndex为2：maxPos为1  则db2 持有的maxPos为最新 因为db2的fileIndex更大说明更新。
 若有一台db故障，选出替代该故障db的dbName，选取策略：
 选取拥有最新maxPos的db，
 若多台db的maxPos相同 ？（若故障db的ldcFlag==1则选取与故障db同机房的db ）：（选取delayTime最小的）
 */
public class DbTest {
    public static void main(String[] args) {
        DbInfo dbInfo1= new DbInfo("db1", "M", 1, 1, 256, 30);
        DbInfo dbInfo2= new DbInfo("db2", "P", 1, 0, 256, 29);
        DbInfo dbInfo3= new DbInfo("db3", "Q", 0, 0, 256, 28);
        DbInfo dbInfo4= new DbInfo("db4", "M", 1, 2, 211, 27);
        DbInfo dbInfo5= new DbInfo("db5", "P", 1, 0, 256, 26);
        DbInfo dbInfo6= new DbInfo("db6", "M", 1, 2, 222, 25);
        //
        List<DbInfo> dbInfos = Arrays.asList(dbInfo1, dbInfo2, dbInfo3, dbInfo4, dbInfo5, dbInfo6);

        String brokenDB=null;
        getReplaceDB(brokenDB,dbInfos);


    }

    /**
     * 根据故障db名称按照要求的选取策略选择出替代其的db名称
     * @param brokenDB 故障dbName
     * @return
     */
     public static String  getReplaceDB(String brokenDB,List<DbInfo> dbInfos){
         for (DbInfo dbInfo : dbInfos) {





         }
        return null;
    }


   static class DbInfo{
        private  String dbName;
        private  String ldcName;
        private int ldcFlag;
        private int fileIndex;
        private int maxPos;
        private int delayTime;

        public DbInfo() {
        }

        public DbInfo(String dbName, String ldcName, int ldcFlag, int fileIndex,int maxPos ,int delayTime) {
            this.dbName = dbName;
            this.ldcName = ldcName;
            this.ldcFlag = ldcFlag;
            this.fileIndex = fileIndex;
            this.delayTime = delayTime;
            this.maxPos = maxPos;
        }

        public String getDbName() {
            return dbName;
        }

        public void setDbName(String dbName) {
            this.dbName = dbName;
        }

        public String getLdcName() {
            return ldcName;
        }

        public void setLdcName(String ldcName) {
            this.ldcName = ldcName;
        }

        public int getLdcFlag() {
            return ldcFlag;
        }

        public void setLdcFlag(int ldcFlag) {
            this.ldcFlag = ldcFlag;
        }

        public int getFileIndex() {
            return fileIndex;
        }

        public void setFileIndex(int fileIndex) {
            this.fileIndex = fileIndex;
        }

        public int getDelayTime() {
            return delayTime;
        }

        public void setDelayTime(int delayTime) {
            this.delayTime = delayTime;
        }

        public int getMaxPos() {
            return maxPos;
        }

        public void setMaxPos(int maxPos) {
            this.maxPos = maxPos;
        }
    }
}
