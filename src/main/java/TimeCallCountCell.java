import java.util.Comparator;

public class TimeCallCountCell {

    //timeInMiliSec represents call start time or call end time in milliseconds
    Long timeInMilliSec;
    //Start time gets 1 as value and end time gets -1 as value
    Long callCount;

    public TimeCallCountCell() {
    }

    public TimeCallCountCell(Long timeInMilliSec, Long callCount) {
        this.timeInMilliSec = timeInMilliSec;
        this.callCount = callCount;
    }


    public Long getTimeInMilliSec() {
        return timeInMilliSec;
    }

    public void setTimeInMilliSec(Long timeInMilliSec) {
        this.timeInMilliSec = timeInMilliSec;
    }

    public Long getCallCount() {
        return callCount;
    }

    public void setCallCount(Long callCount) {
        this.callCount = callCount;
    }


    @Override
    public String toString() {
        return "TimeCallCountCell{" +
                "timeInMiliSec=" + timeInMilliSec +
                ", callCount=" + callCount +
                '}';
    }

    public static Comparator<TimeCallCountCell> milliSecComparator = new Comparator<TimeCallCountCell>() {
        public int compare(TimeCallCountCell timeCallCountCell1, TimeCallCountCell timeCallCountCell12) {
            Long cell1 = timeCallCountCell1.getTimeInMilliSec();
            Long cell2 = timeCallCountCell12.getTimeInMilliSec();

            //ascending order
            return cell1.compareTo(cell2);

        }
    };

}
