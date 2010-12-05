/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function load(source, target)
{
    req.onreadystatechange = function () {
        if ( req.readyState == 4 && (req.status == 200 || window.location.href.indexOf ("http")==- 1)) {
            document.getElementById(target).innerHTML = req.responseText;
            ocultarEspera();
            DPC_autoInit();
        } else {
            if(req.readyState==1){
               mostrarEspera();
            }
        }
    };
    req.open("GET", source , true);
    req.send(null);

    return (true);
}

function execute(source, onSuccess, onError) {

    req.onreadystatechange = function () {
        if ( req.readyState == 4 ) {
            ocultarEspera();
            if (req.status == 200 || window.location.href.indexOf ("http")==- 1) {
                jAlert("Operacion completada con exito");
                if(onSuccess != "") load(onSuccess,"noticias");
            }else {
                jAlert(req.statusText, "Error en la operacion");
                if(onError != "")load(onError,"noticias");
            }
        } else {
            if(req.readyState==1){
               mostrarEspera();
            }
        }
    };
    req.open("GET", source, true);
    req.send(null);

    return (true);

}

function loadModificar(entidad)
{
    loadActualizar(entidad, "modificar");
}

function loadEliminar(entidad)
{
    loadActualizar(entidad, "eliminar");
}

function loadActualizar(entidad, operacion)
{
    servletUrl = "ServletModificar" + entidad + 
        "?operacion=" + operacion + 
        "&valor="+ document.getElementById("selector").value;
    load(servletUrl , "noticias");
}

function guardarModificacion(source)
{
    execute(source, "PanelNoticias.html", "");
}

//////////////////////////////////////////////////////////////

function guardarModificacionTipoHorario()
{
    if(validarFormulario(validarCamposTipoHorario()))
    {
        datos =
           "nombre="+document.getElementById("nombre").value+"&"+
           "descripcion="+document.getElementById("descripcion").value+"&"+
           "horaEntrada="+document.getElementById("horaEntrada").value+"&"+
           "horaSalida="+document.getElementById("horaSalida").value+"&"+
           
           "idEntidad="+document.getElementById("idEntidad").value+"&"+
           "eliminado="+document.getElementById("eliminado").value;

        source = "ServletModificarTipoHorario?operacion=guardar&"+datos;

        error = "";//"manejoHorarios/tipo_horario_1.jsp?" + datos;

        guardarModificacion(source);
    }
}

function guardarModificacionAsignacionHorario()
{
    if(validarFormulario(validarCamposAsignacionHorario()))
    {
        datos =
           "empleado="+document.getElementById("empleado").value+"&"+
           "descripcion="+document.getElementById("descripcion").value+"&"+
           "fechaInicio="+document.getElementById("fechaInicio").value+"&"+
           "fechaFin="+document.getElementById("fechaFin").value+"&"+
           "tipoHorario="+document.getElementById("tipoHorario").value+"&"+
           
           "idEntidad="+document.getElementById("idEntidad").value+"&"+
           "eliminado="+document.getElementById("eliminado").value;

        source = "ServletModificarAsignacionHorario?operacion=guardar&"+datos;

        error = "";//"manejoHorarios/tipo_horario_1.jsp?" + datos;

        guardarModificacion(source);
    }
}

function guardarModificacionRegistroPeriodo()
{
    if(validarFormulario(validarCamposRegistroPeriodo()))
    {
        datos =
           "empleado="+document.getElementById("empleado").value+"&"+
           "fechaEntrada="+document.getElementById("fechaEntrada").value+"&"+
           "horaEntrada="+document.getElementById("horaEntrada").value+"&"+
           "horaSalida="+document.getElementById("horaSalida").value+"&"+

           "idEntidad="+document.getElementById("idEntidad").value+"&"+
           "eliminado="+document.getElementById("eliminado").value;

        source = "ServletModificarRegistroPeriodo?operacion=guardar&"+datos;

        error = "";//"manejoHorarios/tipo_horario_1.jsp?" + datos;

        guardarModificacion(source);
    }
}

function guardarModificacionLicencia()
{
    if(validarFormulario(validarCamposLicencia()))
    {
        datos =
           "empleado="+document.getElementById("empleado").value+"&"+
           "tipoLicencia="+document.getElementById("tipoLicencia").value+"&"+
           "fechaInicio="+document.getElementById("fechaInicio").value+"&"+
           "fechaFin="+document.getElementById("fechaFin").value+"&"+
           "motivo="+document.getElementById("motivo").value+"&"+

           "idEntidad="+document.getElementById("idEntidad").value+"&"+
           "eliminado="+document.getElementById("eliminado").value;

        source = "ServletModificarLicencia?operacion=guardar&"+datos;

        error = "";//"manejoHorarios/tipo_horario_1.jsp?" + datos;

        guardarModificacion(source);
    }
}


