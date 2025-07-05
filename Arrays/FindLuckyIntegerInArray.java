package Arrays;

/*
		1394. Find Lucky Integer in an Array
*/
public class FindLuckyIntegerInArray {

	public int findLucky(int[] arr) {

		int res = -1;

		int[] nums = new int[501];

		for (int a : arr) {
			nums[a]++;

		}

		for (int a : arr) {
			if (nums[a] == a) {
				res = Math.max(res, a);
			}
		}

		return res;

	}

}
