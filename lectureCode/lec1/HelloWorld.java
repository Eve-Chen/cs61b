public class DrawTriangle {
    public static void main(String[] args) {
        int row=1;
        int num=1;
        int ast=1;
        while (row<=5){  
            while (ast<=num){
                System.out.printIn("*");
                ast=ast+1;                
            }
            row=row+1;
            num=num+1;
            ast=1;
        }
    }
}

