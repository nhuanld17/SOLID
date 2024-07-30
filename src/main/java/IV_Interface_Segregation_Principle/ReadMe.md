# Interface Segregation Principle

#### Theo nguyên tắc phân chia giao diện, bạn nên xây dựng các giao diện nhỏ, tập trung mà không ép buộc các lớp phải triển khai những hành vi mà chúng không cần.

>Một ví dụ đơn giản là có một giao diện tính cả diện tích và thể tích của một hình dạng.

```java
public interface IShapeAreaCalculator {
    double calculateArea();

    double calculateVolume();
}

public class Square implements IShapeAreaCalculator {
    @Override
    double calculateArea() {
        //
    }

    @Override
    public double calculateVolume() {
        // 
    }
}
```

>Vấn đề với điều này là nếu một hình vuông-**Square** triển khai giao diện này, thì nó sẽ bị ép buộc phải triển khai phương thức `calculateVolume()`, mà thực tế là nó không cần.

>Mặt khác, một Hình lập phương - **Cube** có thể triển khai cả hai phương thức. Để khắc phục điều này, chúng ta có thể phân chia giao diện và tạo hai giao diện riêng biệt: một cho việc tính diện tích và một cho việc tính thể tích. Điều này sẽ cho phép các hình dạng khác nhau quyết định những gì cần triển khai.

```java
public interface IAreaCalculator {
    double calculateArea();
}

public interface IVolumeCalculator {
    double calculateVolume();
}

public class Square implements IAreaCalculator {
    @Override
    public double calculateArea() {
        //
    }
}

public class Cube implements IVolumeCalculator, IAreaCalculator {
    @Override
    public double calculateVolume() {
        // 
    }

    @Override
    public double calculateArea() {
        //
    }
}
```




