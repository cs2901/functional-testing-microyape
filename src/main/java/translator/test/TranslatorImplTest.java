package translator.test;

import translator.business.Translator;
import translator.business.TranslatorImpl;
import translator.entities.Language;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TranslatorImplTest {
    TranslatorImpl translator;
    String from;
    String to;

    @BeforeMethod
    public void setUp() throws Exception {
        translator = new TranslatorImpl();
        from = "English";
        to = "Spanish";
    }

    @Test(invocationCount = 100, threadPoolSize = 5)
    public void testTranslate() throws Exception {
        String response = translator.translate(from, to, "Hello World");
        Assert.assertEquals(response, "Hola Mundo");
    }

}