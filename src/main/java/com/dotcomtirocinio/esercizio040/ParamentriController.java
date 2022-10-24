package com.dotcomtirocinio.esercizio040;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;


@Controller
    public class ParamentriController {


    @Autowired
    private Parametri parametri;


    @GetMapping("/")
    public ModelAndView home(){

        return new ModelAndView("index");
    }

    @GetMapping("/inizia")
    public ModelAndView carregaForm() throws JAXBException, IOException {

        Map<String, String> usuario = new HashMap<>();
        usuario.put("parametro_uno", "maggiore");
        usuario.put("parametro_due", "maggiore");
        usuario.put("parametro_tre", "minore");

            ModelAndView mav = new ModelAndView("inizia.html");
            mav.addObject("parametri", this.parametri);
            mav.addObject("usuario", usuario);
        System.out.println(mav);

            return mav;
    }

    @PostMapping("/result")
    public ModelAndView submitFormRegister(HttpServletRequest request,ModelMap model){


        ModelAndView mav = new ModelAndView("result.html");
        model.addAttribute("parametro_uno", request.getParameter("parametro_uno"));
        model.addAttribute("parametro_due", request.getParameter("parametro_due"));
        model.addAttribute("parametro_tre", request.getParameter("parametro_tre"));
        return mav;
    }

    @PostMapping("/inizia")
    public ModelAndView submitForm(HttpServletRequest request, Parametri parametri, Parametri.Parametro parametro) {
        Enumeration<String> names = request.getParameterNames();


        ModelAndView mav = new ModelAndView("register.html");

        mav.addObject("parametri", this.parametri.getParametro());
        mav.addObject("names", names);




        while (names.hasMoreElements())
        {
            String name = names.nextElement();
            System.out.println(name + " = " + request.getParameter(name));
            mav.addObject(name, request.getParameter(name));



        }

        ModelMap modelMap = new ModelMap();

        List<Map<String, BigDecimal>> mapsList = new ArrayList<Map<String, BigDecimal>>();

        Map<String, BigDecimal> mapMaggiore = new HashMap<String, BigDecimal>();
        mapMaggiore.put("maggiore", BigDecimal.valueOf(20));


        Map<String, BigDecimal> mapMaggiore2 = new HashMap<String, BigDecimal>();
        mapMaggiore2.put("maggiore", BigDecimal.valueOf(3.7));


        Map<String, BigDecimal> mapMinore = new HashMap<String, BigDecimal>();
        mapMinore.put("minore", BigDecimal.valueOf(10));

        Map<String, BigDecimal> mapMinore2 = new HashMap<String, BigDecimal>();
       mapMinore2.put("minore", BigDecimal.valueOf(5));


        mapsList.add(mapMaggiore);
        mapsList.add(mapMaggiore2);

        mapsList.add(mapMinore);
        mapsList.add(mapMinore2);

        modelMap.put("mapsList", mapsList);

        mav.addObject(mapsList);




        System.out.println(mapsList);

        return mav;
    }


    }


//
//    @PostMapping("/teste2")
//    public ModelAndView mostrarrisultato () throws JAXBException, IOException {
//        ModelAndView mav = new ModelAndView("register.html");
//        mav.addObject("parametri", this.parametri);
//
//        System.out.println(parametri.getRisultato());
//
//        return mav;
//    }


//    @GetMapping("/teste5")
//        public void createParametro(OutputStream out){
//        try (InputStream is = new FileInputStream("/home/patricia/Documenti/07.10/esercizio05.10/esercizio04.10/src/main/resources/web.xml")) {
//                StreamUtils.copy(is, out);  //StreamUtils copia file
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
