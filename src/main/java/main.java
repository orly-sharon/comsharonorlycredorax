import java.io.IOException;
import java.util.*;

public class main {


    public static void main(String[] args) throws IOException {
        FindMaxPeriodOfCall findMaxPeriodOfCall = new FindMaxPeriodOfCall();
        //Option to get files from project

        //String fileName= "Files/callsLog";
        //String fileName = "Files/callLogBigFile";

        System.out.println("Insert full file path");
        Scanner scan = new Scanner(System.in);
        String FileNameFromUser = scan.next();

        HashMap<Long, Long> callsInMilliseconds = new HashMap<Long, Long>();
        callsInMilliseconds = findMaxPeriodOfCall.insertDataFromFile(FileNameFromUser);
        List<TimeCallCountCell> arrayCallsInMilliSec = new ArrayList();
        arrayCallsInMilliSec = findMaxPeriodOfCall.insertToArrayAndRemoveHmap(callsInMilliseconds);
        List<Long> arrayAddCalls = new ArrayList();
        arrayAddCalls = findMaxPeriodOfCall.addedbyValueInArray(arrayCallsInMilliSec);
        List<MaxTime> maxTimes = new ArrayList();
        maxTimes = findMaxPeriodOfCall.getArrayOfMaxTimes(arrayAddCalls, arrayCallsInMilliSec);
        System.out.println(Collections.singletonList(maxTimes));
    }
}
