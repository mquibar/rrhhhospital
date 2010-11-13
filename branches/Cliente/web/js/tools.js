function cargarSource(iframe, target)
{
    //alert("cargando en " + iframe + " : " + target )
    document.getElementById(iframe).src = target;
}

function cargarNoticias(target)
{
    cargarSource('ifnoticias', target)
}

