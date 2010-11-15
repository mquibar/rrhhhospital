
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
    req.open("POST", "logInServlet?userName="+document.getElementById("user").value+"&pass="+document.getElementById("password").value, true);
    req.send(null);

    return (true);
}








