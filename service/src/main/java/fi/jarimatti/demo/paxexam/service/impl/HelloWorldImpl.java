package fi.jarimatti.demo.paxexam.service.impl;

import aQute.bnd.annotation.component.Activate;
import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Deactivate;
import fi.jarimatti.demo.paxexam.service.api.HelloWorld;

/**
 * Implement the HelloWolrd service.
 */
@Component
public class HelloWorldImpl implements HelloWorld {

    /**
     * Just show that the component is activating during integration tests.
     */
    @Activate
    public final void activate() {
        System.out.println("HelloWorldImpl activating.");
    }

    /**
     * Just show that the component is deactivating during integration tests.
     */
    @Deactivate
    public final void deactivate() {
        System.out.println("HelloWorldImpl deactivating.");
    }

    @Override
    public String greet() {
        return greet("World");
    }

    @Override
    public String greet(String who) {
        return "Hello, " + who + "!";
    }
}
