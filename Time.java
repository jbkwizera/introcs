
import java.util.Comparator;
public class Time implements Comparable<Time> {
	private final int    hour;
	private final int minutes;
	private final int seconds;

	public Time(String time) {
		String[] a = time.split(":");
		hour    = Integer.parseInt(a[0]);
		minutes = Integer.parseInt(a[1]);
		seconds = Integer.parseInt(a[2]);
	}

	public Time(int hour, int minutes, int seconds) {
		this.hour    = hour;
		this.minutes = minutes;
		this.seconds = seconds;
	}

	public int hour()	{ 	return hour;	}
	public int minutes(){	return minutes;	}
	public int seconds(){	return seconds;	}

	@Override
	public int compareTo(Time that) {
		long this_ = this.hour*3600 + this.minutes*60 + this.seconds;
		long that_ = that.hour*3600 + that.minutes*60 + that.seconds;
		if (this_ > that_) return +1;
		if (this_ < that_) return -1;
		else	               return  0;
	}

	@Override
	public boolean equals(Object that) {
		if (that == this) return true;
		if (that == null) return false;
		if (that.getClass() != this.getClass()) return false;

		Time that_ = (Time) that;
		return compareTo(that_) == 0;
	}

	@Override
	public String toString() {
		String s = "";
		s = hour    < 10? s + "0" + hour    + ":": s + hour    + ":";
		s = minutes < 10? s + "0" + minutes + ":": s + minutes + ":";
		if (seconds < 10) return s + "0" + seconds;
		return s + seconds;
	}
	public static void main(String[] args) {

	}
}
