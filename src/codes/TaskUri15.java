package codes;

import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.SortedSet;
import java.util.Iterator;
import java.util.Collection;
import java.util.Scanner;
import java.util.Set;
import java.util.Deque;
import java.util.TreeSet;
import java.util.LinkedList;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Emmanuell
 */
public class TaskUri15 {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n, k;


        int debug_teste = 0;
        while (true) {
            Deque<Schedule> parking = new LinkedList<>();
            boolean ok = true;
            n = in.nextInt();
            k = in.nextInt();
            if ((n == k) && (n == 0)) {
                break;
            }
            debug_teste++;
            if (debug_teste == 3) {
                boolean t = true;
            }
            int begin, end;
            for (int i = 0; i < n; i++) {
                begin = in.nextInt();
                end = in.nextInt();
                int time = 0;
//                remove all the cars after add one new, if one stays longer you must print nao
                while (!parking.isEmpty() && parking.getLast().end <= begin) {
                    if (parking.getLast().end < time) {
                        ok = false;
                    }
                    time = parking.getLast().end;
                    parking.remove(parking.getLast());
                }
                if (parking.size() >= k) {
                    ok = false;
                }
                parking.addLast(new Schedule(begin, end));
            }
            if (ok) {
                Iterator<Schedule> it = parking.descendingIterator();
                int exitTime = it.next().end;
                while (it.hasNext()) {
                    int compareTime = it.next().end;
                    if (exitTime >= compareTime) {
                        ok = false;
                        break;
                    }
                    exitTime = compareTime;
                }
            }
            if (!ok) {
                out.println("Nao");
            } else {
                out.println("Sim");
            }
            parking.clear();
        }
    }

    class Schedule implements Comparable {
        int start;
        int end;

        public Schedule(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public String toString() {
            return "Schedule{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }

        public int compareTo(Object o) {
            Schedule s = (Schedule) o;
            return this.start - s.start;
        }
    }
}


