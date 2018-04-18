package marc.dsa.minim1.part1;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class TestMathManager {
    MathManagerImpl mathManager;
    Alumne alumne;
    Institut institut;
    Operacio operacio;


    @org.junit.Before
    public void setUp(){
        mathManager = MathManagerImpl.getInstance();
        alumne=new Alumne("Marc");
        List<Alumne> alumnes= new LinkedList<Alumne>();
        alumnes.add(alumne);
        institut= new Institut("UPC",alumnes);
        mathManager.afagirInstitut(institut);
    }

    @org.junit.Test
    public void test1(){
        Operacio operacio= new Operacio("2x0");
        int res = mathManager.realitzarOperacio(operacio,"Marc","UPC");
        assertEquals(0,res);
        res = mathManager.realitzarOperacio(operacio,"Pepe","UPC");
        assertEquals(-1,res);
        res = mathManager.realitzarOperacio(operacio,"Marc","EETAC");
        assertEquals(-1,res);
    }

    @org.junit.Test
    public void test2(){
        Operacio operacio= new Operacio("2x0");
        int res = mathManager.realitzarOperacio(operacio,"Marc","UPC");
        assertEquals(0,res);
        res=mathManager.procesarOperacio();
        assertEquals(0,res);
        res=mathManager.procesarOperacio();
        assertEquals(-1,res);

    }

    @org.junit.After
    public void tearDown(){
        mathManager.clear();
    }
}
