package com.codegym.customermanageexceptionhandler.exception;

public class DuplicateEmailException extends Exception{
    public DuplicateEmailException() {
        super("Email bị trùng");
    }
}
