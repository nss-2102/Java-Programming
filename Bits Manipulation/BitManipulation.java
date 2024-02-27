import java.util.*;
public class BitManipulation {

    static boolean checkSetBit(int N, int i){
        /*
            A bit is said to be a set bit, if it is "1".
            This function checks if the ith bit of number N, is a set bit.
            We right shift i number of bits on number N, and check if it is 1 or 0.
            If set bit, it returns true, else returns false.
         */
        return (((N>>i)&1)==1);
    } 

    static int countSetBits(int N){
        /*
            This function aims to count number of set bits present in the number N.
            We check, if the last bit of number N is 1, iteratively, by right shifiting
            the each bit of number N.
         */
        int count=0;  
        while (N!=0){
            if ((N&1)==1){
                count++;
            }
            N = N>>1;
        }
        return count;
    }

    static int findNumberForSetBits(int i, int j){
        /*
            This program aims to find the number with ith and jth bits being set bits.
            We use left shift operator to shift 1 bit, i number of times and then j number
            of times.
         */
        return ((1<<i)|(1<<j));
    }

    static int findNumberForRangeOfSetBits(int i, int j){
        /*
            This program aims to find the number containing i number of set bits,
            starting from jth bit.
            We use left shift operator to shift 1 bit, starting from jth bit,
            till i number of set bits are added.
         */
        int N=0;
        for (int b=j;b<i+j;b++){
           N = (N|(1<<b));
        }
        return N;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        try{  
            int N,i,j,choice; 
            do{
                System.out.print("Choose from below:\n\t1.Check Set Bit\n\t2.Count Number of Set Bits\n\t");
                System.out.print("3.Find Number for ith and jth bit being set bits\n\t");
                System.out.print("4.Find Number for i number of set bits, starting from jth bit\n\t");
                System.out.println("Press '5' to terminate");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter Number : ");
                        N = sc.nextInt();
                        System.out.print("Enter ith bit : ");
                        i = sc.nextInt();
                        if (N>0){
                            if (checkSetBit(N, i)){
                                System.out.println("Set Bit");
                            }
                            else{
                                System.out.println("Not a set bit");
                            }
                        }
                        break;
                    case 2:
                        System.out.print("Enter Number : ");
                        N = sc.nextInt();
                        if (N>0){
                            System.out.println("Number of setbits:"+countSetBits(N));
                        }
                        break;
                    case 3:
                        System.out.print("Enter ith bit: ");
                        i = sc.nextInt();
                        System.out.print("Enter jth bit: ");
                        j = sc.nextInt();
                        System.out.println("Number : " + findNumberForSetBits(i, j));
                        break;
                    case 4:
                        System.out.print("Enter i value: ");
                        i = sc.nextInt();
                        System.out.print("Enter jth bit: ");
                        j = sc.nextInt();
                        System.out.println("Number : " + findNumberForRangeOfSetBits(i, j));
                        break;
                    default:
                        break;
                }
            }while(choice>0 && choice<5);
            
        }
        catch(Exception e){
            System.out.println("Invalid");
        }
        finally{
            sc.close();
        }
    }
    
}
