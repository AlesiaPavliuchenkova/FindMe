package com.app.servlet.utilities;

/**
 * Created by alesia on 12/1/16.
 */
public interface Validator<DTO, EX extends Throwable> {
    void validate(DTO dto) throws EX;
}
