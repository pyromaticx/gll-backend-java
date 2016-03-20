package com.gll.controller.hrboost;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FrontController {

	private static final Logger logger = Logger.getLogger(FrontController.class);

	/* ============= Home Page Section Start ==================== */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView indexPage() {

		// logs debug message
		if (logger.isDebugEnabled()) {
			logger.debug("logger.debug:==============> indexPage processing.....");
		}
		logger.info("logger.info:================> indexPage dispatching.....");
		//logger.error("indexPage execption throwing...", new Exception("indexPage exception throwing..."));
		logger.fatal("logger.fatal:================> indexPage dispatching.....");
		logger.trace("logger.trace:================> indexPage dispatching.....");

		return new ModelAndView("index");
	}
}
