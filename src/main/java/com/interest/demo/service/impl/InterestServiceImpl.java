/**
 * 
 */
package com.interest.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.interest.demo.repository.InterestRepository;
import com.interest.demo.service.InterestService;
import com.interest.demo.vo.BusinessErrorException;
import com.interest.demo.vo.CreditInputVO;
import com.interest.demo.vo.CreditOutputVO;

/**
 * @author AGG
 * @date Feb 22, 2022
 * @Desc Interest Srvice Implementation
 */
@Service
public class InterestServiceImpl implements InterestService {

	private static final String SMS_DATOS_REQUERIDOS = "The data amount, rate and terms are required and must be greater than 0.";
	@Autowired
	private InterestRepository interestRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<CreditOutputVO> creteCreditList(CreditInputVO creditInputVO) {
		this.checkData(creditInputVO);
		return interestRepository.creteCreditList(creditInputVO);
	}

	/**
	 * @author AGG
	 * @date Feb 24, 2022
	 * @Desc Dat vaidations
	 * @return void
	 */
	private void checkData(CreditInputVO creditInputVO) {
		boolean exito = true;

		if (creditInputVO.getAmount() == null || creditInputVO.getRate() == null || creditInputVO.getTerms() == null) {
			exito = false;
		} else {
			if (creditInputVO.getAmount() <= 0 || creditInputVO.getRate() <= 0 || creditInputVO.getTerms() <= 0) {
				exito = false;
			}
		}

		if (!exito) {
			throw new BusinessErrorException(SMS_DATOS_REQUERIDOS, HttpStatus.BAD_REQUEST);
		}
	}
}
