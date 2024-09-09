public class Main {
    public static void main(String[] args) {
        Employee[] emploees = new Employee[10];
        emploees[0] = new Employee("Иванов Иван Иванович", 1, 150_000f);
        emploees[1] = new Employee("Петров Петр Петрович", 2, 160_000f);
        emploees[2] = new Employee("Сидоров Сидор Сидорович", 1, 170_000f);

        printAllEmployees(emploees);
        System.out.printf("Всего затрат на зарплату: %.2f\n", getAllSalary(emploees));
        System.out.printf("Сотрудник с минимальной зарплатой: %s\n", getEmployeeMinSalary(emploees));
        System.out.printf("Сотрудник с максимальной зарплатой: %s\n", getEmployeeMaxSalary(emploees));
    }

    public static void printAllEmployees(Employee[] arr) {
        for (final Employee empl : arr) {
            if (empl != null) {
                System.out.println(empl);
            }
        }
    }

    public static float getAllSalary(Employee[] arr) {
        float sum = 0;
        for (final Employee empl : arr) {
            if (empl != null) {
                sum += empl.getSalary();
            }
        }
        return sum;
    }

    public static Employee getEmployeeMinSalary(Employee[] arr) {
        float minSalary = 2_000_000_000;
        Employee ret = null;
        for (final Employee empl : arr) {
            if (empl != null && minSalary > empl.getSalary()) {
                minSalary = empl.getSalary();
                ret = empl;
            }
        }
        return ret;
    }

    public static Employee getEmployeeMaxSalary(Employee[] arr) {
        float maxSalary = 0;
        Employee ret = null;
        for (final Employee empl : arr) {
            if (empl != null && maxSalary < empl.getSalary()) {
                maxSalary = empl.getSalary();
                ret = empl;
            }
        }
        return ret;
    }
}