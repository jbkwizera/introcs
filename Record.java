class Record implements Comparable<Record>{
	private final String key;
	private final String val;
	
	public Record(String k, String v) {
		key = k;
		val = v;
	}
	public String key() { return key; }
	public String val() { return val; }
	
	public int compareTo(Record b) {
		if 		(val.compareTo(b.val) > 0) return +1;
		else if	(val.compareTo(b.val) < 0) return -1;
		else                               return  0;
	}
	public String toString() {
		return key + ": " + val;
	}
}
	
