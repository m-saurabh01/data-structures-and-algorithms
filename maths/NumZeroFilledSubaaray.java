package Maths;


/*
		2348. Number of Zero-Filled Subarrays
*/
public class NumZeroFilledSubaaray {

	public long zeroFilledSubarray(int[] nums) {
		long res = 0;
		int i = 0;

		while (i < nums.length) {

			long temp = 0;

			if (nums[i] == 0) {
				int j = i;
				while (j < nums.length && nums[j] == 0) {
					temp += (j - i + 1);
					j++;
				}

				i = j;
				res += temp;
			}

			i++;

		}

		return res;
	}

}
