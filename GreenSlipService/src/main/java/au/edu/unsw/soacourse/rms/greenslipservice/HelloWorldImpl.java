
package au.edu.unsw.soacourse.rms.greenslipservice;

import javax.jws.WebService;

@WebService(endpointInterface = "au.edu.unsw.soacourse.rms.greenslipservice.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    public String sayHi(String text) {
        return "Hello " + text;
    }
}

