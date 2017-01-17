package secondapp.gpp.com.secondapp.DesignMode;

/**
 * Created by Administrator on 2017/1/16.
 */

public class BuilderTest {

    Builder.MyBuilder myBuilder= new Builder.MyBuilder();
    Builder builder = myBuilder.No(1).name("Jack").age(22).builder();

}
