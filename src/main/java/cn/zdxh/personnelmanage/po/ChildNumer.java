package cn.zdxh.personnelmanage.po;

public class ChildNumer {
    private Integer id;
    private String childType;

    public ChildNumer(Integer id, String childType) {
        this.id = id;
        this.childType = childType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChildType() {
        return childType;
    }

    public void setChildType(String childType) {
        this.childType = childType;
    }
}
