package multithread.package01;

public class Test {

    ThreadLocal<Long> id = new ThreadLocal<>();
    ThreadLocal<String> name = new ThreadLocal<>();

    public void set() {
        id.set(Thread.currentThread().getId());
        name.set(Thread.currentThread().getName());

    }

    public Long getId() {
        return this.id.get();
    }

    public String getName() {
        return this.name.get();
    }

    public static void main(String[] args) throws InterruptedException {

        Test test = new Test();

        test.set();

        System.out.println(test.getId());
        System.out.println(test.getName());

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                test.set();
                System.out.println(test.getId());
                System.out.println(test.getName());
            }
        });

        t1.start();
        t1.join();

        System.out.println(test.getId());
        System.out.println(test.getName());


    }
}
