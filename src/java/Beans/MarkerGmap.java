/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entidades.Ubicacion;
import Servicios.UbicacionFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;


/**
 *
 * @author " "
 */
@Named(value = "MarkerGmap")
@RequestScoped
public class MarkerGmap {

    @EJB
    private UbicacionFacadeLocal ubicacionFacade;

    private String fkcorreoe;
    private String latitud;
    private String longitud;
    
    private MapModel simpleModel;
    
    
    
    public MarkerGmap() {
    }

    public String getFkcorreoe() {
        return fkcorreoe;
    }

    public void setFkcorreoe(String fkcorreoe) {
        this.fkcorreoe = fkcorreoe;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
    
    public List<Ubicacion> getListUbicaion(){
        return this.ubicacionFacade.findAll();
    }
    
    @PostConstruct
    public void init() {
        simpleModel = new DefaultMapModel();
        
        for(Ubicacion u :getListUbicaion()){
            LatLng coord1 = new LatLng(Double.parseDouble(u.getLatitud()),Double.parseDouble(u.getLongitud()));
            simpleModel.addOverlay(new Marker(coord1, u.getFkcorreoe()));
        }     
    }
 
    public MapModel getSimpleModel() {
        return simpleModel;
    }
 
    
    
}
