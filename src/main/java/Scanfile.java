

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;



import java.sql.Timestamp;
import java.util.Calendar;

import java.util.HashMap;
import java.util.regex.Pattern;

public class Scanfile {


    private static HashMap<Timestamp, Long> callsInMilliseconds = new HashMap<Timestamp, Long>();
    private BufferedReader callsFileLog;


    public HashMap<Timestamp, Long> getCallsInMilliseconds() {
        return callsInMilliseconds;
    }

    public void setCallsInMilliseconds(HashMap<Timestamp, Long> callsInMilliseconds) {
        this.callsInMilliseconds = callsInMilliseconds;
    }


    //public void insertDataFromFile(BufferedReader callsFileLog) throws IOException {
    public HashMap<Timestamp, Long>  insertDataFromFile() throws IOException {
        try {

            callsFileLog = new BufferedReader(new FileReader("Files/callsLog.txt"));

            StringBuilder sb = new StringBuilder();
            String line = callsFileLog.readLine();
            Timestamp startTime;
            Timestamp endTime;


            while (line != null) {
                sb.append(line);
                //   sb.append(System.lineSeparator());
                line = callsFileLog.readLine();
                String[] stringToParts = line.split(Pattern.quote(" "));
                startTime = convertToTS(crateOneStringOfDate (stringToParts[2],stringToParts[3]));
                endTime = convertToTS(crateOneStringOfDate (stringToParts[4],stringToParts[5]));
                callsInMilliseconds = insertToHMap(callsInMilliseconds, startTime, endTime);
            }



        } finally {
            callsFileLog.close();
        }
        return  callsInMilliseconds;
    }

    public Timestamp convertToTS(String date) {

        Timestamp timestamp = Timestamp.valueOf(date);

        return timestamp;

    }

    public HashMap<Timestamp, Long> insertToHMap(HashMap<Timestamp, Long> callsMap, Timestamp start, Timestamp end) {

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

    public Timestamp addOneMiliSec(Timestamp time) {
        int millisec = 1;
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time.getTime());
        cal.add(Calendar.MILLISECOND, millisec);
        time = new Timestamp(cal.getTime().getTime());



        return time;
    }

    public String crateOneStringOfDate(String Day, String Time ){

      return Day+" "+Time;
    }

}
