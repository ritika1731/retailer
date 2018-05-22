package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cg.services.AtmDenominationService;

@Controller
public class AtmDenominationController {

	@Autowired
	AtmDenominationService adSer;
}
