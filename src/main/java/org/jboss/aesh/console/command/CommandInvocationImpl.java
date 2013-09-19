/*
 * Copyright 2012 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.jboss.aesh.console.command;

import org.jboss.aesh.console.AeshConsole;
import org.jboss.aesh.console.Prompt;
import org.jboss.aesh.console.operator.ControlOperator;
import org.jboss.aesh.console.reader.AeshStandardStream;
import org.jboss.aesh.terminal.Shell;

/**
 * @author <a href="mailto:stale.pedersen@jboss.org">Ståle W. Pedersen</a>
 */
public final class CommandInvocationImpl implements CommandInvocation {

    private final AeshConsole aeshConsole;
    private final ControlOperator controlOperator;

    public CommandInvocationImpl(AeshConsole aeshConsole, ControlOperator controlOperator) {
        this.aeshConsole = aeshConsole;
        this.controlOperator = controlOperator;
    }
    @Override
    public ControlOperator getControlOperator() {
        return controlOperator;
    }

    @Override
    public CommandRegistry getCommandRegistry() {
        return aeshConsole.getCommandRegistry();
    }

    @Override
    public void attachConsoleCommand(ConsoleCommand consoleCommand) {
        aeshConsole.attachConsoleCommand(consoleCommand);
    }

    @Override
    public Shell getShell() {
        return aeshConsole.getShell();
    }

    @Override
    public void setPrompt(Prompt prompt) {
        aeshConsole.setPrompt(prompt);
    }

    @Override
    public Prompt getPrompt() {
        return aeshConsole.getPrompt();
    }

    @Override
    public AeshStandardStream in() {
        return aeshConsole.in();
    }

    @Override
    public String getHelpInfo(String commandName) {
        return aeshConsole.getHelpInfo(commandName);
    }

    @Override
    public void stop() {
        aeshConsole.stop();
    }
}
