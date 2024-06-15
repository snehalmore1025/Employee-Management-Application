import java.util.ArrayList;
public class EmployeeManagement {
    private ArrayList<Employee> emp1;
    public EmployeeManagement() {
        emp1 = new ArrayList<>();
    }
    public void addEmp(Employee emp) {
        emp1.add(emp);
    }
    public Employee viewEmp(int id) {
        for (Employee emp : emp1) {
            if (emp.getid() == id) {
                return emp;
            }
        }
        return null;
    }
    public boolean updateEmp(int id, String nm, String pos) {
        for (Employee emp : emp1) {
            if (emp.getid() == id) {
                emp.setnm(nm);
                emp.setpos(pos);
                return true;
            }
        }
        return false;
    }
    public boolean delEmp(int id) {
        for (Employee emp : emp1) {
            if (emp.getid() == id) {
                emp1.remove(emp);
                return true;
            }
        }
        return false;
    }
    public ArrayList<Employee> viewAllEmp() {
        return emp1;
    }
}
