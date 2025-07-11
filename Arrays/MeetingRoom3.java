package Arrays;

import java.util.Arrays;
import java.util.Comparator;

/*
		2402. Meeting Rooms III
*/
public class MeetingRoom3 {

	public int mostBooked(int n, int[][] meets) {

		Arrays.sort(meets, Comparator.comparingInt(m -> m[0]));
		long[] tbu = new long[n];
		int[] rfq = new int[n];
		int mx = -1, mxi = -1;

		for (int[] meet : meets) {
			int st = meet[0];
			int ed = meet[1];
			int dur = ed - st;
			long mn = Long.MAX_VALUE;
			int mni = -1;
			boolean flg = false;

			for (int i = 0; i < n; i++) {
				if (tbu[i] <= st) {
					tbu[i] = ed;
					rfq[i]++;
					flg = true;
					break;
				}

				if (mn > tbu[i]) {
					mn = tbu[i];
					mni = i;
				}
			}

			if (!flg) {
				tbu[mni] += dur;
				rfq[mni]++;
			}
		}

		for (int i = 0; i < n; i++) {
			if (rfq[i] > mx) {
				mx = rfq[i];
				mxi = i;
			}
		}

		return mxi;
	}

}
