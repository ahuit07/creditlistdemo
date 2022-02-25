/**
 * 
 */
package com.interest.demo.service;

import java.util.List;

import com.interest.demo.vo.CreditInputVO;
import com.interest.demo.vo.CreditOutputVO;

/**@author AGG
 * @date Feb 22, 2022
 * @Desc 
 */
public interface InterestService {
	/**
	 * @author AGG
	 * @date Feb 22, 2022
	 * @Desc Create credit list
	 * @return void
	 */
	List<CreditOutputVO> creteCreditList(CreditInputVO creditInputVO);
}
