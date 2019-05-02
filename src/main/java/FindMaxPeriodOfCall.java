import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class FindMaxPeriodOfCall {


    private HashMap<Long, Long> callsInMilliseconds = new HashMap<Long, Long>();
    private BufferedReader callsFileLog;


    public HashMap<Long, Long> insertDataFromFile(String fileName) throws IOException {
        try {

            callsFileLog = new BufferedReader(new FileReader(fileName));

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


        } catch (IOException e) {
            System.out.println(e);
        } finally {
            callsFileLog.close();
        }
        return callsInMilliseconds;
    }


    public HashMap<Long, Long> insertToHMap(HashMap<Long, Long> callsMap, Long start, Long end) {
//if there is a call that started in the same time add 1
        if (callsMap.containsKey(start)) {
            Long valueFromMap = callsMap.get(start);
            callsMap.put(start, valueFromMap + 1L);
            // if there is not a call that started in the same time, create one and initialize it with 1
        } else {
            callsMap.put(start, 1L);
        }
//if there is a call that ended  in the same time subtract  1
        if (callsMap.containsKey(end)) {
            Long valueFromMap = callsMap.get(end);
            callsMap.put(end, valueFromMap - -1L);

            // if there is not a call that ended in the same time, create one and initialize it with -1
        } else {
            callsMap.put(end, -1L);
        }


        return callsMap;
    }

    public List<TimeCallCountCell> insertToArrayAndRemoveHmap(HashMap<Long, Long> callsMap) {
        List<TimeCallCountCell> arrayOfData = new ArrayList();

        Iterator<Map.Entry<Long, Long>> entryCell = callsMap.entrySet().iterator();
        while (entryCell.hasNext()) {
            Map.Entry<Long, Long> entry = entryCell.next();
            Long key = entry.getKey();
            Long value = entry.getValue();

            TimeCallCountCell timeCallCountCell = new TimeCallCountCell();
            timeCallCountCell.setTimeInMilliSec(key);
            timeCallCountCell.setCallCount(value);

//Add to array of TimeCallCountCell
            arrayOfData.add(timeCallCountCell);
//After insert to array, remove form HMap in order to save space.
            entryCell.remove();
        }


//Sort array by millisec
        Collections.sort(arrayOfData, TimeCallCountCell.milliSecComparator);
        return arrayOfData;
    }


    public List<Long> addedbyValueInArray(List<TimeCallCountCell> arrayOfData) {
        List<Long> arrayOfValue = new ArrayList<Long>();
        int arraySize = arrayOfData.size();
        //Adding the first value
        if (arraySize != 0) {
            arrayOfValue.add(arrayOfData.get(0).getCallCount());
        } else {
            return arrayOfValue;
        }

        for (int i = 1; i < arraySize; i++) {
            arrayOfValue.add(arrayOfValue.get(i - 1) + arrayOfData.get(i).getCallCount());
        }

        return arrayOfValue;
    }

    public Long findMaxInArray(List<Long> addedbyValueInArray) {
        Long maxValue = 0L;
        int size = addedbyValueInArray.size();
        for (int i = 0; i < size; i++) {
            if (maxValue < addedbyValueInArray.get(i)) {
                maxValue = addedbyValueInArray.get(i);
            }
        }
        return maxValue;
    }


    public List<MaxTime> getArrayOfMaxTimes(List<Long> addedbyValueInArray, List<TimeCallCountCell> timeCallCountCellsInMilliSec) {
        List<MaxTime> arrayOfMaxTimes = new ArrayList();
        Long max = findMaxInArray(addedbyValueInArray);
        int size = timeCallCountCellsInMilliSec.size();
        for (int i = 0; i < size; i++) {
            if (addedbyValueInArray.get(i).equals(max)) {
                Long startTime = timeCallCountCellsInMilliSec.get(i).getTimeInMilliSec();
                Long endTime = timeCallCountCellsInMilliSec.get(i + 1).getTimeInMilliSec();
                MaxTime maxTime = new MaxTime(startTime, endTime);
                arrayOfMaxTimes.add(maxTime);
            }
        }

        return arrayOfMaxTimes;
    }
}

