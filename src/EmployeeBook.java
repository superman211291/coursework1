import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EmployeeBook {
    //private Employee[] employees = new Employee[10];
    private Map<Integer, Employee> employees = new HashMap<>();
    private Integer count;

    private boolean checkEmployee(int id) {
        return employees.containsKey(id);
    }

    public void addEmployee(Employee employee) {
        if (checkEmployee(employee.hashCode())) {
            throw new IllegalArgumentException("Такой Сотрудник уже есть в базе!");
        }
        employees.put(employee.hashCode(), employee);
    }

    public void deleteEmployee(int id) {
        if (!checkEmployee(id)) {
            System.out.println("id сотрудника не найден!");
        } else {
            employees.remove(id);
        }

    }

    public void indexingSalary(int percent) {
        employees.forEach((integer, employee) -> employee.setSalary(employee.getSalary() + employee.getSalary() / 100 * percent));
    }

    public void printAll() {
        employees.forEach((integer, employee) -> System.out.println(employee.toString()));
        System.out.println();
    }

    public float getOurSalary() {
        float sum = 0.0f;
        for (Map.Entry<Integer, Employee> entry : employees.entrySet()) {
            sum += entry.getValue().getSalary();
        }
        return sum;
    }

    public Employee getEmployeeMinSalary() {
        Employee employeeResult = employees.values().iterator().next();
        float minSalary = employeeResult.getSalary();
        for (Map.Entry<Integer, Employee> entry : employees.entrySet()) {
            if (minSalary > entry.getValue().getSalary()) {
                employeeResult = employees.get(entry.getKey());
                minSalary = entry.getValue().getSalary();
            }
        }
        return employeeResult;
    }

    public Employee getEmployeeMaxSalary() {
        Employee employeeResult = employees.values().iterator().next();
        float maxSalary = employeeResult.getSalary();
        for (Map.Entry<Integer, Employee> entry : employees.entrySet()) {
            if (maxSalary < entry.getValue().getSalary()) {
                employeeResult = employees.get(entry.getKey());
                maxSalary = entry.getValue().getSalary();
            }
        }
        return employeeResult;
    }

    public float getAverageSalary() {
        return getOurSalary() / employees.size();
    }

    public void getFullNameAll() {
        employees.forEach((integer, employee) -> System.out.println(employee.getSurname() + " " + employee.getName() + " " + employee.getPatronymic()));
    }

    public int getDepartmentEmployeeMinSalary() {
        return getEmployeeMinSalary().getDepartment();
    }

    public int getDepartmentEmployeeMaxSalary() {
        return getEmployeeMaxSalary().getDepartment();
    }

    public float getDepartmentOurSalary(int department) {
        float sumDepartment = 0.0f;
        for (Map.Entry<Integer, Employee> entry : employees.entrySet()) {
            if (department == entry.getValue().getDepartment()) {
                sumDepartment += entry.getValue().getSalary();
            }
        }
        return sumDepartment;
    }

    public float getDepartmentAverageSalary(int department) {
        return getDepartmentOurSalary(department) / getCountDepartmentEmployee(department);
    }

    public void indexingDepartmentSalary(int department, int percent) {
        for (Map.Entry<Integer, Employee> entry : employees.entrySet()) {
            if (department == entry.getValue().getDepartment()) {
                entry.getValue().setSalary(entry.getValue().getSalary() + (entry.getValue().getSalary() / 100 * percent));
            }
        }
    }

    public void printDepartmentEmployee(int department) {
        for (Map.Entry<Integer, Employee> entry : employees.entrySet()) {
            if (department == entry.getValue().getDepartment()) {
                printEmployeeWithoutDepartment(entry.getValue());
            }
        }
    }


    public void getAllEmployeeLessSalary(float salary) {
        for (Map.Entry<Integer, Employee> entry : employees.entrySet()) {
            if (entry.getValue().getSalary() < salary) {
                printEmployeeWithoutDepartment(entry.getValue());
            }
        }
    }

    public void getAllEmployeeMoreSalary(float salary) {
        for (Map.Entry<Integer, Employee> entry : employees.entrySet()) {
            if (entry.getValue().getSalary() > salary) {
                printEmployeeWithoutDepartment(entry.getValue());
            }
        }
    }

    private Employee getEmployee(String name, String surname, String patronymic) {
        Employee employee = new Employee(name, surname, patronymic, 1, 1);
        employee = employees.get(employee.hashCode());
        if (employee == null) {
            throw new IllegalArgumentException("Такого сотрудника не существует");
        }
        return employee;
    }


    public static float getGeneratedSalary() {
        float leftLimit = 1;
        float rightLimit = 500_000f;
        return leftLimit + (new Random().nextFloat() * (rightLimit - leftLimit));
    }

    public int getCountDepartmentEmployee(int department) {
        int count = 0;
        for (Map.Entry<Integer, Employee> entry : employees.entrySet()) {
            if (entry.getValue().getDepartment() == department) {
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
        employees.forEach((integer, employee) -> System.out.println(employee.getDepartment() + " " + employee.getName() + " " + employee.getSurname() + " " + employee.getPatronymic()));

    }

    private void printEmployeeWithoutDepartment(Employee value) {
        System.out.println(value.getId() + " " + value.getName() + " " + value.getSurname() + " " + value.getPatronymic() + " " + value.getSalary());
    }
}
