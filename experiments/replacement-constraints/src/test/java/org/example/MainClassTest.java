package org.example;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MainClassTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testMain() {
        exception.expect(NoClassDefFoundError.class);
        exception.expectMessage("org/apache/cassandra/thrift/CassandraServer");

        MainClass.run();
    }
}