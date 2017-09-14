package org.una.work.usuario;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.una.work.utils.GenericService;
import org.una.work.utils.ServicePath;

@RestController
@RequestMapping(path = ServicePath.USUARIO_PATH)
public class UsuarioService extends GenericService<Usuario, Long> {

	

}
