document.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">\n\
        <link href=\"./js/jqueryjs/jquery.alerts.css\" rel=\"stylesheet\" type=\"text/css\" media=\"screen\" />\n\
        <script type=\"text/javascript\" src=\"./js/jqueryjs/js/jquery-1.4.2.min.js\"></script>\n\
        <script type=\"text/javascript\" src=\"./js/jqueryjs/jquery.alerts.js\"></script>");
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
    jConfirm('Desea Cancelar la Operacion?', 'Sistema Personal', function(r) {
        if( r )  location="PanelNoticias.html";
    });
}