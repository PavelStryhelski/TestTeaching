package com.qulix.ft.implementation;

import com.qulix.ft.model.IDropDown;
import com.qulix.ft.model.IElement;
import com.qulix.ft.model.IPage;
import org.openqa.selenium.By;

import java.util.Collection;

/**
 * Выпадающий список
 */
public class DropDown implements IDropDown {
    @Override
    public String getSelected() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void select(String text) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void selectByOptionValue(String value) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Collection<String> getAllValues() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getValuesCount() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean hasSelectedValue() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean clickable(int timeout) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean enabled(int timeout) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean disabled(int timeout) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void click() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void sendKeys(CharSequence... sequence) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IPage getOwnerPage() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public By getLocator() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getName() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getProperty(String propertyName) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean visible(int timeout) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean invisible(int timeout) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean exists(int timeout) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean doesntExist(int timeout) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IElement getParentElement() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
