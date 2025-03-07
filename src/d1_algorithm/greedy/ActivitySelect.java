package d1_algorithm.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ActivitySelect {
    public static void main(String[] args) {
        Activity[] activities = {
                new Activity(0, 2, 3),
                new Activity(1, 1, 4),
                new Activity(2, 5, 6),
                new Activity(3, 3, 5)
        };
        Arrays.sort(activities, Comparator.comparing(Activity::getFinish));
        select(activities);
    }

    //有n个活动,每个活动有开始和结束时间,如何举办最多的活动
    //贪心思路,先按照最晚结束时间排序,然后每次选与最初重叠时间最短的活动
    private static void select(Activity[] activities) {
        List<Activity> result = new ArrayList<>();
        Activity prev = activities[0];
        result.add(prev);
        for (Activity curr : activities) {
            if (curr.start >= prev.finish) {
                result.add(curr);
                prev = curr;
            }
        }
        System.out.println(result);

    }

    private static class Activity {
        int index;
        int start;
        int finish;

        public Activity(int index, int start, int finish) {
            this.index = index;
            this.start = start;
            this.finish = finish;
        }

        public int getFinish() {
            return finish;
        }

        @Override
        public String toString() {
            return "Activity " + index ;
        }
    }


}
