import java.util.Random;

public class EmployeeBook {
    private Employee[] employees = new Employee[10];
    private int count;

    public void addEmployee(Employee employee) {
        for (int i = 0; i < count; i++) {
            if (employees[i].equals(employee)) {
                throw new IllegalArgumentException("Такой Сотрудник уже есть в базе!");
            }
        }
        employees[count] = employee;
        count++;
    }

    public void deleteEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                for (int j = i; j < employees.length - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[employees.length - 1] = null;
                count--;
                return;
            }
        }
        System.out.println("id сотрудника не найден!");
    }

    public void indexingSalary(int percent) {
        for (Employee employee : employees) {
            employee.setSalary(employee.getSalary() + (employee.getSalary() / 100 * percent));
        }
    }

    public void printAll() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
        System.out.println();
    }

    public float getOurSalary() {
        float sum = 0.0f;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum;
    }

    public Employee getEmployeeMinSalary() {
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

    public Employee getEmployeeMaxSalary() {
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

    public float getAverageSalary() {
        return getOurSalary() / employees.length;
    }

    public void getFullNameAll() {
        for (Employee employee : employees) {
            System.out.println(employee.getSurname() + " " + employee.getName() + " " + employee.getPatronymic());
        }
    }

    public int getDepartmentEmployeeMinSalary() {
        return getEmployeeMinSalary().getDepartment();
    }

    public int getDepartmentEmployeeMaxSalary() {
        return getEmployeeMaxSalary().getDepartment();
    }

    public float getDepartmentOurSalary(int department) {
        float sumDepartment = 0.0f;
        for (Employee employee : employees) {
            if (department == employee.getDepartment()) {
                sumDepartment += employee.getSalary();
            }
        }
        return sumDepartment;
    }

    public float getDepartmentAverageSalary(int department) {
        return getDepartmentOurSalary(department) / getCountDepartmentEmployee(department);
    }

    public void indexingDepartmentSalary(int department, int percent) {
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                employee.setSalary(employee.getSalary() + (employee.getSalary() / 100 * percent));
            }
        }
    }

    public void printDepartmentEmployee(int department) {
        for (Employee employee : employees) {
            if (department == employee.getDepartment()) {
                printEmployeeWithoutDepartment(employee);
            }
        }
    }

    public void printEmployeeWithoutDepartment(Employee employee) {
        System.out.println(employee.getId() + " " +
                employee.getName() + " " +
                employee.getSurname() + " " +
                employee.getPatronymic() + " " +
                employee.getSalary()
        );
    }

    public void getAllEmployeeLessSalary(float salary) {
        for (Employee employee : employees) {
            if (employee.getSalary() < salary) {
                printEmployeeWithoutDepartment(employee);
            }
        }
    }

    public void getAllEmployeeMoreSalary(float salary) {
        for (Employee employee : employees) {
            if (employee.getSalary() > salary) {
                printEmployeeWithoutDepartment(employee);
            }
        }
    }

    private Employee getEmployee(String name, String surname, String patronymic) {
        Employee employee = null;
        for (int i = 0; i < count; i++) {
            if (new Employee(name, surname, patronymic, 1, 0.0f).equals(employees[i])) {
                employee = employees[i];
                return employee;
            }
        }
        throw new IllegalArgumentException("Такого сотрудника не существует");
    }


    public static float getGeneratedSalary() {
        float leftLimit = 1;
        float rightLimit = 500_000f;
        return leftLimit + (new Random().nextFloat() * (rightLimit - leftLimit));
    }

    public int getCountDepartmentEmployee(int department) {
        int count = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                count++;
            }
        }
        return count;
    }

    public void changeSalary(String name, String surname, String patronymic, float newSalary) {
        getEmployee(name, surname, patronymic).setSalary(newSalary);
    }

    public void changeDepartment(String name, String surname, String patronymic, int department) {
        getEmployee(name, surname, patronymic).setDepartment(department);
    }

    public void printAllDepartmentAndFullName() {
        for (int i = 0; i < count; i++) {
            System.out.println( employees[i].getDepartment() + " " +
                                employees[i].getName() + " " +
                                employees[i].getSurname() + " " +
                                employees[i].getPatronymic());
        }
    }
}
