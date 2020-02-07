
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;

public class Subsets {
    private static int[][] subs;
    private static int k = 0;
    private static void substrings(String s, String t) {
        if (s.length() == 0) {
        	StdOut.println(t);
        	return;
        }
        substrings(s.substring(1), t+s.charAt(0));
        substrings(s.substring(1), t);
    }
    public static void substrings(String s) {
        substrings(s, "");
    }
    public static void subsets(int[] a) {
    	int N = a.length;
    	int s = (int) Math.pow(2, N);
    	subs  = new int[s + 1][];

        ArrayList<Integer> aux = new ArrayList<Integer>();
        subsets(a, aux, 0);
    }
    private static void subsets(int[] a, ArrayList<Integer> aux, int i) {
        if (i == a.length) {
            subs[k] = new int[aux.size()];
            for (int v = 0; v < aux.size(); v++)
                subs[k][v] = aux.get(v);
            StdOut.println(aux);
            k++;
            return;
        }
        ArrayList<Integer> tem = new ArrayList<Integer>();
        for (int v: aux) tem.add(v);

        aux.add(a[i]);
        subsets(a, tem, i+1);
        subsets(a, aux, i+1);
    }
    public static void main(String[] args) {
    	String s = args[0];
    	substrings(s);
    }
}
