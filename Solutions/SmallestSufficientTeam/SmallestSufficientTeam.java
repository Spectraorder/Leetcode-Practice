package Solutions.SmallestSufficientTeam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 2023/7/15
 *
 * @author Daniel Atlas
 */
public class SmallestSufficientTeam {
    public static int n;
    public static int skillsMaskOfPerson[];
    public static long[] dp;
    public static void main(String[] args) {
        String[] req_skills = {"java","nodejs","reactjs"};
        List<String> one = new ArrayList<>();
        List<String> two = new ArrayList<>();
        List<String> three = new ArrayList<>();
        List<List<String>> people = new ArrayList<>();
        one.add("java");
        two.add("nodejs");
        three.add("nodejs");
        three.add("reactjs");
        people.add(one);
        people.add(two);
        people.add(three);
        System.out.println(Arrays.toString(smallestSufficientTeam(req_skills, people)));
    }
    public static Long f(int skillsMask) {
        if (skillsMask == 0) {
            return 0L;
        }
        if (dp[skillsMask] != -1) {
            return dp[skillsMask];
        }
        for (int i = 0; i < n; i++) {
            int smallerSkillsMask = skillsMask & ~skillsMaskOfPerson[i];
            if (smallerSkillsMask != skillsMask) {
                long peopleMask = f(smallerSkillsMask) | (1L << i);
                if (dp[skillsMask] == -1 || Long.bitCount(peopleMask) <
                        Long.bitCount(dp[skillsMask])) {
                    dp[skillsMask] = peopleMask;
                }
            }
        }
        return dp[skillsMask];
    }

    public static int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        n = people.size();
        int m = req_skills.length;
        HashMap<String, Integer> skillId = new HashMap<String, Integer>();
        for (int i = 0; i < m; i++) {
            skillId.put(req_skills[i], i);
        }
        skillsMaskOfPerson = new int[n];
        for (int i = 0; i < n; i++) {
            for (String skill : people.get(i)) {
                skillsMaskOfPerson[i] |= 1 << skillId.get(skill);
            }
        }
        dp = new long [1 << m];
        Arrays.fill(dp, -1);
        long answerMask = f((1 << m) - 1);
        int ans[] = new int [Long.bitCount(answerMask)];
        int ptr = 0;
        for (int i = 0; i < n; i++) {
            if (((answerMask >> i) & 1) == 1) {
                ans[ptr++] = i;
            }
        }
        return ans;
    }
}
