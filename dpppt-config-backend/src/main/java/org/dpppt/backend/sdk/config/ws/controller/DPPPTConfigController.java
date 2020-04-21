package org.dpppt.backend.sdk.config.ws.controller;

import org.dpppt.backend.sdk.config.ws.model.ConfigResponse;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/v1")
public class DPPPTConfigController {

	private static final DateTimeFormatter DAY_DATE_FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd")
			.withZone(DateTimeZone.UTC);
	private static final Logger logger = LoggerFactory.getLogger(DPPPTConfigController.class);

	@CrossOrigin(origins = {"https://editor.swagger.io"})
	@GetMapping(value = "")
	public @ResponseBody
	String hello() {
		return "Hello from DP3T Config WS";
	}

	@CrossOrigin(origins = {"https://editor.swagger.io"})
	@GetMapping(value = "/config")
	public @ResponseBody
	ResponseEntity<ConfigResponse> getConfig(@RequestParam(required = true) String appVersion,
											 @RequestParam(required = true) String osVersion) {
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
