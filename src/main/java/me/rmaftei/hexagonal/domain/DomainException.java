package me.rmaftei.hexagonal.domain;

class DomainException extends RuntimeException {
    DomainException(final String message) {
        super(message);
    }
}