package marc.dsa.minim1.part1;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestReversePolishNotation {


    @org.junit.Test
    public void test1(){
        Operacio operacio= new Operacio("5 1 2 + 4 * + 3 -");
        ReversePolishNotationImpl reversePolish = new ReversePolishNotationImpl();
        int res = reversePolish.procesar(operacio);
        assertEquals(0,res);
    }


}
