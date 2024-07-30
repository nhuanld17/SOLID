# Nguyên tắc Trách nhiệm Đơn lẻ (Single Responsibility Principle)
#### Nguyên tắc trách nhiệm đơn lẻ quy định rằng mỗi lớp phải có một trách nhiệm duy nhất, tập trung và một lý do duy nhất để thay đổi.
  
```java
public class Employee {
    public String getDesignation(int employeeID){//};
    public void udateSalary(int employeeID){//};
    public void sendMail(){//};
}
```

#### Trong ví dụ ở trên, class Employee có một số hành vi cụ thể liên quan đến lớp nhân viên như getDesignation & updateSalary

#### Ngoài ra, lớp này còn có một phương thức khác tên là sendMail, phương thức này không thuộc trách nhiệm của lớp Employee.

#### Hành vi này không cụ thể cho lớp này, và việc có nó vi phạm nguyên tắc trách nhiệm đơn lẻ. Để khắc phục điều này, bạn có thể di chuyển phương thức sendMail vào một lớp riêng biệt.

#### Ví dụ:

```java
public class Employee {
    public String getDesignation(int employeeID){
        //
    }
    public void updateSalary(int employeeID){
        //
    }
}

public class NotificationService {
    public void sendMail(){
        //
    }
}
```





