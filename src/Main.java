public class Main {
    public static void main(String[] args) {
        // 1
        Employee[] employees = new Employee[10];
        employees[0] = new Employee("Иванов Иван Иванович", 1, 15_000);
        employees[1] = new Employee("Петров Петр Петрович", 2, 16_000);
        employees[2] = new Employee("Сидоров Сидор Сидорович", 1, 17_000);
//        employees[3] = new Employee("", 1, 170_000);

        printAllEmployees(employees);
        System.out.printf("Всего затрат на зарплату: %.2f\n", getAllSalary(employees));
        System.out.printf("Сотрудник с минимальной зарплатой: %s\n", getEmployeeMinSalary(employees));
        System.out.printf("Сотрудник с максимальной зарплатой: %s\n", getEmployeeMaxSalary(employees));
        System.out.printf("Средняя зарплата: %.2f\n", getAvgSalary(employees));
        printAllEmployeesFIO(employees);

        // 2
        changeSalaryByPercent(employees, 10.5);
        printAllEmployees(employees);

        int dept = 1;
        System.out.printf("Сотрудник отдела %d с минимальной зарплатой: %s\n", dept, getEmployeeMinSalary(employees, dept));
        System.out.printf("Сотрудник отдела %d с максимальной зарплатой: %s\n", dept, getEmployeeMaxSalary(employees, dept));
        System.out.printf("Всего затрат на зарплату в отделе %d: %.2f\n", dept, getAllSalary(employees));
        System.out.printf("Средняя зарплата по отделу %d: %.2f\n", dept, getAvgSalary(employees));
        changeSalaryByPercent(employees, .5, dept);
        printAllEmployees(employees, dept);


    }

    private static boolean isEmployeeNeed(Employee employee, int department) {
        return employee != null && (department < 0 || employee.getDepartment() == department);
    }

    public static void printAllEmployees(Employee[] arr, int department) {
        System.out.printf("Список сотрудников отдела %d (всего %d):\n", department, getEmployeeCount(arr, department));
        for (final Employee empl : arr) {
            if (isEmployeeNeed(empl, department)) {
                System.out.printf("id=%d, fullName='%s', salary=%.2f\n", empl.getId(), empl.getFullName(), empl.getSalary());
            }
        }
    }

    public static void printAllEmployees(Employee[] arr) {
        System.out.printf("Список сотрудников (всего %d):\n", getEmployeeCount(arr));
        for (final Employee empl : arr) {
            if (empl != null) {
                System.out.println(empl);
            }
        }
    }


    public static void printAllEmployeesFIO(Employee[] arr, int department) {
        for (final Employee empl : arr) {
            if (isEmployeeNeed(empl, department)) {
                System.out.println(empl.getFullName());
            }
        }
    }

    public static void printAllEmployeesFIO(Employee[] arr) {
        printAllEmployeesFIO(arr, -1);
    }

    public static double getAllSalary(Employee[] arr, int department) {
        double sum = 0;
        for (final Employee empl : arr) {
            if (isEmployeeNeed(empl, department)) {
                sum += empl.getSalary();
            }
        }
        return sum;
    }

    public static double getAllSalary(Employee[] arr) {
        return getAllSalary(arr, -1);
    }

    public static Employee getEmployeeMinSalary(Employee[] arr, int department) {
        double minSalary = 2_000_000_000;
        Employee ret = null;
        for (final Employee empl : arr) {
            if (isEmployeeNeed(empl, department) && minSalary > empl.getSalary()) {
                minSalary = empl.getSalary();
                ret = empl;
            }
        }
        return ret;
    }

    public static Employee getEmployeeMinSalary(Employee[] arr) {
        return getEmployeeMinSalary(arr, -1);
    }


    public static Employee getEmployeeMaxSalary(Employee[] arr) {
        return getEmployeeMaxSalary(arr, -1);
    }

    public static Employee getEmployeeMaxSalary(Employee[] arr, int department) {
        double maxSalary = 0;
        Employee ret = null;
        for (final Employee empl : arr) {
            if (isEmployeeNeed(empl, department)
                    && maxSalary < empl.getSalary()) {
                maxSalary = empl.getSalary();
                ret = empl;
            }
        }
        return ret;
    }

    public static int getEmployeeCount(Employee[] arr, int department) {
        int cnt = 0;
        for (final Employee empl : arr) {
            if (isEmployeeNeed(empl, department)) cnt++;
        }
        return cnt;
    }

    public static int getEmployeeCount(Employee[] arr) {
        return getEmployeeCount(arr, -1);
    }


    public static double getAvgSalary(Employee[] arr, int department) {
        double sum = getAllSalary(arr, department);
        int len = getEmployeeCount(arr, department);
        return (double) (Math.round(sum / len * 100) / 100);
    }

    public static double getAvgSalary(Employee[] arr) {
        return getAvgSalary(arr, -1);
    }

    public static void changeSalaryByPercent(Employee[] arr, double changePercent, int department) {
        for (final Employee empl : arr) {
            if (isEmployeeNeed(empl, department)) empl.setSalary(empl.getSalary() * (100 + changePercent) / 100);
        }
    }

    public  static void changeSalaryByPercent(Employee[] arr, double changePercent) {
        changeSalaryByPercent(arr, changePercent, -1);
    }


}