package com.codegik.poc.billionaires;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {


	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length;
		List<List<Integer>> result = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			// duplicated ones
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			int left = i + 1;
			int right = n - 1;

			while (left < right) {
				int threeSum = nums[i] + nums[left] + nums[right];

				if (threeSum == 0) {
					result.add(Arrays.asList(nums[i], nums[left], nums[right]));
					left++;

					// duplicated ones
					while (left < right && nums[left] == nums[left - 1]) {
						left++;
					}
				} else if (threeSum < 0) {
					left++;
				} else {
					right--;
				}
			}
		}

		return result;
	}

}
