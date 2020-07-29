package intro;

class Sample{
    Sample(){
        System.out.println("Inside Sample Constructor");
    }
}

interface Inter{
    public Sample get();
}
public class ConstRef {
    public static void main(String[] args) {
        Inter i= Sample::new;
        Sample s= i.get();
    }
}
