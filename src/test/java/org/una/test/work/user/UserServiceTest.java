package org.una.test.work.user;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.una.test.work.utils.BaseTest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



public class UserServiceTest extends BaseTest {


    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

    }

    @Test
    public void test_get_all_success() throws Exception {
       /* List<Usuario> users = Arrays.asList(
                new Usuario(1, "Daenerys Targaryen"),
                new Usuario(2, "John Snow"));

        when(usuarioService.findAll()).thenReturn(users);*/

        mockMvc.perform(get("/api/private/usuario"))
                .andExpect(status().isOk());

    }

    @Test
    public void test_find_by_name_not_found() throws Exception {

        // Test if Data was removed
        mockMvc.perform(get("/api/private/usuario/asdfa"))
                .andExpect(status().isNotFound());

    }

    @Test
    public void test_find_by_name_sucess() throws Exception {

        // Test if Data was removed
        mockMvc.perform(get("/api/private/usuario/User 2"))
                .andExpect(status().isOk()).andDo(print());

    }

    @Test
    public void test_post_success() throws Exception {
        mockMvc.perform(post("/api/private/usuario")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\" : 5,\"email\" : \"carlos@gmail.com\",\"nome\" : \"carlos\", \"password\" : \"123456\"}"))
                .andExpect(status().isOk());
    }



    @Test
    public void test_post_conflict() throws Exception {
        mockMvc.perform(post("/api/private/usuario")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\" : 5,\"email\" : \"carlos@gmail.com\",\"nome\" : null, \"password\" : \"123456\"}"))
                .andExpect(status().isConflict());
    }


    @Test
    public void test_update_success() throws Exception {

        mockMvc.perform(put("/api/private/usuario")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\" : 5,\"email\" : \"carlos@gmail.com\",\"nome\" : \"carlos\", \"password\" : \"102123\"}"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void test_update_conflict() throws Exception {

        mockMvc.perform(put("/api/private/usuario")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\" : 5,\"email\" : \"carlos@gmail.com\",\"nome\" : null, \"password\" : \"102123\"}"))
                .andExpect(status().isConflict())
                .andDo(print());
    }



    @Test
    public void test_delete_Ok() throws Exception {


        // Delete
        mockMvc.perform(delete("/api/private/usuario")
        .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\" : 1,\"email\" : \"admin@gmail.com\",\"nome\" : \"User 1\", \"password\" : \"123\"}"))
                .andExpect(status().isOk());

    }



    @Test
    public void test_delete_not_found() throws Exception {


        mockMvc.perform(delete("/api/private/usuario")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\" : 15,\"email\" : \"carlos@gmail.com\",\"nome\" : \"carlos\", \"password\" : \"102123\"}"))
                .andExpect(status().isNotFound());


    }




}