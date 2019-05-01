import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class Scanfile {


    private  HashMap<Long, Long> callsInMilliseconds = new HashMap<Long, Long>();
    private BufferedReader callsFileLog;


    public HashMap<Long, Long> getCallsInMilliseconds() {
        return callsInMilliseconds;
    }

    public void setCallsInMilliseconds(HashMap<Long, Long> callsInMilliseconds) {
        this.callsInMilliseconds = callsInMilliseconds;
    }


    public HashMap<Long, Long> insertDataFromFile() throws IOException {
        try {

            callsFileLog = new BufferedReader(new FileReader("Files/callsLog.txt"));

            StringBuilder sb = new StringBuilder();
            String line = callsFileLog.readLine();
            Long startTime;
            Long endTime;


            while (line != null) {
                sb.append(line);
                String[] stringToParts = line.split(Pattern.quote("-"));
                startTime = Long.parseLong(stringToParts[0]);
                endTime = Long.parseLong(stringToParts[1]);
                callsInMilliseconds = insertToHMap(callsInMilliseconds, startTime, endTime);
                line = callsFileLog.readLine();
            }


        } finally {
            callsFileLog.close();
        }
        return callsInMilliseconds;
    }


    public HashMap<Long, Long> insertToHMap(HashMap<Long, Long> callsMap, Long start, Long end) {

        if (callsMap.containsKey(start)) {
            Long valueFromMap = callsMap.get(start);
            callsMap.put(start, valueFromMap + 1L);
        } else {
            callsMap.put(start, 1L);
        }

        if (callsMap.containsKey(end)) {
            Long valueFromMap = callsMap.get(end);
            callsMap.put(end, valueFromMap - -1L);
        } else {
            callsMap.put(end, -1L);
        }


        return callsMap;
    }

    public List<ArrayCell> insertToArrayAndRemoveHmap(HashMap<Long, Long> callsMap) {
        List<ArrayCell> arrayOfData = new ArrayList();

        Iterator<Map.Entry<Long, Long>> entryCell = callsMap.entrySet().iterator();
        while (entryCell.hasNext()) {
            Map.Entry<Long, Long> entry = entryCell.next();
            Long key = entry.getKey();
            Long value = entry.getValue();

            ArrayCell arrayCell = new ArrayCell();
            arrayCell.setKay(key);
            arrayCell.setValue(value);

//Add to array of ArrayCell
            arrayOfData.add(arrayCell);
//After insert to array, remove form HMap in order to save space.
            entryCell.remove();
        }


//sort array by key
        Collections.sort(arrayOfData, ArrayCell.keyComparator );
        return arrayOfData;
    }



public List<Long> addedbyValueInArray ( List<ArrayCell> arrayOfData){
    List<Long> arrayOfValue= new ArrayList<Long>();
    int arraySize=arrayOfData.size();
    //Adding the first value
    if (arraySize!=0) {
        arrayOfValue.add(arrayOfData.get(0).getValue());
    }
    else{
        return  arrayOfValue;
    }

    for (int i=1; i<arraySize; i++) {
        arrayOfValue.add(arrayOfValue.get(i-1)+arrayOfData.get(i).getValue());
    }

    return  arrayOfValue;
}



}

