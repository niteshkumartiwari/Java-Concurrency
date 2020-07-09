package ThreadLocal;

public class Service1 {
    public void process1(User user){
        //do something
        UserContextHolder.holder.set(user);
    }
}
