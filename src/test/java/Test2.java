import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Test2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Test2 run");
        Runtime      runtime = Runtime.getRuntime();
        Process      process = runtime.exec("java Test2");
        InputStream  ins =  process.getInputStream();
        OutputStream ous = process.getOutputStream();
        //InputStream  err = process.getErrorStream();
//        ous.write(1);
//        ous.write(2);
//        ous.write(-1);
        int i;
        while ((i = ins.read()) != -1){
            System.out.println(i);
            Thread.sleep(1000);
        }
        System.out.println("end");
    }
}
