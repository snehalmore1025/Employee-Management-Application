import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class EmployeeManagementApp extends JFrame {
    public EmployeeManagement mng;
    public EmployeeManagementApp() {
        mng = new EmployeeManagement();
        initUI();
    }
    private void initUI() {
        setTitle("Employee Management System");
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel p1 = new JPanel();
        getContentPane().add(p1);
        p1.setLayout(new GridLayout(6, 1));
        JButton addB = new JButton("Add Employee");
        JButton viewB = new JButton("View Employee");
        JButton updateB= new JButton("Update Employee");
        JButton delB = new JButton("Delete Employee");
        JButton viewAllB= new JButton("View All Employees");
        JButton exitB= new JButton("Exit");
        p1.add(addB);
        p1.add(viewB);
        p1.add(updateB);
        p1.add(delB);
        p1.add(viewAllB);
        p1.add(exitB);
        addB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEmp();
            }
        });
        viewB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewEmp();
            }
        });
        updateB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateEmp();
            }
        });
        delB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delEmp();
            }
        });
        viewAllB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewAllEmp();
            }
        });
        exitB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    private void addEmp() {
        JTextField tid = new JTextField();
        JTextField tnm = new JTextField();
        JTextField tpos = new JTextField();
        Object[] message = {
            "Employee ID:", tid,
            "Name:", tnm,
            "Position:", tpos
        };
        int opt = JOptionPane.showConfirmDialog(this, message, "Add Employee", JOptionPane.OK_CANCEL_OPTION);
        if (opt == JOptionPane.OK_OPTION) {
            int id = Integer.parseInt(tid.getText());
            String nm = tnm.getText();
            String pos = tpos.getText();
            mng.addEmp(new Employee(id, nm, pos));
            JOptionPane.showMessageDialog(this, "Employee added successfully!");
        }
    }
    private void viewEmp() {
        String id = JOptionPane.showInputDialog(this, "Enter Employee ID to view:");
        if (id != null) {
            Employee emp = mng.viewEmp(Integer.parseInt(id));
            if (emp != null) {
                JOptionPane.showMessageDialog(this, emp);
            }
             else {
                JOptionPane.showMessageDialog(this, "Employee not found.");
            }
        }
    }
    private void updateEmp() {
        String id = JOptionPane.showInputDialog(this, "Enter Employee ID to update:");
        if (id != null) {
            int empId = Integer.parseInt(id);
            Employee emp = mng.viewEmp(empId);
            if (emp != null) {
                JTextField tnm = new JTextField(emp.getnm());
                JTextField tpos = new JTextField(emp.getpos());
                Object[] message = {
                    "Name:", tnm,
                    "Position:", tpos
                };
                int opt = JOptionPane.showConfirmDialog(this, message, "Update Employee", JOptionPane.OK_CANCEL_OPTION);
                if (opt== JOptionPane.OK_OPTION) {
                    String nm =tnm.getText();
                    String pos = tpos.getText();
                    mng.updateEmp(empId, nm,pos);
                    JOptionPane.showMessageDialog(this, "Employee updated successfully!");
                }
            }
             else {
                JOptionPane.showMessageDialog(this, "Employee not found.");
            }
        }
    }

    private void delEmp() {
        String id = JOptionPane.showInputDialog(this, "Enter Employee ID to delete:");
        if (id != null) {
            boolean success = mng.delEmp(Integer.parseInt(id));
            if (success) {
                JOptionPane.showMessageDialog(this, "Employee deleted successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Employee not found.");
            }
        }
    }
    private void viewAllEmp() {
        java.util.List<Employee> emp1 = mng.viewAllEmp();
        if (emp1.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No employees to display.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Employee employee : emp1) {
                sb.append(employee).append("\n");
            }
            JTextArea ta = new JTextArea(sb.toString());
            JScrollPane sp = new JScrollPane(ta);
            sp.setPreferredSize(new Dimension(380, 200));
            JOptionPane.showMessageDialog(this, sp, "All Employees", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                EmployeeManagementApp app = new EmployeeManagementApp();
                app.setVisible(true);
            }
        });
    }
}
