/**
 * 
 */
package com.interest.demo.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.interest.demo.vo.BusinessErrorException;
import com.interest.demo.vo.CreditGenericErrorVO;

/**
 * @author AGG
 * @date Feb 24, 2022
 * @Desc Error handling controller
 */
@ControllerAdvice
public class ExceptionHandlerController {

	/**
	 * @author AGG
	 * @date Feb 24, 2022
	 * @Desc Handle Business Exception
	 * @return ResponseEntity<CreditGenericErrorVO>
	 */
	@ExceptionHandler
	@ResponseBody
	public ResponseEntity<CreditGenericErrorVO> handleException(BusinessErrorException exception) {
		return new ResponseEntity<>(new CreditGenericErrorVO(exception.getStatus(), exception.getMessage(), exception),
				exception.getStatus());
	}

	/**
	 * @author AGG
	 * @date Feb 24, 2022
	 * @Desc Handle Runtime Exception
	 * @return ResponseEntity<CreditGenericErrorVO>
	 */
	@ExceptionHandler
	@ResponseBody
	public ResponseEntity<CreditGenericErrorVO> handleException(RuntimeException exception) {
		return new ResponseEntity<>(new CreditGenericErrorVO(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.name(),
				HttpStatus.BAD_REQUEST.value(), exception.getMessage()), HttpStatus.BAD_REQUEST);
	}
}
