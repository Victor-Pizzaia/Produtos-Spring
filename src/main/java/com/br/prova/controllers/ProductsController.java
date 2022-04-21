package com.br.prova.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.br.prova.models.Produto;
import com.br.prova.repository.IProdutoRepository;

import lombok.val;

@Controller
public class ProductsController {
	@Autowired
	private IProdutoRepository productRepository;

	@RequestMapping(value="/produtos", method=RequestMethod.GET)
	public ModelAndView getAllProducts() {
		ModelAndView modelView = new ModelAndView("/produtos");
		val products = productRepository.findAll();
		modelView.addObject("products", products);
		return modelView;
	}
	
	@RequestMapping(value="/cadastro", method=RequestMethod.POST)
	public String save(@Valid Produto prod, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastro";
		}
		val cadProduct = productRepository.save(prod);
		attributes.addFlashAttribute("mensagem", "Produto adicionado com sucesso ! #" + cadProduct.getIdProduto());
		return "redirect:/produtos";
	}
	
	@RequestMapping(value="/produtos/{id}", method=RequestMethod.GET)
	public Optional<Produto> getById(@PathVariable int id) {
		return productRepository.findById(id);
	}

	@RequestMapping(value="/deletarProduto", method=RequestMethod.DELETE)
	public String delete(int id) {
		productRepository.deleteById(id);
		return "redirect:/produtos";
	}
	
	@RequestMapping(value="/cadastro", method=RequestMethod.GET)
	public String cadastro() {
		return "cadastro";
	}
}
