import java.util.Comparator;

public class ArrayCell {


    Long kay;
    Long value;

    public ArrayCell() {
    }
    public ArrayCell(Long kay, Long value) {
        this.kay = kay;
        this.value = value;
    }


    public Long getKay() {
        return kay;
    }

    public void setKay(Long kay) {
        this.kay = kay;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "ArrayCell{" +
                "kay=" + kay +
                ", value=" + value +
                '}';
    }

    public static Comparator<ArrayCell> keyComparator = new Comparator<ArrayCell>() {
        public int compare(ArrayCell arrayCell1, ArrayCell arrayCell12) {
            Long cell1 = arrayCell1.getKay();
            Long cell2 = arrayCell12.getKay();

            //ascending order
            return cell1.compareTo(cell2);

            //descending order
            //return cell2.compareTo(cell1);
        }
    };

}
