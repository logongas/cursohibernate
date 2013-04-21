/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo03.presentacion;

import com.fpmislata.persistencia.dao.BussinessException;
import com.fpmislata.persistencia.dao.BussinessMessage;
import ejemplo03.dominio.Usuario;
import ejemplo03.persistencia.dao.UsuarioDAO;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioController {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    private UsuarioDAO usuarioDAO;

    @RequestMapping({"/usuario/newForm.html"})
    public ModelAndView newForm(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> model = new HashMap<String, Object>();
        String viewName;

        try {
            Usuario usuario = usuarioDAO.create();
            model.put("formOperation", FormOperation.Create);
            model.put("usuario", usuario);
            viewName = "usuario";
        } catch (BussinessException ex) {
            model.put("bussinessMessages", ex.getBussinessMessages());
            model.put("backURL", request.getContextPath() + "/index.html");
            viewName = "error";
        }

        return new ModelAndView(viewName, model);
    }

    @RequestMapping({"/usuario/viewForm.html"})
    public ModelAndView viewForm(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> model = new HashMap<String, Object>();
        String viewName;

        try {

            int idUsuario;
            try {
                idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
            } catch (NumberFormatException nfe) {
                throw new BussinessException(new BussinessMessage(null,"Se debe escribir un IdUsuario"));
            }
            Usuario usuario = usuarioDAO.get(idUsuario);
            if (usuario == null) {
                throw new BussinessException(new BussinessMessage(null, "No existe el usuario con IdUsuario=" + idUsuario));
            }
            model.put("formOperation", FormOperation.Read);
            model.put("usuario", usuario);
            viewName = "usuario";
        } catch (BussinessException ex) {
            model.put("bussinessMessages", ex.getBussinessMessages());
            model.put("backURL", request.getContextPath() + "/index.html");
            viewName = "error";
        }

        return new ModelAndView(viewName, model);
    }

    @RequestMapping({"/usuario/editForm.html"})
    public ModelAndView editForm(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> model = new HashMap<String, Object>();
        String viewName;

        try {
            int idUsuario;
            try {
                idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
            } catch (NumberFormatException nfe) {
                throw new BussinessException(new BussinessMessage(null,"Se debe escribir un IdUsuario"));
            }
            Usuario usuario = usuarioDAO.get(idUsuario);
            if (usuario == null) {
                throw new BussinessException(new BussinessMessage(null, "No existe el usuario con IdUsuario=" + idUsuario));
            }
            model.put("formOperation", FormOperation.Update);
            model.put("usuario", usuario);
            viewName = "usuario";
        } catch (BussinessException ex) {
            model.put("bussinessMessages", ex.getBussinessMessages());
            model.put("backURL", request.getContextPath() + "/index.html");
            viewName = "error";
        }

        return new ModelAndView(viewName, model);
    }

    @RequestMapping({"/usuario/deleteForm.html"})
    public ModelAndView deleteForm(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> model = new HashMap<String, Object>();
        String viewName;

        try {
            int idUsuario;
            try {
                idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
            } catch (NumberFormatException nfe) {
                throw new BussinessException(new BussinessMessage(null,"Se debe escribir un IdUsuario"));
            }
            Usuario usuario = usuarioDAO.get(idUsuario);
            if (usuario == null) {
                throw new BussinessException(new BussinessMessage(null, "No existe el usuario con IdUsuario=" + idUsuario));
            }
            model.put("formOperation", FormOperation.Delete);
            model.put("usuario", usuario);
            viewName = "usuario";
        } catch (BussinessException ex) {
            model.put("bussinessMessages", ex.getBussinessMessages());
            model.put("backURL", request.getContextPath() + "/index.html");
            viewName = "error";
        }

        return new ModelAndView(viewName, model);
    }

    @RequestMapping({"/usuario/save.html"})
    public ModelAndView save(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> model = new HashMap<String, Object>();
        String viewName;

        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex);
        }

        Usuario usuario = null;
        try {
            usuario = usuarioDAO.create();

            usuario.setLogin(request.getParameter("login"));
            usuario.setNombre(request.getParameter("nombre"));
            usuario.setApe1(request.getParameter("ape1"));
            usuario.setApe2(request.getParameter("ape2"));
            usuario.setPassword(request.getParameter("password"));

            usuarioDAO.saveOrUpdate(usuario);

            viewName = "index";
        } catch (BussinessException ex) {
            model.put("bussinessMessages", ex.getBussinessMessages());
            model.put("usuario", usuario);
            model.put("formOperation", FormOperation.Create);
            viewName = "usuario";
        }



        return new ModelAndView(viewName, model);
    }

    @RequestMapping({"/usuario/update.html"})
    public ModelAndView update(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> model = new HashMap<String, Object>();
        String viewName;

        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex);
        }

        Usuario usuario = null;
        try {
            int idUsuario;
            try {
                idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
            } catch (NumberFormatException nfe) {
                throw new BussinessException(new BussinessMessage(null,"Se debe escribir un IdUsuario"));
            }
            usuario = usuarioDAO.get(idUsuario);
            if (usuario == null) {
                throw new BussinessException(new BussinessMessage(null, "Ya no existe el usuario."));
            }
            usuario.setLogin(request.getParameter("login"));
            usuario.setNombre(request.getParameter("nombre"));
            usuario.setApe1(request.getParameter("ape1"));
            usuario.setApe2(request.getParameter("ape2"));
            usuario.setPassword(request.getParameter("password"));

            usuarioDAO.saveOrUpdate(usuario);

            viewName = "index";
        } catch (BussinessException ex) {
            model.put("bussinessMessages", ex.getBussinessMessages());
            model.put("usuario", usuario);
            model.put("formOperation", FormOperation.Update);
            viewName = "usuario";
        }

        return new ModelAndView(viewName, model);
    }

    @RequestMapping({"/usuario/delete.html"})
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> model = new HashMap<String, Object>();
        String viewName;

        try {
            int idUsuario;
            try {
                idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
            } catch (NumberFormatException nfe) {
                throw new BussinessException(new BussinessMessage(null,"Se debe escribir un IdUsuario"));
            }
            usuarioDAO.delete(idUsuario);
            viewName = "index";
        } catch (BussinessException ex) {
            model.put("bussinessMessages", ex.getBussinessMessages());
            model.put("backURL", request.getContextPath() + "/index.html");
            viewName = "error";
        }

        return new ModelAndView(viewName, model);
    }
}
