boolean subarrayWithSum(int[] arr, int target) {
    int start = 0, sum = 0;
    for (int end = 0; end < arr.length; end++) {
        sum += arr[end];
        while (sum > target) sum -= arr[start++];
        if (sum == target) return true;
    }
    return false;
}
