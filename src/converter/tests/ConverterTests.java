package converter.tests;

import converter.ElbonianArabicConverter;
import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test cases for the ElbonianArabicConverter class.
 */
public class ConverterTests {

    @Test
    public void ElbonianToArabicSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("1");
        assertEquals(converter.toElbonian(), "I");
        converter = new ElbonianArabicConverter("NNNDDDYYYJJJ");
        assertEquals(9999, converter.toArabic());
        converter = new ElbonianArabicConverter("NMJI");
        assertEquals(4004, converter.toArabic());
         converter = new ElbonianArabicConverter("NNMDYYYJI");
        assertEquals(7394, converter.toArabic());
    }

    @Test
    public void ArabicToElbonianSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("I");
        assertEquals(converter.toArabic(), 1);
         converter = new ElbonianArabicConverter("4004");
        assertEquals("NMJI", converter.toElbonian());
        converter = new ElbonianArabicConverter("9999");
        assertEquals("NNNDDDYYYJJJ", converter.toElbonian());
         converter = new ElbonianArabicConverter("7394");
        assertEquals("NNMDYYYJI", converter.toElbonian());
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("TEST");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest1() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("MNJJ");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("DMJJ");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest3() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("CDJJ");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest4() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("YCJJ");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest5() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("XYJJ");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest6() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("JXII");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest7() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("IJJ");
    }


    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest8() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("9 9");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest13() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("9M");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest9() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("N M");
    }


    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest10() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("DDDC");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest11() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("NNNM");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest12() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("YYYX");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest17() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("JJJI");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest14() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("-1");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest16() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("ym");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest18() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException(" ");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutOfBoundsTest14() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new ValueOutOfBoundsException("0");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutOfBoundsTest15() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new ValueOutOfBoundsException("12000");
    }
}
