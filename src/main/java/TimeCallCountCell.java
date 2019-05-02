import java.util.Comparator;

public class TimeCallCountCell {

    //timeInMiliSec represents call start time or call end time in milliseconds
    Long timeInMiliSec;
    //Start time gets 1 as value and end time gets -1 as value
    Long callCount;

    public TimeCallCountCell() {
    }

    public TimeCallCountCell(Long timeInMiliSec, Long callCount) {
        this.timeInMiliSec = timeInMiliSec;
        this.callCount = callCount;
    }


    public Long getTimeInMiliSec() {
        return timeInMiliSec;
    }

    public void setTimeInMiliSec(Long timeInMiliSec) {
        this.timeInMiliSec = timeInMiliSec;
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
                "timeInMiliSec=" + timeInMiliSec +
                ", callCount=" + callCount +
                '}';
    }

    public static Comparator<TimeCallCountCell> milliSecComparator = new Comparator<TimeCallCountCell>() {
        public int compare(TimeCallCountCell timeCallCountCell1, TimeCallCountCell timeCallCountCell12) {
            Long cell1 = timeCallCountCell1.getTimeInMiliSec();
            Long cell2 = timeCallCountCell12.getTimeInMiliSec();

            //ascending order
            return cell1.compareTo(cell2);

        }
    };

}
