package V_Dependency_Inversion_Principle;

public class Employee {
    public Notification notification;

    public Employee(Notification notification) {
        this.notification = notification;
    }

    public void notifyUsers() {
        notification.notificate();
    }
}
