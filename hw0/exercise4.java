public class exercise4 {//breakcontinue
    public static void windowPosSum(int[] a, int n) {
        /** your code here */
        int i=0;
        int j=0;
        for(i=0;i<a.length;i++)
        {
            if(a[i]<0){
                continue;
            }
            int sum=a[i];
            for(j=i+1;j<=i+n;j++)
            {
                if(j<a.length){
                    sum+=a[j];
                }
                else{
                    break;
                }
            }
            a[i]=sum;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, -3, 4, 5, 4};
        int n = 3;
        windowPosSum(a, n);

        // Should print 4, 8, -3, 13, 9, 4
        System.out.println(java.util.Arrays.toString(a));
    }
}