import java.util.Arrays;

public class EmployeeBook {
    private Employee[] employees;

    private boolean isEmployeeNeed(Employee employee, int department) {
        return employee != null && (department < 0 || employee.getDepartment() == department);
    }

    public EmployeeBook(int employeesCount) {
        this.employees = new Employee[employeesCount];
    }

    public boolean addEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                return true;
            }
        }
        return false;
    }

    public boolean addEmployee(String fullName, int department, double salary) {
        Employee employee = new Employee(fullName, department, salary);
        return addEmployee(employee);
    }

    public void delEmployeeById(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                employees[i] = null;
                break;
            }
        }
    }

    public Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) return employee;
        }
        return null;
    }

    public Employee[] getEmployees(int department) {
        int cntr = getEmployeeCount(department);
        Employee[] massEmpl = new Employee[cntr];
        cntr = 0;
        for (final Employee empl : employees) {
            if (isEmployeeNeed(empl, department)) {
                massEmpl[cntr++] = empl;
            }
        }
        return massEmpl;
    }

    public Employee[] getEmployees() {
        return getEmployees(-1);
    }

    public void printAllEmployees(int department) {
        Employee[] massEmpl = getEmployees(department);
        System.out.printf("Список сотрудников отдела %d (всего %d):\n", department, massEmpl.length);
        for (final Employee empl : massEmpl) {
            System.out.println(getEmployeeFormatted(empl));
        }
    }

    public void printAllEmployees() {
        Employee[] massEmpl = getEmployees();
        System.out.printf("Список сотрудников (всего %d):\n", massEmpl.length);
        for (final Employee empl : employees) {
            System.out.println(empl);
        }
    }


    public void printAllEmployeesFIO(int department) {
        Employee[] massEmpl = getEmployees(department);
        for (final Employee empl : massEmpl) {
            System.out.println(empl.getFullName());
        }
    }

    public void printAllEmployeesFIO() {
        printAllEmployeesFIO(-1);
    }

    public double getAllSalary(int department) {
        double sum = 0;
        for (final Employee empl : employees) {
            if (isEmployeeNeed(empl, department)) {
                sum += empl.getSalary();
            }
        }
        return sum;
    }

    public double getAllSalary() {
        return getAllSalary(-1);
    }

    public Employee getEmployeeMinSalary(int department) {
        double minSalary = 2_000_000_000;
        Employee ret = null;
        for (final Employee empl : employees) {
            if (isEmployeeNeed(empl, department) && minSalary > empl.getSalary()) {
                minSalary = empl.getSalary();
                ret = empl;
            }
        }
        return ret;
    }

    public Employee getEmployeeMinSalary() {
        return getEmployeeMinSalary(-1);
    }


    public Employee getEmployeeMaxSalary() {
        return getEmployeeMaxSalary(-1);
    }

    public Employee getEmployeeMaxSalary(int department) {
        double maxSalary = 0;
        Employee ret = null;
        for (final Employee empl : employees) {
            if (isEmployeeNeed(empl, department)
                    && maxSalary < empl.getSalary()) {
                maxSalary = empl.getSalary();
                ret = empl;
            }
        }
        return ret;
    }

    public int getEmployeeCount(int department) {
        int cnt = 0;
        for (final Employee empl : employees) {
            if (isEmployeeNeed(empl, department)) cnt++;
        }
        return cnt;
    }

    public int getEmployeeCount() {
        return getEmployeeCount(-1);
    }


    public double getAvgSalary(int department) {
        double sum = getAllSalary(department);
        int len = getEmployeeCount(department);
        return (double) Math.round(sum / len * 100) / 100;
    }

    public double getAvgSalary() {
        return getAvgSalary(-1);
    }

    public void changeSalaryByPercent(double changePercent, int department) {
        for (final Employee empl : employees) {
            if (isEmployeeNeed(empl, department)) empl.setSalary(empl.getSalary() * (100 + changePercent) / 100);
        }
    }

    public void changeSalaryByPercent(double changePercent) {
        changeSalaryByPercent(changePercent, -1);
    }

    private String getEmployeeFormatted(Employee empl) {
        return String.format("id=%d, fullName='%s', salary=%.2f", empl.getId(), empl.getFullName(), empl.getSalary());
    }

    public void printAllEmployeesSalaryLessThan(double salary) {
        System.out.printf("Сотрудники с зарплатой меньше %.2f:\n", salary);
        for (final Employee empl : employees) {
            if (empl != null && empl.getSalary() < salary) {
                System.out.println(getEmployeeFormatted(empl));
            }
        }
    }

    public void printAllEmployeesSalaryGreaterOrEqualThan(double salary) {
        System.out.printf("Сотрудники с зарплатой не меньше %.2f:\n", salary);
        for (final Employee empl : employees) {
            if (empl != null && empl.getSalary() >= salary) {
                System.out.println(getEmployeeFormatted(empl));
            }
        }
    }

    public double getMedianSalary(int department) {
        double ret = 0;

        int len = getEmployeeCount(department);
        if (len == 0) return 0;

        double[] salaries = new double[len];
        int cntr = 0;
        for (Employee employee : employees) {
            if (isEmployeeNeed(employee, department)) {
                salaries[cntr++] = employee.getSalary();
            }
        }

        Arrays.sort(salaries);

        ret = switch (len % 2) {
            case 0 -> (double) Math.round((salaries[len / 2 - 1] + salaries[len / 2]) / 2 * 100) / 100;
            case 1 -> salaries[len / 2];
            default -> ret;
        };

        return ret;
    }

    public double getMedianSalary() {
        return getMedianSalary(-1);
    }

}
