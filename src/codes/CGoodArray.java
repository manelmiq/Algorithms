package codes;



import javax.swing.*;
import java.util.*;
import java.io.PrintWriter;

public class CGoodArray {


    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] nums = new int[200001];
        int[] map = new int[1000010];
        int[] ans = new int[200001];
        int cont_ans = 0;
        Long sum = 0L;
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            map[a]++;
            nums[i] = a;
            sum += a;
        }
        for (int i = 0; i < n; i++) {
            sum -= nums[i];
            map[nums[i]]--;
            Long search =   sum / 2;
            if (search <= 1000000) {
                if (sum % 2 == 0 && map[(int)(long)search] > 0) {
                    ans[cont_ans++] = i + 1;
                }
            }
            sum += nums[i];
            ++map[nums[i]];
        }
        out.println(cont_ans);
        for (int i = 0; i < cont_ans; i++) {
            if (i > 0) out.print(" ");
            out.print(ans[i]);
        }

    }
}
