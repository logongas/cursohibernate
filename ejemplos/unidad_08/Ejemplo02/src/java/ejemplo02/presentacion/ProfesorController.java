/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo02.presentacion;

import com.fpmislata.persistencia.dao.BussinessException;
import ejemplo02.dominio.Profesor;
import ejemplo02.persistencia.dao.ProfesorDAO;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Lorenzo González
 */
@Controller
public class ProfesorController {

    @Autowired
    private ProfesorDAO profesorDAO;

    @RequestMapping({"/index.html"})
    public ModelAndView read(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> model = new HashMap<String, Object>();
        String viewName;

        try {
            Profesor profesor = profesorDAO.get(1001);
            model.put("texto", profesor.toString());
            viewName = "profesor";
        } catch (BussinessException ex) {
            model.put("msgError", "No es posible obtener los datos");
            viewName = "error";
        }

        return new ModelAndView(viewName, model);
    }
}
