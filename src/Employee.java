import java.util.Objects;

public class Employee {
    private static int nextId = 0;

    final private int id;
    final private String fullName;
    private int department;
    private double salary;

    final private int minDepNumber = 1;
    final private int maxDepNumber = 5;


    public Employee(String fullName, int department, double salary) {
        if (fullName == null || fullName.trim().isEmpty()) throw new IllegalArgumentException("Не указаны ФИО");
        this.fullName = fullName.trim();
        this.setDepartment(department);
        this.setSalary(salary);
        this.id = getNextId();
    }

    private static int getNextId() {
        nextId++;
        return nextId;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        if (department >= minDepNumber && department <= maxDepNumber) {
            this.department = department;
        } else {
            throw new IllegalArgumentException("Недопустимый номер отдела");
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Значение зарплаты меньше нуля");
        }
        this.salary = (double) Math.round(salary * 100) / 100;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(fullName, employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName);
    }

    @Override
    public String toString() {
        return String.format("department=%d, id=%d, fullName='%s', salary=%.2f", department, id, fullName, salary);
    }
}
