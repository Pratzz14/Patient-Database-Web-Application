package com.example.patientDatabase;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/patients/")
public class PatientController {
	@Autowired
	private PatientRepository patientRepository;	
	
	//GetMapping means sending a GET request
	//Send the user to the add-patient.html file to add the patient info
	@GetMapping("showForm")
	public String showStudentForm(Patient patient) {
		return "add-patient";
	}
	
	//Display index.html file
	//This file contains a button to add patient
	//And the list of all the patients with the options to update/delete
	@GetMapping("list")
	public String patients(Model model) {
		model.addAttribute("patients", this.patientRepository.findAll());
		return "index";
	}
	
	//Sending a POST request
	//The post request takes in the patient details
	//If any error is encountered it just redirects it to add-patient.html file
	//If no error then it is saved and redirected to index.html
	@PostMapping("add")
	public String addPatient(@Valid Patient patient, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "add-patient";
		}
		
		this.patientRepository.save(patient);
		return "redirect:list";
	}
	
	//So when we click on the update button on a particular patient
	//It will redirect you to the update-patient.html 
	//{id} will take in account which patient details to update
	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable ("id") long id, Model model) {
		Patient patient = this.patientRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid patient id : " + id));
		
		model.addAttribute("patient", patient);
		return "update-patient";
	}
	
	//This POST request will take the patient updated info and it for {id} patient
	//After updating it will redirect you to the index.html page
	@PostMapping("update/{id}")
	public String updatePatient(@PathVariable("id") long id, @Valid Patient patient, BindingResult result, Model model) {
		if(result.hasErrors()) {
			patient.setId(id);
			return "update-patient";
		}
		
		patientRepository.save(patient);
		
		model.addAttribute("patients", this.patientRepository.findAll());
		return "index";
	}
	
	//When you click on delete button it delete the {id} patient
	//After deleting, you will be redirected to index.html page.
	//If you did a manual delete with non-existing id it will throw an error.
	@GetMapping("delete/{id}")
	public String deletePatient(@PathVariable ("id") long id, Model model) {
		
		Patient patient = this.patientRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid patient id : " + id));
		
		this.patientRepository.delete(patient);
		model.addAttribute("patients", this.patientRepository.findAll());
		return "index";
		
	}
}
