function validarNoVacio(cadena)
{
    for ( i = 0; i < cadena.length; i++ )
    {
        if ( cadena.charAt(i) != " " )
        {
            return true;
        }
    }
    return false
}

function validarNumero(numero)
{
    if (/^([0-9])*$/.test(numero))
    {
        return true;
    }
    else
    {
        return false;
    }
}

function validarCampos()
{
    resultado = ""

/*    if(validarNoVacio(document.getElementById("nombre").value))
    {
        resultado += "Nombre no debe ser vacio.\n";
    }
*/
    if(validarNumero(document.getElementById("nombre").value))
    {
        resultado += "Nombre no debe ser un numero.\n";
    }

    if(resultado == "")
    {
        resultado = "Datos correctos";
    }

    return resultado;
}

function validarFormulario()
{
    resultado = validarCampos();
    if(resultado != "Datos correctos")
    {
        alert(resultado);
        return false;
    }
    else
    {
        return true;
    }
}

window.onload = function()
{
    document.getElementById("buttonSave").onclick = validarFormulario;
}