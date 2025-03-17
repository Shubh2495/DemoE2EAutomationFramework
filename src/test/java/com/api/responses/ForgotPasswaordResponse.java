package com.api.responses;

public class ForgotPasswaordResponse {
public ForgotPasswaordResponse() {
		super();
	}

private String message;

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

@Override
public String toString() {
	return "ForgotPasswaordResponse [message=" + message + "]";
}

public ForgotPasswaordResponse(String message) {
	super();
	this.message = message;
}

}
