class Solution:
    def twoSum(self, nums, target):
        for i in range(0, len(nums) - 1):
            for j in range(i + 1, len(nums)):
                if nums[i] + nums[j] == target:
                    return [i, j]

    print(twoSum([3, 2, 4], 6))
