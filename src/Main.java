public class Main {
    public static void main(String[] args) {

        int employeesCount = 10;
        EmployeeBook employeeBook = new EmployeeBook(employeesCount);
        System.out.printf("Создан объект EmployeeBook. Максимальное количество сотрудников: %d, в списке %d сотрудников\n",
                employeesCount, employeeBook.getEmployeeCount());
        System.out.println();

        employeeBook.addEmployee(new Employee("Иванов Иван Иванович", 1, 15_000));
        employeeBook.addEmployee(new Employee("Петров Петр Петрович", 2, 16_000));
        employeeBook.addEmployee(new Employee("Сидоров Сидор Сидорович", 1, 17_000));
        employeeBook.addEmployee(new Employee("Горбунков Семен Семенович", 4, 27_000));
        System.out.println("Добавлено сотрудников (новыми объектами Employee): " + employeeBook.getEmployeeCount());
        System.out.println();

        System.out.print("Проверка на переполнение вакансий...\n...");
        for (int i = 0; i < employeesCount; i++) {
            Employee employee = new Employee("Сотрудник " + i, i % 5 + 1, (i + 1) * 1_100);
            if (employeeBook.addEmployee(employee)) {
                System.out.printf("id(%d)=ok, ", employee.getId());
            } else {
                System.out.printf("id(%d) - Нет свободных вакансий\n", employee.getId());
                break;
            }
        }
        System.out.println("Всего сотрудников: " + employeeBook.getEmployeeCount());
        System.out.println();

        System.out.println("Удалим сотрудника с id=5...");
        employeeBook.delEmployeeById(5);
        System.out.println("...осталось сотрудников: " + employeeBook.getEmployeeCount());
        System.out.println();

        System.out.println("Добавим сотрудника прямым указанием полей...");
        employeeBook.addEmployee("Руководитель Отдела 1", 1, 40_000);
        System.out.println("...теперь сотрудников: " + employeeBook.getEmployeeCount());
        System.out.println();

        employeeBook.printAllEmployees();
        System.out.println();

        System.out.printf("Всего затрат на зарплату: %.2f\n", employeeBook.getAllSalary());
        System.out.printf("Сотрудник с минимальной зарплатой: %s\n", employeeBook.getEmployeeMinSalary());
        System.out.printf("Сотрудник с максимальной зарплатой: %s\n", employeeBook.getEmployeeMaxSalary());
        System.out.printf("Средняя зарплата: %.2f\n", employeeBook.getAvgSalary());
        System.out.println();

        System.out.println("ФИО сотрудников:");
        employeeBook.printAllEmployeesFIO();
        System.out.println();

        double changeSalaryPercent = 10.5;
        System.out.printf("Увеличим зарплату всем сторудникам на %.2f%% и проверим результат\n", changeSalaryPercent);
        employeeBook.changeSalaryByPercent(changeSalaryPercent);
        employeeBook.printAllEmployees();
        System.out.println();

        int dept = 1;
        System.out.println("______________________");
        System.out.println("  Работа с отделом " + dept);
        System.out.println("----------------------");
        System.out.printf("Сотрудник отдела %d с минимальной зарплатой: %s\n", dept, employeeBook.getEmployeeMinSalary(dept));
        System.out.printf("Сотрудник отдела %d с максимальной зарплатой: %s\n", dept, employeeBook.getEmployeeMaxSalary(dept));
        System.out.printf("Всего затрат на зарплату в отделе %d: %.2f\n", dept, employeeBook.getAllSalary(dept));
        System.out.printf("Средняя зарплата по отделу %d: %.2f\n", dept, employeeBook.getAvgSalary(dept));
        System.out.println();

        changeSalaryPercent = -0.5;
        System.out.printf("Изменим зарплату сторудникам отдела %d на %.2f%% и проверим результат\n", dept, changeSalaryPercent);
        employeeBook.changeSalaryByPercent(changeSalaryPercent, dept);
        employeeBook.printAllEmployees(dept);
        System.out.println("______________________");
        System.out.println();

        double avgSalary = employeeBook.getAvgSalary();
        employeeBook.printAllEmployeesSalaryLessThan(avgSalary);
        employeeBook.printAllEmployeesSalaryGreaterOrEqualThan(avgSalary);
        System.out.println();

        System.out.println("Данные сотрудника с id=2: " + employeeBook.getEmployeeById(2));
        System.out.println();

//        employeeBook.delEmployeeById(6);
        System.out.println("employeeBook.getAvgSalary() = " + employeeBook.getAvgSalary());
        System.out.println("employeeBook.getMedianSalary() = " + employeeBook.getMedianSalary());

    }
}