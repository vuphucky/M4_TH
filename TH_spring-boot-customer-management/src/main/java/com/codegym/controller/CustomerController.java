package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer())      ;
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer){
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message","create succsessfully");
        return modelAndView;
    }

    @GetMapping
    public ModelAndView listCustomer(){
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customers",customerService.findAll());
        return modelAndView;
    }
    @GetMapping("/update/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/customer/update" );
            modelAndView.addObject("customer",customer.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error_404");
        }
    }

    @PostMapping("/update")
    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer){
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/update");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("message", "update successfully");
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id)   {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/customer/delete" );
            modelAndView.addObject("customer",customer.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error_404");
        }
    }
    @PostMapping("/delete")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer){
        customerService.remmove(customer.getId());
        return "redirect:/customers";
    }
}
