# Nguyên tắc Thay thế Liskov (Liskov Substitution Principle - LSP)

#### Nguyên tắc thay thế Liskov quy định rằng bạn phải có khả năng thay thế một đối tượng của lớp cơ sở bằng một đối tượng của lớp con mà không làm ảnh hưởng đến tính đúng đắn của chương trình.

```java
public abstract class Bird {
    abstract void fly();
}

public class Eagle extends Bird {
    @Override
    public void fly() {
        //
    }
}

public class Ostrich extends Bird {
    @Override
    public void fly() {
        //
    }
}
```
> Trong ví dụ trên, lớp **Eagle** và lớp **Ostrich** đều kế thừa lớp **Bird** và ghi đè phương thức `fly()`. Tuy nhiên, lớp **Ostrich** phải cung cấp một triển khai giả (dummy) vì nó không thể bay, và do đó, lớp **Ostrich** không hoạt động giống như khi chúng ta thay thế đối tượng của lớp Bird bằng đối tượng của lớp **Ostrich**.

> Điều này vi phạm **nguyên tắc thay thế Liskov**. Để khắc phục điều này, chúng ta có thể tạo một lớp riêng cho các loài chim có thể bay và để lớp **Eagle** kế thừa lớp đó, trong khi các loài chim khác có thể kế thừa một lớp khác, lớp này sẽ không bao gồm hành vi `fly()`. 

```java
public abstract class FlyingBird {
    abstract void fly();
}

public abstract class NonFlyingBird {
    abstract void doSomeThing();
}

public class Eagle extends FlyingBird {
    @Override
    public void fly(){
        //
    }
}

public class Ostrich extends NonFlyingBird {
    @Override
    public void doSomeThing(){
        //
    }
}
```