import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
    private String employeeId;
    private String name;
    private double basic;
    private double hra;
    private double lta;
    private double pf;
    private double sodexo;
    private double specialAllowance;
    private double vpf;
    private double totalSalary;

    public Employee(String employeeId, String name, double basic, double hra, double lta, double pf,
                    double sodexo, double specialAllowance, double vpf, double totalSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.basic = basic;
        this.hra = hra;
        this.lta = lta;
        this.pf = pf;
        this.sodexo = sodexo;
        this.specialAllowance = specialAllowance;
        this.vpf = vpf;
        this.totalSalary = totalSalary;
    }

    public String getEmployeeId() {
        return employeeId;
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

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }

    public String toCsvString() {
        return employeeId + "," + name + "," + basic + "," + hra + "," + lta + "," +
                pf + "," + sodexo + "," + specialAllowance + "," + vpf + "," + totalSalary;
    }
}

class HRSystem {
    private List<Employee> employees;

    public HRSystem() {
        employees = new ArrayList<>();
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("******Welcome to ESS*******");
            System.out.println("1. Admin login");
            System.out.println("2. Employee login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    adminLogin();
                    break;
                case 2:
                    employeeLogin();
                    break;
                case 3:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }

    private void adminLogin() {
        Scanner scanner = new Scanner(System.in);
        String adminPassword = "Admin@123";

        System.out.print("Enter admin password: ");
        String password = scanner.nextLine();

        if (password.equals(adminPassword)) {
            System.out.println("Admin login successful.");

            int choice;
            do {
                System.out.println("1. Add employee details");
                System.out.println("2. Update record");
                System.out.println("3. Save employee details to file");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        addEmployeeDetails();
                        break;
                    case 2:
                        updateRecord();
                        break;
                    case 3:
                        saveEmployeeDetailsToFile("C:\\Users\\deepanshusingh8\\Desktop\\employee_details.csv");
                        break;
                    case 4:
                        System.out.println("Exiting admin mode...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 4);
        } else {
            System.out.println("Invalid password. Access denied.");
        }
    }

    private void addEmployeeDetails() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee ID: ");
        String employeeId = scanner.nextLine();

        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        System.out.print("Enter total salary: ");
        double total = scanner.nextDouble();

        System.out.print("Enter basic salary: ");
        double basic = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character
        double totalSalary = total;
        double hra = basic * 0.5;
        double lta = basic * 0.21;
        double pf = 1800;
        double sodexo = 2200;
        double specialAllowance = total -(basic + hra + lta + pf + sodexo);

//        double totalSalary = basic + hra + lta + pf + sodexo + specialAllowance;

        Employee employee = new Employee(employeeId, name, basic, hra, lta, pf, sodexo, specialAllowance, 0, totalSalary);
        employees.add(employee);

        System.out.println("Employee details added successfully.");
    }

    private void updateRecord() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter new basic percentage (e.g., 50 for 50%): ");
        double basicPercentage = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        for (Employee employee : employees) {
            double basic = employee.getTotalSalary() * (basicPercentage / 100);
            double hra = basic * 0.5;
            double specialAllowance = basic - (hra + employee.getLta() + employee.getPf() + employee.getSodexo());

            employee.setBasic(basic);
            employee.setHra(hra);
            employee.setSpecialAllowance(specialAllowance);
        }

        System.out.println("Records updated successfully.");
    }

    private void employeeLogin() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee ID: ");
        String employeeId = scanner.nextLine();

        Employee employee = findEmployee(employeeId);

        if (employee != null) {
            System.out.println("Employee login successful.");

            int choice;
            do {
                System.out.println("1. My current CTC");
                System.out.println("2. Modify details");
                System.out.println("3. Calculate salary");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        displayEmployeeDetails(employee);
                        break;
                    case 2:
                        modifyDetails(employee);
                        break;
                    case 3:
                        calculateSalary(employee);
                        break;
                    case 4:
                        System.out.println("Exiting employee mode...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 4);
        } else {
            System.out.println("Invalid employee ID. Access denied.");
        }
    }

    private Employee findEmployee(String employeeId) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId().equals(employeeId)) {
                return employee;
            }
        }
        return null;
    }

    private void displayEmployeeDetails(Employee employee) {
        System.out.println("******* My Current CTC *******");
        System.out.println("TOTAL\tBasic\tHRA\tLTA\tSODEXO\tPF\tSpecial Allowance\tVPF");
        System.out.println("Monthly\t" + employee.getTotalSalary() + "\t" + employee.getBasic() + "\t" +
                employee.getHra() + "\t" + employee.getLta() + "\t" + employee.getSodexo() + "\t" +
                employee.getPf() + "\t" + employee.getSpecialAllowance() + "\t" + employee.getVpf());
        System.out.println("Fixed\t" + (employee.getTotalSalary() * 12) + "\t" + (employee.getBasic() * 12) + "\t" +
                (employee.getHra() * 12) + "\t" + (employee.getLta() * 12) + "\t" + (employee.getSodexo() * 12) +
                "\t" + (employee.getPf() * 12) + "\t" + (employee.getSpecialAllowance() * 12) + "\t" +
                (employee.getVpf() * 12));
    }

    private void modifyDetails(Employee employee) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. VPF");
        System.out.println("2. Sodexo");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (choice) {
            case 1:
                System.out.print("Enter new VPF percentage (e.g., 5 for 5%): ");
                double vpfPercentage = scanner.nextDouble();
                scanner.nextLine(); // Consume the newline character

                double vpf = employee.getBasic() * (vpfPercentage / 100);
                double specialAllowance = employee.getBasic() - (employee.getHra() + employee.getLta() +
                        employee.getPf() + employee.getSodexo());

                employee.setVpf(vpf);
                employee.setSpecialAllowance(specialAllowance);

                System.out.println("Details updated successfully.");
                break;
            case 2:
                System.out.println("1. Opt IN");
                System.out.println("2. Opt OUT");
                System.out.print("Enter your choice: ");
                int sodexoChoice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (sodexoChoice) {
                    case 1:
                        employee.setSodexo(2200);
                        break;
                    case 2:
                        employee.setSodexo(0);
                        employee.setSpecialAllowance(employee.getSpecialAllowance() + 2200);
                        break;
                    default:
                        System.out.println("Invalid choice. Details not updated.");
                }

                System.out.println("Details updated successfully.");
                break;
            default:
                System.out.println("Invalid choice. Details not updated.");
        }
    }

    private void calculateSalary(Employee employee) {
        System.out.println("******* Calculate Salary *******");
        System.out.println("1. 0 VPF, 0 Sodexo");
        System.out.println("2. Some % VPF, 0 Sodexo");
        System.out.println("3. Some % VPF, 2200 Sodexo");
        System.out.println("4. 0 VPF, 2200 Sodexo");
        System.out.print("Enter your choice: ");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        double monthlySalary = 0;

        switch (choice) {
            case 1:
                monthlySalary = employee.getTotalSalary();
                break;
            case 2:
                System.out.print("Enter VPF percentage (e.g., 5 for 5%): ");
                double vpfPercentage = scanner.nextDouble();
                scanner.nextLine(); // Consume the newline character

                double vpfAmount = employee.getBasic() * (vpfPercentage / 100);
                double specialAllowance = employee.getBasic() - (employee.getHra() + employee.getLta() +
                        employee.getPf() + employee.getSodexo());

                monthlySalary = employee.getBasic() + employee.getHra() + employee.getLta() +
                        employee.getPf() + employee.getSodexo() + specialAllowance - vpfAmount;
                break;
            case 3:
                System.out.print("Enter VPF percentage (e.g., 5 for 5%): ");
                double vpfPercentageWithSodexo = scanner.nextDouble();
                scanner.nextLine(); // Consume the newline character

                double vpfAmountWithSodexo = employee.getBasic() * (vpfPercentageWithSodexo / 100);

                monthlySalary = employee.getBasic() + employee.getHra() + employee.getLta() +
                        employee.getPf() + employee.getSodexo() + employee.getSpecialAllowance() - vpfAmountWithSodexo;
                break;
            case 4:
                monthlySalary = employee.getBasic() + employee.getHra() + employee.getLta() +
                        employee.getPf() + 2200 + employee.getSpecialAllowance();
                break;
            default:
                System.out.println("Invalid choice. Salary calculation canceled.");
                return;
        }

        System.out.println("Monthly In hand Salary: " + monthlySalary);
    }

    private void saveEmployeeDetailsToFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("EmployeeID,Name,Basic,HRA,LTA,PF,Sodexo,SpecialAllowance,VPF,TotalSalary\n");

            for (Employee employee : employees) {
                writer.write(employee.toCsvString() + "\n");
            }

            System.out.println("Employee details saved to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the employee details to file: " + e.getMessage());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        HRSystem hrSystem = new HRSystem();
        hrSystem.login();
    }
}
