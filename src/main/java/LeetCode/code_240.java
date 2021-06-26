package LeetCode;

//编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
//        每行的元素从左到右升序排列。
//        每列的元素从上到下升序排列。


public class code_240 {
    private boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length-1;
        int col = 0;

        while (row >= 0 && col <matrix.length){
            if (matrix[row][col] > target)
                row--;
            else if (matrix[row][col] < target)
                col++;
            else
                return true;
        }
        return false;
    }

    private boolean binarySearch(int[][] arr, int target, int start, boolean vertical){
        int low = start;
        int high = vertical ? arr[0].length-1 : arr.length-1;

        while (high >= low){
            int mid = (high + low) / 2;
            if (vertical){
                if (arr[start][mid] < target)
                    low = mid + 1;
                else if (arr[start][mid] > target)
                    high = mid - 1;
                else
                    return true;
            }
            else {
                if (arr[mid][start] < target)
                    low = mid + 1;
                else if (arr[mid][start] > target)
                    high = mid - 1;
                else
                    return true;
            }
        }
        return false;
    }

    //二分搜索法
    private boolean searchMatrix_1(int[][] matrix, int target){
        if (matrix == null || matrix.length == 0)
            return false;

        for (int i = 0; i < Math.min(matrix.length,matrix[0].length); i++) {
            boolean vec = binarySearch(matrix,target,i,true);
            boolean hor = binarySearch(matrix,target,i,false);
            if (vec || hor)
                return true;
        }
        return false;
    }
}
