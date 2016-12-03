package com.app.servlet.columnTEST;

/**
 * Created by apavliuchenkova on 22/11/2016.
 */
public interface ColumnParameters {
    String getColumnName();
    boolean isDisabled();
    boolean isMandatory();
    int getMinLength();
    int getMaxLength();
    String getPlaceholder();
}
