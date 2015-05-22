
package au.edu.unsw.soacourse.rms.pinkslipprovider;

import javax.jws.WebService;

@WebService(endpointInterface = "au.edu.unsw.soacourse.rms.pinkslipprovivider.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    public String sayHi(String text) {
        return "Hello " + text;
    }
}

