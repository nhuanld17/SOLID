# Nguyên tắc Mở/Đóng (Open/Closed Principle)

#### Theo nguyên tắc mở/đóng (open/closed principle), các thành phần phải mở rộng được nhưng đóng đối với việc chỉnh sửa. Để hiểu rõ nguyên tắc này, chúng ta hãy lấy ví dụ về một lớp tính diện tích của một hình dạng.

```java
public class AreaCalculator {
    public double area(Shape shape) {
        double areaOfShape;
        if (shape instanceof Square) {
            // Calculate the area of Square
        } else if (shape instanceof Circle) {
            // Calculate the area of Circle
        }
        
        return  areaOfShape;
    }
}
```
> Vấn đề với ví dụ trên là nếu có một trường hợp mới của loại Shape mà bạn cần tính diện tích trong tương lai, bạn sẽ phải sửa đổi lớp trên bằng cách thêm một khối điều kiện else-if khác. Bạn sẽ phải làm điều này cho mỗi đối tượng mới của loại Shape.

> Để khắc phục vấn đề này, bạn có thể tạo một giao diện (interface) và để mỗi loại Shape triển khai giao diện này. Sau đó, mỗi lớp có thể cung cấp triển khai riêng của nó để tính diện tích. Điều này sẽ giúp chương trình của bạn dễ dàng mở rộng trong tương lai mà không cần chỉnh sửa mã nguồn hiện có.

```java
public interface AreaCalculatorInterface {
    double area();
}

public class Square implements AreaCalculatorInterface {
    @Override
    public double area() {
        System.out.println("Calculating area for Square");
        return 0.0;
    }
}

public class Circle implements AreaCalculatorInterface {
    @Override
    public double area() {
        System.out.println("Calculating area for Circle");
        return  0.0;
    }
}
```