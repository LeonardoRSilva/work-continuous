package org.una.work.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.work.errors.FieldsErrorDetalhe;
import org.una.work.errors.Message;
import org.una.work.utils.GenericService;
import org.una.work.utils.ServicePath;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = ServicePath.USUARIO_PATH)
public class UsuarioService extends GenericService<Usuario, Long> {

    @Autowired
    private UsuarioRepository usuarioRepository;

    FieldsErrorDetalhe fieldsErrorDetalhe = new FieldsErrorDetalhe();
    Message message = new Message();

    @RequestMapping(path = "/{nomeUsuario}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> findUsuarioName(@PathVariable("nomeUsuario") String nomeUsuario) {



        Usuario usuario = this.usuarioRepository.findByNome(nomeUsuario);

        if(usuario == null) {
            message.AddField("mensagem", "Load Medicos success");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }

        message.AddField("mensagem", "Load Medicos success");
        message.setData(usuario);
        return ResponseEntity.status(HttpStatus.OK).body(message);

    }


}
