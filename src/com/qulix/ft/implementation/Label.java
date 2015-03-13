package com.qulix.ft.implementation;

import com.qulix.ft.model.IElement;
import com.qulix.ft.model.ILabeledElement;
import com.qulix.ft.model.IPage;
import org.openqa.selenium.By;

/**
 * Метка
 */
public class Label implements ILabeledElement {
    @Override
    public String getText() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
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
