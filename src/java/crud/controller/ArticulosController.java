/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import crud.model.Articulo;
import crud.model.ArticulosDao;
@Controller
public class ArticulosController {
    @Autowired
ArticulosDao dao;
//-- Listar los artículos (Grid)
@RequestMapping(value = "/lista")
public String articuloview(Model m){
System.out.println("*** ArticulosController.articuloview" );
List<Articulo> list = dao.getArticulos();
m.addAttribute("list", list);
return "articulosGrid";
}
@RequestMapping(value = "/nuevo")
public String showForm( Model m){
System.out.println("*** ArticulosController.showForm" );
m.addAttribute("command", new Articulo() );
return "articuloNewForm";
}
@RequestMapping(value = "/guardar", method= RequestMethod.POST)
public String guardar( @ModelAttribute("articulo") Articulo articulo ){
System.out.println("*** ArticulosController.guardar" );
dao.guardar(articulo);
return "redirect:lista.htm";
}
@RequestMapping(value = "/editar", method = RequestMethod.GET)
public String actualiza (@RequestParam(value = "id", required = true)
int id, Model m){
System.out.println("*** ArticulosController.actualiza id=" + id);
Articulo articulo = dao.getArticuloById( id);
m.addAttribute("command", articulo);
return "articuloEditForm";
}
@RequestMapping( value = "/actualizar", method = RequestMethod.POST)
public String editsave( @ModelAttribute("articulo") Articulo articulo) {
System.out.println("*** ArticulosController.editsave " );
dao.actualiza(articulo);
return "redirect:lista.htm";
}
@RequestMapping( value = "/borrar", method = RequestMethod.GET)
public String borrar( @RequestParam(value = "id", required = true)int id) {
System.out.println("*** ArticulosController.borrar id=" + id );
dao.borrar(id);
return "redirect:lista.htm";
}

    
}
