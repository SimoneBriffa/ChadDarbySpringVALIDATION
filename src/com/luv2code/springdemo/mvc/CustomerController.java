package com.luv2code.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		
		model.addAttribute("customer", new Customer());
		
		return "customer-form";
		
	}
	
	
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer customer,
								BindingResult bindingResult) {
		
		/*@Valid preleva le validazione, come @NotNull, presenti nella classe
		 * Customer; BindingResult registra i risultati
		 */
		
		if(bindingResult.hasErrors())
			return "customer-form";
		else
			return "customer-confirmation";
	}
	
	/* Aggiungiamo un metodo contrassegnato dall'annotazione "@InitBinder";
	 * senza questa procedura accade che una stringa composta solo da caratteri
	 * spazio non verrà riconosciuta come null dal compilatore, dunque
	 * verrà accettata. Questa annotazione fa in modo di processare tutte le richieste che
	 * arrivano al controller con questo metodo, eliminando gli spazi bianchi
	 * dalla stringa ed eventualmente degradandola a null nel caso sia
	 * composta solo da spazi bianchi
	 */
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		/*il "true" come argomento specifica che in caso di una stringa
		 * vuota, dovrà essere degradata a null
		 */
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

}
