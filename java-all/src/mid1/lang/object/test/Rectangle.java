package mid1.lang.object.test;

public class Rectangle {

    int width;
    int height;

    Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle [width=" + width + ", height=" + height + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Rectangle rectangle)
            return rectangle.width == this.width && rectangle.height == this.height;
        return false;
    }
}
