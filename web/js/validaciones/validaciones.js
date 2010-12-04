function tieneDatos(cadena)
{
    return /^.*[^\s]+.*$/.test(cadena);
}

function esDecimal(numero)
{
    return /^[0-9]+,?[0-9]*$/.test(numero);
}

function esDni (numero)
{
    return /^([0-9]{7,8})$/.test(numero);

}

function esCuil (numero)
{

    return /(^((20|27|30)\-[0-9]{7,8}\-[0-9])|^)$/.test(numero);

}

function esNumerico(numero)
{
    return /^[0-9]+$/.test(numero);
}

function esAlfabetico(cadena)
{
    return /^[\s\xF1\xD1a-zA-Z]+$/.test(cadena);
}

function esHora(cadena)
{
    return /^[012]?[0-9]:[0-5][0-9]$/.test(cadena);
}

function getDate(fecha)
{
    arrDate = fecha.split("/");
    return new Date(arrDate[2], arrDate[1]-1, arrDate[0]);
}

function esPeriodoValido(fechaIni, fechaFin)
{
    return getDate(fechaIni) <= getDate(fechaFin);
}

function validarFormulario()
{
    listaErrores = validarCampos();
    if(listaErrores != "")
    {
        alert(listaErrores);
        return false;
    }
    else
    {
        return true;
    }
}

function validarFormularioProfesional()
{
    listaErrores = validarCamposProfesional();
    if(listaErrores != "")
    {
        alert(listaErrores);
        return false;
    }
    else
    {
        return true;
    }
}

function validarFormularioEmpleado()
{
    listaErrores = validarCamposEmpleado();
    if(listaErrores != "")
    {
        alert(listaErrores);
        return false;
    }
    else
    {
        return true;
    }
}

function validarFormularioAsignarLegajo()
{
    listaErrores = validarCamposAsignarLegajo();
    if(listaErrores != "")
    {
        alert(listaErrores);
        return false;
    }
    else
    {
        return true;
    }
}

function valorFromId(nombre)
{
    return document.getElementById(nombre).value;
}

window.onload = function()
{
    document.getElementById("buttonSave").onclick = validarFormulario;
}

