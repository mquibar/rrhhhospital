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
    obj = createRequestObject();
    //cargarSource('noticias', target)
    obj.onreadystatechange = function () {
        if ( obj.readyState == 4 && (obj.status == 200 || window.location.href.indexOf ("http")==- 1)) {
            document.getElementById("noticias").innerHTML = obj.responseText;
            ocultarEspera();
        } else {
            if(obj.readyState==1){
                mostrarEspera();
            }
        }
    };
    obj.open("GET", "loadPageServlet?target="+target , true);
    obj.send(null);

    return (true);
}

function cargar(target)
{
    window.location = target;
}

function js_cancel_operacion(){
    jConfirm('Desea Cancelar la Operacion?', 'Sistema Personal', function(r) {
        if( r )  loadMenuFunction("gohome");
    });
}

function filterSelect(dropdownlist)
{
	optionsLength = dropdownlist.options.length;
	lastCoincidence = 0;
	for (n=0; n < optionsLength; n++) 
	{ 
		optionText = dropdownlist.options[n].text; 
		if (optionText.indexOf(dropdownlist.keypressBuffer,0) > 0) 
		{ 
			dropdownlist.options[n].style.display = "inline";
			temp = dropdownlist.options[lastCoincidence];
			dropdownlist.options[lastCoincidence] = dropdownlist.options[n];
			dropdownlist.options[n] = temp;
			lastCoincidence++;
			
//			dropdownlist.selectedIndex = n; 
//			return false;  
		}
		else
		{
			dropdownlist.options[n].style.display = "none";
		}		
	} 
}