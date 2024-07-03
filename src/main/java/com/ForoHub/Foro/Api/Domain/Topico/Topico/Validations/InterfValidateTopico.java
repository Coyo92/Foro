package com.ForoHub.Foro.Api.Domain.Topico.Topico.Validations;

import com.ForoHub.Foro.Api.Domain.Topico.Topico.TopicoData;

public interface InterfValidateTopico {
    public void validate(TopicoData topicoData);
    public void validateUpdate(TopicoData topicoData);
    public void validateSerchByIdTopico(int idtopico);
}
