package com.br.prova.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping(value="/produtos", method=RequestMethod.POST)
	public ResponseEntity<Produto> save(@RequestBody Produto prod) {
		val cadProduct = productRepository.save(prod);
		return new ResponseEntity<Produto>(cadProduct, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/produtos/{id}", method=RequestMethod.GET)
	public Optional<Produto> getById(@PathVariable int id) {
		return productRepository.findById(id);
	}

	@RequestMapping(value="/produtos/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable int id) {
		productRepository.deleteById(id);
		return ResponseEntity.ok("Produto Deletado");
	}
}
