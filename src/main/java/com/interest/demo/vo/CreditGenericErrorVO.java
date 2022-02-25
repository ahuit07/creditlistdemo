/**
 * 
 */
package com.interest.demo.vo;

import java.time.LocalDateTime;
	
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author AGG
 * @date Feb 24, 2022
 * @Desc Generic error VO
 */
public class CreditGenericErrorVO {
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	private String message;
	private int  statusNumber;;
	private String traceMessage;
	private HttpStatus status;

	private CreditGenericErrorVO() {
		timestamp = LocalDateTime.now();
	}

	public CreditGenericErrorVO(HttpStatus status) {
		this();
		this.setStatus(status);
	}

	public CreditGenericErrorVO(HttpStatus status, String messsageError, int statusValue, String traceMessage) {
		this();
		this.setStatus(status);
		this.setStatusNumber(statusValue);
		this.setMessage(messsageError);
		this.setTraceMessage(traceMessage);
	}

	public CreditGenericErrorVO(HttpStatus status, String message, Throwable ex) {
		this();
		this.setStatus(status);
		this.setMessage(message);
		this.setTraceMessage(ex.getLocalizedMessage());
	}

	/**
	 * @return the status
	 */
	public HttpStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the traceMessage
	 */
	public String getTraceMessage() {
		return traceMessage;
	}

	/**
	 * @param traceMessage the traceMessage to set
	 */
	public void setTraceMessage(String traceMessage) {
		this.traceMessage = traceMessage;
	}

	/**
	 * @return the statusNumber
	 */
	public int getStatusNumber() {
		return statusNumber;
	}

	/**
	 * @param statusNumber the statusNumber to set
	 */
	public void setStatusNumber(int statusNumber) {
		this.statusNumber = statusNumber;
	}
}
