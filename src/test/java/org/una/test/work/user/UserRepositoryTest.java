package org.una.test.work.user;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.una.test.work.utils.BaseTest;
import org.una.work.usuario.Usuario;
import org.una.work.usuario.UsuarioRepository;

public class UserRepositoryTest extends BaseTest {

    private final Logger LOGGER = Logger.getLogger(this.getClass());

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    public void findAll_success() {
        List<Usuario> usuario = usuarioRepository.findAll();

        LOGGER.debug(usuario);

        assertNotNull(usuario);
        assertTrue(usuario.size() > 0);
    }

    @Test
    public void insert() {
        //Usuario
        Usuario usuario = new Usuario();

        usuario.setNome("Leonardo Silva");
        usuario.setEmail("leonardo@gmail.com");
        usuario.setPassword("123456");

        usuarioRepository.save(usuario);
    }

}
