/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entidades.TipoHorario;
import Expertos.horario.ExpAltaTipoHorario;
import Expertos.horario.ExpModificacionTipoHorario;
import Expertos.horario.consultar.ExpConsultarTipoHorario;
import Tools.ManejaFechas;
import models.combos.ModelOptionTipoHorario;

/**
 *
 * @author leoroot
 */
public class ctrlModificarTipoHorario extends GeneralController {

    ExpConsultarTipoHorario _expTH;
    ModelOptionTipoHorario _mth;

    public ctrlModificarTipoHorario() {
        try
        {
            _expTH = (ExpConsultarTipoHorario) super.getExpert(ExpConsultarTipoHorario.class.getName());
        } catch (Exception ex) {
            System.out.println("Error: No se pudo instanciar el experto: " + ex.getMessage());
        }

        cargarOpciones();
    }

    void cargarOpciones()
    {
       try
        {
            _mth = new ModelOptionTipoHorario(_expTH.listar());
        }
        catch(Exception ex)
        {
            System.out.println("ctrlAltaTipoHorario: Error creando modelos: " + ex.toString());
        }
    }

    public String guardar(
            String idEntidad,
            String nombre,
            String descripcion,
            String horaEntrada,
            String horaSalida,
            String eliminado) {

        String res = "Error: entidad no guardada";

        try
        {
            if(idEntidad != null && !idEntidad.isEmpty())
            {
                ExpModificacionTipoHorario _expModif = (ExpModificacionTipoHorario) super.getExpert(ExpModificacionTipoHorario.class.getName());

                _expModif.iniciarAlta(
                        idNegocio(idEntidad),
                        nombre,
                        descripcion,
                        ManejaFechas.getHour(horaEntrada),
                        ManejaFechas.getHour(horaSalida),
                        Boolean.parseBoolean(eliminado));

                res = _expModif.guardar();
            }
            else
            {
                ExpAltaTipoHorario _expModif = (ExpAltaTipoHorario) super.getExpert(ExpAltaTipoHorario.class.getName());

                _expModif.iniciarAlta(
                    idNegocio(idEntidad),
                    nombre,
                    descripcion,
                    ManejaFechas.getHour(horaEntrada),
                    ManejaFechas.getHour(horaSalida),
                    Boolean.parseBoolean(eliminado));

                res = _expModif.guardar();
            }
        }
        catch (Exception ex)
        {
            System.out.println("Error: No se pudo instanciar el experto: " + ex.getMessage());
        }

        cargarOpciones();

        return res;
    }

    String idNegocio(String idCombo) {
        resetCacheEntidad();

        TipoHorario th = getEntidad(idCombo);
        if (th == null) {
            return "";
        } else {
            return th.getId().toString();
        }
    }

    public String getHoraIngreso(String idEntidad) {
        return ManejaFechas.getHour(getEntidad(idEntidad).getHoraIngreso());
    }

    public String getHoraSalida(String idEntidad) {
        return ManejaFechas.getHour(getEntidad(idEntidad).getHoraSalida());
    }

    public String getNombre(String idEntidad) {
        return getEntidad(idEntidad).getNombre();
    }

    public String getDescripcion(String idEntidad) {
        return getEntidad(idEntidad).getDescripcion();
    }

    public String getOptionsTipoHorario(String tipoHorario)
    {
        String opt = "<option>No Hay opciones disponibles</option>\n";

        if(_mth != null)
        {
            opt = _mth.toString(tipoHorario);
        }

        return  opt;
    }

    public TipoHorario getTipoHorarioSeleccionado(String idTipoHorario)
    {
        System.out.println("Seleccionado TipoHorario con id =" + idTipoHorario);
        return _mth.getSelectedItem(idTipoHorario);
    }

    public String getCombo()
    {
        return getOptionsTipoHorario("");
    }

    TipoHorario _th = null;
    public TipoHorario getEntidad(String idEntidad) {
        if (_th == null) {
            _th = getTipoHorarioSeleccionado(idEntidad);
        }

        return _th;
    }

    public String getUrlModificar(String idEntidad)
    {
        resetCacheEntidad();
        
        return  "manejoHorarios/tipo_horario_1.jsp?" +
               "idEntidad="+idEntidad+"&"+
               "nombre="+getNombre(idEntidad)+"&"+
               "descripcion="+getDescripcion(idEntidad)+"&"+
               "horaEntrada="+getHoraIngreso(idEntidad)+"&"+
               "horaSalida="+getHoraSalida(idEntidad);
    }

    public String getUrlEliminar(String idEntidad)
    {
        return getUrlModificar(idEntidad) + "&action=delete";
    }

    void resetCacheEntidad()
    {
        _th = null;
    }


}
