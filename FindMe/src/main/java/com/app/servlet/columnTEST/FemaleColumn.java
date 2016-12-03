package com.app.servlet.columnTEST;

/**
 * Created by apavliuchenkova on 22/11/2016.
 */
public class FemaleColumn implements ColumnParameters, ColumnParametersInput{
    private final String female = "female";
    private final String columnName = "Female";
    private final boolean disabled = false;
    private final boolean mandatory = false;
    private final int minLength = 0;
    private final int maxLength = 6;
    private final String placeholder = "";
    private final String type = "text";

    public String getMale() {
        return female;
    }

    @Override
    public String getColumnName() {
        return columnName;
    }

    @Override
    public boolean isDisabled() {
        return disabled;
    }

    @Override
    public boolean isMandatory() {
        return mandatory;
    }

    @Override
    public int getMinLength() {
        return minLength;
    }

    @Override
    public int getMaxLength() {
        return maxLength;
    }

    @Override
    public String getPlaceholder() {
        return placeholder;
    }

    @Override
    public String getType() {
        return type;
    }
}
