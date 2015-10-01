package ru.habrahabr.exceptions;

/**
 * Date: 26.03.2014
 * Time: 16:09
 *
 * @author Ruslan Molchanov (ruslanys@gmail.com)
 */
public class SequenceException extends RuntimeException {
    public SequenceException(String message) {
        super(message);
    }
}
