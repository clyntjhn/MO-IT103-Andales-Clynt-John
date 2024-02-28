import java.util.Scanner;

public class SalaryCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee's basic salary: ");
        double basicSalary = scanner.nextDouble();

        System.out.print("Enter number of hours worked: ");
        double hoursWorked = scanner.nextDouble();

        double hourlyRate = basicSalary / 22; // 22 is the number of working days in a month
        double overtimePay = 0;

        if (hoursWorked > 8) {
            double overtimeHours = hoursWorked - 8;
            overtimePay = overtimeHours * hourlyRate * 1.5;
        }

        double totalSalary = basicSalary + overtimePay;

        // Deductions
        double sssDeduction = totalSalary * 0.0275;
        double philhealthDeduction = totalSalary * 0.025;
        double pagibigDeduction = totalSalary * 0.01;
        double taxDeduction = calculateTax(totalSalary);

        double netSalary = totalSalary - sssDeduction - philhealthDeduction - pagibigDeduction - taxDeduction;

        System.out.println("Total salary: " + totalSalary);
        System.out.println("SSS deduction: " + sssDeduction);
        System.out.println("PhilHealth deduction: " + philhealthDeduction);
        System.out.println("Pag-IBIG deduction: " + pagibigDeduction);
        System.out.println("Tax deduction: " + taxDeduction);
        System.out.println("Net salary: " + netSalary);

        scanner.close();
    }

    private static double calculateTax(double totalSalary) {
        if (totalSalary <= 20000) {
            return 0;
        } else if (totalSalary <= 25000) {
            return (totalSalary - 20000) * 0.10;
        } else if (totalSalary <= 30000) {
            return (totalSalary - 25000) * 0.15 + 2000;
        } else if (totalSalary <= 35000) {
            return (totalSalary - 30000) * 0.20 + 3500;
        } else if (totalSalary <= 40000) {
            return (totalSalary - 35000) * 0.25 + 8000;
        } else {
            return (totalSalary - 40000) * 0.30 + 14000;
        }
    }
}