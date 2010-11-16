
var req = createRequestObject();
function js_logIn(){
    req.onreadystatechange = function () {
        if ( req.readyState == 4){
            if(req.status == 200 || window.location.href.indexOf ("http")==- 1) {
                //open("home.jsp?user="+req.responseText,"_self");
                jAlert('Bienvenido', 'Sistema Personal', function(r) {
                    if( r )  location="home.jsp?user="+req.responseText;
                });
            }
            else{
                jAlert("Nombre de usuario o contraseña Incorrecta","Sistema Personal");
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
            jAlert("Cerrando sesi&oacuten","Sistema Personal", function(r){
                if(req.status != 200) {
                    alert("Error al cerrar la sesi&oacuten \nPuede que no se haya inicado con exito la session");
                }
                window.location="index.jsp";
            });
            

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








