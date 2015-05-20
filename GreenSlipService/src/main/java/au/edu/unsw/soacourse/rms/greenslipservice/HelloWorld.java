package au.edu.unsw.soacourse.rms.greenslipservice;

import javax.jws.WebService;

@WebService
public interface HelloWorld {
    String sayHi(String text);
}

