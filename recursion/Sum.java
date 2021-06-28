package recursion;

public class Sum {

    public static int sum(int[] arr){
        return sum(arr,0);
    }
    //计算l到n的和
    public static  int sum(int[] arr,int l){
        if (l==arr.length){
            return 0;
        }
        return arr[l]+sum(arr,l+1);
    }

    public static void main(String[] args) {
        int[] arr ={2,3,4,2,1,4,13,2};
        int sum = sum(arr, 3);
        System.out.println(sum);
    }
}
