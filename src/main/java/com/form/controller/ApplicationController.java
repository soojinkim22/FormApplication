package com.form.controller;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.form.model.UserAnswer;

@Controller
public class ApplicationController {
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String GetPageForm( UserAnswer user_answer, Model model ){
		model.addAttribute("useranswer", new UserAnswer());
		//model.addAttribute("checkItems", CHECK_ITEMS);
	    model.addAttribute("radioItems", RADIO_ITEMS);
	    
		return "form/userAnswerForm";
	}
	
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String FormConfirm(@ModelAttribute("useranswer") UserAnswer user_answer, BindingResult result, Model model){
		if(result.hasErrors()){
			model.addAttribute("validationError", "不正な値が入力されました。");
			return GetPageForm(user_answer, model);
		}
		// user 処理
		return "form/userAnswerResult";
	}

	/**
	 * check boxの表示に使用するアイテム
	 */
	final static Map<String, String> CHECK_ITEMS = Collections.unmodifiableMap(new LinkedHashMap<String, String>() {
	    {
	      put("checkbox_A", "A");
	      put("checkbox_B", "B");
	      put("checkbox_C", "C");
	      put("checkbox_D", "D");
	      put("checkbox_E", "E");
	    }
	});

	/**
	 * radio buttonの表示に使用するアイテム
	 */
	final static Map<String, String> RADIO_ITEMS = Collections.unmodifiableMap(new LinkedHashMap<String, String>() {
	    {
	      put("radio_A", "A");
	      put("radio_B", "B");
	      put("radio_C", "C");
	      put("radio_D", "D");
	      put("radio_E", "E");
	    }
	});
}
