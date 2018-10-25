package com.backendless;

import com.backendless.servercode.IBackendlessService;


public class HelloWorldService implements IBackendlessService {

    public String sayHelloUser (String str) {
        return "Hello "  + str + "!";
    }
}
