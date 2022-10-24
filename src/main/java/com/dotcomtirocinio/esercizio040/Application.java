package com.dotcomtirocinio.esercizio040;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@ComponentScan
@SpringBootApplication
@Controller
public class Application{


//	Parametri parametri = new Parametri();
public static void main(String[] args) {
	SpringApplication.run(Application.class, args);
}


//
//	@Autowired
//	private AppMarshaller appMarshaller;
//
//	public Application(AppMarshaller appMarshaller) {
//		this.appMarshaller = appMarshaller;
//	}
//
//
//

//
//		@GetMapping("/register")
//		public String iniciarparamentros (Model model, Parametri parametri) {
//			model.addAttribute("parameters", parametri);
//			model.addAttribute("parameters2", appMarshaller);
//			return "webparametri";
//		}
//
//	@GetMapping("/novosparametros")
//	public String parametriadd (Model model2,  Parametri parametri)
//	{
//		model2.addAttribute("parameters", new Parametri());
//
//		return "novoteste";
//	}

	}



