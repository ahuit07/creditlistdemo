/**
 * 
 */
package com.interest.demo.vo;

import org.springframework.http.HttpStatus;

/**@author AGG
 * @date Feb 24, 2022
 * @Desc Business exception
 */
public class BusinessErrorException extends RuntimeException{ 
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private HttpStatus status;

	    public BusinessErrorException(String message, HttpStatus status) {
	        super(message);
	        this.status = status;
	    }

	    public HttpStatus getStatus() {
	        return status;
	    }
}
