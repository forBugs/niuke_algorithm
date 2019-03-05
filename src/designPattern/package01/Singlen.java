package designPattern.package01;

/**
 * 单例模式
 */
public class Singlen {

    private Singlen() {}

    public static Singlen instance;
    public static synchronized Singlen newInstance() {

        if(instance == null ) {
            instance = new Singlen();
        }
        return instance;
    }

}
