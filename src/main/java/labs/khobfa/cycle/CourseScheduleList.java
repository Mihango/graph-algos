package labs.khobfa.cycle;

import java.util.*;

public class CourseScheduleList {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int[] pre : prerequisites) {
            if (map.containsKey(pre[1])) {
                map.get(pre[1]).add(pre[0]);
            } else {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(pre[0]);
                map.put(pre[1], list);
            }
        }

        boolean[] checked = new boolean[numCourses];
        boolean[] inPath = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (isCyclic(map, i, checked, inPath, stack))
                return new int[0];
        }

        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = stack.pop();
        }
        return result;
    }

    private boolean isCyclic(Map<Integer, List<Integer>> map, int course, boolean[] visited,
                             boolean[] inPath, Stack<Integer> stack) {
        if (visited[course]) return false;
        if (inPath[course]) return true;

        if (!map.containsKey(course)) {
            visited[course] = true;
            inPath[course] = false;
            stack.push(course);
            return false;
        }

        inPath[course] = true;
        boolean cyclic = false;

        for (int i : map.get(course)) {
            cyclic = isCyclic(map, i, visited, inPath, stack);
            if (cyclic) break;
        }

        visited[course] = true;
        inPath[course] = false;
        stack.push(course);
        return cyclic;
    }

    public static void main(String[] args) {
        CourseScheduleList scheduleList = new CourseScheduleList();
        System.out.println(Arrays.toString(scheduleList.findOrder(2, new int[][] { {1, 0}})));
    }
}
