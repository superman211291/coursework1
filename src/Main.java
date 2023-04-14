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
        System.out.println("MiddleDifficult");
        System.out.println("task1");
        indexingSalary(employees, 10);
        getAll(employees);
        System.out.println("task2");
        System.out.println("departmentMinSalary - " + getDepartmentEmployeeMinSalary(employees));
        System.out.println("departmentMaxSalary - " + getDepartmentEmployeeMaxSalary(employees));
        System.out.println("departmentSumSalary 3 - " + getDepartmentOurSalary(employees, 3));
        System.out.println("departmentAverageSalary 3 - " + getDepartmentAverageSalary(employees, 3));
        indexingDepartmentSalary(employees, 3, 10);
        printDepartmentEmployee(employees, 3);
        System.out.println("task3");
        getAllEmployeeLessSalary(employees, 150_000.0f);
        System.out.println();
        getAllEmployeeMoreSalary(employees, 150_000.0f);
    }

    private static void indexingSalary(Employee[] employees, int percent) {
        for (Employee employee : employees) {
            employee.setSalary(employee.getSalary() + (employee.getSalary() / 100 * percent));
        }
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

    private static int getDepartmentEmployeeMinSalary(Employee[] employees) {
        return getEmployeeMinSalary(employees).getDepartment();
    }

    private static int getDepartmentEmployeeMaxSalary(Employee[] employees) {
        return getEmployeeMaxSalary(employees).getDepartment();
    }

    private static float getDepartmentOurSalary(Employee[] employees, int department) {
        float sumDepartment = 0.0f;
        for (Employee employee : employees) {
            if (department == employee.getDepartment()) {
                sumDepartment += employee.getSalary();
            }
        }
        return sumDepartment;
    }

    private static float getDepartmentAverageSalary(Employee[] employees, int department) {
        return getDepartmentOurSalary(employees, department) / getCountDepartmentEmployee(employees, department);
    }

    private static void indexingDepartmentSalary(Employee[] employees, int department, int percent) {
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                employee.setSalary(employee.getSalary() + (employee.getSalary() / 100 * percent));
            }
        }
    }

    private static void printDepartmentEmployee(Employee[] employees, int department) {
        for (Employee employee : employees) {
            if (department == employee.getDepartment()) {
                printEmployeeWithoutDepartment(employee);
            }
        }
    }

    private static void printEmployeeWithoutDepartment(Employee employee) {
        System.out.println(employee.getId() + " " +
                employee.getName() + " " +
                employee.getSurname() + " " +
                employee.getPatronymic() + " " +
                employee.getSalary()
        );
    }

    private static void getAllEmployeeLessSalary(Employee[] employees, float salary) {
        for (Employee employee : employees) {
            if (employee.getSalary() < salary) {
                printEmployeeWithoutDepartment(employee);
            }
        }
    }

    private static void getAllEmployeeMoreSalary(Employee[] employees, float salary) {
        for (Employee employee : employees) {
            if (employee.getSalary() > salary) {
                printEmployeeWithoutDepartment(employee);
            }
        }
    }


    private static float getGeneratedSalary() {
        float leftLimit = 1;
        float rightLimit = 500_000f;
        return leftLimit + (new Random().nextFloat() * (rightLimit - leftLimit));
    }

    private static int getCountDepartmentEmployee(Employee[] employees, int department) {
        int count = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                count++;
            }
        }
        return count;
    }
}