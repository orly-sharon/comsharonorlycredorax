public class MaxTime {

    Long startMaxTime;
    Long endMaxTime;

    public MaxTime(Long startMaxTime, Long endMaxTime) {
        this.startMaxTime = startMaxTime;
        this.endMaxTime = endMaxTime;
    }


    public Long getStartMaxTime() {
        return startMaxTime;
    }

    public void setStartMaxTime(Long startMaxTime) {
        this.startMaxTime = startMaxTime;
    }

    public Long getEndMaxTime() {
        return endMaxTime;
    }

    public void setEndMaxTime(Long endMaxTime) {
        this.endMaxTime = endMaxTime;
    }

    @Override
    public String toString() {
        return "MaxTime{" +
                "startMaxTime=" + startMaxTime +
                ", endMaxTime=" + endMaxTime +
                '}';
    }


}
