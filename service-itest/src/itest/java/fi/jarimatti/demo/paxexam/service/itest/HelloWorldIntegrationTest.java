package fi.jarimatti.demo.paxexam.service.itest;

import fi.jarimatti.demo.paxexam.service.api.HelloWorld;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.options.MavenArtifactUrlReference;
import org.ops4j.pax.exam.options.MavenUrlReference;

import javax.inject.Inject;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.ops4j.pax.exam.CoreOptions.*;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.features;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.karafDistributionConfiguration;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.keepRuntimeFolder;

/**
 *Test HelloWorld service in Karaf.
 */
@RunWith(PaxExam.class)
public class HelloWorldIntegrationTest {

    @Inject
    private HelloWorld helloWorld;

    @Configuration
    public Option[] config() {
        MavenArtifactUrlReference karafUrl = maven()
                .groupId("org.apache.karaf")
                .artifactId("apache-karaf")
                .version("4.0.3")
                .type("tar.gz");
        MavenUrlReference karafStandardRepo = maven()
                .groupId("org.apache.karaf.features")
                .artifactId("standard")
                .classifier("features")
                .type("xml")
                .version("4.0.3");
        return new Option[]{
                karafDistributionConfiguration()
                        .frameworkUrl(karafUrl)
                        .unpackDirectory(new File("build/exam"))
                        .useDeployFolder(false),
                // keepRuntimeFolder(),
                features(karafStandardRepo, "scr"),
                bundle(new File("../service/build/libs/service-0.0.1-SNAPSHOT.jar").toURI().toString()),
                junitBundles()
        };
    }

    @Test
    public void testGreet() {
        assertEquals("Hello, World!", helloWorld.greet());
    }

    @Test
    public void testGreetWithName() {
        assertEquals("Hello, Paavo!", helloWorld.greet("Paavo"));
    }
}
