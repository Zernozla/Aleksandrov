public class Main {
    public static void main(String[] args)
    {
        int i;
        for(i=1; i<=500; i++)
        {
            if(i%5!=0 && i%7!=0){
                System.out.println(i);
            }
            else {
                if (i % 5 == 0) {
                    System.out.println("fizz");
                }
                if (i % 7 == 0) {
                    System.out.println("buzz");
                }
            }
            System.out.println();
        }
    }
}
