function tieneDatos(cadena)
{
    return /^.*[^\s]+.*$/.test(cadena);
}

function esDecimal(numero)
{
    return /^[0-9]+,?[0-9]*$/.test(numero);
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

function valorFromId(nombre)
{
    return document.getElementById(nombre).value;
}

window.onload = function()
{
    document.getElementById("buttonSave").onclick = validarFormulario;
}

