package marc.dsa.minim1.part1;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class ReversePolishNotationImpl implements ReversePolishNotation {
    //Passem de String a una Cua
    public int procesar(Operacio operacio){
        Queue<Character> expresio= new LinkedList<Character>();
        Queue<Character> expresio2=new LinkedList<Character>();
        for (char c : operacio.getExpresio().toCharArray()) {
           expresio.add(c);
        }
        for(int i=0;i<expresio.size();i++){
            char a= expresio.poll();
            int num1;
            int num2;
            char res;
            switch(a){
                case '+': ;
                        num1= expresio2.poll();
                        num2= expresio2.poll();
                        res= (char) (num1+num2);
                        expresio2.add(res);
                        break;
                case '-': ;
                    num1= expresio2.poll();
                    num2= expresio2.poll();
                    res= (char) (num1+num2);
                    expresio2.add(res);
                    break;
                case '*': ;
                    num1= expresio2.poll();
                    num2= expresio2.poll();
                    res= (char) (num1+num2);
                    expresio2.add(res);
                    break;
                default:
                    expresio2= new LinkedList<Character>();
                    expresio2.add(a);

            }
        }
        return 0;
    }
}
