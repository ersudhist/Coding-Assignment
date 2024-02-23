package com.ims;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InstituteManagementSystemApplicationTests {

	@Test
	void contextLoads() {
	}
	
	 @Test
	 void testExampleService() {
	        // Mocking dependencies
	        Dependency dependency = mock(Dependency.class);
	        when(dependency.getData()).thenReturn("Mocked data");

	        // Creating an instance of the class to be tested, injecting the mocked dependency
	        ExampleService exampleService = new ExampleService(dependency);

	        // Calling the method under test
	        String result = exampleService.processData();

	        // Verifying the behavior
	        verify(dependency, times(1)).getData();

	        // Asserting the result using AssertJ
	        assertThat(result).isEqualTo("Mocked data");
	    }
	}

	// ExampleService class to be tested
	class ExampleService {
	    private Dependency dependency;

	    public ExampleService(Dependency dependency) {
	        this.dependency = dependency;
	    }

	    public String processData() {
	        return dependency.getData();
	    }
	}

	// Example dependency interface
	interface Dependency {
	    String getData();

}
