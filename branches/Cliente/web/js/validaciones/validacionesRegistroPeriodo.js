function validarCampos()
{
    listaErrores = ""

    if(!tieneDatos(valorFromId("DPC_edit1")))
    {
        listaErrores += "Fecha no debe ser vacio.\n";
    }

    if(!tieneDatos(valorFromId("horaEntrada")))
    {
        listaErrores += "Hora Entrada no debe ser vacio.\n";
    }
    else
    {
        if(!esHora(valorFromId("horaEntrada")))
        {
            listaErrores += "Hora Entrada debe ser una hora valida.\n";
        }
    }

    if(!tieneDatos(valorFromId("horaSalida")))
    {
        listaErrores += "Hora Salida no debe ser vacio.\n";
    }
    else
    {
        if(!esHora(valorFromId("horaSalida")))
        {
            listaErrores += "Hora Salida debe ser una hora valida.\n";
        }
    }



    return listaErrores;
}

