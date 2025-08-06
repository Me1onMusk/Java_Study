package optional.logger;

import java.util.function.Supplier;

public class Logger {

    private boolean isDebug = false;

    public boolean isDebug() {
        return isDebug;
    }

    public void setDebug(boolean debug) {
        isDebug = debug;
    }

    public void debug(int message) {
        if (isDebug)
            System.out.println("[DEBUG] " + message);
    }

    // Supplier -> 반환값만
    public void debug(Supplier<?> supplier) {
        if (isDebug)
            System.out.println("[DEBUG] " + supplier.get());
    }

}
