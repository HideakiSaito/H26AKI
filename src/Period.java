import java.util.Date;

public final class Period {
    private static final Date EPOCH = new Date(0L);
    private final Date        start, end;

    public Period(Date start, Date end) {
        if (start == null || end == null) {
            throw new NullPointerException();
        }
        if (start.compareTo(EPOCH) < 0 || end.compareTo(EPOCH) < 0) {
            throw new IllegalArgumentException();
        }
        this.start = start;
        this.end = end;
    }

    public Date getStart() {
        //F
        return (Date) start.clone();
        //return start;
    }

    public Date getEnd() {
        return end;
    }

    public long getLength() {
        return end.getTime() - start.getTime();
    }

    public boolean isBackward() {
        return end.compareTo(start) < 0;
    }

    public boolean contains(Date time) {
      return (time.compareTo(start) >= 0 && time.compareTo(end) < 0) 
          || (time.compareTo(start)  <= 0 && time.compareTo(end)  > 0);
   }
}
