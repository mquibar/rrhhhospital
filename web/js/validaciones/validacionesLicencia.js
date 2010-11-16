function validarCampos()
{
    listaErrores = ""
alert(valorFromId("empleado"));
    if(valorFromId("empleado") == "0" )
    {
        listaErrores += "Debe elegir un empleado.\n";
    }

    if(valorFromId("tipoHorario") == "0" )
    {
        listaErrores += "Debe elegir un tipo de licencia.\n";
    }

    if(!tieneDatos(valorFromId("DPC_edit1")))
    {
        listaErrores += "Fecha Inicio no debe ser vacio.\n";
    }

    if(!tieneDatos(valorFromId("DPC_edit2")))
    {
        listaErrores += "Fecha Fin no debe ser vacio.\n";
    }

    if(!esPeriodoValido(valorFromId(fechaInicio), valorFromId(fechaFin)))
    {
        listaErrores += "El periodo ingresado no es valido.\n";
    }

    return listaErrores;
}

