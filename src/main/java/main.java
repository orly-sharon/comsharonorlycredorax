import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class main {


    public static void main(String[] args) throws IOException {
        FindMaxPeriodOfCall findMaxPeriodOfCall = new FindMaxPeriodOfCall();
        //String fileName= "Files/callsLog";
        String fileName = "Files/callLogBigFile";
        String FileNameFromUser;
      //  FileNameFromUser=
        HashMap<Long, Long> callsInMilliseconds = new HashMap<Long, Long>();
        callsInMilliseconds = findMaxPeriodOfCall.insertDataFromFile(fileName);
        List<TimeCallCountCell> arrayCallsInMilliSec = new ArrayList();
        arrayCallsInMilliSec = findMaxPeriodOfCall.insertToArrayAndRemoveHmap(callsInMilliseconds);
        List<Long> arrayAddCalls = new ArrayList();
        arrayAddCalls = findMaxPeriodOfCall.addedbyValueInArray(arrayCallsInMilliSec);
        List<MaxTime> maxTimes = new ArrayList();
        maxTimes = findMaxPeriodOfCall.getArrayOfMaxTimes(arrayAddCalls, arrayCallsInMilliSec);
        System.out.println(Collections.singletonList(maxTimes));
    }
}
