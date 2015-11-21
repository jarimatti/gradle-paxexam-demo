package fi.jarimatti.demo.paxexam.service.impl;

import org.junit.Test;

import static org.junit.Assert.*;

public class HelloWorldImplTest {

    @Test
    public void testGreet() throws Exception {
        final HelloWorldImpl helloWorld = new HelloWorldImpl();

        assertEquals("Hello, World!", helloWorld.greet());
    }

    @Test
    public void testGreetWithName() throws Exception {
        final HelloWorldImpl helloWorld = new HelloWorldImpl();
        final String name = "Paavo";
        final String expected = "Hello, " + name + "!";

        assertEquals(expected, helloWorld.greet(name));
    }
}