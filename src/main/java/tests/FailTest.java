package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FailTest {

    @Test
    public void testFailure() {

        Assert.assertEquals(1, 2);
    }
}