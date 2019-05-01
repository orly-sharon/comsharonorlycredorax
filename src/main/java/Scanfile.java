import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Pattern;

public class Scanfile {


    private static HashMap<Long, Long> callsInMilliseconds = new HashMap<Long, Long>();
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


}
