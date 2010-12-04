function validarCamposAsignarLegajo ()
{

    listaErrores = ""

    if(!tieneDatos(valorFromId("legajo")))
    {
        listaErrores += "El empleado debe tener legajo. \n";
    }
    
    if (!esNumerico(valorFromId("legajo"))) {

        listaErrores += "El legajo debe contener solo digitos. \n";
    }


    if(!tieneDatos(valorFromId("agrupamiento")))
    {
        listaErrores += "El empleado debe tener agrupamiento. \n";
    }

    if(!tieneDatos(valorFromId("tramo")))
    {
        listaErrores += "El empleado debe tener tramo. \n";
    }

    if(!tieneDatos(valorFromId("categoria")))
    {
        listaErrores += "El empleado debe tener categoria. \n";
    }

    if(!tieneDatos(valorFromId("clase")))
    {
        listaErrores += "El empleado debe tener clase. \n";
    }

    return listaErrores;

}
