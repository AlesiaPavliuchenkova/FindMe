package com.app.servlet.columnTEST;

/**
 * Created by apavliuchenkova on 22/11/2016.
 */
public class UserNameColumn implements ColumnParameters,ColumnParametersInput {

    private String name;
    private final String columnName = "User Name";
    private final boolean disabled = false;
    private final boolean mandatory = true;
    private final int minLength = 1;
    private final int maxLength = 30;
    private final String placeholder = "user_name";
    private final String type = "text";

    public UserNameColumn(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
