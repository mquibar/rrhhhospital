function validarCampos()
{
    listaErrores = ""

    if(!tieneDatos(valorFromId("nombre")))
    {
        listaErrores += "Nombre no debe ser vacio.\n";
    }
    else
    {
        if(!esAlfabetico(valorFromId("nombre")))
        {
            listaErrores += "Nombre debe ser alfabetico.\n";
        }
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

