/**
 * 
 */
package com.interest.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.interest.demo.service.InterestService;
import com.interest.demo.vo.CreditInputVO;
import com.interest.demo.vo.CreditOutputVO;

/**
 * @author AGG
 * @date Feb 22, 2022
 * @Desc Create interest list Contoller 
 */
@RestController
@RequestMapping(value = "/ms")
public class InterestController {
	
	@Autowired
	private InterestService interestService;
	
	/**
	 * @author AGG
	 * @date Feb 24, 2022
	 * @Desc End point credit list
	 * @return List<CreditOutputVO>
	 */
	@RequestMapping(value = "/createCreditList", method = RequestMethod.POST)
	public List<CreditOutputVO> createCreditList(@RequestBody CreditInputVO creditInputVO) {
		return interestService.creteCreditList(creditInputVO);
	}
}
