package ase.group10.cicdtest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testHelloGet() throws Exception {
        // Test GET /api/hello with default parameter
        mockMvc.perform(get("/api/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("GET: Hello, World!"));

        // Test GET /api/hello with query parameter
        mockMvc.perform(get("/api/hello").param("name", "TestUser"))
                .andExpect(status().isOk())
                .andExpect(content().string("GET: Hello, TestUser!"));
    }

    @Test
    void testFuckGet() throws Exception {
        // Test GET /api/fuck with default parameter
        mockMvc.perform(get("/api/fuck"))
                .andExpect(status().isOk())
                .andExpect(content().string("GET: fuck, World!"));

        // Test GET /api/fuck with query parameter
        mockMvc.perform(get("/api/fuck").param("name", "TestUser"))
                .andExpect(status().isOk())
                .andExpect(content().string("GET: fuck, TestUser!"));
    }

    @Test
    void testHelloPost() throws Exception {
        // Test POST /api/hello with no body (default to "Kate")
        mockMvc.perform(post("/api/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("POST: Greetings, Kate!"));

        // Test POST /api/hello with body
        mockMvc.perform(post("/api/hello").content("TestUser"))
                .andExpect(status().isOk())
                .andExpect(content().string("POST: Greetings, TestUser!"));
    }
}
