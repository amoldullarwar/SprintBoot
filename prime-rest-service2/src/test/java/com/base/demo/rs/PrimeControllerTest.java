package  com.base.demo.rs;

import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class PrimeControllerTest {

	@Autowired
    private MockMvc mockMvc;
    
	@Test
    public void test() throws Exception {

		mockMvc.perform(get("/primes/0"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("Initial", is(0)))
        .andExpect(jsonPath("Primes").isArray())
        .andExpect(jsonPath("Primes", hasItems()));
		
		mockMvc.perform(get("/primes/3"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("Initial", is(3)))
        .andExpect(jsonPath("Primes").isArray())
        .andExpect(jsonPath("Primes", hasItems(2,3)));
		
        mockMvc.perform(get("/primes/10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("Initial", is(10)))
                .andExpect(jsonPath("Primes").isArray())
                .andExpect(jsonPath("Primes", hasItems(2, 3, 5, 7)));
        
        
        
        
        

    }
}
