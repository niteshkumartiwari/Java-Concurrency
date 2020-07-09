package ThreadLocal;

public class UserContextHolder {
    public static ThreadLocal<User> holder= new ThreadLocal<User>();
}
