package medium;

import java.util.ArrayList;
import java.util.List;

/*
    There are 8 prison cells in a row, and each cell is either occupied or vacant.

    Each day, whether the cell is occupied or vacant changes according to the following rules:

    If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
    Otherwise, it becomes vacant.
    (Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.)

    We describe the current state of the prison in the following way: cells[i] == 1 if the i-th cell is occupied, else cells[i] == 0.

    Given the initial state of the prison, return the state of the prison after N days (and N such changes described above.)
 */
public class PrisonCellsAfterNDays {

    public static void main(String... args) {

        int[] cells = {0, 1, 0, 1, 1, 0, 0, 1};
        PrisonCellsAfterNDays prisonCellsAfterNDays = new PrisonCellsAfterNDays();
        System.out.println(prisonCellsAfterNDays.prisonAfterNDays(cells, 7));
    }

    public int[] prisonAfterNDays(int[] cells, int N) {

        boolean[] t = new boolean[256];
        List<int[]> list = new ArrayList<>();
        int[] a = {128, 64, 32, 16, 8, 4, 2, 1};
        list.add(cells);
        int n = 1;

        while (true) {

            int s = 0;
            int[] b = new int[8];
            int[] c = list.get(n-1);

            for (int i = 1; i <= 6; i++)
                if (c[i-1] == c[i+1]) {
                    b[i] = 1;
                    s += a[i];
                }

            if (t[s]) return list.get(1 + (N-1) % (n-1));
            t[s] = true;
            list.add(b);
            n++;
        }
    }

}
