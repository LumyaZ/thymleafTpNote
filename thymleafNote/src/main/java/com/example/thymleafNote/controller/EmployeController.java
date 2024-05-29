package com.example.thymleafNote.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.thymleafNote.model.Absence;
import com.example.thymleafNote.model.Candidat;
import com.example.thymleafNote.model.Conge;
import com.example.thymleafNote.model.Employe;
import com.example.thymleafNote.repository.AbsenceRepository;
import com.example.thymleafNote.repository.CongeRepository;
import com.example.thymleafNote.service.AbsenceService;
import com.example.thymleafNote.service.CandidatService;
import com.example.thymleafNote.service.CongeService;
import com.example.thymleafNote.service.EmployeService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/employes")
public class EmployeController {

	@Autowired
	private EmployeService employesService;
	
	@Autowired
	private CandidatService candidatService;
	
	@Autowired
    private CongeService congeService;
	
	@Autowired
    private CongeRepository congeRepo;
    
    @Autowired
    private AbsenceService absenceService;
    
    @Autowired
    private AbsenceRepository absenceRepo;
	
	/*@GetMapping("/listEmployes")
    public String listEmployes(Model model) {
    	List<Employes> employesList = employesService.findAll();
        model.addAttribute("employes", employesList);
        return "product/list";
    }*/
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
	
	@GetMapping("/view/home")
    public String home(Model model) {
		int nombreEmployes = employesService.findAll().size();
	    int nombreCandidats = candidatService.findAll().size();

	    model.addAttribute("nombreEmployes", nombreEmployes);
	    model.addAttribute("nombreCandidats", nombreCandidats);

		
        return "view/home";  
    }

    @GetMapping("/view/employes")
    public String employes(Model model) {
    	List<Employe> employeList = employesService.findAll();
        model.addAttribute("employes", employeList);
        return "view/employes";  
    }

    @GetMapping("/view/candidat")
    public String candidat(Model model) {
    	List<Candidat> candidatList = candidatService.findAll();
        model.addAttribute("candidats", candidatList);
        return "view/candidat";
    }
    
    @GetMapping("/view/addEmploye")
    public String showFormEmployee(Model model) {
        model.addAttribute("employe", new Employe());
        model.addAttribute("employes", employesService.findAll());
        return "view/addEmploye";
    }
    
    @PostMapping("/view/saveEmploye")
    public String saveEmploye(@Valid @ModelAttribute Employe employe, BindingResult result,
    							Model model 
    							) {
    	if(result.hasErrors()) {
    		model.addAttribute("employes", employesService.findAll());
    		return "view/addEmploye";
    	}
    	employesService.save(employe);
        return "redirect:employes";
    }
    
    @GetMapping("/deleteEmploye/{id}")
    public String deleteEmploye(@PathVariable("id") Long id) {
    	Employe employe = employesService.findById(id);
    	List<Conge> findAllCongeByEmployeId = congeService.findAllByEmployeId(id);
    	if(findAllCongeByEmployeId != null) {
    		for(Conge conge : findAllCongeByEmployeId) {
	    		congeService.deleteById(conge.getId());
	    	}
    	}
    	List<Absence> findAllAbsenceByEmployeId = absenceService.findAllByEmployeId(id);
    	if(findAllAbsenceByEmployeId != null) {
    		for(Absence absence : findAllAbsenceByEmployeId) {
	    		absenceService.deleteById(absence.getId());
	    	}
    	}
    	employesService.deleteById(id);
        return "redirect:/employes/view/employes";
    }
    
    @GetMapping("view/detailEmploye/{id}")
    public String detailEmploye(@PathVariable("id") Long id, Model model) {
        Employe employe = employesService.findById(id);
        List<Conge> findAllCongesByEmployeId = congeService.findAllByEmployeId(id);
        List<Absence> findAllAbsenceByEmployeId = absenceService.findAllByEmployeId(id);
        model.addAttribute("employe", employe);
        model.addAttribute("findAllCongesByEmployeId", findAllCongesByEmployeId);
        model.addAttribute("findAllAbsenceByEmployeId", findAllAbsenceByEmployeId);
        model.addAttribute("countConge", findAllCongesByEmployeId.size());
        model.addAttribute("countAbsence", findAllAbsenceByEmployeId.size());
        return "view/detailEmploye";
    }
    
    @GetMapping("view/editEmploye/{id}")
    public String editEmploye(@PathVariable("id") Long id, Model model) {
        Employe employe = employesService.findById(id);
        model.addAttribute("employe", employe);
        return "view/editEmploye";
    }
    
    @PostMapping("view/updateEmploye")
    public String updateEmploye(@ModelAttribute("employe") Employe employe) {
    	employesService.save(employe);
        return "redirect:/employes/view/employes";
    }
    
    
    @GetMapping("/view/addCandidat")
    public String showFormCandidat(Model model) {
        model.addAttribute("candidat", new Candidat());
        model.addAttribute("candidats", candidatService.findAll());
        return "view/addCandidat";
    }
    
    
    @PostMapping("/view/saveCandidat")
    public String saveCandidat(@Valid @ModelAttribute Candidat candidat, BindingResult result,
    							Model model 
    							) {
    	if(result.hasErrors()) {
    		model.addAttribute("candidats", candidatService.findAll());
    		return "view/addCandidat";
    	}
    	candidatService.save(candidat);
        return "redirect:/employes/view/candidat";
    }
    
    @GetMapping("/deleteCandidat/{id}")
    public String deleteCandidat(@PathVariable("id") Long id) {
    	candidatService.deleteById(id);
        return "redirect:/employes/view/candidat"; 
    }
    
    @GetMapping("view/detailCandidat/{id}")
    public String detailCandidat(@PathVariable("id") Long id, Model model) {
        Candidat candidat = candidatService.findById(id);
        model.addAttribute("candidat", candidat);
        return "view/detailCandidat";
    }
    
    @GetMapping("view/editCandidat/{id}")
    public String editCandidat(@PathVariable("id") Long id, Model model) {
        Candidat candidat = candidatService.findById(id);
        model.addAttribute("candidat", candidat);
        return "view/editCandidat";
    }
    
    @PostMapping("/updateCandidat")
    public String updateCandidat(@ModelAttribute("candidat") Candidat candidat) {
        candidatService.save(candidat);
        return "redirect:/employes/view/candidat";
    }
    
    @GetMapping("/view/addConge/{id}")
    public String showAddCongeForm(@PathVariable("id") Long employeId, Model model) {
        Employe employe = employesService.findById(employeId);
        Conge conge = new Conge();
        conge.setEmploye(employe);
        model.addAttribute("employe", employe);
        model.addAttribute("conge", conge);
        return "view/addConge"; 
    }

    @PostMapping("view/saveConge")
    public String saveConge(@ModelAttribute("conge") Conge conge, @RequestParam("employe.id") Long employeId) {
        Employe employe = employesService.findById(employeId);
        Conge newConge = new Conge();
        newConge.setDatedebut(conge.getDatedebut());
        newConge.setDatefin(conge.getDatefin());
        newConge.setEmploye(employe);
        congeService.save(newConge);
        return "redirect:/employes/view/detailEmploye/" + employe.getId();
    }
    
    @GetMapping("/view/addAbsence/{id}")
    public String showAddAbsenceForm(@PathVariable("id") Long employeId, Model model) {
        Employe employe = employesService.findById(employeId);
        Absence absence = new Absence();
        absence.setEmploye(employe);
        model.addAttribute("employe", employe);
        model.addAttribute("absence", absence);
        return "view/addAbsence"; 
    }

    @PostMapping("view/saveAbsence")
    public String saveAbsence(@ModelAttribute("absence") Absence absence, @RequestParam("employe.id") Long employeId) {
        Employe employe = employesService.findById(employeId);
        Absence newAbsence = new Absence();
        newAbsence.setDate(absence.getDate());
        newAbsence.setEmploye(employe);
        absenceService.save(newAbsence);
        return "redirect:/employes/view/detailEmploye/" + employe.getId();
    }

}
