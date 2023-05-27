import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
    private String employeeID;
    private String name;
    private double basic;
    private double hra;
    private double lta;
    private double pf;
    private double sodexo;
    private double specialAllowance;
    private double vpf;
    private double totalSalary;

    public Employee(String employeeID, String name, double basic, double hra, double lta, double pf, double sodexo, double specialAllowance, double vpf) {
        this.employeeID = employeeID;
        this.name = name;
        this.basic = basic;
        this.hra = hra;
        this.lta = lta;
        this.pf = pf;
        this.sodexo = sodexo;
        this.specialAllowance = specialAllowance;
        this.vpf = vpf;
        this.totalSalary = basic + hra + lta + sodexo + specialAllowance - pf;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getName() {
        return name;
    }

    public double getBasic() {
        return basic;
    }

    public void setBasic(double basic) {
        this.basic = basic;
    }

    public double getHra() {
        return hra;
    }

    public void setHra(double hra) {
        this.hra = hra;
    }

    public double getLta() {
        return lta;
    }

    public void setLta(double lta) {
        this.lta = lta;
    }

    public double getPf() {
        return pf;
    }

    public void setPf(double pf) {
        this.pf = pf;
    }

    public double getSodexo() {
        return sodexo;
    }

    public void setSodexo(double sodexo) {
        this.sodexo = sodexo;
    }

    public double getSpecialAllowance() {
        return specialAllowance;
    }

    public void setSpecialAllowance(double specialAllowance) {
        this.specialAllowance = specialAllowance;
    }

    public double getVpf() {
        return vpf;
    }

    public void setVpf(double vpf) {
        this.vpf = vpf;
    }

    public double getTotalSalary() {
        return totalSalary;
    }
}

class HRSystem {
    private List<Employee> employees;

    public HRSystem() {
        this.employees = new ArrayList<>();
        // Initialize with some sample data
        employees.add(new Employee("EMP001", "John Doe", 100000, 47500, 23750, 1800, 2200, 14750, 0));
        employees.add(new Employee("EMP002", "Jane Smith", 120000, 57000, 28500, 21600, 26400, 57000, 0));
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("******Welcome to ESS*******");
            System.out.println("1. Admin login");
            System.out.println("2. Employee login");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    adminLogin();
                    break;
                case 2:
                    employeeLogin();
                    break;
                case 0:
                    System.out.println("Thank you for using ESS. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private void adminLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter login ID: ");
        String loginID = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        if (loginID.equals("Admin") && isValidPassword(password)) {
            System.out.println("Login successful.");
            adminMenu();
        } else {
            System.out.println("Invalid login credentials.");
        }
    }

    private boolean isValidPassword(String password) {
        // Validate password requirements
        if (password.length() < 5 || password.length() > 10) {
            return false;
        }
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasSpecialChar = false;
        boolean hasDigit = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (isSpecialCharacter(c)) {
                hasSpecialChar = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }
        return hasUppercase && hasLowercase && hasSpecialChar && hasDigit;
    }

    private boolean isSpecialCharacter(char c) {
        return c == '@' || c == '#' || c == '&' || c == '%' || c == '*' || c == '!';
    }

    private void adminMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("******Admin Menu*******");
            System.out.println("1. Add employee details");
            System.out.println("2. Update record");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addEmployeeDetails();
                    break;
                case 2:
                    updateRecord();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private void addEmployeeDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee ID: ");
        String employeeID = scanner.nextLine();
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter basic salary: ");
        double basic = scanner.nextDouble();
        System.out.print("Enter HRA: ");
        double hra = scanner.nextDouble();
        System.out.print("Enter LTA: ");
        double lta = scanner.nextDouble();
        System.out.print("Enter PF: ");
        double pf = scanner.nextDouble();
        System.out.print("Enter Sodexo: ");
        double sodexo = scanner.nextDouble();
        System.out.print("Enter special allowance: ");
        double specialAllowance = scanner.nextDouble();
        System.out.print("Enter VPF: ");
        double vpf = scanner.nextDouble();

        Employee employee = new Employee(employeeID, name, basic, hra, lta, pf, sodexo, specialAllowance, vpf);
        employees.add(employee);
        System.out.println("Employee details added successfully.");
    }

    private void updateRecord() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new basic percentage (e.g., 50 for 50%): ");
        double newBasicPercentage = scanner.nextDouble();
        for (Employee employee : employees) {
            double newBasic = employee.getTotalSalary() * (newBasicPercentage / 100);
            double newHra = newBasic * 0.5;
            double newSpecialAllowance = employee.getTotalSalary() - (newHra + employee.getLta() + employee.getPf() + employee.getSodexo());
            employee.setBasic(newBasic);
            employee.setHra(newHra);
            employee.setSpecialAllowance(newSpecialAllowance);
        }
        System.out.println("Record updated successfully.");
    }

    private void employeeLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee ID: ");
        String employeeID = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        Employee employee = findEmployeeByID(employeeID);
//        if (employee != null && employee.getPassword().equals(password)) {
//            System.out.println("Login successful.");
//            employeeMenu(employee);
//        } else {
//            System.out.println("Invalid login credentials.");
//        }
    }

    private Employee findEmployeeByID(String employeeID) {
        for (Employee employee : employees) {
            if (employee.getEmployeeID().equals(employeeID)) {
                return employee;
            }
        }
        return null;
    }

    private void employeeMenu(Employee employee) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("******Employee Menu*******");
            System.out.println("1. My current CTC");
            System.out.println("2. Modify details");
            System.out.println("3. Calculate salary");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    displayCurrentCTC(employee);
                    break;
                case 2:
                    modifyDetails(employee);
                    break;
                case 3:
                    calculateSalary(employee);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private void displayCurrentCTC(Employee employee) {
        System.out.println("******Current CTC*******");
        System.out.println("Total\tBasic\tHRA\tLTA\tSODEXO\tPF\tSpecial Allowance\tVPF");
        System.out.println("Monthly\t" + employee.getTotalSalary() + "\t" + employee.getBasic() + "\t" + employee.getHra() +
                "\t" + employee.getLta() + "\t" + employee.getSodexo() + "\t" + employee.getPf() + "\t" +
                employee.getSpecialAllowance() + "\t" + employee.getVpf());
        System.out.println("Fixed\t" + (employee.getTotalSalary() * 12) + "\t" + (employee.getBasic() * 12) +
                "\t" + (employee.getHra() * 12) + "\t" + (employee.getLta() * 12) + "\t" +
                (employee.getSodexo() * 12) + "\t" + (employee.getPf() * 12) + "\t" +
                (employee.getSpecialAllowance() * 12) + "\t" + (employee.getVpf() * 12));
    }

    private void modifyDetails(Employee employee) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("******Modify Details*******");
        System.out.println("1. VPF");
        System.out.println("2. Sodexo");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.print("Enter new VPF percentage (e.g., 5 for 5%): ");
                double newVPFPercentage = scanner.nextDouble();
                double newVPF = employee.getBasic() * (newVPFPercentage / 100);
                double newSpecialAllowance = employee.getTotalSalary() - (employee.getHra() + employee.getLta() +
                        employee.getPf() + employee.getSodexo());
                employee.setVpf(newVPF);
                employee.setSpecialAllowance(newSpecialAllowance);
                System.out.println("Details modified successfully.");
                break;
            case 2:
                System.out.print("Opt IN or Opt OUT (1 for Opt IN, 2 for Opt OUT): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    employee.setSodexo(2200);
                    employee.setSpecialAllowance(employee.getSpecialAllowance() - 2200);
                } else if (option == 2) {
                    employee.setSodexo(0);
                    employee.setSpecialAllowance(employee.getSpecialAllowance() + 2200);
                } else {
                    System.out.println("Invalid choice.");
                    return;
                }
                System.out.println("Details modified successfully.");
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private void calculateSalary(Employee employee) {
        double inHandSalary;
        System.out.println("******Calculate Salary*******");
        System.out.println("1. Scenario 1: 0 VPF, 0 Sodexo");
        System.out.println("2. Scenario 2: some % VPF, 0 Sodexo");
        System.out.println("3. Scenario 3: some % VPF, 2200 Sodexo");
        System.out.println("4. Scenario 4: 0 VPF, 2200 Sodexo");
        System.out.print("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                inHandSalary = employee.getTotalSalary();
                break;
            case 2:
                System.out.print("Enter VPF percentage (e.g., 5 for 5%): ");
                double vpfPercentage = scanner.nextDouble();
                double vpfAmount = employee.getBasic() * (vpfPercentage / 100);
                inHandSalary = employee.getTotalSalary() - vpfAmount;
                break;
            case 3:
                System.out.print("Enter VPF percentage (e.g., 5 for 5%): ");
                double vpfPercentage1 = scanner.nextDouble();
                double vpfAmount1 = employee.getBasic() * (vpfPercentage1 / 100);
                inHandSalary = employee.getTotalSalary() - vpfAmount1 + 2200;
                break;
            case 4:
                inHandSalary = employee.getTotalSalary() + 2200;
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }
        System.out.println("Monthly In Hand Salary: " + inHandSalary);
    }
}

public class Main {
    public static void main(String[] args) {
        HRSystem hrSystem = new HRSystem();
        hrSystem.login();
    }
}
