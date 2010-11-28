function validarCamposEmpleado ()
{

    listaErrores = ""

    if(!tieneDatos(valorFromId("nombre")))
    {
        listaErrores += "La Persona debe tener Nombre. \n";
    }

    if(!tieneDatos(valorFromId("apellido")))
    {
        listaErrores += "La Persona debe tener Apellido. \n";
    }

    if(!tieneDatos(valorFromId("dni")))
    {
        listaErrores += "La Persona debe tener DNI. \n";
    }

    if(!tieneDatos(valorFromId("DPC_edit1")))
    {
        listaErrores += "La Persona debe tener Fecha de Nacimiento. \n";
    }

    if(!tieneDatos(valorFromId("telefono")))
    {
        listaErrores += "La Persona debe tener Telefono. \n";
    }

    if(!tieneDatos(valorFromId("cuil")))
    {
        listaErrores += "La Persona debe tener CUIL. \n";
    }

   if(!tieneDatos(valorFromId("ntarjeta")))
    {
        listaErrores += "La Persona debe tener ntarjeta. \n";
    }

    if(!tieneDatos(valorFromId("calle")))
    {
        listaErrores += "La Persona debe tener calle. \n";
    }

    if(!tieneDatos(valorFromId("numero")))
    {
        listaErrores += "La Persona debe tener numero. \n";
    }

    if(!tieneDatos(valorFromId("barrio")))
    {
        listaErrores += "La Persona debe tener barrio. \n";
    }


    if(!tieneDatos(valorFromId("piso")) && tieneDatos(valorFromId("departamento")))
    {
            listaErrores += "La Persona no puede, tener departamento y no piso. \n";

    }

    if(tieneDatos(valorFromId("piso")) && !tieneDatos(valorFromId("departamento")))
    {
        listaErrores += "La Persona no puede, tener piso y no departamento. \n";

    }

    if(!tieneDatos(valorFromId("piso")) && !tieneDatos(valorFromId("departamento")))
    {

        listaErrores += "La Persona debe tener Piso y Departamento. \n";

    }

    if(!tieneDatos(valorFromId("pais")))
    {
        listaErrores += "La Persona debe tener pais. \n";
    }

    if (!esNumerico(valorFromId("dni"))) {

        listaErrores += "El Documento debe tener solo digitos. \n";
    }

         if (!esDni(valorFromId("dni"))) {
            listaErrores += "El Documento debe tiene 8 digitos. \n";
        }

        if(!esCuil(valorFromId("cuil")))
        {
            listaErrores += "CUIL con el formato incorrecto. \n";
        }


    return listaErrores;

}


