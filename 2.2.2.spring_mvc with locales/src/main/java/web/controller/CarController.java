package web.controller;

import org.apache.taglibs.standard.lang.jstl.test.PageContextImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/")
public class CarController {

    @Autowired
    private SessionLocaleResolver sessionLocaleResolver;

    @RequestMapping(value = "cars", method = RequestMethod.GET)
    public String printWelcome(@RequestParam(required = false, defaultValue = "en") String locale, ModelMap model) {

        sessionLocaleResolver.setDefaultLocale(new Locale(locale));

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Mitsubishi", "Lancer", "a123ck"));
        cars.add(new Car("Toyota", "Corolla", "h451sd"));
        cars.add(new Car("Nissan", "Quashqai", "j564ef"));

        model.addAttribute("cars", cars);
        model.addAttribute("locale", locale);
        return "cars";
    }
}
