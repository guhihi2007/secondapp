package secondapp.gpp.com.secondapp.DesignMode;



/**
 * Created by Administrator on 2017/1/16.
 */

public class Builder {
    private String name;
    private int No;
    private int age;
    private Builder(MyBuilder myBuilder) {
        this.name = myBuilder.name;
        this.age = myBuilder.age;
        this.No = myBuilder.No;
    }
    public String getName() {
        return this.name;
    }
    public int getNo() {
        return this.No;
    }
    public int getAge() {
        return this.age;
    }
    static class MyBuilder {
        private String name;
        private int No;
        private int age;
        public MyBuilder name(String name) {
            this.name = name;
            return this;
        }
        public MyBuilder No(int No) {
            this.No = No;
            return this;
        }
        public MyBuilder age(int age) {
            this.age = age;
            return this;
        }
        public Builder builder() {
            return new Builder(this);
        }
    }
}
