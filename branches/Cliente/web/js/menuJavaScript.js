
var req = createRequestObject();
function loadMenuFunction(menu){
    req.onreadystatechange = function () {
        if ( req.readyState == 4 && (req.status == 200 || window.location.href.indexOf ("http")==- 1)) {
            document.getElementById("noticias").src = req.responseText;
            ocultarEspera();
        } else {
            if(req.readyState==1){
               mostrarEspera();
            }
        }
    };
    req.open("GET", "menuServlet?opMenu="+menu , true);
    req.send(null);

    return (true);
}