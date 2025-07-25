package util.concurrent;

public interface Executor {
    void execute(Runnable command);
}
