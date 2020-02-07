public class MMatrix {
    public static void main(String[] args) {
        int[][] coords = {{ 22, 22 }, { 22, 55 }, { 55, 76 }, { 76, 29 }};
        System.out.println(checkRec(coords));
    }
    public static int checkRec(int[][] coords) {
        if (coords.length == 2) {
            return 0;
        }
        int max = 0;
        int l = -1;
        for (int j = 0; j < coords.length - 1; j++) {
            if (coords[j][1] > max) {
                max = coords[j][1];
                l = j;
            }
        }
        int most = recurM(coords, l) + checkRec(reOrder(coords, l));

        long min = 200000000;
        int k = -1;
        for (int j = 0; j < coords.length - 1; j++) {
            if (coords[j][0] * coords[j + 1][1] < min) {
                min = coords[j][0] * coords[j + 1][1];
                k = j;
            }
        }
        int little = 0;
        if (k != l) little = recurM(coords, k) + checkRec(reOrder(coords, k));
        else        little = most;

        int back;
        if (most < little)  back = most;
        else                back = little;
        return back;
    }

    public static int recurM(int[][] coords, int l) {
        return coords[l][0] * coords[l + 1][1];
    }

    public static int[][] reOrder(int[][] coords, int l) {
        int[][] temp = new int[coords.length - 1][2];
        for (int k = 0, g = 0; k < temp.length; k++, g++) {
            if (k == l) {
                temp[k][0] = coords[g][0];
                temp[k][1] = coords[g + 1][1];
                g++;
            } else {
                temp[k][0] = coords[g][0];
                temp[k][1] = coords[g][1];
            }
        }
        return temp;
    }

    /*
     * SECOND EFFORT! EASY EXAMPLE NO WORK public static void
     * checkCo2(int[][]coords) { if(coords.length == 2) { System.out.println(0); }
     * int sum = 0; for (int i = coords.length; i > 2; i --) { int max = 0; int l =
     * -1; for (int j = 0; j < coords.length-1; j ++) { if(coords[j][1] > max) { max
     * = coords[j][1]; l = j; } }
     *
     *
     * System.out.println(coords[l][1] + "\t" + l); sum += coords[l][0] *
     * coords[l+1][1]; int[][] temp = new int[coords.length-1][2]; for(int k = 0, g
     * = 0; k < temp.length; k++, g++) { if(k == l) { temp[k][0] = coords[g][0];
     * temp[k][1] = coords[g+1][1]; g++; }else { temp[k][0] = coords[g][0];
     * temp[k][1] = coords[g][1]; } } coords = temp; } System.out.println("\n\n" +
     * sum); }
     *
     *
     * /* FIRST EFFORT! DOES NOT WORK FOR LAST EXAMPLE public static void
     * checkCo(int [][] coords) { if(coords.length == 2) { System.out.println(0); }
     * int sum = 0; for (int i = coords.length; i > 2; i --) { long min = 200000000;
     * int l = -1; for (int j = 0; j < coords.length-1; j ++) { if(coords[j][0] *
     * coords[j+1][1] < min) { min = coords[j][0] * coords[j+1][1]; l = j; } }
     *
     *
     * System.out.println(min + "\t" + l); sum += min; int[][] temp = new
     * int[coords.length-1][2]; for(int k = 0, g = 0; k < temp.length; k++, g++) {
     * if(k == l) { temp[k][0] = coords[g][0]; temp[k][1] = coords[g+1][1]; g++;
     * }else { temp[k][0] = coords[g][0]; temp[k][1] = coords[g][1]; } } coords =
     * temp; } System.out.println("\n\n" + sum); }
     */

}
