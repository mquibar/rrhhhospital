
var req = createRequestObject();
function js_logIn(){
    req.onreadystatechange = function () {
        if ( req.readyState == 4){
            if(req.status == 200 || window.location.href.indexOf ("http")==- 1) {
                open("home.jsp?user="+req.responseText,"_self");
            }
            else{
                alert("Nombre de usuario o contraseña Incorrecta");
            }
            ocultarEspera();
        } else {
            if(req.readyState==1){
                mostrarEspera();
            }
        }
    };
    req.open("POST", "logInServlet?segurityOption=login&userName="+document.getElementById("user").value+"&pass="+document.getElementById("password").value, true);
    req.send(null);

    return (true);
}

function js_logOff(){
    req.onreadystatechange = function () {
        if ( req.readyState == 4){
            ocultarEspera();
            alert("Gracias por utilizar nuestro sistema");
            if(req.status != 200) {
                alert("Error al cerrar la sesion \nPuede que no se haya inicado con exito la session");
            }
            window.location="index.jsp";

        } else {
            if(req.readyState==1){
                mostrarEspera();
            }
        }
    };
    req.open("POST", "logInServlet?segurityOption=logoff", true);
    req.send(null);

    return (true);
}








