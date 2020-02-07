
import java.util.Arrays;
import java.util.Comparator;
public class Trans implements Comparable<Trans> {
    private final String what;		// product's name
    private final String type;		// product's type
    private final int    qty;		// quantity
    private final Date   date;		// day
    private final Time   time;		// time
    private final double amount;   	// amount
    private final String who;		// customer's name
    private final String phone;		// customer's phone
    private final String sex;		// customer's sex
    private final int    age;		// customer's age
    private final String reason;		// reason

    public Trans(String transaction) {
        String[] a = transaction.split(",");
        date   = new Date(a[0]);
        time   = new Time(a[1]);
        what   = a[2];
        qty    = Integer.parseInt(a[3]);
        amount = Double.parseDouble(a[4]);
        type   = a[5];
        who    = a[6];
        phone  = a[7];
        age    = Integer.parseInt(a[8]);
        sex    = a[9];
        reason = a[10];
        if (Double.isNaN(amount) || Double.isInfinite(amount))
            throw new IllegalArgumentException("Amount cannot be NaN or " +
            	"infinite");
    }
    public String what()	{	return what;	    }
    public String type()	{	return type;    	}
    public int qty()	    {return qty;        	}
    public Date date()	{	return date;    	}
    public Time time()	{ 	return time;    	}
    public String who()	{	return who;		}
    public String sex()	{ 	return sex;		}
    public int age()		{ 	return age;		}
    public String phone()	{	return phone;	}
    public double amount()	{	return amount;	}
    public String reason()	{ 	return reason;	}

    @Override
    public String toString() 
	{	return String.format("%-10s %-14s %10s %8.2f", who, what, date, amount);	}

	@Override
    public int compareTo(Trans that) 
	{	return Double.compare(this.amount, that.amount);	}    

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (other.getClass() != this.getClass()) return false;
        Trans that = (Trans) other;
        return (this.amount == that.amount) && 
               (this.who.equals(that.who))  && 
               (this.date.equals(that.date));
    }

    public int hashCode() {
        int hash = 1;
        hash = 31*hash + who.hashCode();
        hash = 31*hash + date.hashCode();
        hash = 31*hash + ((Double) amount).hashCode();
        return hash;
        // return Objects.hash(who, date, amount);
    }
	
	// Compares two transactions by customers.
    public static class WhoOrder implements Comparator<Trans> {
        @Override
        public int compare(Trans v, Trans w) 
        {	return v.who.compareTo(w.who);	}
    }

    //Compares two transactions by date.
    public static class WhenOrder implements Comparator<Trans> {
        @Override
        public int compare(Trans v, Trans w) 
        {	return v.date.compareTo(w.date);		}
    }

    // Compares two transactions by amount.
    public static class HowMuchOrder implements Comparator<Trans> {
        @Override
        public int compare(Trans v, Trans w) 
        {	return Double.compare(v.amount, w.amount);	}
    }
    
    // Compares two transactions by product.
    public static class WhatOrder implements Comparator<Trans> {
    		@Override
    		public int compare(Trans v, Trans w)
    		{	return v.what.compareTo(w.what);		}
    	}

    /**
     * Unit tests the {@code Transaction} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        
        String[] records = StdIn.readAllLines();
        int N = records.length;
        Trans[] a = new Trans[N];
        for (int i = 0; i < N; i++)
        		a[i] = new Trans(records[i]);
        	
        	Arrays.sort(a, new Trans.WhatOrder());
        	for (Trans t : a)	StdOut.println(t);
        	
        	double max = 0.0;
        	double[] v = new double[N];
        	for (int i = 0; i < N; i++) {
        		v[i] = a[i].amount();
        		if (v[i] > max) 
        			max = v[i];
        	}
        	StdDraw.setYscale(-100, max + 100);
        	StdDraw.setXscale(-1, N);
        	StdStats.plotBars(v);
    }
}
