package com.app.servlet.columnTEST;

/**
 * Created by apavliuchenkova on 22/11/2016.
 */
public class LastNameColumn implements ColumnParameters,ColumnParametersInput {

    private String lastName;
    private final String columnName = "Last Name";
    private final boolean disabled = false;
    private final boolean mandatory = false;
    private final int minLength = 0;
    private final int maxLength = 100;
    private final String placeholder = "Your Last Name";
    private final String type = "text";

    public LastNameColumn(String firstName) {
        this.lastName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String firstName) {
        this.lastName = firstName;
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
