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


    //public void insertDataFromFile(BufferedReader callsFileLog) throws IOException {
    public HashMap<Long, Long>  insertDataFromFile() throws IOException {
        try {

            callsFileLog = new BufferedReader(new FileReader("Files/callsLog.txt"));

            StringBuilder sb = new StringBuilder();
            String line = callsFileLog.readLine();
            Long startTime;
            Long endTime;


            while (line != null) {
                sb.append(line);
                //   sb.append(System.lineSeparator());
                line = callsFileLog.readLine();
                String[] stringToParts = line.split(Pattern.quote(" "));
                startTime = Long.parseLong(stringToParts[2]);
                endTime = Long.parseLong(stringToParts[3]);
                callsInMilliseconds = insertToHMap(callsInMilliseconds, startTime, endTime);
            }



        } finally {
            callsFileLog.close();
        }
        return  callsInMilliseconds;
    }



    public HashMap<Long, Long> insertToHMap(HashMap<Long, Long> callsMap, Long start, Long end) {

//         while (start.before(end)) {
//            if (callsMap.containsKey(start)) {
//                Long valueFromMap = callsMap.get(start);
//                callsMap.put(start, valueFromMap + 1L);
//            } else {
//                callsMap.put(start, 1L);
//            }
//
//            start = addOneMiliSec(start);
//
//        }

        if (callsMap.containsKey(start)) {
                Long valueFromMap = callsMap.get(start);
                callsMap.put(start, valueFromMap + 1L);
            } else {
                callsMap.put(start, 1L);
            }

        if (callsMap.containsKey(end)) {
            Long valueFromMap = callsMap.get(end);
            callsMap.put(start, valueFromMap + -1L);
        } else {
            callsMap.put(end, 1L);
        }



        return callsMap;
    }

//    public Long addOneMiliSec(Long time) {
//        int millisec = 1;
//        Calendar cal = Calendar.getInstance();
//        cal.setTimeInMillis(time.getTime());
//        cal.add(Calendar.MILLISECOND, millisec);
//        time = new Long(cal.getTime().getTime());
//
//
//
//        return time;
//    }

//    public String crateOneStringOfDate(String Day, String Time ){
//
//      return Day+" "+Time;
//    }

}
