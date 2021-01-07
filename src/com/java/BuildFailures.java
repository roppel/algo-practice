package com.java;
/*
Given a history of project build runs and their pass/fail instances,
where every build history starts with at least one pass and ends with at least one fail,
and all your passing builds happen before failures (no alternating pass/fail records),
return a value representing the longest number of strictly decreasing instances, inclusive.

In the following example, you will return 3:
ar[1] passes 80%, ar[2] passes 66%, and ar[3] passes 16%.

If you don't have any strictly decreasing instances of build runs, return -1.

 */
class BuildFailures {
    public static void main(String[] args) {
        System.out.println(buildFailures(new boolean[][]{
              {true, true, true, false, false},
              {true, true, true, true, false},
              {true, true, true, true, true, true, false, false, false},
              {true, false, false, false, false, false},
              {
                      true, true, true, true, true, true, true,
                      true, true, true, true, true, false
              },
              {true, false},
              {true, true, true, true, false, false}
      }));
    }
    public static int buildFailures(boolean[][] buildRuns) {
        int decreasingCount = 0;
        int maxDecreasing = 0;
        double prevPercentage = 0;
        for (boolean[] run : buildRuns) {
            int count = binarySearch(run);
            int len = run.length;


            double percentage = (double)count/(double)len;
            if (percentage < prevPercentage) {
                decreasingCount++;
                if (decreasingCount > maxDecreasing) {
                    maxDecreasing = decreasingCount;
                }
            } else {
                decreasingCount = 0;
            }
            prevPercentage = percentage;
        }
        if (maxDecreasing == 0) return -1;
        return maxDecreasing+1;

    }
    static int binarySearch(boolean[] ar) {
        int left = 0, right = ar.length, mid = right/2;
        while (left <= right) {
            if (ar[mid] == true && ar[mid+1] == false) return mid+1;
            if (ar[mid] == true) {
                left = mid;
            } else {
                right = mid;
            }
            mid = (left+right)/2;

        }
        return mid+1;
    }
}
