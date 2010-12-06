
function js_cargarNoticias_rpec(){
    req.onreadystatechange = function () {
        if ( req.readyState == 4 ){
            if(req.status == 200 || window.location.href.indexOf ("http")==- 1) {
                document.getElementById("noticias").innerHTML = req.responseText;
                js_lista_agrupamiento_rpec();
            }
            else
                alert(req.statusText);
            ocultarEspera();
        } else {
            if(req.readyState==1){
                mostrarEspera();
            }
        }
    };
    req.open("GET", "loadPageServlet?target=reporte_emp_cat.jsp" , true);
    req.send(null);

    return (true);
}
function js_lista_agrupamiento_rpec(){
    req.onreadystatechange = function () {
        if ( req.readyState == 4 ){
            if(req.status == 200 || window.location.href.indexOf ("http")==- 1) {
                document.getElementById("agrupamiento").innerHTML = req.responseText;
                document.getElementById("tramo").innerHTML="";
                document.getElementById("categoria").innerHTML="";
            }
            ocultarEspera();
        } else {
            if(req.readyState==1){
                mostrarEspera();
            }
        }
    };
    req.open("GET", "reportesCategoriaServlet?operacion=agrupamiento" , true);
    req.send(null);
    return (true);
}

function js_lista_tramo_rpec(){
    req.onreadystatechange = function () {
        if ( req.readyState == 4 ){
            if(req.status == 200 || window.location.href.indexOf ("http")==- 1) {
                document.getElementById("tramo").innerHTML = req.responseText;

                document.getElementById("categoria").innerHTML="";
            }
            ocultarEspera();
        } else {
            if(req.readyState==1){
                mostrarEspera();
            }
        }
    };
    req.open("GET", "reportesCategoriaServlet?operacion=tramo&agrupamiento="+document.getElementById("agrupamiento").value , true);
    req.send(null);
    return (true);
}

function js_lista_categoria_rpec(){
    req.onreadystatechange = function () {
        if ( req.readyState == 4){
            if(req.status == 200 || window.location.href.indexOf ("http")==- 1) {
                document.getElementById("categoria").innerHTML = req.responseText;

            }
            ocultarEspera();
        } else {
            if(req.readyState==1){
                mostrarEspera();
            }
        }
    };
    req.open("GET", "reportesCategoriaServlet?operacion=categoria&tramo="+document.getElementById("tramo").value , true);
    req.send(null);
    return (true);
}

function js_imprimir_todo_rpec(){
    req.onreadystatechange = function () {
        if ( req.readyState == 4){
            if(req.status == 200 || window.location.href.indexOf ("http")==- 1) {
            window.open(req.responseText);
            }
            ocultarEspera();
        } else {
            if(req.readyState==1){
                mostrarEspera();
            }
        }
    };
    req.open("GET", "reportesCategoriaServlet?operacion=IMPRIMIRTODO" , true);
    req.send(null);
    return (true);
}

function js_imprimir_todo_rpec(){
    req.onreadystatechange = function () {
        if ( req.readyState == 4){
            if(req.status == 200 || window.location.href.indexOf ("http")==- 1) {
            window.open(req.responseText);
            }
            ocultarEspera();
        } else {
            if(req.readyState==1){
                mostrarEspera();
            }
        }
    };
    req.open("GET", "reportesCategoriaServlet?operacion=IMPRIMIR&categoria="+document.getElementById("categoria").value , true);
    req.send(null);
    return (true);
}