package network.tcp.autocloseable;

public class ResourceV2 implements AutoCloseable {

    private String name;

    public ResourceV2(String name) {
        this.name=name;
    }

    // 정상 로직 //
    public void call() {
        System.out.println(name + "call");
    }

    // 비정상 로직 //
    public void callEx() throws CallException {
        System.out.println(name + "callEx");
        throw new CallException(name + "ex");
    }

    // 정상 종료 //
    @Override
    public void close() throws CloseException {
        System.out.println(name + "close");
        throw new CloseException(name + "ex");
    }

}
