package ThreadLocal;

public class Service2 {
    public User process(){
        User user= UserContextHolder.holder.get();
        UserContextHolder.holder.remove();//delete after the request is served
        return user;
    }
}
