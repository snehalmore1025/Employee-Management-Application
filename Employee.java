public class Employee {
    private int id;
    private String nm;
    private String pos;
    public Employee(int id, String nm, String pos) {
        this.id = id;
        this.nm = nm;
        this.pos = pos;
    }
    public int getid() {
        return id;
    }
    public String getnm() {
        return nm;
    }
    public String getpos() {
        return pos;
    }
    public void setnm(String nm) {
        this.nm = nm;
    }
    public void setpos(String pos) {
        this.pos = pos;
    }
    @Override
    public String toString() {
        return "Employee ID: " + id + ", Name: " + nm + ", Position: " + pos;
    }
}
