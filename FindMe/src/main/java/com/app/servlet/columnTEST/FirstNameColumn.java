package com.app.servlet.columnTEST;

/**
 * Created by apavliuchenkova on 22/11/2016.
 */
public class FirstNameColumn implements ColumnParameters,ColumnParametersInput {

    private String firstName;
    private final String columnName = "First Name";
    private final boolean disabled = false;
    private final boolean mandatory = false;
    private final int minLength = 1;
    private final int maxLength = 100;
    private final String placeholder = "Your First Name";
    private final String type = "text";

    public FirstNameColumn(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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
        return null;
    }

    @Override
    public String getType() {
        return type;
    }
}
