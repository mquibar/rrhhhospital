function validarCamposAsignacionHorario()
{
    listaErrores = ""

    if(valorFromId("empleado") == "0" )
    {
        listaErrores += "Debe elegir un empleado.\n";
    }

    if(valorFromId("tipoHorario") == "0" )
    {
        listaErrores += "Debe elegir un tipo de horario.\n";
    }

    if(!tieneDatos(valorFromId("DPC_edit1")))
    {
        listaErrores += "Fecha Inicio no debe ser vacio.\n";
    }

    if(!tieneDatos(valorFromId("DPC_edit2")))
    {
        listaErrores += "Fecha Fin no debe ser vacio.\n";
    }

    if(!esPeriodoValido(valorFromId("DPC_edit1"), valorFromId("DPC_edit2")))
    {
        listaErrores += "El periodo ingresado no es valido.\n";
    }

    return listaErrores;
}

