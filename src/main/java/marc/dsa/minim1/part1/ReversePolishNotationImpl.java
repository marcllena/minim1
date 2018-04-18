package marc.dsa.minim1.part1;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class ReversePolishNotationImpl implements ReversePolishNotation {
    //Passem de String a una Cua
    public int procesar(Operacio operacio){
        Queue<Character> expresio= new LinkedList<Character>();
        Stack<Integer> expresio2=new Stack<Integer>();
        for (char c : operacio.getExpresio().toCharArray()) {
           expresio.add(c);
        }
        for(int i=0;i<expresio.size();i++){
            char a= expresio.poll();
            expresio.poll();
            int num1;
            int num2;
            int res;
            switch(a){
                case '+': ;
                        num1= expresio2.pop();
                        num2= expresio2.pop();
                        res= num1+num2;
                        expresio2.add(res);
                        break;
                case '-': ;
                    num1= expresio2.pop();
                    num2= expresio2.pop();
                    res= (char) (num1+num2);
                    expresio2.add(res);
                    break;
                case '*': ;
                    num1= expresio2.pop();
                    num2= expresio2.pop();
                    res= (char) (num1+num2);
                    expresio2.add(res);
                    break;
                default:
                    int numa= Character.getNumericValue(a);
                    expresio2.add(numa);

            }
        }

        return 0;
    }
}
