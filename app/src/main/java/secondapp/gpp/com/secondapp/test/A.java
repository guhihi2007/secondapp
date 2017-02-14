package secondapp.gpp.com.secondapp.test;

/**
 * Created by Administrator on 2017/2/13.
 */

public class A {
    private Listener listener;
    public void setListener(Listener listener){
        this.listener = listener;
    }
    public void testMethod(){
        listener.doSomething();
    }
    class c implements Listener{
        A a = new A();
        @Override
        public void doSomething() {
            a.setListener(this);

        }
    }
}
