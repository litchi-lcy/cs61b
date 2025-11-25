public class 1bTriangleDrawer {
    public static void drawTriangle(int N) {
        int col=0;
        int row=0;
        while(row<N){
            col=0;
            while(col<=row){
                System.out.print("*");
                col++;
            }
            row++;
            System.out.println(" ");
        }


    }


    public static void main(String[] args) {
        drawTriangle(5);
    }
}