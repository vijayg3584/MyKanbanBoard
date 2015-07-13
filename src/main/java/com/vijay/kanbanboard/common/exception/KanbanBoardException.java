package com.vijay.kanbanboard.common.exception;

import com.vijay.kanbanboard.common.model.ErrorMessage;

@SuppressWarnings("serial")
public class KanbanBoardException extends RuntimeException {

	private ErrorMessage errorMessage;

	public KanbanBoardException() {
		super();
	}

	public KanbanBoardException(ErrorMessage errMsg) {
		this.setErrorMessage(errMsg);
	}

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}

}
