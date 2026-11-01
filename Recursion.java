import java.util.*;

class main{
    static void nonRec(int n){
        int a = 0 , b = 1;

        System.out.print("Recursive: ");
        for(int i = 0 ; i < n ; i++){
            System.out.print(a + " ");
            int c = a + b;
            a = b;
            b = c;
        }
        System.out.println();
    }

    static int Rec(int n){
        // Base Condition
        if(n <= 1){
            return n;
        }

        return Rec(n - 1) + Rec(n - 2);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Number : ");
        int n = sc.nextInt();

        nonRec(n);

        System.out.println();

        System.out.print("Recursive: ");

        for(int i = 0 ; i < n ; i++){
            System.out.print(Rec(i) + " ");
        }
    }
}