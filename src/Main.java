import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        employees[0] = new Employee("Дмитрий", "Ершов", "Владимирович", 1, getGeneratedSalary());
        employees[1] = new Employee("Артур", "Изотов", "Генадьевич", 2, getGeneratedSalary());
        employees[2] = new Employee("Виктория", "Крылова", "Юрьевна", 1, getGeneratedSalary());
        employees[3] = new Employee("Светлана", "Суркова", "Николаевна", 3, getGeneratedSalary());
        employees[4] = new Employee("Григорий", "Карпов", "Германович", 5, getGeneratedSalary());
        employees[5] = new Employee("Алексей", "Старостин", "Константинович", 4, getGeneratedSalary());
        employees[6] = new Employee("Павел", "Емнельянов", "Аркадьевич", 2, getGeneratedSalary());
        employees[7] = new Employee("Петр", "Степанов", "Максимович", 3, getGeneratedSalary());
        employees[8] = new Employee("Никита", "Чернаков", "Александрович", 4, getGeneratedSalary());
        employees[9] = new Employee("Илья", "Строев", "Павлович", 1, getGeneratedSalary());
        System.out.println("task1");
        getAll(employees);
        System.out.println("task2");
        System.out.println(getOurSalary(employees));
        System.out.println("task3");
        System.out.println(getEmployeeMinSalary(employees));
        System.out.println("task4");
        System.out.println(getEmployeeMaxSalary(employees));
        System.out.println("task5");
        System.out.println(getAverageSalary(employees));
        System.out.println("task6");
        getFullNameAll(employees);
    }

    private static void getAll(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private static float getOurSalary(Employee[] employees) {
        float sum = 0.0f;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum;
    }

    private static Employee getEmployeeMinSalary(Employee[] employees) {
        Employee employeeResult = employees[0];
        float minSalary = employees[0].getSalary();
        for (Employee employee : employees) {
            if (minSalary > employee.getSalary()) {
                employeeResult = employee;
                minSalary = employee.getSalary();
            }
        }
        return employeeResult;
    }

    private static Employee getEmployeeMaxSalary(Employee[] employees) {
        Employee employeeResult = employees[0];
        float maxSalary = employees[0].getSalary();
        for (Employee employee : employees) {
            if (maxSalary < employee.getSalary()) {
                employeeResult = employee;
                maxSalary = employee.getSalary();
            }
        }
        return employeeResult;
    }

    private static float getAverageSalary(Employee[] employees) {
        return getOurSalary(employees) / employees.length;
    }

    private static void getFullNameAll(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println(employee.getSurname() + " " + employee.getName() + " " + employee.getPatronymic());
        }
    }

    private static float getGeneratedSalary() {
        float leftLimit = 1;
        float rightLimit = 500_000f;
        return leftLimit + (new Random().nextFloat() * (rightLimit - leftLimit));
    }
}