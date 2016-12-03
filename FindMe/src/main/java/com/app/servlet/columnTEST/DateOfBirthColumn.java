package com.app.servlet.columnTEST;

/**
 * Created by apavliuchenkova on 22/11/2016.
 */
public class DateOfBirthColumn implements ColumnParameters, ColumnParametersInput {
    private String dateOfBirth;
    private final String columnName = "Date of Birth";
    private final boolean disabled = false;
    private final boolean mandatory = false;
    private final int minLength = 0;
    private final int maxLength = 20;
    private final String placeholder = "";
    private final String type = "date";

    public DateOfBirthColumn(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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
