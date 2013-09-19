/*
 * Copyright 2012 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.jboss.aesh.cl.completer;

import org.jboss.aesh.console.command.Command;

import java.util.ArrayList;
import java.util.List;

/**
 * A payload object to store completion values for an Option
 * Offset is only needed to change if the there is only one completion value
 * and the value is not replacing the current given value, but appending.
 * If its only appending then set the offset to the length of completeValue
 * given in OptionCompleter.complete(String completeValue)
 *
 * @author <a href="mailto:stale.pedersen@jboss.org">Ståle W. Pedersen</a>
 */
public class CompleterData {

    private List<String> completerValues;
    private boolean appendSpace = true;
    private String completeValue;
    private Command command;

    public CompleterData(String completeValue, Command command) {
        this.completeValue = completeValue;
        this.command = command;
        completerValues = new ArrayList<String>();
    }

    public String getGivenCompleteValue() {
        return completeValue;
    }

    public Command getCommand() {
        return command;
    }

    public List<String> getCompleterValues() {
        return completerValues;
    }

    public void setCompleterValues(List<String> completerValues) {
        this.completerValues = completerValues;
    }

    public void clearCompleterValues() {
        this.completerValues.clear();
    }

    public void addAllCompleterValues(List<String> completerValues) {
        this.completerValues.addAll(completerValues);
    }

    public void addCompleterValue(String value) {
        this.completerValues.add(value);
    }

    public boolean isAppendSpace() {
        return appendSpace;
    }

    public void setAppendSpace(boolean appendSpace) {
        this.appendSpace = appendSpace;
    }
}
