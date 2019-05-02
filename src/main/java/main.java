import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class main {


    public static void main(String[] args) throws IOException {
        FindMaxPeriodOfCall findMaxPeriodOfCall = new FindMaxPeriodOfCall();
        String fileName= "Files/callsLog.txt";
        HashMap<Long, Long> callsInMilliseconds = new HashMap<Long, Long>();
        callsInMilliseconds = findMaxPeriodOfCall.insertDataFromFile(fileName);
        List<TimeCallCountCell> arrayOfData = new ArrayList();
        arrayOfData = findMaxPeriodOfCall.insertToArrayAndRemoveHmap(callsInMilliseconds);
        List<Long> addaingArray = new ArrayList();
        addaingArray = findMaxPeriodOfCall.addedbyValueInArray(arrayOfData);
        List<MaxTime> maxTimes= new ArrayList();
        maxTimes= findMaxPeriodOfCall.getArrayOfMaxTimes(addaingArray,arrayOfData );
        System.out.println(Collections.singletonList(maxTimes));
    }
}
