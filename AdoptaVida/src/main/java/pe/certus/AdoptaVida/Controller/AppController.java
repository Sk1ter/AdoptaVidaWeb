package pe.certus.AdoptaVida.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
	
	@GetMapping("/")
    public String index(){ 
    	return "index"; 
    }
	
	@GetMapping("/login")
    public String login() {
        return "index";
    }
	
	@GetMapping("/profile")
	public String perfil() {
        return "profile";
    }
    
    @GetMapping("/configuration")
    public String configuration() {
        return "configuration";
    }
    
    @GetMapping("/support")
    public String support() {
        return "support";
    }
    
    @GetMapping("/payment")
    public String payment(){ 
    	return "payment"; 
    }
     
    @GetMapping("/luna")
    public String luna(){ 
    	return "luna"; 
    }
    
}