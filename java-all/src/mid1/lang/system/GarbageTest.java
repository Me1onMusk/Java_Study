package mid1.lang.system;

/*
    Garbage 컬렉터는 수거를 마음대로 한다.
*/

public class GarbageTest {
    public static void main(String[] args) {

        for (int i = 0; i <3; i++) {
            new Garbage(i);
            System.gc();
        }

    }
}

class Garbage {
    int no;

    public Garbage(int no) {
        this.no = no;
        System.out.printf("Garbage (%d) 생성 \n", no);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Garbage (%d) 수거 \n", no);
    }
}
