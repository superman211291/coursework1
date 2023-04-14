public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();

        employeeBook.addEmployee(new Employee("Дмитрий", "Ершов", "Владимирович", 1, EmployeeBook.getGeneratedSalary()));
        employeeBook.addEmployee(new Employee("Артур", "Изотов", "Генадьевич", 2, EmployeeBook.getGeneratedSalary()));
        employeeBook.addEmployee(new Employee("Виктория", "Крылова", "Юрьевна", 1, EmployeeBook.getGeneratedSalary()));
        employeeBook.addEmployee(new Employee("Светлана", "Суркова", "Николаевна", 3, EmployeeBook.getGeneratedSalary()));
        employeeBook.addEmployee(new Employee("Григорий", "Карпов", "Германович", 5, EmployeeBook.getGeneratedSalary()));
        employeeBook.addEmployee(new Employee("Алексей", "Старостин", "Константинович", 4, EmployeeBook.getGeneratedSalary()));
        employeeBook.addEmployee(new Employee("Павел", "Емнельянов", "Аркадьевич", 2, EmployeeBook.getGeneratedSalary()));
        employeeBook.addEmployee(new Employee("Петр", "Степанов", "Максимович", 3, EmployeeBook.getGeneratedSalary()));
        employeeBook.addEmployee(new Employee("Никита", "Чернаков", "Александрович", 4, EmployeeBook.getGeneratedSalary()));
        employeeBook.addEmployee(new Employee("Илья", "Строев", "Павлович", 1, EmployeeBook.getGeneratedSalary()));
        System.out.println("task1");
        employeeBook.printAll();
        System.out.println("task2");
        System.out.println(employeeBook.getOurSalary());
        System.out.println("task3");
        System.out.println(employeeBook.getEmployeeMinSalary());
        System.out.println("task4");
        System.out.println(employeeBook.getEmployeeMaxSalary());
        System.out.println("task5");
        System.out.println(employeeBook.getAverageSalary());
        System.out.println("task6");
        employeeBook.getFullNameAll();
        System.out.println("MiddleDifficult");
        System.out.println("task1");
        employeeBook.indexingSalary(10);
        employeeBook.printAll();
        System.out.println("task2");
        System.out.println("departmentMinSalary - " + employeeBook.getDepartmentEmployeeMinSalary());
        System.out.println("departmentMaxSalary - " + employeeBook.getDepartmentEmployeeMaxSalary());
        System.out.println("departmentSumSalary 3 - " + employeeBook.getDepartmentOurSalary(3));
        System.out.println("departmentAverageSalary 3 - " + employeeBook.getDepartmentAverageSalary(3));
        employeeBook.indexingDepartmentSalary(3, 10);
        employeeBook.printDepartmentEmployee(3);
        System.out.println("task3");
        employeeBook.getAllEmployeeLessSalary(150_000.0f);
        System.out.println();
        employeeBook.getAllEmployeeMoreSalary(150_000.0f);
        System.out.println("HardDifficult");
        System.out.println("task4");
        employeeBook.printAll();
        employeeBook.deleteEmployee(5);
        employeeBook.printAll();
        //employeeBook.addEmployee(new Employee("Никита", "Чернаков", "Александрович", 4, EmployeeBook.getGeneratedSalary()));
        //employeeBook.printAll();
        System.out.println("task5");
        employeeBook.printAll();
        employeeBook.changeSalary("Илья", "Строев", "Павлович",135_000.0f);
        employeeBook.changeDepartment("Илья", "Строев", "Павлович", 3);
        employeeBook.printAll();
        System.out.println("task6");
        employeeBook.printAllDepartmentAndFullName();

    }


}