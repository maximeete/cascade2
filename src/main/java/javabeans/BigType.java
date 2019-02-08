package javabeans;

//这个是大类
public class BigType {

    private int bigTypeId;//数据库的字段1
    private String bigTypeName;//数据库的字段2
    public int getBigTypeId() {
        return bigTypeId;
    }
    public void setBigTypeId(int bigTypeId) {
        this.bigTypeId = bigTypeId;
    }
    public String getBigTypeName() {
        return bigTypeName;
    }
    public void setBigTypeName(String bigTypeName) {
        this.bigTypeName = bigTypeName;
    }

}
