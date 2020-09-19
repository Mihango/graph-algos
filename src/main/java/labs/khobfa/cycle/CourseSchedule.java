package labs.khobfa.cycle;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> courses = new HashMap<>();

        for (int[] edge : prerequisites) {
            if (courses.containsKey(edge[1])) {
                courses.get(edge[1]).add(edge[0]);
            } else {
                List<Integer> nextCourse = new LinkedList<>();
                nextCourse.add(edge[0]);
                courses.put(edge[1], nextCourse);
            }
        }

        boolean[] path = new boolean[numCourses];

        for (int currCourse = 0; currCourse < numCourses; currCourse++) {
            if (isCyclic(currCourse, courses, path))
                return false;
        }
        return true;
    }

    private boolean isCyclic(Integer currCourse, Map<Integer, List<Integer>> courses, boolean[] path) {
        if (path[currCourse]) return true;
        if (!courses.containsKey(currCourse)) return false;

        path[currCourse] = true;
        boolean ret = false;

        for (int nextCourse : courses.get(currCourse)) {
            ret = isCyclic(nextCourse, courses, path);
            if (ret) break;
        }
        path[currCourse] = false;
        return ret;
    }

    public static void main(String[] args) {
        CourseSchedule can = new CourseSchedule();
        System.out.println(can.canFinish(2, new int[][]{
                {1, 0}
        }));
    }
}
