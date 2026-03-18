import static java.lang.Integer.MAX_VALUE;
import static java.lang.Math.max;
import static java.lang.Math.min;

class OptimalPool {

    public static int[] calculateDepth(int[] a) {
        var maxArea = 0;
        var minArea = MAX_VALUE;
        var minDist = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                var dist = j - i;
                var minHeight = min(a[i], a[j]);
                var area = minHeight * dist;
                maxArea = max(maxArea, area);
                minArea = min(minArea, area);
                minDist = min(minDist, dist);
            }
        }

        return new int[]{maxArea, minArea};
    }

    public static void main(String[] args) {
        int a[] = {1, 5, 4, 3};
        int b[] = {3, 1, 2, 4, 5};
        int c[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int d[] = {3, 1, 2, 4, 5, 8};

        System.out.println(calculateDepth(a)[0] + " " + calculateDepth(a)[1]);
        System.out.println(calculateDepth(b)[0] + " " + calculateDepth(b)[1]);
        System.out.println(calculateDepth(c)[0] + " " + calculateDepth(c)[1]);
        System.out.println(calculateDepth(d)[0] + " " + calculateDepth(d)[1]);
    }
}
