package singleton;

import java.io.Serializable;

public class LazySingleton extends MyClone implements Serializable {
    private static LazySingleton instance=null;

    private LazySingleton(){
        if(instance != null)
            throw new IllegalStateException("Object can't be created using reflection");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Singleton doesn't allow cloning");
    }

    //to protect from deserialization
    protected Object readResolve(){
        return instance;
    }

    public static LazySingleton getInstance(){
        if(instance == null){
            synchronized (LazySingleton.class){
                if(instance == null)
                    instance= new LazySingleton();
            }
        }
        return instance;
    }
}
