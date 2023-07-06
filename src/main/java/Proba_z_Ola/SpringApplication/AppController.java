package Proba_z_Ola.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@Controller
public class AppController implements WebMvcConfigurer {

    @Autowired
    private WnioskiDAO dao;

    @Autowired
    private KlienciDAO tao;

    /*@RequestMapping(value={"/index","/"})
    public String viewHomePage(Model model){
        List<Wnioski> listWnioski = dao.list();
        model.addAttribute("listWnioski", listWnioski);
        return "index";
    }*/

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/edit_form").setViewName("admin/edit_form");
        registry.addViewController("/new_form").setViewName("user/new_form");
        registry.addViewController("/klienci_admin").setViewName("admin/klienci_admin");
        registry.addViewController("/klienci_user").setViewName("user/klienci_user");
        registry.addViewController("/edit2_form").setViewName("user/edit_form");

        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/main_user").setViewName("user/main_user");
    }
    @Controller
    public class DashboardController
    {
        @RequestMapping("/main")
        public String defaultAfterLogin(HttpServletRequest request) {
            if (request.isUserInRole("ADMIN")) {
                return "redirect:/main_admin";
            }
            else if (request.isUserInRole("USER")) {
                return "redirect:/main_user";
            }
            else {
                return "redirect:/index";
            }
        }
    }
    @RequestMapping(value={"/main_admin"})
    public String showAdminPage(Model model) {
        List<Wnioski> listWnioski = dao.list();
        model.addAttribute("listWnioski", listWnioski);
        return "admin/main_admin";
    }
    @RequestMapping(value={"/main_user"})
    public String showUserPage(Model model) {
        List<Wnioski> listWnioski = dao.list();
        model.addAttribute("listWnioski", listWnioski);
        return "user/main_user";
    }
    @RequestMapping(value={"/klienci_admin"})
    public String showPage(Model model){
        List<Klienci> listKlienci = tao.list();
        model.addAttribute("listKlienci", listKlienci);
        return "admin/klienci_admin";
    }
    @RequestMapping(value={"/klienci_user"})
    public String showPage2(Model model){
        List<Klienci> listKlienci = tao.list();
        model.addAttribute("listKlienci", listKlienci);
        return "user/klienci_user";
    }
    @RequestMapping("/new")
    public String showNewForm(Model model){
        Wnioski wnioski = new Wnioski();
        model.addAttribute("Wnioski", wnioski);

        return "user/new_form";
    }

    @RequestMapping("/edit/{nr_wniosku}")
    public ModelAndView showEditForm(@PathVariable(name = "nr_wniosku") int nr_wniosku){
        ModelAndView mav = new ModelAndView("admin/edit_form");
        Wnioski wnioski = dao.get(nr_wniosku);
        mav.addObject("wnioski", wnioski);

        return mav;
    }
    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("wnioski") Wnioski wnioski){
        dao.update(wnioski);

        return "redirect:/main_admin";
    }
    @RequestMapping("/delete/{nr_wniosku}")
    public String delete(@PathVariable(name = "nr_wniosku") int nr_wniosku){
        dao.delete(nr_wniosku);

        return "redirect:/main_admin";
    }
    @RequestMapping("/delete2/{nr_klienta}")
    public String delete2(@PathVariable(name = "nr_klienta") int nr_klienta){
        tao.delete(nr_klienta);

        return "redirect:/klienci_admin";
    }
    @RequestMapping(value ="/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("Wnioski") Wnioski wnioski){
        dao.save(wnioski);

        return "redirect:/main_user";
    }
    @RequestMapping("/edit2/{nr_klienta}")
    public ModelAndView showEditForm2(@PathVariable(name = "nr_klienta") int nr_klienta){
        ModelAndView mav = new ModelAndView("user/edit2_form");
        Klienci klienci = tao.get(nr_klienta);
        mav.addObject("klienci", klienci);

        return mav;
    }
    @RequestMapping(value = "/update2", method = RequestMethod.POST)
    public String update2(@ModelAttribute("klienci") Klienci klienci){
        tao.update(klienci);

        return "redirect:/klienci_user";
    }
}
