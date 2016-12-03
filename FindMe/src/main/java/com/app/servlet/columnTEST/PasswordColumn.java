package com.app.servlet.columnTEST;

/**
 * Created by apavliuchenkova on 22/11/2016.
 */
public class PasswordColumn implements ColumnParameters, ColumnParametersInput {

    private String password;
    private final String columnName = "Password";
    private final boolean disabled = false;
    private final boolean mandatory = true;
    private final int minLength = 7;
    private final int maxLength = 15;
    private final String placeholder = "password";
    private final String type = "password";

    public PasswordColumn(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
