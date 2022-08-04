package tests;

import org.junit.jupiter.api.*;

public class JUnit5Examples {

    @BeforeAll
    static void beforeAll() {
        System.out.println("== Something before all tests");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("=== Something before each tests");
    }

    @Test
    void firstTest() {
        System.out.println("========== Started firstTest");
    }

    @Test
    void secondTest() {
        System.out.println("========== Started secondTest");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("== Something after all tests");
    }

    @AfterEach
    void afterEach() {
        System.out.println("=== Something after each tests");
    }
}
