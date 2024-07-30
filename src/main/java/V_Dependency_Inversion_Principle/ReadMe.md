# Nguyên Tắc Đảo Ngược Phụ Thuộc (Dependency Inversion Principle - DIP)

#### Trong nguyên tắc Đảo Ngược Phụ Thuộc, các module cấp cao không nên phụ thuộc vào các module cấp thấp. Nói cách khác, bạn phải tuân theo sự trừu tượng và đảm bảo sự kết nối lỏng lẻo.

```java
public interface Notification {
    void notify();
}

public class EmailNotification implements Notification {
    @Override
    public void notify() {
        System.out.println("Sending notification via email");
    }
}

public class Employee {
    private EmailNotification emailNotification;
    public Employee(EmailNotification emailNotification) {
        this.emailNotification = emailNotification;
    }
    
    public void notifyUser() {
        emailNotification.notify();
    }
}
```

>Trong ví dụ được đưa ra, lớp **Employee** phụ thuộc trực tiếp vào lớp **EmailNotification**, là một module cấp thấp. Điều này vi phạm nguyên tắc đảo ngược phụ thuộc.

```java
public interface Notification {
    public void notify();
}

public class Employee {
    private Notification notification;
    public Employee(Notification notification){
        this.notification = notification;
    }
    
    public void notifyUser() {
        notification.notify();
    }
}

public class EmailNotification implements Notification {
    @Override
    public void notify() {
        // implement notification via email
    }
}

public class Main {
    public static void main(String[] args) {
        Notification notification = new EmailNotification();
        Employee employee = new Employee(notification);
        employee.notifyUser();
    }
}
```

>Trong ví dụ trên, chúng tôi đã đảm bảo sự kết nối lỏng lẻo. Lớp **Employee** không phụ thuộc vào bất kỳ triển khai cụ thể nào, mà chỉ phụ thuộc vào sự trừu tượng (giao diện **notification**).

>Nếu chúng ta cần thay đổi chế độ thông báo, chúng ta có thể tạo một triển khai mới và truyền nó vào lớp **Employee**.