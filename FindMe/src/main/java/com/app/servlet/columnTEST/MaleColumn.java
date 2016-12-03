package com.app.servlet.columnTEST;

/**
 * Created by apavliuchenkova on 22/11/2016.
 */
public class MaleColumn implements ColumnParameters, ColumnParametersInput{

    private final String male = "male";
    private final String columnName = "Male";
    private final boolean disabled = false;
    private final boolean mandatory = false;
    private final int minLength = 0;
    private final int maxLength = 4;
    private final String placeholder = "Your First Name";
    private final String type = "text";

    public String getMale() {
        return male;
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
