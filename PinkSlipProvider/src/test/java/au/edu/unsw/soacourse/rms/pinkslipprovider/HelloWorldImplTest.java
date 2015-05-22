
package au.edu.unsw.soacourse.rms.pinkslipprovider;

import org.junit.Test;

import au.edu.unsw.soacourse.rms.pinkslipprovider.HelloWorldImpl;
import static org.junit.Assert.assertEquals;

public class HelloWorldImplTest {

    @Test
    public void testSayHi() {
        HelloWorldImpl helloWorldImpl = new HelloWorldImpl();
        String response = helloWorldImpl.sayHi("Sam");
        assertEquals("HelloWorldImpl not properly saying hi", "Hello Sam", response);
    }
}
