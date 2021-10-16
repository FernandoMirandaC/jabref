package org.jabref.logic.util.strings;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuotedStringTokenizerTest {

    private QuotedStringTokenizer qst;

    @Test
    public void simpleTokenTest() {
        qst = new QuotedStringTokenizer("Token", "", 'n');
        assertEquals(true, qst.hasMoreTokens());
        assertEquals("Token", qst.nextToken());
    }

    @Test
    public void edgeDemiliterTest() {
        qst = new QuotedStringTokenizer("Token to test", " ", 'n');
        assertEquals("Token to", qst.nextToken());
    }

    @Test
    public void noDelimiterPresentTest() {
        qst = new QuotedStringTokenizer("Token", " ", 'a');
        assertEquals("Token", qst.nextToken());
    }


    @Test
    public void onlyDelimitersTest() {
        qst = new QuotedStringTokenizer("Token", "Token", 'a');
        assertEquals(false, qst.hasMoreTokens());
    }

}
