public class Main {
    public static void main(String[] args) {
        Employee[] emploees = new Employee[10];
        emploees[0] = new Employee("Иванов Иван Иванович", 1, 15_000);
        emploees[1] = new Employee("Петров Петр Петрович", 1, 16_000);
        emploees[2] = new Employee("Сидоров Сидор Сидорович", 1, 17_000);

        printAllEmployees(emploees);
    }

    public static void printAllEmployees(Employee[] arr){
        for (final Employee empl : arr){
            if(empl != null){
                System.out.println(empl);
            }
        }
    }

}