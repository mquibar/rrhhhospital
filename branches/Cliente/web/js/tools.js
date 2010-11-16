function cargarSource(iframe, target)
{
    //alert("cargando en " + iframe + " : " + target )
    document.getElementById(iframe).src = target;
}

function cargarNoticias(target)
{
    cargarSource('noticias', target)
}

function cargar(target)
{
    window.location = target;
}

function js_cancel_operacion(){
    alert("Operacion cancelada por el usuario");
    location="PanelNoticias.html";
}