/**
 * 
 */
package com.interest.demo.repository;

import java.util.List;

import com.interest.demo.vo.CreditInputVO;
import com.interest.demo.vo.CreditOutputVO;

/**@author AGG
 * @date Feb 22, 2022
 * @Desc 
 */
public interface InterestRepository {
	/**
	 * @author AGG
	 * @date Feb 22, 2022
	 * @Desc Create credit list
	 * @return void
	 */
	List<CreditOutputVO> creteCreditList(CreditInputVO creditInputVO);
}
