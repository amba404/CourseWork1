import org.w3c.dom.ls.LSOutput;

public class Main {
    public static void main(String[] args) {

        int employeesCount = 10;
        EmployeeBook employeeBook = new EmployeeBook(employeesCount);

        employeeBook.addEmployee(new Employee("Иванов Иван Иванович", 1, 15_000));
        employeeBook.addEmployee(new Employee("Петров Петр Петрович", 2, 16_000));
        employeeBook.addEmployee(new Employee("Сидоров Сидор Сидорович", 1, 17_000));
        employeeBook.addEmployee(new Employee("Горбунков Семен Семенович", 4, 27_000));

        for (int i = 0; i < 10; i++) {
            if (!employeeBook.addEmployee(new Employee("Сотрудник " + i, i % 5 + 1, (i + 1) * 1_100))) {
                System.out.println("Нет свободных вакансий");
                break;
            }
        }
        System.out.println("employeeBook.getEmployeeCount() = " + employeeBook.getEmployeeCount());

        employeeBook.delEmployeeById(4);
        System.out.println("employeeBook.getEmployeeCount() = " + employeeBook.getEmployeeCount());

        System.out.println("employeeBook.getEmployeeById(2) = " + employeeBook.getEmployeeById(2));

        employeeBook.printAllEmployees();

        System.out.printf("Всего затрат на зарплату: %.2f\n", employeeBook.getAllSalary());
        System.out.printf("Сотрудник с минимальной зарплатой: %s\n", employeeBook.getEmployeeMinSalary());
        System.out.printf("Сотрудник с максимальной зарплатой: %s\n", employeeBook.getEmployeeMaxSalary());
        System.out.printf("Средняя зарплата: %.2f\n", employeeBook.getAvgSalary());

        employeeBook.printAllEmployeesFIO();

        employeeBook.changeSalaryByPercent(10.5);
        employeeBook.printAllEmployees();

        int dept = 1;
        System.out.printf("Сотрудник отдела %d с минимальной зарплатой: %s\n", dept, employeeBook.getEmployeeMinSalary(dept));
        System.out.printf("Сотрудник отдела %d с максимальной зарплатой: %s\n", dept, employeeBook.getEmployeeMaxSalary(dept));
        System.out.printf("Всего затрат на зарплату в отделе %d: %.2f\n", dept, employeeBook.getAllSalary(dept));
        System.out.printf("Средняя зарплата по отделу %d: %.2f\n", dept, employeeBook.getAvgSalary(dept));

        employeeBook.changeSalaryByPercent(.5, dept);
        employeeBook.printAllEmployees(dept);

        employeeBook.printAllEmployeesSalaryLessThan(18000);
        employeeBook.printAllEmployeesSalaryGreaterOrEqualThan(18000);

    }
}