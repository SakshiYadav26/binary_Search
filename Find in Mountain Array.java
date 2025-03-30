// https://leetcode.com/problems/find-in-mountain-array/description/ --hard
/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray a) {
        int  start = 0;int end = a.length() - 1;int mid = 0;
        while (start != end){
            mid = start + (end - start)/2;
            if (a.get(mid) >= a.get(mid+1)){
                end = mid;
            } else{
                start = mid+1;
            }
        }
        return FindElementAssending(a,target,start) != -1 ? FindElementAssending(a,target,start) : FindElementDesending(a,target,start+1);
    }

    public static int FindElementAssending(MountainArray arr, int target ,int end) {
        int start = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < arr.get(mid)) {
                end = mid - 1;
            } else if (target > arr.get(mid)) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int FindElementDesending(MountainArray arr, int target ,int start){
        int end = arr.length() - 1;
        while (start <= end){
            int mid = start + (end - start)/2;
            if (arr.get(mid) > target) {
                start = mid+1;
            } else if (arr.get(mid) < target) {
                end = mid-1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
