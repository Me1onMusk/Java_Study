package annotation.basic;

import java.util.Arrays;

public class ElementData1Main {
    public static void main(String[] args) {

        Class<ElementData1> annoClass = ElementData1.class;
        AnnoElement annotation = annoClass.getAnnotation(AnnoElement.class);

        System.out.println("value = " + annotation.value());  //value = data
        System.out.println("count = " + annotation.count());  //count = 10
        System.out.println("tags = " + Arrays.toString(annotation.tags()));  //tags = [t1, t2]
        System.out.println("annoData = " + annotation.annoData());  //annoData = class util.MyLogger

    }
}
