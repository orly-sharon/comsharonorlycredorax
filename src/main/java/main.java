import java.io.IOException;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.HashMap;

public class main {


    public static void main(String[] args) throws IOException {
    Scanfile  scanfile = new Scanfile();
         HashMap<Timestamp, Long> callsInMilliseconds = new HashMap<Timestamp, Long>();
        callsInMilliseconds= scanfile.insertDataFromFile();
        System.out.println(Collections.singletonList(callsInMilliseconds));

        System.out.println("test" + callsInMilliseconds.size() );
    }
}
