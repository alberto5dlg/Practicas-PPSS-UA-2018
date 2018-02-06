package ppss;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatriculaTest {
    int edad;
    boolean familiaNumerosa;
    boolean repetidor;
    float resultadoReal, resultadoEsperado;
    Matricula mat= new Matricula();

    @Test
    public void testCalculaTasaMatricula() {
        edad = 23;
        familiaNumerosa = true;
        repetidor = true;
        resultadoEsperado = 250.00f;
        resultadoReal = mat.calculaTasaMatricula(edad,familiaNumerosa,repetidor);
        //el tercer parámetro del método Assert.assertEquals es necesario si estamos comparando "floats"
        //en este caso el método devuelve cierto si:
        //resultadoEsperado = resultadoReal +/- 0.002
        assertEquals(resultadoEsperado, resultadoReal,0.002f);
    }
    
    @Test
    public void testCalculaTasaMatricula2() {
        edad = 23;
        familiaNumerosa = false;
        repetidor = true;
        resultadoEsperado = 2000.00f;
        resultadoReal = mat.calculaTasaMatricula(edad,familiaNumerosa,repetidor);
        assertEquals(resultadoEsperado, resultadoReal,0.002f);
    }
    
    @Test
    public void testCalculaTasaMatricula3() {
        edad = 67;
        familiaNumerosa = false;
        repetidor = true;
        resultadoEsperado = 250.00f;
        resultadoReal = mat.calculaTasaMatricula(edad,familiaNumerosa,repetidor);
        assertEquals(resultadoEsperado, resultadoReal,0.002f);
    }
    
    @Test
    public void testCalculaTasaMatricula4() {
        edad = 55;
        familiaNumerosa = false;
        repetidor = true;
        resultadoEsperado = 400.00f;
        resultadoReal = mat.calculaTasaMatricula(edad,familiaNumerosa,repetidor);
        assertEquals(resultadoEsperado, resultadoReal,0.002f);
    }
    
    @Test
    public void testCalculaTasaMatricula5() {
        edad = 26;
        familiaNumerosa = false;
        repetidor = true;
        resultadoEsperado = 500.00f;
        resultadoReal = mat.calculaTasaMatricula(edad,familiaNumerosa,repetidor);
        assertEquals(resultadoEsperado, resultadoReal,0.002f);
    }
    
    @Test
    public void testCalculaTasaMatricula6() {
        edad = 25;
        familiaNumerosa = true;
        repetidor = true;
        resultadoEsperado = 250.00f;
        resultadoReal = mat.calculaTasaMatricula(edad,familiaNumerosa,repetidor);
        assertEquals(resultadoEsperado, resultadoReal,0.002f);
    }
    
    
}