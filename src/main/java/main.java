import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class main {


    public static void main(String[] args) throws IOException {
    Scanfile  scanfile = new Scanfile();
         HashMap<Long, Long> callsInMilliseconds = new HashMap<Long, Long>();
        callsInMilliseconds= scanfile.insertDataFromFile();
        List<ArrayCell> arrayOfData = new ArrayList();
        arrayOfData = scanfile.insertToArrayAndRemoveHmap(callsInMilliseconds);



        System.out.println(Collections.singletonList(callsInMilliseconds));

        System.out.println("test" + callsInMilliseconds.size() );
    }
}
