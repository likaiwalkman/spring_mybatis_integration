import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Test run");
        //Runtime runtime = Runtime.getRuntime();
        //Process process = runtime.exec("java Test2");
        //process.getInputStream();
        //process.getOutputStream();
        //process.getErrorStream();
        int i = -1;
//        while ((i = System.in.read()) != -1){
//            System.out.println(i);
//        }
        System.out.write(0);
        Thread.sleep(2000);
        System.out.write(-1);


    }
}
