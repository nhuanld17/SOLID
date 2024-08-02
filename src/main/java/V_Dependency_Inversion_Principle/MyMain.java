package V_Dependency_Inversion_Principle;

public class MyMain {
    public static void main(String[] args) {
        Notification emailNotification = new EmailNotification();
        Employee employee = new Employee(emailNotification);
        employee.notifyUsers();
    }
}
